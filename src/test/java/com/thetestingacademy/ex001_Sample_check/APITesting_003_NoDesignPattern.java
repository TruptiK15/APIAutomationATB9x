package com.thetestingacademy.ex001_Sample_check;

public class APITesting_003_NoDesignPattern {

    public void stet2(){
        System.out.println("Step 2");
    }
    public void step3(String param1){
        System.out.println("Step 3");
    }

    public static void main(String[] args) {
        APITesting_003_NoDesignPattern np = new APITesting_003_NoDesignPattern();
        np.stet2();
        np.step3("Trupti");
    }
}
