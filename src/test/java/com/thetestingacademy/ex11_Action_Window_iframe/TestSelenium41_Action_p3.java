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
import java.util.List;

public class TestSelenium41_Action_p3 {
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
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();

//        //span[@data-cy="closeModal"]
         WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//         wait until element is visible
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy=\"closeModal\"]")));

        driver.findElement(By.xpath("//span[@data-cy=\"closeModal\"]")).click();


        WebElement form_city = driver.findElement(By.id("fromCity"));

        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(form_city).click().sendKeys("del").perform();

//        List<WebElement> city_suggest = driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li"));
//
//        for(WebElement e : city_suggest){
//            if(e.getText().contains("New Delhi")){
//                e.click();
//                break;
//            }
//        }
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }

        actions.moveToElement(form_city).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ARROW_DOWN).perform();
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
