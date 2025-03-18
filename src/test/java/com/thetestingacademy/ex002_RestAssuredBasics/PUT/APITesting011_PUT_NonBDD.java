package com.thetestingacademy.ex002_RestAssuredBasics.PUT;

import com.thetestingacademy.ex002_RestAssuredBasics.POST.APITesting010_POST_NonBDD;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting011_PUT_NonBDD {

    //Non BDD - If your TC are more than 100 then use Non BDD
    // public void get_Token(){
    // public void get_booking_id(){

    @Description("Verify the PUT Request | Positive")
    @Test
    public void test_Put_NonBDD() {

        //Need Token & Booking ID
        String token = "cf7f106bd0338af";
        String bookingid = "1643";

        RequestSpecification r;
        String payload_put = "{\n" +
                "    \"firstname\": \"Jim\",\n" +
                "        \"lastname\": \"Will\",\n" +
                "        \"totalprice\": 105,\n" +
                "        \"depositpaid\": false,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2025-03-10\",\n" +
                "            \"checkout\": \"2025-03-15\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Dinner\"\n" +
                "}";

        r = RestAssured.given();
            r.baseUri("https://restful-booker.herokuapp.com/");
            r.basePath("/booking/"+ bookingid);
            r.contentType(ContentType.JSON);
            r.cookie("token",token);
            r.body(payload_put).log().all();

        Response response = r.when().put(); //http methods

        ValidatableResponse vr = response.then().log().all();
        vr.statusCode(200);
    }
}
