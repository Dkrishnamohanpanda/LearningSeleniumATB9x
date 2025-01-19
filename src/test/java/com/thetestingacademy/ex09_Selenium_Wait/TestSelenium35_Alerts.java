package com.thetestingacademy.ex09_Selenium_Wait;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TestSelenium35_Alerts {
    public static void main(String[] args) {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

//        //button[@onclick ="jsAlert()"]
//        //button[text() ='Click for JS Alert']

//        WebElement element = driver.findElement(By.xpath("//button[@onclick =\"jsAlert()\"]"));
//
//             element.click();
//
//        Alert alert =driver.switchTo().alert();
//        alert.accept();
//
//         String result = driver.findElement(By.id("result")).getText();
//        Assert.assertEquals(result,"You successfully clicked an alert");

//
//        WebElement element_confirm = driver.findElement(By.xpath("//button[text() ='Click for JS Confirm']"));
//        element_confirm.click();
//
//        Alert alert =driver.switchTo().alert();
//        alert.dismiss();
//
//         String result = driver.findElement(By.id("result")).getText();
//        Assert.assertEquals(result,"You clicked: Cancel");

        WebElement element_prompt= driver.findElement(By.xpath("//button[text() ='Click for JS Prompt']"));
        element_prompt.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("krishna");
        alert.accept();



        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result,"You entered: krishna");


    }
}
