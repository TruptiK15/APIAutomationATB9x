package com.thetestingacademy.ex004_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting019_TestNG_Enabled {


    @Test
    public void test1() {
        Assert.assertTrue(true);
    }

    @Test(enabled = false)
    public void test2() {
        Assert.assertTrue(true);
    }

    @Test
    public void test3() {
        Assert.assertTrue(true);
    }

}
