package com.thetestingacademy.ex06_Selenium_locator_Xpath;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium21 {

    @Description("Automating Appointment,username,password and login scenario of katalon-demo-cura . ")
    @Test
    public void katalon_login() throws Exception {
        EdgeOptions edgeOptions = new EdgeOptions();
//
        edgeOptions.addArguments("--start-maximized");
//
        WebDriver driver = new EdgeDriver(edgeOptions);
    driver.get("https://katalon-demo-cura.herokuapp.com/");
//    driver.navigate().to("https://app.vwo.com");

        WebElement make_appointment_button = driver.findElement(By.xpath("//a[@id = \"btn-make-appointment\"]"));
        make_appointment_button.click();

        Thread.sleep(3000);

        WebElement username_input_box = driver.findElement(By.xpath("//input[@id = 'txt-username']"));
        username_input_box.sendKeys("John Doe");

         WebElement password_input_box = driver.findElement(By.xpath("//input[@id ='txt-password']"));
        password_input_box.sendKeys("ThisIsNotAPassword");

        WebElement login_button = driver.findElement(By.xpath("//button[@id=\"btn-login\"]"));
        login_button.click();

     Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");


        Thread.sleep(5000);
        driver.quit();










}
}
