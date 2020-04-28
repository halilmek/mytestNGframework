package com.tecproed.tests;

import com.tecproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FaceLogin extends TestBase {

    @Test
    public void loginTest(){

driver.get("https://www.facebook.com/");
WebElement userName=driver.findElement(By.xpath("//*[@name='email']"));
WebElement pass=driver.findElement(By.xpath("//*[@name='pass']"));
WebElement loginButton=driver.findElement(By.xpath("//*[@id='u_0_b']"));

userName.sendKeys("fakeusername");
pass.sendKeys("fakepass");
loginButton.click();

WebElement verifyingFortgotPass=driver.findElement(By.partialLinkText("Forgot Password?"));
        Assert.assertTrue(verifyingFortgotPass.isDisplayed());
    }
}
