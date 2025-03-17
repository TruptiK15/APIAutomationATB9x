package com.thetestingacademy.ex002_RestAssuredBasics.GET.Task_12122024;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GET_NonBDD_TestNG {

    //Non BDD - used for code reusability (RestAssured not written again
    //make them instance variable (by taking outside the class) for reusability
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description("Verify the GET Request with Positive data")
    @Test
    public void test_GET_NonBDD_Postive() {

        String pincode = "560016";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);
        response = r.when().log().all().get(); //http methods
        vr = response.then().log().all().statusCode(200);
    }
    @Description("Verify the GET Request with Negative data: -1")
    @Test
    public void test_GET_NonBDD_Negative() {
        String pincode1 = "-1";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode1);
        response = r.when().get(); //http methods
        vr = response.then();
        vr.log().all().statusCode(404);
    }
    @Description("Verify the GET Request with Negative data: long input")
    @Test
    public void test_GET_NonBDD_Negative_longNo() {
        String pincode2 = "4000000000000";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode2);
        response = r.when().get(); //http methods
        vr = response.then()
                .log().all().statusCode(404);
    }
    @Description("Verify the GET Request with Negative data: special characters")
    @Test
    public void test_GET_NonBDD_Negative_special() {
        String pincode3 = "@@777hhhhh";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode3);
        response = r.when().get(); //http methods
        vr = response.then()
                .log().all().statusCode(404);
    }
    @Description("Verify the GET Request with Negative data: blank data")
    @Test
    public void test_GET_NonBDD_Negative_blank() {
        String pincode4 = "";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode4);
        response = r.when().get(); //http methods
        vr = response.then()
                .log().all().statusCode(404);
    }
    @Description("Verify the GET Request with Negative data: null")
    @Test
    public void test_GET_NonBDD_Negative_null() {
        String pincode5 = null;
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode5);
        response = r.when().get(); //http methods
        vr = response.then()
                .log().all().statusCode(404);
    }
    @Description("Verify the GET Request with Negative data: only space")
    @Test
    public void test_GET_NonBDD_Negative_space() {
        String pincode6 = " ";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode6);
        response = r.when().get(); //http methods
        vr = response.then()
                .log().all().statusCode(404);
    }
    @Description("Verify the GET Request with Negative data: only alphabets")
    @Test
    public void test_GET_NonBDD_Negative_characters() {
        String pincode7 = "abcdefg";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode7);
        response = r.when().get(); //http methods
        vr = response.then()
                .log().all().statusCode(404);
    }
    @Description("Verify the GET Request with Negative data: Spaces in no")
    @Test
    public void test_GET_NonBDD_Negative_spaceInNo() {
        String pincode8 = "56 00 16";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode8);
        response = r.when().get(); //http methods
        vr = response.then()
                .log().all().statusCode(404);
    }
    @Description("Verify the GET Request with Negative data: no too short")
    @Test
    public void test_GET_NonBDD_Negative_noTooShort() {
        String pincode8 = "5600";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode8);
        response = r.when().get(); //http methods
        vr = response.then()
                .log().all().statusCode(404);
    }
    @Description("Verify the GET Request with Negative data: space before no")
    @Test
    public void test_GET_NonBDD_Negative_spaceBeforeNo() {
        String pincode8 = " 560016";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode8);
        response = r.when().get(); //http methods
        vr = response.then()
                .log().all().statusCode(404);
    }
    @Description("Verify the GET Request with Negative data: space after no")
    @Test
    public void test_GET_NonBDD_Negative_spaceAfterNo() {
        String pincode8 = "560016 ";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode8);
        response = r.when().get(); //http methods
        vr = response.then()
                .log().all().statusCode(404);
    }
    @Description("Verify the GET Request with Negative data: decimal in no")
    @Test
    public void test_GET_NonBDD_Negative_decimalInNo() {
        String pincode8 = "560.016";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode8);
        response = r.when().get(); //http methods
        vr = response.then()
                .log().all().statusCode(404);
    }
    @Description("Verify the GET Request with Negative data: hyphen in no")
    @Test
    public void test_GET_NonBDD_Negative_hypenInNo() {
        String pincode8 = "560-016";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode8);
        response = r.when().get(); //http methods
        vr = response.then()
                .log().all().statusCode(404);
    }
}
