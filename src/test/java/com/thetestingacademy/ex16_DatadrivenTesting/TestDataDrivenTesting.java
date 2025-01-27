package com.thetestingacademy.ex16_DatadrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataDrivenTesting {

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                new Object[]{"admin@gmail.com","1234"},
                new Object[]{"admin5436@gmail.com","1y234"},
                new Object[]{"admin4034@gmail.com","123fgh4"}
        };

    }




    @Test(dataProvider ="getData")
    public void loginTest(String email,String password){
        System.out.println(email +" " +password);
    }
}
