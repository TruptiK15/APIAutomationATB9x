package com.thetestingacademy.ex002_RestAssuredBasics.GET;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting008_GET_NonBDD_TestNG {

    //Non BDD - used for code reusability (RestAssured not written again
    //make them instance variable (by taking outside the class) for reusability
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description("Verify the GET Request with Positive data")
    @Test
    public void test_GET_NonBDD_Postive() {

        //Inbuild Interfaces - RestAssured Interface
        //Abstract methods
        //breaking down the code into 3 parts
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

        String pincode = "-1";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);
        response = r.when().get(); //http methods
        vr = response.then();
        vr.log().all().statusCode(404);
    }
    @Description("Verify the GET Request with Negative data: long input")
    @Test
    public void test_GET_NonBDD_Negative_longNo() {

        String pincode = "4000000000000";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);
        response = r.when().get(); //http methods
        vr = response.then()
                .log().all().statusCode(404);
    }
    @Description("Verify the GET Request with Negative data: special characters")
    @Test
    public void test_GET_NonBDD_Negative_special() {

        String pincode = "@@777hhhhh";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);
        response = r.when().get(); //http methods
        vr = response.then()
                .log().all().statusCode(404);
    }
    @Description("Verify the GET Request with Negative data: blank data")
    @Test
    public void test_GET_NonBDD_Negative_blank() {

        String pincode = "";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);
        response = r.when().get(); //http methods
        vr = response.then()
                .log().all().statusCode(404);
    }
    @Description("Verify the GET Request with Negative data: null")
    @Test
    public void test_GET_NonBDD_Negative_null() {

        String pincode = null;
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);
        response = r.when().get(); //http methods
        vr = response.then()
                .log().all().statusCode(404);
    }
    @Description("Verify the GET Request with Negative data: only space")
    @Test
    public void test_GET_NonBDD_Negative_space() {

        String pincode = " ";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);
        response = r.when().get(); //http methods
        vr = response.then()
                .log().all().statusCode(404);
    }
    @Description("Verify the GET Request with Negative data: only alphabets")
    @Test
    public void test_GET_NonBDD_Negative_characters() {

        String pincode = "abcdefg";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);
        response = r.when().get(); //http methods
        vr = response.then()
                .log().all().statusCode(404);
    }
    @Description("Verify the GET Request with Negative data: Spaces in no")
    @Test
    public void test_GET_NonBDD_Negative_spaceInNo() {

        String pincode = "56 00 16";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);
        response = r.when().get(); //http methods
        vr = response.then()
                .log().all().statusCode(404);
    }
    @Description("Verify the GET Request with Negative data: boolean")
    @Test
    public void test_GET_NonBDD_Negative_boolean() {

        Boolean pincode = true;
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);
        response = r.when().get(); //http methods
        vr = response.then()
                .log().all().statusCode(404);
    }

}
