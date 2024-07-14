package services;

import com.github.tomakehurst.wiremock.WireMockServer;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import ru.otus.stub.helpers.Helper;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class SpringServiceTest {

  private static WireMockServer wireMockServer = new WireMockServer();

  @BeforeTestClass
  public static void startWireMock() {
    wireMockServer.start();
    wireMockServer.port();
    configureFor(wireMockServer.port());
    stubFor(get(urlPathEqualTo("/users/all"))
        .willReturn(aResponse()
            .withBody("\"name\":\"Test user\", \"course\":\"QA\",\"email\":\"test@test.test\",\"age\": 23")
            .withStatus(200)));
  }

  @AfterTestClass
  public static void stopWireMock() {
    wireMockServer.stop();
  }

  @Test
  public void stubWireMock() throws IOException, ParseException {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    //HttpGet httpGet = new HttpGet("http://localhost:/users/all");
    HttpGet httpGet = new HttpGet("http://localhost:" + wireMockServer.port() + "/users/all");

    CloseableHttpResponse response = httpClient.execute(httpGet);
    String responseBody = EntityUtils.toString(response.getEntity());

    System.out.println(responseBody);

  }
}
