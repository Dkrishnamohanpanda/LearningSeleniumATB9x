package com.thetestingacademy.ex03_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestSelenium11 {
@Description("Open the url")
    @Test
    public void test_selenium01() throws Exception {

    WebDriver driver1 = new ChromeDriver();
    driver1.get("https://google.com");

//    use navigation
    driver1.navigate().to("https://bing.com");
    driver1.navigate().forward();
    driver1.navigate().refresh();
    driver1.navigate().back();

}
}
