package com.tecproed.tests;

import com.tecproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnableTest extends TestBase {
/*
When use goes to https://the-internet.herokuapp.com/dynamic_controls
    And clicks on Enable button
    Then verify that textbox is enable-I can type in
    And verify the text "It's enabled!"
 */

    @Test
    public void isEnabled(){

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//<button autocomplete="off" type="button" onclick="swapInput()">Enable</button>
        WebElement enableIsOk=driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        enableIsOk.click();

        WebElement enabledMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertEquals(enabledMessage.getText(),"It's enabled!");

//<input type="text" style="width: 30%;">
WebElement typingEnabledArea=driver.findElement(By.xpath("//input[@type='text']"));

//isDisplayed ==> if an element displays or not on the page!
//isSelected==> clicking radio button or check button!
//isEnabled ==> to check if an element is enabled or not!
        boolean isEnable=typingEnabledArea.isEnabled();
        Assert.assertTrue(isEnable);




    }

}


/*
public class EnableTest extends TestBase {
    /*
    When use goes to https://the-internet.herokuapp.com/dynamic_controls
    And clicks on Enable button
    Then verify that textbox is enable-I can type in
    And verify the text "It's enabled!"
     */
/*
@Test
public void isEnabled(){
    //I am creating a webdriverwait object
    WebDriverWait wait=new WebDriverWait(driver,10);
    //going to the page
    driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    //location enable button
    WebElement enableButton=driver.findElement(By.xpath("(//button[@type='button'])[2]"));
    //clicking on enable button
    enableButton.click();
    //waiting for the enabled message because it takes time to load.
    //Explicit wait will wait for that enabled message up to 10 seconds. If it locates in less than 10 sec, then it go to the next line
    //If that element is not found in 10 seconds, then this line will fail

    WebElement enabledMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

    //Verifying the enabled text message
    Assert.assertEquals(enabledMessage.getText(),"It's enabled!");
    //Locating textbox element
    WebElement textBox=driver.findElement(By.xpath("//input[@type='text']"));
    //To test is an element Enabled or Not, we can use isEnabled() method.
    //isDisplayed=>if an element displayed or not
    //isSelected=>radio button or checkbox
    //isEnabled=>to check if an element enabled or not.
    //checking the condition of the textbox. If it is enabled or not
    boolean isEnable=textBox.isEnabled();
    //Asserting if above statement is true or not
    Assert.assertTrue(isEnable);
}
}
 */