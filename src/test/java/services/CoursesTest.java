package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import ru.otus.stub.helpers.Helper;
import ru.otus.stub.model.CourseModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CoursesTest {

  Helper helper = new Helper();

  @Test
  public void checkAllCourses() throws IOException {
    List<CourseModel> courseModelsListResponse = List.of(helper.getAllEntityResponse(Helper.COURSES_PATH)
        .extract()
        .body()
        .as(CourseModel [].class, ObjectMapperType.GSON)
    );

    ObjectMapper objectMapper = new ObjectMapper();
    String courseModelJson = objectMapper.writeValueAsString(courseModelsListResponse);

    String expectedJson = new String(Files.readAllBytes(Paths.get("src/test/resources/templates/courses.json")));

    try {
      JSONAssert.assertEquals(expectedJson, courseModelJson, true);
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
}
