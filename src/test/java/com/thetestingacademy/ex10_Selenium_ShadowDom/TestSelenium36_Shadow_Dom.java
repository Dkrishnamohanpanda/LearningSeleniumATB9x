package com.thetestingacademy.ex10_Selenium_ShadowDom;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium36_Shadow_Dom {
    EdgeDriver driver;
    @BeforeTest
public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);

    }

    @Description("verify Shadow_Dom")
    @Test
    public  void test_Shadow_DOM(){

        String url = "https://selectorshub.com/xpath-practice-page/";
        driver.get(url);
        driver.manage().window().maximize();



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
