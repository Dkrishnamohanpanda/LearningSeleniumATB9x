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

public class TestSelenium37_JS_Executor {
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

        WebElement div_to_Scroll = driver.findElement(By.xpath("//div[@id =\"userName\"]"));
        js.executeScript("arguments[0].scrollIntoView(true);",div_to_Scroll);

       Thread.sleep(3000);

// document.querySelector("div#userName").shadowRoot.querySelector("div#app2").shadowRoot.querySelector("input#pizza")

    WebElement inputbox_pizza = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div#app2\").shadowRoot.querySelector(\"input#pizza\");");
     inputbox_pizza.sendKeys("farmhouse");







//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("alert(1)");


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
