package com.thetestingacademy.ex11_Action_Window_iframe;

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

public class TestSelenium43_Action_iframe_p5 {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);

    }
    @Description("Verify Heatmap(app.vwo.com) ")
    @Test
    public void test_Heatmap_ClickmapButton() throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Parent Winow handle :" + mainWindowHandle);

        List<WebElement> list_heatmap = driver.findElements(By.xpath("//div[@class=\"screenshot-thumb ng-isolate-scope\"]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(list_heatmap.get(1)).click().build().perform();

        Thread.sleep(13000);

        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("All window handles" + allHandles);

        for(String handle : allHandles){
            if(!handle.equals(mainWindowHandle)){
                driver.switchTo().window(handle);
                System.out.println("Child window handle"+driver.getTitle());
                driver.switchTo().frame("heatmap-iframe");

                WebElement clickMap = driver.findElement(By.xpath("//div[@data-qa=\"liqokuxuba\"]"));
                clickMap.click();

            }
        }
        driver.switchTo().window(mainWindowHandle);


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
