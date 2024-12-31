package com.thetestingacademy.ex05_Selenium_locators;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium17 {

    @Description("verify that text is match  on the free trial of  app.vwo.com  ")
    @Test
    public void negative_test_vwo_login() throws Exception {
        EdgeOptions edgeOptions = new EdgeOptions();
//
        edgeOptions.addArguments("--start-maximized");
//
        WebDriver driver = new EdgeDriver(edgeOptions);
    driver.get("https://app.vwo.com");
    driver.navigate().to("https://app.vwo.com");



//       <a
//       href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage"
//       class="text-link"
//       data-qa="bericafeqo">
//       Start a free trial
//        </a>


//        //link text -->Full Text match
//        WebElement a_tag_free_trial = driver.findElement(By.linkText(" Start a free trial"));
//        a_tag_free_trial.click();

//partial -->partial  Text match
        WebElement partial_text_match = driver.findElement(By.partialLinkText("free trial"));
        partial_text_match.click();

// partial will match
//Start a free trial
// a free trial
//free trial
// trial






        Thread.sleep(5000);
        driver.quit();










}
}
