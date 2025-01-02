package com.thetestingacademy.ex06_Selenium_locator_Xpath;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium22_Task31st {

    @Description("Verify that Free trial expire message in idrve.com ")
    @Test
    public void test_verify_expire_message() throws Exception {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//
        edgeOptions.addArguments("--start-maximized");
//
        WebDriver driver = new EdgeDriver(edgeOptions);
    driver.get(" https://www.idrive360.com/enterprise/login");

        Thread.sleep(2000);

    WebElement email_input = driver.findElement(By.xpath("//input[@id ='username']"));
    email_input.sendKeys("augtest_040823@idrive.com");


    WebElement password_input = driver.findElement(By.xpath("//input[@id ='password']"));
        password_input.sendKeys("123456");

        Thread.sleep(2000);

    WebElement span_checkbox = driver.findElement(By.className("id-checkmark"));
        span_checkbox.click();

     WebElement signin_button = driver.findElement(By.xpath("//button[@id ='frm-btn']"));
        signin_button.click();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement freetrial_text = driver.findElement(By.xpath("//h5[@class='id-card-title']"));
       Assert.assertEquals(freetrial_text.getText(),"Your free trial has expired");



        driver.quit();










}
}
