package com.thetestingacademy.ex003_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting016_TestNG_Groups {

    @Test(groups = {"Sanity","QA"})
    public void SanityRun(){
        System.out.println("Sanity Run - 1");
        System.out.println("QA");
        Assert.assertTrue(true);
    }
    @Test(groups = "Regression")
    public void RegressionRun(){
        System.out.println("Regression Run..");
        Assert.assertTrue(false);
    }
    @Test(groups = {"Smoke","QA"})
    public void Smoke_Run(){
        System.out.println("Smoke Run..");
        Assert.assertTrue(false);
    }
    @Test(groups = "Sanity")
    public void SanityRun2(){
        System.out.println("Sanity Run - 2");
        Assert.assertTrue(true);
    }
}
