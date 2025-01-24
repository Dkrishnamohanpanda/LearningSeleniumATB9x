package com.thetestingacademy.ex15_SeleniumException;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSelenium64_NoSuchElementException {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);

    }
    @Description("Verify Exception ")
    @Test
    public void test_JsExecutor() throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com/");
        driver.manage().window().maximize();
//even if you try to cath the nosuchelement exception it will still throw the eror.
        try {
            driver.findElement(By.id("Pramod"));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }


    }
        @AfterTest
        public void closeBrowser(){
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            driver.quit();

    }
}
