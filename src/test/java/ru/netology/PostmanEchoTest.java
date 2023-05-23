package ru.netology;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @Test
    void shouldReturnData() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Today we have dinner at 6pm.")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data",equalTo ("Today we have dinner at 6pm."))
                .contentType(ContentType.JSON)
        ;
    }
}
