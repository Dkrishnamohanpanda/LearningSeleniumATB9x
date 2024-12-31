package com.thetestingacademy.ex05_Selenium_locators;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium18 {

    @Description("verify that with invalid email when you try Signup for a full-featured trial on the app.vwo.com you will get a messege  The email address you entered is incorrect. ")
    @Test
    public void negative_test_vwo_login() throws Exception {
        EdgeOptions edgeOptions = new EdgeOptions();
//
        edgeOptions.addArguments("--start-maximized");
//
        WebDriver driver = new EdgeDriver(edgeOptions);
    driver.get("https://vwo.com/free-trial");
//    driver.navigate().to("https://app.vwo.com");

WebElement email = driver.findElement(By.id("page-v1-step1-email"));
email.sendKeys("bhbbbdnd");

WebElement checkbox = driver.findElement(By.name("gdpr_consent_checkbox"));
checkbox.click();

List <WebElement> buttonList = driver.findElements(By.tagName("button"));
buttonList.get(0).click();


//Error messege
// <div
// class="C($color-red) Fz($font-size-12) Trsp($Op) Trsdu(0.15s) Op(0) invalid-input+Op(1) invalid-reason">
// The email address you entered is incorrect.
// </div>

        WebElement eror_messege = driver.findElement(By.className("invalid-reason"));
  Assert.assertEquals(eror_messege.getText(),"The email address you entered is incorrect.");




        Thread.sleep(5000);
        driver.quit();










}
}
