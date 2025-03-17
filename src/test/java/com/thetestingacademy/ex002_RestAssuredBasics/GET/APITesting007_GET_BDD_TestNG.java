package com.thetestingacademy.ex002_RestAssuredBasics.GET;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting007_GET_BDD_TestNG {

    @Test
    public void test_GET_Req_Positive() {

        //Positive TC
        String pincode = "560016";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().log().all().get()  //http methods
                .then()
                .log().all().statusCode(200);
    }
    @Test
    public void test_GET_Req_Negative() {
        //Negative TC
        String pincode1 = "-1";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode1)
                .when().log().all().get()  //http methods
                .then()
                .log().all().statusCode(404);
    }
    }
