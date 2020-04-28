package com.tecproed.tests;

import com.tecproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

//Create a new Class Tests package: WindowHandleExample
public class WindowHandleExamples extends TestBase {

    @Test
    public void newWindowTest(){
  //Given user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");

//first determine parent window.
        String paretnWindowHandle=driver.getWindowHandle();
        System.out.println("parent window handle "+paretnWindowHandle);

//<h3>Opening a new window</h3>
  //Then user verifies the text : “Opening a new window”
        Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().equals("Opening a new window"));

  //Then user verifies the title of the page is “The Internet”
        Assert.assertTrue(driver.getTitle().equals("The Internet"));

//When user clicks on the Click Here button
//<a href="/windows/new" ,="" target="_blank">Click Here</a>
        driver.findElement(By.linkText("Click Here")).click();
//after clicking i have 2 windows.
Set<String> allWindowHandles=driver.getWindowHandles();// to pass to new page we can
//use iterator, for loop, for each loop,

        System.out.println(allWindowHandles);
        for (String w:allWindowHandles){
            if (!w.equals(paretnWindowHandle)){
                driver.switchTo().window(w);
            }
        }
//Then user verifies the new window title is “New Window”
    Assert.assertTrue(driver.getTitle().equals("New Window"));
        System.out.println(driver.findElement(By.tagName("h3")).getText());

//When user goes back to the previous window and then verifies the title : “The Internet”
//how do you go back to parent window?
        driver.switchTo().window(paretnWindowHandle);//i switched to parent window.
        Assert.assertTrue(driver.getTitle().equals("The Internet"));//if i did not
//switch it to parent, it would fail.
    }

}
