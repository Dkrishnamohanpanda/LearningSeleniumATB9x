package com.thetestingacademy.ex12_Action_Window_iframe_practice;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSelenium50 {
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
        String URL = "https://awesomeqa.com/practice.html";
        driver.manage().window().maximize();
        driver.get(URL);

        WebElement firstname = driver.findElement(By.xpath("//input[@name = \"firstname\"]"));
//keyBoard
//        keydown --> shift ->sendkeys(type)->keyup
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT)
                .sendKeys(firstname,"the testing academy")
                .keyUp(Keys.SHIFT).build().perform();
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
