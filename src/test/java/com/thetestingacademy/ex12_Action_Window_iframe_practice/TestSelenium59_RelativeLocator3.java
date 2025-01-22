package com.thetestingacademy.ex12_Action_Window_iframe_practice;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class TestSelenium59_RelativeLocator3 {
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
        WebElement form = driver.findElement(By.xpath("//form[@id=\"form\"]/button"));
        form.click();

        WebElement username_element = driver.findElement(By.xpath("//input[@id=\"username\"]"));

        WebElement eror_element = driver.findElement(with(By.tagName("small")).below(username_element));
        Thread.sleep(5000);

        String eror_text =eror_element.getText();
        Assert.assertTrue(eror_element.isDisplayed());
        Assert.assertEquals(eror_text,"Username must be at least 3 characters");


        

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
