package com.thetestingacademy.ex07_Selenium_Webtables;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium24_dynamic_WEBTABLE {

    @Description("printing all in Webtables ")
    @Test
    public void test_webtable() throws Exception {

        WebDriver driver = new EdgeDriver();
    driver.get("https://awesomeqa.com/webtable1.html");
    driver.manage().window().maximize();

    WebElement table = driver.findElement(By.xpath(" //table[@summary=\"Sample Table\"]/tbody"));

//rows and colomns
        List<WebElement> rows_tables =table.findElements(By.tagName("tr"));

        for(int i=0;i<rows_tables.size();i++){
            List<WebElement> cols =rows_tables.get(i).findElements(By.tagName("td"));
            for(WebElement c :cols){
                System.out.println(c.getText());
            }
        }


}
}
