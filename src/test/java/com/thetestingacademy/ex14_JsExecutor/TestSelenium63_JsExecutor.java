package com.thetestingacademy.ex14_JsExecutor;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSelenium63_JsExecutor {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);

    }
    @Description("Verify JsExecutor ")
    @Test
    public void test_JsExecutor() throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement div_to_Scroll = driver.findElement(By.xpath("//div[@id=\"userName\"]"));
//  js.executeScript("arguments[0].scrollIntoView(true);",div_to_Scroll);
//  scrolling 500 pixel
        js.executeScript("window.scrollTo(0,500)");
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
