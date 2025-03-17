package com.thetestingacademy.ex002_RestAssuredBasics.GET;

import io.restassured.RestAssured;

public class APITesting006_GET_BDDStyle {
    public static void main(String[] args) {

        //Positive TC
        String pincode = "560016";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().log().all().get()  //http methods
                .then()
                .log().all().statusCode(200);

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
