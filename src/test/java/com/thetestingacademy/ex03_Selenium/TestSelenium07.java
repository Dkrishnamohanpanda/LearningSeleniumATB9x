package com.thetestingacademy.ex03_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium07 {
@Description("Open the url")
    @Test
    public void test_selenium01(){
   WebDriver driver = new EdgeDriver();
   driver.get("https://google.com");
    System.out.println(driver.getTitle());
    System.out.println(driver.getCurrentUrl());
    System.out.println(driver.getPageSource());

    driver.manage().window().maximize();
    driver.manage().window().minimize();


    }
}
