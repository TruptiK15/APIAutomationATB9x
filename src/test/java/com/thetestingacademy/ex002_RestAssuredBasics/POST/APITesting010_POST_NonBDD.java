package com.thetestingacademy.ex002_RestAssuredBasics.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting010_POST_NonBDD {

    //Non BDD - If your TC are more than 100 then use Non BDD
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description("Verify the POST Request with Positive data")
    @Test
    public void test_POST_NonBDD() {

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}\n";
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("auth");
        r.contentType(ContentType.JSON).log().all();
        r.body(payload);
        response = r.when().log().all().post(); //http methods
        vr = response.then().log().all().statusCode(200);
    }
}
