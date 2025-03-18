package com.thetestingacademy.ex002_RestAssuredBasics.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class APITesting009_POST_BDD {

    @Description("Verify the POST Request with Positive data")
    @Test
    public void test_POST_BDD() {

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}\n";
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/auth")
                    .contentType(ContentType.JSON)
                    .log().all().body(payload)
                .when()
                    .log().all().post()  //http methods
                .then()
                    .log().all().statusCode(200);
    }
}
