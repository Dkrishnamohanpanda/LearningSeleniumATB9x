package com.thetestingacademy.ex12_Action_Window_iframe_practice;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium52_Action_MakeMyTrip {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);

    }
    @Description("Verify Action")
    @Test
    public void test_Action() throws InterruptedException{
        String URL = "https://www.makemytrip.com/";
        driver.manage().window().maximize();
        driver.get(URL);
//
//        WebElement close_modal = driver.findElement(By.xpath("//span[@data-cy=\"closeModal\"]"));
//        try{
//            Thread.sleep(13000);
//        }catch(InterruptedException e){
//            throw new RuntimeException(e);
//        }
//
//        Actions actions = new Actions(driver);
//         actions.moveToElement(close_modal).click().build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy=\"closeModal\"]")));

        driver.findElement(By.xpath("//span[@data-cy=\"closeModal\"]")).click();

        WebElement formCity =driver.findElement(By.xpath("//input[@data-cy=\"fromCity\"]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(formCity).click().sendKeys("Blr").build().perform();

        Thread.sleep(3000);

        actions.moveToElement(formCity).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();

    }
    @AfterTest
    public void closeBrowser(){
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }

}
