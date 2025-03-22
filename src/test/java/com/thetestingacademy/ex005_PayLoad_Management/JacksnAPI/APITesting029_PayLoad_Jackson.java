package com.thetestingacademy.ex005_PayLoad_Management.JacksnAPI;

import com.google.gson.Gson;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class APITesting029_PayLoad_Jackson {
    RequestSpecification r;
    ValidatableResponse validatableResponse;

    @Test
    public void test_CreateBooking_Positive(){

        //Step 1: URL, Body, Auth
        //Step 2: Payload
        //Step 3: Validation

        //Payload creation
        Booking_Jackson booking_jack = new Booking_Jackson();
        booking_jack.setFirstname("Karan");
        booking_jack.setLastname("Mang");
        booking_jack.setTotalprice(150);
        booking_jack.setDepositpaid(true);

        Bookingdates_Jackson bookingdates_jack = new Bookingdates_Jackson();
        bookingdates_jack.setCheckin("2025-04-10");
        bookingdates_jack.setCheckout("2025-04-15");
        booking_jack.setBookingdates(bookingdates_jack);
        booking_jack.setAdditionalneeds("Lunch");
        System.out.println(booking_jack);

        //Jackson
        ObjectMapper objectMapper;
        objectMapper = new ObjectMapper();
        String payLoad;
        try {
            payLoad = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking_jack);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(payLoad);

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(payLoad).log().all();

        Response response = r.when().post(); //http methods
        String jsonResponseString = response.asString();

        //Get Validatable Response to perform Validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //Case 3 - De-serialization extraction
        BookingResponse_Jackson bookResponse_jack;
        try {
            bookResponse_jack = objectMapper.readValue(response.asString(),BookingResponse_Jackson.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(bookResponse_jack.getBookingid());
        System.out.println(bookResponse_jack.getBooking().getFirstname());
        System.out.println(bookResponse_jack.getBooking().getLastname());

        assertThat(bookResponse_jack.getBookingid()).isNotZero().isNotNull();
        assertThat(bookResponse_jack.getBooking().getFirstname()).isEqualTo("Karan");

    }
}
