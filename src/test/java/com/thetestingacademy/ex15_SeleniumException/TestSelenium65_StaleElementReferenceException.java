package com.thetestingacademy.ex15_SeleniumException;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSelenium65_StaleElementReferenceException {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);

    }
    @Description("Verify StaleElementReference Exception ")
    @Test
    public void test_staleElementException() throws Exception {

        WebDriver driver = new EdgeDriver();
        try {
            driver.get("https://google.com");
            driver.manage().window().maximize();

            WebElement searchinputBox = driver.findElement(By.xpath("//textarea[@id=\"APjFqb\"]"));
            driver.navigate().refresh();
//now the HTML page(DOM) is refresh
// driver will think that the element may or may not be availaible now..
// Because driver found tyhe element before.
            searchinputBox.sendKeys("thetestingacademy"+ Keys.ENTER);
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getMessage());
        }
//stale element reference: stale element not found

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
