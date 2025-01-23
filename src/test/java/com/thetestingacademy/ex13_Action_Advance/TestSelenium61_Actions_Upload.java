package com.thetestingacademy.ex13_Action_Advance;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSelenium61_Actions_Upload {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);

    }
    @Description("Verify Scroll ")
    @Test
    public void test_scroll() throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/selenium/upload.html");
        driver.manage().window().maximize();

        WebElement file_Upload =driver.findElement(By.id("fileToUpload"));

//src/test/java/com/thetestingacademy/ex13_Action_Advance/upload.txt :copy path from content root
//  working dir :C:\Users\dkris\IdeaProjects\LearningSeleniumATB9x

        String working_dir =System.getProperty("user.dir");
        System.out.println(working_dir);

        file_Upload.sendKeys(working_dir+"/src/test/java/com/thetestingacademy/ex13_Action_Advance/upload.txt");
        driver.findElement(By.name("submit")).click();

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
