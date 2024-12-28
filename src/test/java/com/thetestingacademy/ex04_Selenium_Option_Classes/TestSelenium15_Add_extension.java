package com.thetestingacademy.ex04_Selenium_Option_Classes;

import io.qameta.allure.Description;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class TestSelenium15_Add_extension {

    @Description("Open the url")
    @Test
    public void test_selenium01() throws Exception {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--window-size=1280,720");
        edgeOptions.addExtensions(new File("src/test/java/com/thetestingacademy/ex04_Selenium_Option_Classes/AddBlocker.crx"));
//

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("103.152.112.120");
        edgeOptions.setCapability("proxy",proxy);

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://youtube.com");

//        Thread.sleep(5000);
//        driver.quit();

}
}
