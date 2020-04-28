package com.tecproed.tests;

import com.tecproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import javax.print.DocFlavor;
import java.security.Key;


public class ActionsClassExample extends TestBase {

    @Test
    public void contextClickMethod(){
        //Given user is on the https://the-internet.herokuapp.com/context_menu
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //When use Right clicks on the box
        //1. Identify the webelement
        WebElement rectangle=driver.findElement(By.id("hot-spot"));
        //2.Create Actions Object
        Actions actions=new Actions(driver);
        //3.Now I have actions object, I can perform mouse and keyboard actions
        //actions.contextClick().perform();//This is not going to click on the specific element
        actions.contextClick(rectangle).perform();
        //Then verify the alert message is “You selected a context menu”
        String actualText=driver.switchTo().alert().getText();
        String expectedText="You selected a context menu";
        Assert.assertEquals(actualText,expectedText);
        //Then accept the alert
        driver.switchTo().alert().accept();
        actions.contextClick(rectangle).perform();
        //Now Right Click On the Element selenium==>HOMEWORK
    }
    @Test
    public void hoverOver(){
        /*Create another test method : hoverOver() and test the following scenario:
        Given user is on the https://www.amazon.com/
        When use click on “Your Account” link
        Then verify the page title contains “Your Account”
         */
        driver.get("https://www.amazon.com/");

        WebElement hoverOverPopUp=driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));

        //Actions actions=new Actions(driver);//TestBase has this, so we can use actions
        //directly.
        actions.moveToElement(hoverOverPopUp).build();
        actions.moveToElement(hoverOverPopUp);
        actions.moveToElement(hoverOverPopUp).perform();

        WebElement yourAccount=driver.findElement(By.linkText("Your Account"));
        yourAccount.click();

        String actualTitle=driver.getTitle();
        String expectedTitle="Your Account";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void imageTest(){
/*
Create a method: imageTest()
Hover over the Try Prime
And Verify the image displays.
 */
        driver.get("https://www.amazon.com/");
//<span class="icp-nav-language">EN</span>
        WebElement hoverOverTryPrime=driver.findElement(By.className("icp-nav-language"));
//we deleted the Action class and object creation. we moved it to TestBase.
        actions.moveToElement(hoverOverTryPrime).perform();
        Assert.assertTrue(hoverOverTryPrime.isDisplayed());
        WebElement deutscheClick=driver.findElement(By.linkText("Deutsch - DE"));
        deutscheClick.click();
    }

    @Test
    public void keysUpDown(){
        driver.get("https://www.google.com/");
        WebElement searchBox=driver.findElement(By.name("q"));
        searchBox.sendKeys("iphone x prices");
//change the letters from lowercase to uppercase

        searchBox.clear();

        //method 1.
        searchBox.sendKeys(Keys.SHIFT+"iphone x prices");

        //method 2.
        actions.
                moveToElement(searchBox).
                    click().
                        keyDown(Keys.SHIFT).
                                sendKeys("iphone x prices").
                                    perform();
        searchBox.clear();

        actions.//using the action object. ==> mause and keyboard action.
                keyDown(searchBox, Keys.SHIFT).//pressing shift button.
                    sendKeys("iphone x prices").//typing.
                        keyUp(searchBox, Keys.SHIFT).//releasing the shift button
                            keyDown(searchBox, Keys.SHIFT).sendKeys("son gülen").
                keyUp(searchBox, Keys.SHIFT).sendKeys("iyi gülermiş").
                                perform();//performing the action.
    }

    @Test
    public void iphone11(){

        driver.get("https://www.google.com/");
        WebElement searchBox=driver.findElement(By.name("q"));

        Actions actions=new Actions(driver);

        actions.keyDown(searchBox,Keys.SHIFT).sendKeys("iphone ").
                keyUp(searchBox,Keys.SHIFT).sendKeys("11").perform();

        //searchBox.clear();


    }


    @Test
    public void scrollUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_UP).build();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);//hard wait.


        // it is better to put wait for threading.
        Thread.sleep(5000);
        //page up.
        actions.sendKeys(Keys.PAGE_UP).perform();

//use arrow down.
        actions.sendKeys(Keys.ARROW_DOWN).perform();
//ARROW_DOWN scrolls down more less then PAGE_DOWN.
//use ARROW_UP
        actions.sendKeys(Keys.ARROW_UP).perform();
    }

}
