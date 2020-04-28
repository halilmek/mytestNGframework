package com.tecproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class DropDown {

    WebDriver driver; // instance variable.

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
//dropdowns are in select class.
//1. locate the select element using any locator.
//
    public void dropDownTest(){
//<select id="dropdown">
//    <option value="" disabled="disabled" selected="selected">Please select an option</option>
//    <option value="1">Option 1</option>
//    <option value="2">Option 2</option>
//  </select>

        WebElement selectElementTitle=driver.findElement(By.id("dropdown"));

//2. create Select object and pass the select Element to that object.
        Select option=new Select(selectElementTitle);// now we can use the Select object
// to reach the dropdown option.
        System.out.println(option.getFirstSelectedOption().getText());//to get the selected option we use this.


    }
}
