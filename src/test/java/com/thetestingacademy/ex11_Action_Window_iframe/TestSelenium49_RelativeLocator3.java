package com.thetestingacademy.ex11_Action_Window_iframe;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class TestSelenium49_RelativeLocator3 {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);

    }
    @Description("Verify RealativeLocator ")
    @Test
    public void test_uploadFile() throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        driver.manage().window().maximize();
        Thread.sleep(15000);

//        iframe
        driver.switchTo().frame("result");

        WebElement button = driver.findElement(By.xpath("//form[@id =\"form\"]/button"));
        button.click();

        WebElement element = driver.findElement(By.xpath("//input[@id=\"username\"]"));
        WebElement erorElement = driver.findElement(with(By.tagName("small")).below(element));

        String erorText = erorElement.getText();
        Assert.assertEquals(erorText,"Username must be at least 3 characters");

        Thread.sleep(5000);


        

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
