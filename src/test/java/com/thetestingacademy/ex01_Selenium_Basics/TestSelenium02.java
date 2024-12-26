package com.thetestingacademy.ex01_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestSelenium02 {
@Description("Open App.vwo.com and get the title")
    @Test
    public void test_selenium01(){
//open url
//        print title

        EdgeDriver  driver = new EdgeDriver();
//        EdgeDriver(); this command converted to local host 56055
//    started the edge browser
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());

    }
}
