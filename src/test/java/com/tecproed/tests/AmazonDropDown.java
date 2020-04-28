package com.tecproed.tests;

import com.tecproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonDropDown extends TestBase {//2 days after
//we started to learn TestBase abstract class. so we could use.
//in order to make it clean we can use abstract class like here.

    @Test
    public void amazonTest(){

        driver.get("https://www.amazon.com/");

        WebElement dropDown=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropDown);
        String firstOption=select.getFirstSelectedOption().getText();
        Assert.assertEquals(firstOption,"All Departments");
        select.selectByIndex(3);
        String forthOption=select.getFirstSelectedOption().getText();
        Assert.assertEquals(forthOption,"Baby");

        List<WebElement> allOption=select.getOptions();
        for (WebElement option:allOption){
            System.out.println(option.getText());
        }
        List<String> alphabeticalOrderCheck=new ArrayList<String>();
        for (WebElement exChanging:allOption){
            alphabeticalOrderCheck.add(exChanging.getText());
        }
        System.out.println(alphabeticalOrderCheck);

        //yeni sıralı list
        List<String> alphabeticalOrderCheck1=new ArrayList<String>();
        for (String exChanging:alphabeticalOrderCheck){
            alphabeticalOrderCheck1.add(exChanging);
        }
        System.out.println("bu yeni olan alphabeticalOrderCheck1 "+alphabeticalOrderCheck1);

        //sort edelim
        Collections.sort(alphabeticalOrderCheck1);
        System.out.println("bu yeni olan alphabeticalOrderCheck1 "+alphabeticalOrderCheck1
        +"sortlu şekli");


        int count=0;
        for (int i=0; i<allOption.size();i++){
            if(alphabeticalOrderCheck.get(i).equals(alphabeticalOrderCheck1.get(i))){
                count=0;
            }else{
                count++;
            }
        }
        System.out.println(count);
        System.out.println("ödev kısmı sonucu aşağıda!");
        if(count>0){
            System.out.println("False");
        }else{
            System.out.println("True");
        }
        System.out.println("ödev kısmı sonucu yukarıda!");

//check if appliances id in the dropdown. print true if it is.
        for (WebElement option:allOption){
            if (option.getText().contains("Appliances")){
               System.out.println("True");
            }else{
               System.out.println("True");
           }
        }

        boolean flag=false;
        for (WebElement option:allOption){
            if (option.getText().contains("Appliances")){
                flag=true;
                break;
            }
        }
        System.out.println(flag);

            }

}
