package com.thetestingacademy.ex10_Selenium_ShadowDom;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSelenium38_JS_Executor_demo2 {
    EdgeDriver driver;
    @BeforeTest
public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);

    }

    @Description("verify javaScriptExecutor")
    @Test
    public  void test_javaScriptExecutor() throws InterruptedException {
//document.querySelectorAll("login-username") in javascript
        String url = "https://selectorshub.com/xpath-practice-page/";
        driver.get(url);
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor)driver;

       js.executeScript("window.scrollBy(0,500);");

       String url3 = js.executeScript("return document.URL;").toString();
       String title = js.executeScript("return document.title;").toString();


        System.out.println(url3);
        System.out.println(title);




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
