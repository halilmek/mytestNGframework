package com.tecproed.pageobjecttests;

import com.tecproed.pages.FaceLoginPage;
import com.tecproed.utilities.TestBase;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    //FaceLoginPage faceLoginPage=new FaceLoginPage(driver);

    @Test
    public void firstPageObjectTestLoginTest(){
        driver.get("https://www.facebook.com/");
        FaceLoginPage faceLoginPage=new FaceLoginPage(driver); //--> instead
//of creating it here, we can move it to class level. thus, we wont need
//to create object again and again if we need that.
        faceLoginPage.email.sendKeys("fakeusername");
        faceLoginPage.pass.sendKeys("fakepass");
        faceLoginPage.loginButton.click();

    }

}
