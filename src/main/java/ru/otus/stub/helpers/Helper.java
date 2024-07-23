package ru.otus.stub.helpers;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Helper {

  private static final String BASE_URL = "http://localhost:8090";
  public static final String USERS_PATH = "/users/all";
  public static final String COURSES_PATH = "courses/all";
  public static final String SCORES_PATH = "scores/all";
  private RequestSpecification spec;
  public Helper(){
    spec = given()
        .baseUri(BASE_URL)
        .contentType(ContentType.JSON);
  }
  public ValidatableResponse getAllEntityResponse(String path) {

    return given(spec)
        .basePath(path)
        .log().all()
        .when()
        .get()
        .then()
        .log().all();
  }
}
