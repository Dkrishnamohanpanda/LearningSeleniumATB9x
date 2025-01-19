package com.thetestingacademy.ex11_Action_Window_iframe;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSelenium40_Action_p2 {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);

    }
    @Description("Action class ")
    @Test
    public void test_actions() throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();

        WebElement sorce = driver.findElement(By.xpath("//div[@data-testid=\"to-testID-origin\"]/div/div/input"));
     Actions actions = new Actions(driver);
     actions.moveToElement(sorce).click().sendKeys("blr").build().perform();
//        sorce.sendKeys("blr");
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
