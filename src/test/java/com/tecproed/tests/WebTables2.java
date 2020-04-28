package com.tecproed.tests;

import com.tecproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


public class WebTables2 extends TestBase {


    public void login(){
        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");
        WebElement userNameBox=driver.findElement(By.id("UserName"));
        WebElement passBox=driver.findElement(By.id("Password"));
        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));

        userNameBox.sendKeys("manager2");
        passBox.sendKeys("Man1ager2!");
        loginButton.click();
    }


   public void printData(int row, int column){
//String xpathData="//tbody//tr[8]//td[6]; --> this is direct. i need dynamic
//one.
//String xpathData1="//tbody//tr[8]//td[6]";
  // System.out.println(xpathData1);// in this string there is no
//parameter using, therefore syso will work just once.

String xpathData="//tbody//tr["+row+"]//td["+column+"]";
  // System.out.println(xpathData);

   //System.out.println(driver.findElement(By.xpath(xpathData)).getText());

//OR

WebElement dataValue=driver.findElement(By.xpath(xpathData));
       System.out.println(dataValue.getText());

   }

   @Test
public void printDataTest() throws InterruptedException {

    login();

printData(4,5);
printData(3,5);
printData(1,4);
   }

}
