package com.tecproed.tests;

import com.tecproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitTest extends TestBase {


    @Test
    public void implicitWait(){

    driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//<button autocomplete="off" type="button" onclick="swapCheckbox()">Remove</button>

WebElement removeButton=driver.findElement(By.xpath("//button[@type='button']"));
removeButton.click();

WebElement message=driver.findElement(By.id("message"));

Assert.assertEquals(message.getText(),"It's gone!");

    }

    @Test
    public void explicitWait(){

        WebDriverWait wait=new WebDriverWait(driver,10);

driver.get("https://the-internet.herokuapp.com/dynamic_controls");
WebElement removeButton=driver.findElement(By.xpath("//button[@type='button']"));
removeButton.click();

//WebElement message=driver.findElement(By.id("message"));

//create again webelement

WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

Assert.assertEquals(message.getText(),"It's gone!");


    }

}
