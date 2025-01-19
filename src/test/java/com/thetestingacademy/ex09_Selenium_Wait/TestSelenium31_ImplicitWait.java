package com.thetestingacademy.ex09_Selenium_Wait;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestSelenium31_ImplicitWait {

    @Description("verify that with invalid email and pass error messwege is shown on the app.vwo.com  ")
    @Test
    public void negative_test_vwo_login() throws Exception {
        EdgeOptions edgeOptions = new EdgeOptions();
//
        edgeOptions.addArguments("--start-maximized");
//
        WebDriver driver = new EdgeDriver(edgeOptions);
    driver.get("https://app.vwo.com");
    driver.navigate().to("https://app.vwo.com");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

// 1.   find the email input box  and enter the email
//<input -----> open tag
// type="email"  -----> key and value
// class="text-input W(100%)"
// name="username"
// id="login-username"
// data-qa="hocewoqisi"
// > ---> close tag
       WebElement emailInputBox=  driver.findElement(By.id("login-username"));
       emailInputBox.sendKeys("admin@admin.com");

// 2.   find the password input box  and enter the password
//        <input
//        type="password"
//        class="text-input W(100%)"
//        name="password"
//        id="login-password"  --->suppose it is nopt available
//        data-qa="jobodapuxe">

        WebElement passInputBox = driver.findElement(By.name("password"));
        passInputBox.sendKeys("password");


// 3.   find the submit botton   and click on it
//        <button type="submit"
//        id="js-login-btn"
//        class="btn btn--positive btn--inverted W(100%) H(48px) Fz(16px)"
//        onclick="login.login(event)"
//        data-qa="sibequkica"
//        >
//
         WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
         buttonSubmit.click();





        Thread.sleep(5000);



// 4.   find the invalid error messege   and verify it
//        <div
//        class="notification-box-description"
//        io.qameta.allure.Owner
//        id="js-notification-box-msg" --->suppose it is nopt available
//        data-qa="rixawilomi"
//        >Your email, password, IP address or location did not match</div>

        WebElement eror_messege = driver.findElement(By.className("notification-box-description"));

        Assert.assertEquals(eror_messege.getText(),"Your email, password, IP address or location did not match");

        driver.quit();





}
}
