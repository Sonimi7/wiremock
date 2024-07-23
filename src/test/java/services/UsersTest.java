package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import ru.otus.stub.helpers.Helper;
import ru.otus.stub.model.UserModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class UsersTest {
  Helper helper = new Helper();

  @Test
  public void checkListAllUsers() throws IOException {
    List<UserModel> userModelListResponse = List.of(helper.getAllEntityResponse(Helper.USERS_PATH)
        .extract()
        .body()
        .as(UserModel [].class, ObjectMapperType.GSON)
    );

    ObjectMapper objectMapper = new ObjectMapper();
    String userModelJson = objectMapper.writeValueAsString(userModelListResponse);

    String expectedJson = new String(Files.readAllBytes(Paths.get("src/test/resources/templates/users.json")));

    try {
      JSONAssert.assertEquals(expectedJson, userModelJson, true);
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
}
