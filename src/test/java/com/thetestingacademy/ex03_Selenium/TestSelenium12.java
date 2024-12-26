package com.thetestingacademy.ex03_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium12 {
@Description("Open the url")
    @Test
    public void test_selenium01() throws Exception {

    WebDriver driver1 = new ChromeDriver();
    driver1.get("https://google.com");
//    close() -> will close the current tab but not the session
//sessiuon id != null;
    Thread.sleep(5000);
    driver1.quit();
//    quit will close all session
//    session id == null





}
}
