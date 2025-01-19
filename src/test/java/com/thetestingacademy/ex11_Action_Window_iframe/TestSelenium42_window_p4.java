package com.thetestingacademy.ex11_Action_Window_iframe;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class TestSelenium42_window_p4 {
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
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();

        String parentWindow = driver.getWindowHandle();
        System.out.println("parent window handle :"+ parentWindow);

        driver.findElement(By.linkText("Click Here")).click();
// getting both of the window
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("window Handles :"+ windowHandles);

//        switch between them
        for(String handle:windowHandles){
            driver.switchTo().window(handle);
//            if the page contains new window then print test case passed
            if(driver.getPageSource().contains("New Window")){
                System.out.println("Test case passed");
                break;
            }
        }

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
