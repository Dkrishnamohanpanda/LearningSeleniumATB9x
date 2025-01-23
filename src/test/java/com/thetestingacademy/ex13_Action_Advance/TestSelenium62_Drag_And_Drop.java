package com.thetestingacademy.ex13_Action_Advance;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSelenium62_Drag_And_Drop {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);

    }
    @Description("Verify Drag_And_Drop ")
    @Test
    public void test_uploadFile() throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().window().maximize();
//        WE NEED TO FIND SORCE and destination
        WebElement source = driver.findElement(By.xpath("//div[@id=\"column-a\"]"));
        WebElement destination = driver.findElement(By.xpath("//div[@id=\"column-b\"]"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,destination).build().perform();
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
