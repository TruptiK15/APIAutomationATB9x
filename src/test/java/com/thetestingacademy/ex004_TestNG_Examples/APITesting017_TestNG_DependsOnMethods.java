package com.thetestingacademy.ex004_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting017_TestNG_DependsOnMethods {

    @Test
    public void serverStartedOK(){
        System.out.println("I will run first");
        Assert.assertTrue(true);
    }
    @Test(dependsOnMethods = "serverStartedOK")
    public void method1(){
        System.out.println("method1");
        Assert.assertTrue(true);
    }
    @Test(dependsOnMethods = "serverStartedOK")
    public void method2(){
        System.out.println("method2");
        Assert.assertTrue(true);
    }
}
