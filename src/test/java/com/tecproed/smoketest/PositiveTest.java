package com.tecproed.smoketest;

import com.tecproed.pages.FhcLoginPage;
import com.tecproed.utilities.TestBase;
import org.testng.annotations.Test;

public class PositiveTest extends TestBase {

    @Test
    public void positiveLoginTest(){

        driver.get("http://www.fhctrip.com/Account/Logon");

        FhcLoginPage fhcLoginPage=new FhcLoginPage(driver);

        fhcLoginPage.userName.sendKeys("manager2");
        fhcLoginPage.pass.sendKeys("Man1ager2!");
        fhcLoginPage.loginButton.click();
    }
}
