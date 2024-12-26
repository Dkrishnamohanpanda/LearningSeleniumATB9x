package com.thetestingacademy.ex03_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium03 {
@Description("Open App.vwo.com and get the title")
    @Test
    public void test_selenium01(){


        EdgeDriver  driver = new EdgeDriver();
//        EdgeDriver(); this command converted to local host 56055
//    started the edge browser
        driver.get("https://google.com");


    }
}
