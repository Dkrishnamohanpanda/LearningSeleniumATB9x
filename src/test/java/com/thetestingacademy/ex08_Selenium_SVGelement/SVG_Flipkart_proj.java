package com.thetestingacademy.ex08_Selenium_SVGelement;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class SVG_Flipkart_proj {
    EdgeDriver driver;
    @BeforeTest
public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);

    }

    @Description("verify that after search ,results are visible")
    @Test
    public  void flipkart_Search(){

        String url = "https://www.flipkart.com";
        driver.get(url);
        driver.manage().window().maximize();
//        enter thge macmini in the inpout box

        driver.findElement(By.name("q")).sendKeys("macmini");

        //        step2 - click on the svg element
                 //*[name() ='svg']
                 //*[local-name() ='svg']
        List<WebElement> svg_elements = driver.findElements(By.xpath("//*[name() ='svg']"));
        svg_elements.get(0).click();

        List<WebElement> title_results = driver.findElements(By.xpath("//div[contains(@data-id,'CPU')]/div/a[2]"));
            for(WebElement title : title_results){
                System.out.println(title.getText());
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
