package com.thetestingacademy.ex12_Action_Window_iframe_practice;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class TestSelenium53_window_p {
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
      driver.findElement(By.linkText("Click Here")).click();

//      getting both of the window
        Set<String> windowhandles = driver.getWindowHandles();
        System.out.println("Window Handles"+windowhandles);

        for(String handles:windowhandles){
            driver.switchTo().window(handles);
            if(driver.getPageSource().contains("New Window")){
                System.out.println("TestCase Passed");
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
