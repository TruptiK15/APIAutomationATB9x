package com.thetestingacademy.ex001_Sample_check;

import io.restassured.RestAssured;

public class APITesting_002 {

    public static void main(String[] args) {

        //Gherkins Syntax
        // Given()  --> Pre- req - URL, Headers, Auth, Body,
        // When()  --> HTTP Methods - GET, POST, PUT, PATCH, DELETE
        // Then()  --> Validation --> 200 OK,


        //Full URl - https://api.zippopotam.us/IN/560016
        //BaseURi - https://api.zippopotam.us
        //path - /IN/560016
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/560016").
                when()
                    .get()
                .then().log().all().statusCode(200);
    }
}
