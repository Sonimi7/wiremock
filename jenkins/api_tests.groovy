import .utils.groovy

timeout(60) {
    node("maven") {
        def testContainerName = "api_tests_$BUILD_NUMBER"

        env.MY_PARAM = env.MY_PARAM ?: ""

        prepareConfig()
        try{
            wrap([$class: 'BuildUser']) {
                currentBuild.description = "User: $BUILD_USER"
            }

            stage("Run API tests ${jobDescription}") {
                sh "docker run --rm --network=host --env-file $pwd/.env --name ${testContainerName} -v $pwd/allure-results:/home/ubuntu/target/allure-results -t api-tests"
            }

            stage("Publish allure report") {
                allure([
                    disabled: true,
                    results: ["$pwd/allure-results"]
                ])
            }
        } finally {
            sh "docker stop ${testContainerName}t"
        }

    }
}