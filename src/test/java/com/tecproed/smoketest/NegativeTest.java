package com.tecproed.smoketest;

import com.tecproed.pages.FhcLoginPage;
import com.tecproed.utilities.ConfigReader;
import com.tecproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTest extends TestBase {

    @Test //correct user name but incorrect pass!!
    public void invalidPass(){

//creating explicit wait object!!
        WebDriverWait wait=new WebDriverWait(driver,10);
//driver.get("http://www.fhctrip.com/Account/Logon"); //--> hard coded!!
driver.get(ConfigReader.getProperties("fhc_login_url"));
        FhcLoginPage fhcLoginPage=new FhcLoginPage(driver);


//fhcLoginPage.userName.sendKeys("manager2"); --> hard coded!!
fhcLoginPage.userName.sendKeys(ConfigReader.getProperties("valid_userName"));

//fhcLoginPage.pass.sendKeys("abidikgubidik"); ==>hard coded!!
fhcLoginPage.pass.sendKeys(ConfigReader.getProperties("invalid_pass"));

fhcLoginPage.loginButton.click();



//all of this is enough? no, we need to verify, therefore we are gonna use
//assertion!!
//Assert.assertTrue(fhcLoginPage.errorMessage.getText().contains("again"));
//instead of above one, lets try below one!!

Assert.assertTrue(fhcLoginPage.errorMessage.getText().contains(ConfigReader.getProperties("login_error_message")));

    }

//C:\Users\halil\IdeaProjects\mytestNGframework\src\test\java\com\tecproed\smoketest\NegativeTest.java


@Test //wrong user name and correct password!!
    public void invalidId(){

//driver.get("http://www.fhctrip.com/Account/Logon");
driver.get(ConfigReader.getProperties("fhc_login_url"));

FhcLoginPage fhcLoginPage=new FhcLoginPage(driver);

//fhcLoginPage.userName.sendKeys("abidikgubidik");
fhcLoginPage.userName.sendKeys(ConfigReader.getProperties("invalid_userName"));

//fhcLoginPage.pass.sendKeys("Man1ager!2"); instead of this!!
fhcLoginPage.pass.sendKeys(ConfigReader.getProperties("valid_pass"));

fhcLoginPage.loginButton.click();

//assertion!! verify if it is ok!!
//Assert.assertTrue(fhcLoginPage.errorMessage.getText().contains("again"));

Assert.assertTrue(fhcLoginPage.errorMessage.getText().contains(ConfigReader.getProperties("login_error_message")));

    }


    @Test // -->both are incorrect!!
    public void bothOfThemInvalid(){

//driver.get("http://www.fhctrip.com/Account/Logon");
        //instead of this!!
driver.get(ConfigReader.getProperties("fhc_login_url"));

        FhcLoginPage fhcLoginPage=new FhcLoginPage(driver);

//fhcLoginPage.userName.sendKeys("abidikgubidik");
        //instead of this!!
fhcLoginPage.userName.sendKeys(ConfigReader.getProperties("invalid_userName"));

//fhcLoginPage.pass.sendKeys("abidikgubidik");
        //instead of above one!!
fhcLoginPage.pass.sendKeys(ConfigReader.getProperties("invalid_pass"));

        fhcLoginPage.loginButton.click();

//assertion!!
//i can find the error message by putting explicit wait!!

WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='divMessageResult']")));
//Assert.assertTrue(fhcLoginPage.errorMessage.getText().contains("again"));
    //instead of above one!!
Assert.assertTrue(fhcLoginPage.errorMessage.getText().contains(ConfigReader.getProperties("login_error_message2")));

//another way to assert!!
//Assert.assertTrue(message.getText().contains("Wrong"));


    }
}
