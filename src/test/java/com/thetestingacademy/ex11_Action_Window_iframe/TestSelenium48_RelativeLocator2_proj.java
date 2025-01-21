package com.thetestingacademy.ex11_Action_Window_iframe;

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

public class TestSelenium48_RelativeLocator2_proj {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);

    }
    @Description("Verify RealativeLocator ")
    @Test
    public void test_uploadFile() throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
        driver.manage().window().maximize();

        WebElement searchcity = driver.findElement(By.xpath("//input[@placeholder =\"Search\"]"));
        searchcity.sendKeys("India"+ Keys.ENTER);

        List<WebElement> list_of_states = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));

        for (WebElement l : list_of_states) {
            System.out.println(l.getText());
            String s1 = driver.findElement(with(By.tagName("p")).toRightOf(l)).getText();
            String s2 = driver.findElement(with(By.tagName("p")).toLeftOf(l)).getText();
            String s3 = driver.findElement(with(By.tagName("p")).below(l)).getText();
            String s4 = driver.findElement(with(By.tagName("p")).above(l)).getText();
            System.out.println(l.getText() + " | " + s1 + " | " + s2);
            System.out.println(l.getText() + " | " + s3 + " | " + s4);

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
