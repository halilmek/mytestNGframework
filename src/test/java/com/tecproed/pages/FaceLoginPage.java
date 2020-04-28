package com.tecproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceLoginPage {//this is object class!! we dont need extends!!

//we will create page objects (webelements) in this class
//
//we will store all of the face log page object in this class and use
//in test.

// 1. creating driver!!
    WebDriver driver;

// 2. initializing the driver using constructor!!
    public FaceLoginPage(WebDriver driver){

//we are using PageFactory to initialize the driver!!
        PageFactory.initElements(driver,this); //driver is page
// instance, this means page instance!!
        this.driver=driver;
    }

    @FindBy(xpath = "//input[@type='email']")
    public WebElement email;

    @FindBy(id="pass")
    public WebElement pass;


    @FindBy(id = "u_0_b")
    public WebElement loginButton; //if i use vary browser, then i need to use
    //css locator, because it does not change browser by browser!!






}
