package com.thetestingacademy.ex03_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium05 {
@Description("Open App.vwo.com and get the title")
    @Test
    public void test_selenium01(){

//  2.  Do you want to run on chrome then you want to change to edge

   WebDriver driver = new ChromeDriver();
   driver.get("https://app.vwo.com");
//    driver = new EdgeDriver();
//    driver = new FirefoxDriver();




    }
}
