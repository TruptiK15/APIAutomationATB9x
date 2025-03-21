package com.thetestingacademy.ex005_PayLoad_Management;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class APITesting025_PayLoad_Map_GSON {
    RequestSpecification r;
    ValidatableResponse validatableResponse;

    @Test
    public void test_POST(){
//        String payload_POST = "{\n" +
//                "    \"firstname\" : \"Trupti\",\n" +
//                "    \"lastname\" : \"Cate\",\n" +
//                "    \"totalprice\" : 50,\n" +
//                "    \"depositpaid\" : true,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2025-04-10\",\n" +
//                "        \"checkout\" : \"2025-04-15\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Breakfast\"\n" +
//                "}";

        Map<String,Object> jsonBodyUsingMap = new LinkedHashMap();
        jsonBodyUsingMap.put("firstname","Trupti");
        jsonBodyUsingMap.put("lastname","Cate");
        jsonBodyUsingMap.put("totalprice",50);
        jsonBodyUsingMap.put("depositpaid",true);

        Map<String,Object> bookingDatesMap = new LinkedHashMap();
        bookingDatesMap.put("checkin","2025-04-10");
        bookingDatesMap.put("checkout","2025-04-15");

        jsonBodyUsingMap.put("bookingdates",bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds","Breakfast");
        System.out.println(jsonBodyUsingMap);
        //Now add dependency of GSON
        //Your HashMap will be converted to JSON i.e., having double quotes

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(jsonBodyUsingMap).log().all();
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
    }
}
