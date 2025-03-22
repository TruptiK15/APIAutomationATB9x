package com.thetestingacademy.ex004_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class APITesting024_RestAssured_TestNG_AssertJ_Assertions {
    RequestSpecification r;
    ValidatableResponse validatableResponse;
    String bookingId;

    @Test
    public void test_POST(){
        String payload_POST = "{\n" +
                "    \"firstname\" : \"Trupti\",\n" +
                "    \"lastname\" : \"Cate\",\n" +
                "    \"totalprice\" : 50,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2025-03-10\",\n" +
                "        \"checkout\" : \"2025-03-15\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(payload_POST).log().all();
        Response response = r.when().post(); //http methods

        //Get Validatable Response to perform Validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //For RestAssured Vaidation --> import org.hamcrest.Matchers;
        //Use Function --> Matchers.Equalto()
        //bookingid is path in json
        validatableResponse.body("bookingid",Matchers.notNullValue());
        validatableResponse.body("booking.firstname",Matchers.equalTo("Trupti"));
        validatableResponse.body("booking.lastname",Matchers.equalTo("Cate"));
        validatableResponse.body("booking.depositpaid",Matchers.equalTo(true));

        //TestNG Assertion & AssertJ extraction is same
        bookingId = response.then().extract().path("bookingid");
        String firstname1 = response.then().extract().path("booking.firstname");
        String lastname1 = response.then().extract().path("booking.lastname");

        //TestNG Assertion
        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstname1,"Trupti");
        Assert.assertEquals(lastname1,"Cate");

        //AssertJ Assertion - Lib
        assertThat(bookingId).isNotNull().isNotBlank();
    }
}