package com.thetestingacademy.ex11_Action_Window_iframe;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSelenium45_uploadFile_p7 {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);

    }
    @Description("Verify file uploaded ")
    @Test
    public void test_uploadFile() throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/selenium/upload.html");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement uploadFileInput = driver.findElement(By.id("fileToUpload"));
//        src/test/java/com/thetestingacademy/ex11_Action_Window_iframe/Hello.txt

        String dir = System.getProperty("user.dir");
        System.out.println(dir);
//        C:\Users\dkris\IdeaProjects\LearningSeleniumATB9x/src/test/java/com/thetestingacademy/ex11_Action_Window_iframe/Hello.txt
    uploadFileInput.sendKeys(dir+"/src/test/java/com/thetestingacademy/ex11_Action_Window_iframe/Hello.txt");
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
