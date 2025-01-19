package com.thetestingacademy.ex09_Selenium_Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class TestSelenium30_InputBox_CheckBox_RadioBox {
    public static void main(String[] args) {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/practice.html");
        driver.findElement(By.name("firstname")).sendKeys("thetestingacademy");
//RadioBox
        driver.findElement(By.id("sex-1")).click();

//        checkBox
        driver.findElement(By.id("tool-1")).click();
        driver.quit();
    }
}
