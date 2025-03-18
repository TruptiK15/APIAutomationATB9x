package com.thetestingacademy.ex002_RestAssuredBasics.PATCH;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting012_PATCH_NonBDD {

    //Non BDD - If your TC are more than 100 then use Non BDD
    // public void get_Token(){
    // public void get_booking_id(){

    @Description("Verify the PATCH Request | Positive")
    @Test
    public void test_Patch_NonBDD() {

        //Need Token & Booking ID
        String token = "27e1e071cd9246f";
        String bookingid = "1520";

        RequestSpecification r;
        String payload_patch = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Bond\"\n" +
                "}";

        r = RestAssured.given();
            r.baseUri("https://restful-booker.herokuapp.com/");
            r.basePath("/booking/"+ bookingid);
            r.contentType(ContentType.JSON);
            r.cookie("token",token);
            r.body(payload_patch).log().all();

        Response response = r.when().patch(); //http methods

        ValidatableResponse vr = response.then().log().all();
        vr.statusCode(200);
    }
}
