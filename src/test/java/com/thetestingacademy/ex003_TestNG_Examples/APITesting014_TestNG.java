package com.thetestingacademy.ex003_TestNG_Examples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting014_TestNG {

    @BeforeTest
    public void getToken(){
        System.out.println("1 - get Token");
    }
    @BeforeTest
    public void getBookingID(){
        System.out.println("2 - get Booking ID");
    }
    @Test
    public void test_PUT(){
        //Token & Booking ID
        System.out.println("3 - PUT Request");
    }
    @AfterTest
    public void closeAll_Pages(){
        System.out.println("Close Tabs");
    }
}
