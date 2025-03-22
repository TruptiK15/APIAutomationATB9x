package com.thetestingacademy.ex005_PayLoad_Management;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class APITesting026_PayLoad_POJO {
    RequestSpecification r;
    ValidatableResponse validatableResponse;

    @Test
    public void test_POST(){

        //POJO - Plain Old Java Objects
        //Normal class - having concept of encapsulation
        // No special naming conversion
        // Create classes - according to the {} have in json

        Booking booking = new Booking();
        booking.setFirstname("Mini");
        booking.setLastname("Cate");
        booking.setTotalprice(100);
        booking.setDepositpaid(true);

        BookingDates bookdates = new BookingDates();
        bookdates.setCheckin("2025-04-10");
        bookdates.setCheckout("2025-04-15");
        //Add in booking
        booking.setBookingdates(bookdates);
        booking.setAdditonalneeds("Lunch");
        System.out.println(booking);


        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(booking).log().all();
        Response response = r.when().post(); //http methods

        //Get Validatable Response to perform Validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //For RestAssured Vaidation --> import org.hamcrest.Matchers;
        //Use Function --> Matchers.Equalto()
        //bookingid is path in json
        validatableResponse.body("bookingid",Matchers.notNullValue());
        validatableResponse.body("booking.firstname",Matchers.equalTo("Mini"));
        validatableResponse.body("booking.lastname",Matchers.equalTo("Cate"));
        validatableResponse.body("booking.depositpaid",Matchers.equalTo(true));
    }
}
