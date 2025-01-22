package com.thetestingacademy.ex12_Action_Window_iframe_practice;

import com.beust.ah.A;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class TestSelenium54_Vwo_Actio_Windo_iframe {
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
        driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window "+parentWindow);

        List<WebElement> heatMaps = driver.findElements(By.cssSelector("[data-qa=\"yedexafobi\"]"));

        Actions action = new Actions(driver);
        action.moveToElement(heatMaps.get(1)).click().build().perform();

        Thread.sleep(13000);

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("All Handles" +windowHandles);

        for(String handle: windowHandles){
            if(!handle.equals(parentWindow)){
                driver.switchTo().window(handle);
                driver.switchTo().frame("heatmap-iframe");

                WebElement clickMap = driver.findElement(By.cssSelector("[data-qa=\"liqokuxuba\"]"));
                clickMap.click();
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
