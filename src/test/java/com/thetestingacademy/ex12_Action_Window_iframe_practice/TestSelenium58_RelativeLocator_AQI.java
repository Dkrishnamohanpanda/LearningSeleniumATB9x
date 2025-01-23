package com.thetestingacademy.ex12_Action_Window_iframe_practice;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class TestSelenium58_RelativeLocator_AQI {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);

    }
    @Description("Verify RealativeLocator ")
    @Test
    public void test_relativeLocator() throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
        driver.manage().window().maximize();
//to search all the polutted city in india
        List<WebElement> search_box = driver.findElements(By.xpath("//input[@type=\"search\"]"));
        search_box.get(1).sendKeys("India"+ Keys.ENTER);

        Thread.sleep(5000);

//        get all the poluuted city of india list
        List<WebElement> location = driver.findElements(By.cssSelector("div.location-name>p"));

        for(WebElement e:location){
            System.out.println(e.getText());

            String s1 = driver.findElement(with(By.tagName("p")).toLeftOf(e)).getText();
            String s2 = driver.findElement(with(By.tagName("span")).toRightOf(e)).getText();
//            System.out.println(s1);
//            System.out.println(s2);
            System.out.println( s1  +  e.getText()+    s2);
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
