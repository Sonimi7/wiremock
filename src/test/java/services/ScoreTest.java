package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import ru.otus.stub.helpers.Helper;
import ru.otus.stub.model.ScoreModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ScoreTest {

  Helper helper = new Helper();

  @Test
  public void checkAllScore() throws IOException {
    List<ScoreModel> scoreModelListResponse = List.of(helper.getAllEntityResponse(Helper.SCORES_PATH)
        .extract()
        .body()
        .as(ScoreModel [].class, ObjectMapperType.GSON)
    );

    ObjectMapper objectMapper = new ObjectMapper();
    String scoreModelJson = objectMapper.writeValueAsString(scoreModelListResponse);

    String expectedJson = new String(Files.readAllBytes(Paths.get("src/test/resources/templates/score.json")));

    try {
      JSONAssert.assertEquals(expectedJson, scoreModelJson, true);
    } catch (JSONException e) {
      e.printStackTrace();
    }

  }
}
