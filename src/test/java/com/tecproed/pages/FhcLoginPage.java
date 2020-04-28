package com.tecproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FhcLoginPage {

    WebDriver driver;

    //creating constructor!!
    public FhcLoginPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "UserName")
    public WebElement userName;

    @FindBy(id = "Password")
    public WebElement pass;

    @FindBy(id = "btnSubmit")
    public WebElement loginButton;



//to check error message appearing!!
    @FindBy(xpath = "//div[@id='divMessageResult']")
    public WebElement errorMessage;

}
