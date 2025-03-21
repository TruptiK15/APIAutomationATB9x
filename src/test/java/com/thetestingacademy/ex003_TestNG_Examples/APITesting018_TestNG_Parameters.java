package com.thetestingacademy.ex003_TestNG_Examples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting018_TestNG_Parameters {

    @Parameters("browser")
    @Test
    public void demo1(String value) {
        System.out.println("Browser is " + value);

        //Open the browser
        if (value.equalsIgnoreCase("chrome")) {
            System.out.println("Start my Chrome..");
        }
        if (value.equalsIgnoreCase("firefox")) {
            System.out.println("Start my Firefox..");
        }

    }

}
