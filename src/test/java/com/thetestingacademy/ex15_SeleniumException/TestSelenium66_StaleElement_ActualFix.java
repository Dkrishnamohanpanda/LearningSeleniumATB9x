package com.thetestingacademy.ex15_SeleniumException;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSelenium66_StaleElement_ActualFix {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);

    }
    @Description("Verify StaleElementReference Exception ")
    @Test
    public void test_staleElementException() throws Exception {

        WebDriver driver = new EdgeDriver();
        try {
            driver.get("https://google.com");
            driver.manage().window().maximize();

            WebElement searchinputBox = driver.findElement(By.xpath("//textarea[@id=\"APjFqb\"]"));
            driver.navigate().refresh();

//    ACTUAL FIX:        you need to refind the Element


      searchinputBox = driver.findElement(By.xpath("//textarea[@id=\"APjFqb\"]"));

            searchinputBox.sendKeys("thetestingacademy"+ Keys.ENTER);
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getMessage());
        }
//stale element reference: stale element not found
        System.out.println("other code can run");
//        try catch only handles the exceptio
//
//     whenever the page changes driver knows about it so it gives stalelementException

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
