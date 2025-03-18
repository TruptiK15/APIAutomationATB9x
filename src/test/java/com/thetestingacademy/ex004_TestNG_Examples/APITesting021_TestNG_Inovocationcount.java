package com.thetestingacademy.ex004_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting021_TestNG_Inovocationcount {
    
    @Test(invocationCount = 2)
    public void test001() {
        Assert.assertTrue(true);
        System.out.println("Run 2 times");
    }

    @Test
    public void test002() {
        Assert.assertTrue(true);
    }

}
