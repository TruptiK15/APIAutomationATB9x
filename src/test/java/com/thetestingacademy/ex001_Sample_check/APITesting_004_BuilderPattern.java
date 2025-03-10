package com.thetestingacademy.ex001_Sample_check;

public class APITesting_004_BuilderPattern {

    //instead of void use its class name
    public APITesting_004_BuilderPattern stet2(){
        System.out.println("Step 2");
        return this;
    }
    public APITesting_004_BuilderPattern step3(String param1){
        System.out.println("Step 3");
        return this;
    }

    public static void main(String[] args) {
        APITesting_004_BuilderPattern np = new APITesting_004_BuilderPattern();
        np.stet2().step3("Trupti");
    }
}
