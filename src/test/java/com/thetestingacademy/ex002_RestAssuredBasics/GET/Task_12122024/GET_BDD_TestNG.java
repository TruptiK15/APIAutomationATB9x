package com.thetestingacademy.ex002_RestAssuredBasics.GET.Task_12122024;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GET_BDD_TestNG {

    // BDD Style
    @Description("Verify the GET Request with Positive data")
    @Test
    public void test_GET_NonBDD_Postive() {
        String pincode = "560016";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().log().all().get()  //http methods
                .then()
                .log().all().statusCode(200);
    }

    @Description("Verify the GET Request with Negative data: -1")
    @Test
    public void test_GET_NonBDD_Negative() {
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/-1")
                .when().log().all().get()  //http methods
                .then()
                .log().all().statusCode(404);
    }

    @Description("Verify the GET Request with Negative data: long input")
    @Test
    public void test_GET_NonBDD_Negative_longNo() {
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/4000000000000")
                .when().log().all().get()  //http methods
                .then()
                .log().all().statusCode(404);
    }

    @Description("Verify the GET Request with Negative data: special characters")
    @Test
    public void test_GET_NonBDD_Negative_special() {
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/@@777hhhhh")
                .when().log().all().get()  //http methods
                .then()
                .log().all().statusCode(404);
    }

    @Description("Verify the GET Request with Negative data: blank data")
    @Test
    public void test_GET_NonBDD_Negative_blank() {
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/")
                .when().log().all().get()  //http methods
                .then()
                .log().all().statusCode(404);
    }

    @Description("Verify the GET Request with Negative data: null")
    @Test
    public void test_GET_NonBDD_Negative_null() {
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/null")
                .when().log().all().get()  //http methods
                .then()
                .log().all().statusCode(404);
    }

    @Description("Verify the GET Request with Negative data: only space")
    @Test
    public void test_GET_NonBDD_Negative_space() {
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/ ")
                .when().log().all().get()  //http methods
                .then()
                .log().all().statusCode(404);
    }

    @Description("Verify the GET Request with Negative data: only alphabets")
    @Test
    public void test_GET_NonBDD_Negative_characters() {
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/abcdefg")
                .when().log().all().get()  //http methods
                .then()
                .log().all().statusCode(404);
    }

    @Description("Verify the GET Request with Negative data: Spaces in no")
    @Test
    public void test_GET_NonBDD_Negative_spaceInNo() {
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/56 00 16")
                .when().log().all().get()  //http methods
                .then()
                .log().all().statusCode(404);
    }

    @Description("Verify the GET Request with Negative data: no too short")
    @Test
    public void test_GET_NonBDD_Negative_noTooShort() {
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/5600")
                .when().log().all().get()  //http methods
                .then()
                .log().all().statusCode(404);
    }

    @Description("Verify the GET Request with Negative data: space before no")
    @Test
    public void test_GET_NonBDD_Negative_spaceBeforeNo() {
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/ 560016")
                .when().log().all().get()  //http methods
                .then()
                .log().all().statusCode(404);
    }

    @Description("Verify the GET Request with Negative data: space after no")
    @Test
    public void test_GET_NonBDD_Negative_spaceAfterNo() {
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/560016 ")
                .when().log().all().get()  //http methods
                .then()
                .log().all().statusCode(404);
    }

    @Description("Verify the GET Request with Negative data: decimal in no")
    @Test
    public void test_GET_NonBDD_Negative_decimalInNo() {
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/560.016")
                .when().log().all().get()  //http methods
                .then()
                .log().all().statusCode(404);
    }

    @Description("Verify the GET Request with Negative data: hyphen in no")
    @Test
    public void test_GET_NonBDD_Negative_hypenInNo() {
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/560-016")
                .when().log().all().get()  //http methods
                .then()
                .log().all().statusCode(404);
    }
}
