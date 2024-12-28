package com.thetestingacademy.ex04_Selenium_Option_Classes;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class TestSelenium14 {

    @Description("Open the url")
    @Test
    public void test_selenium01() throws Exception {
        EdgeOptions edgeOptions = new EdgeOptions();
//        edgeOptions.addArguments("--window-size=1280,720");
//        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");
//        edgeOptions.addArguments("--headless");
//        incognito mood sometimes didi not work with edge it work with chrome

        WebDriver driver = new EdgeDriver(edgeOptions);
    driver.get("https://google.com");

        Thread.sleep(5000);
        driver.quit();

}
}
