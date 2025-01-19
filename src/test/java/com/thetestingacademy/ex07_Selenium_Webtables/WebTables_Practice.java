package com.thetestingacademy.ex07_Selenium_Webtables;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class WebTables_Practice {

    @Description("printing all in Webtables ")
    @Test
    public void test_webtable() throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/webtable.html");
        driver.manage().window().maximize();

//        p1: print all data in the table
//        p2:print helen Banett belongs to which country
//        //table[@id = "customers"]/tbody/tr[5]/td[2]


        String first_part = " //table[@id = \"customers\"]/tbody/tr[";
        String second_part ="]/td[";
        String third_part = "]";

        int row =driver.findElements(By.xpath("//table[@id = \"customers\"]/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@id = \"customers\"]/tbody/tr[2]/td")).size();

        for(int i=2;i<=row;i++){
            for(int j =1;j<=col;j++){
                String dynamic_PATH = first_part+i+second_part+j+third_part;
//             System.out.println(dynamic_PATH);
                String data = driver.findElement(By.xpath(dynamic_PATH)).getText();
//             System.out.println(data);
                if(data.contains("Helen Bennett")){
                    String country_path = dynamic_PATH+"/following-sibling::td";
                    String country_text =driver.findElement(By.xpath(country_path)).getText();
                    System.out.println("-----------------------------");
                    System.out.println("Helen Benet is in -"+country_text);
                }
            }
        }



    }
}
