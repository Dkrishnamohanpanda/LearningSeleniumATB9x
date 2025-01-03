package com.thetestingacademy.ex07_Selenium_Webtables;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium25 {

    @Description("printing all in Webtables ")
    @Test
    public void test_webtable() throws Exception {

        WebDriver driver = new EdgeDriver();
    driver.get(" https://awesomeqa.com/hr/web/index.php/auth/login");
    driver.manage().window().maximize();

    Thread.sleep(3000);

    WebElement username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
    username.sendKeys("admin");
    WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
    password.sendKeys("Hacker@4321");

    WebElement login =driver.findElement(By.xpath("//button[@type =\"submit\"]"));
    login.click();
//
//    WebElement table = driver.findElement(By.xpath(" //table[@summary=\"Sample Table\"]/tbody"));
//
////rows and colomns
//        List<WebElement> rows_tables =table.findElements(By.tagName("tr"));
//
//        for(int i=0;i<rows_tables.size();i++){
//            List<WebElement> cols =rows_tables.get(i).findElements(By.tagName("td"));
//            for(WebElement c :cols){
//                System.out.println(c.getText());
//            }
//        }
        Thread.sleep(3000);
        driver.quit();

}
}
