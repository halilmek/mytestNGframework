package com.tecproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingAlerts {

    /*
    create 3 methods
    1. acceptAlert
    2. dismissAlert
    3. sendKeysAlert
    go to https://the-internet.herokuapp.com/javascript_alerts
     */

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void acceptAlerts(){

        WebElement clickAlert=driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        clickAlert.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();//switching
//to the alert then accepting the alert (clicking ok).

        //i m checking if i clicked Ok by verifying the
//the result message.
        WebElement resultUp=driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultUp.isDisplayed());// isDisplayed() ==> returns true or false. var mı diye bakıyor sadece true false cevap veriyor.
    }

    @Test
    public void dismissAlerts(){

        //click on the 2nd button and click cancel and verify
//that you clicked.
        WebElement dismiss=driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        dismiss.click();
        driver.switchTo().alert().dismiss();// pop up lar için özel kodlama

        WebElement verifyDismissResult=driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(verifyDismissResult.getText(),"You clicked: Cancel");// verify için illa ki isDisplayed() yazamaya gerek yok.
        // ama formal kısmı isDisplayed().

    }

    @Test
    public void sendKeysAlerts(){

        WebElement sendKeysForPrompt=driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        sendKeysForPrompt.click();
        driver.switchTo().alert().sendKeys("baboş nabersin!");

        driver.switchTo().alert().accept();// burda 2 tane handling methodu kullanılıyor. tıklamayı unutmamak lazım.

        WebElement verifyPromptResult=driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(verifyPromptResult.getText(),"You entered: baboş nabersin!");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
