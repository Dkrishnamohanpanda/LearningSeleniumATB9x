package com.thetestingacademy.ex03_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestSelenium04 {
@Description("Open App.vwo.com and get the title")
    @Test
    public void test_selenium01(){
    //webDriver ### **Hierarchy**
//  SearchContext -> Findelement(),findElements()
//   webDriver ->
//    RemoteWebDriver
//    EdgeDriver

    //  SearchContext -> Findelement(),findElements()
//   webDriver ->
//    RemoteWebDriver
//    ChromeDriver

//    SearchContext driver = new ChromeDriver();
//    WebDriver driver = new ChromeDriver();
//    RemoteWebDriver  driver = new ChromeDriver();
//    ChromeDriver = new ChromeDriver();


//    Scenarios
//    1.Do you want to run on edge or chrome
//    ChromeDriver driver = new ChromeDriver(); 1%


//  2.  Do you want to run on chrome then you want to change to edge

//    WebDriver driver = new ChromeDriver();
//    driver = new EdgeDriver();
//    driver = new FirefoxDriver();

//  3.  Do you want to run on multiple browsers,aws machine  2%
//    RemoteWebDriver driver(with Grid) - Advance  (Last 2 session)


    }
}
