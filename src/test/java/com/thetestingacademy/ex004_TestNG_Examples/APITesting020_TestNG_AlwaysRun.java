package com.thetestingacademy.ex004_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting020_TestNG_AlwaysRun {

    @Test
    public void test1() {
        Assert.assertTrue(true);
    }

    @Test(alwaysRun = true)
    public void test2() {
        Assert.assertTrue(true);
    }

    @Test
    public void test3() {
        Assert.assertTrue(true);
    }

}
