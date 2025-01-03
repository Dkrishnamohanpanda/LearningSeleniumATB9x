package com.thetestingacademy.ex08_Selenium_SVGelement;

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
    driver.get("https://www.amcharts.com/svg-maps/?map=india");
    driver.manage().window().maximize();

Thread.sleep(3000);
        //*[local-name()="svg"]/*[name()='g'][7]/*[name() ='g']/*[name()='g']/*[name()='path']

     List<WebElement> states=driver.findElements(By.xpath("//*[local-name()=\"svg\"]/*[name()='g'][7]/*[name() ='g']/*[name()='g']/*[name()='path']"));
  for(WebElement state:states){
      System.out.println(state.getAttribute("aria-label"));
      if(state.getAttribute("aria-label").contains("Odisha")){
          state.click();
      }
  }

    }
}
