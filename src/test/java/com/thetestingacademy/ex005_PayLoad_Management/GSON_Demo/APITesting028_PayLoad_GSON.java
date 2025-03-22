package com.thetestingacademy.ex005_PayLoad_Management.GSON_Demo;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class APITesting028_PayLoad_GSON {
    RequestSpecification r;
    ValidatableResponse validatableResponse;

    @Test
    public void test_CreateBooking_Positive(){

        //Step 1: URL, Body, Auth
        //Step 2: Payload
        //Step 3: Validation

        //Payload creation
        Booking booking = new Booking();
        booking.setFirstname("Karan");
        booking.setLastname("Mang");
        booking.setTotalprice(150);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2025-04-10");
        bookingdates.setCheckout("2025-04-15");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Lunch");
        System.out.println(booking);

        //to send data convert Java object to JSON - we use GSON
        //.toJSON(object.ref)
        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(jsonStringBooking).log().all();

        Response response = r.when().post(); //http methods
        String jsonResponseString = response.asString();

        //Get Validatable Response to perform Validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //To validations
        //Case 1 - use .extract() - direct extraction
        String booking1 = response.then().extract().path("bookingid");
        String firstname1 = response.then().extract().path("booking.firstname");
        String lastname1 = response.then().extract().path("booking.lastname");
        System.out.println("Book ID: " + booking1);

        //Case 2 - jsonPath.getString(""); - json path extraction
        JsonPath jsonPath = new JsonPath(response.asString());
        String bookingId = jsonPath.getString("bookingid");
        String firstName = jsonPath.getString("booking.firstname");
        String lastName = jsonPath.getString("booking.lastname");
        System.out.println("Booking ID: " + bookingId);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);

        //Case 3 - De-serialization extraction
        BookingResponse bookResponse = gson.fromJson(jsonResponseString, BookingResponse.class);
        System.out.println(bookResponse.getBookingid());
        System.out.println(bookResponse.getBooking().getFirstname());
        System.out.println(bookResponse.getBooking().getLastname());

        assertThat(bookResponse.getBookingid()).isNotZero().isNotNull();
        assertThat(bookResponse.getBooking().getFirstname()).isEqualTo("Karan");

    }
}
