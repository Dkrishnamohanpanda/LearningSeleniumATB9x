package com.thetestingacademy.ex15_SeleniumException;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium67_TimeoutException {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);

    }
    @Description("Verify TimeOut Exception ")
    @Test
    public void test_staleElementException() throws Exception {

        WebDriver driver = new EdgeDriver();

            driver.get("https://google.com");
            driver.manage().window().maximize();

//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id=\"APjFqb\"]")));
//
//            WebElement searchinputBox = driver.findElement(By.xpath("//textarea[@id=\"APjFqb\"]"));
//            searchinputBox.sendKeys("thetestingacademy"+ Keys.ENTER);

// from the above code we are able to find the code.lets say their is a senario
// we are not able find the element then the driver will wait for 10 seconds
// if the driver will not able to find the element still 10sec then it will give eror


        try {
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id=\"APjF\"]")));

            WebElement searchinputBox1 = driver.findElement(By.xpath("//textarea[@id=\"APjFqb\"]"));
            searchinputBox1.sendKeys("thetestingacademy"+ Keys.ENTER);
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Programme is runnable");
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
