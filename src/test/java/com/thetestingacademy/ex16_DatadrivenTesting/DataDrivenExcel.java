package com.thetestingacademy.ex16_DatadrivenTesting;

import com.thetestingacademy.ex16_DatadrivenTesting.UtilExcel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataDrivenExcel {

    @Test(dataProvider = "getData",dataProviderClass = UtilExcel.class)
    public void test_VWOLogin(String email, String password){
        System.out.println("Email - "+ email);
        System.out.println("Password - "+ password);

        // If email and pass ->  correct ->

        /// Else





    }



}