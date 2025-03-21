package com.thetestingacademy.ex004_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting023_TestNG_Assertions {

    @Test
    public void test_Hard_AssertExample(){
        //Hard Assertion - if failed remaining code will not get executed
        System.out.println("Start of the Program");
        Boolean is_neelu = true;
        Assert.assertTrue(is_neelu);
        System.out.println("End of the Program");

        //case sensitive
        //Assert.assertEquals("Trupti", "trupti");
    }

    @Test
    public void test_Soft_AssertExample(){
        //Soft Assertion - if failed remaining code will not get executed
        SoftAssert softasse = new SoftAssert();
        System.out.println("Start of the Program");
        Boolean is_neelu = false;
        softasse.assertTrue(is_neelu);
        softasse.assertEquals("Trupti", "trupti");
        System.out.println("Still the End of the Program will executed");
        softasse.assertAll();
    }
}
