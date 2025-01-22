package com.thetestingacademy.ex12_Action_Window_iframe_practice;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSelenium56_JavaScriptExecutor {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);

    }
    @Description("windows ")
    @Test
    public void test_window() throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();
        Thread.sleep(5000);

       JavascriptExecutor js = (JavascriptExecutor) driver;
//scrolling
       WebElement scroll_username = driver.findElement(By.xpath("//div[@id=\"userName\"]"));
       js.executeScript("arguments[0].scrollIntoView(true);",scroll_username);


//navigate to other webpage
        js.executeScript("window.location='https://google.com'");







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
