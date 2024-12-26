package com.thetestingacademy.ex03_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium10 {
@Description("Open the url")
    @Test
    public void test_selenium01() throws Exception {
    ChromeDriver driver = new ChromeDriver();
//    driver = new FirefoxDriver();

    WebDriver driver1 = new ChromeDriver();
    driver1 = new FirefoxDriver();

}
}
