package com.thetestingacademy.ex12_Action_Window_iframe_practice;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSelenium51_Action_spicejet {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);

    }
    @Description("Verify Action")
    @Test
    public void test_Action() throws InterruptedException{
        String URL = "https://www.spicejet.com/";
        driver.manage().window().maximize();
        driver.get(URL);

        WebElement source = driver.findElement(By.xpath("   //div[@data-testid=\"to-testID-origin\"]/div/div/input"));
         Actions actions = new Actions(driver);
         actions.moveToElement(source).click().sendKeys("blr").build().perform();

//         source.click(); ->whenever the direct click are not happening
//        you need to move to thge action class
    }
    @AfterTest
    public void closeBrowser(){
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }

}
