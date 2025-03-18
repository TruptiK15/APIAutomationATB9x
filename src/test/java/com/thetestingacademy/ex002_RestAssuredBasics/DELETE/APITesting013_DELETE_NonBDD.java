package com.thetestingacademy.ex002_RestAssuredBasics.DELETE;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting013_DELETE_NonBDD {

    //Non BDD - If your TC are more than 100 then use Non BDD
    // public void get_Token(){
    // public void get_booking_id(){

    @Description("Verify the Delete Request | Positive")
    @Test
    public void test_Delete_NonBDD() {

        //Need Token & Booking ID
        String token = "06bfcb5e0fe2356";
        String bookingid = "6019";

        RequestSpecification r;
        r = RestAssured.given();
            r.baseUri("https://restful-booker.herokuapp.com/");
            r.basePath("/booking/"+ bookingid);
            r.contentType(ContentType.JSON);
            r.cookie("token",token);
            r.log().all();

        Response response = r.when().delete(); //http methods

        ValidatableResponse vr = response.then().log().all();
        vr.statusCode(201);
    }
}
