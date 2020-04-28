package com.tecproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Soft_Hard_Assertions {

    /*
    When user goes to http://a.testaddressbook.com/sign_in
Locate the elements of email textbox,password textbox, and signin button
Enter below username and password then click sign in button
Username :  testtechproed@gmail.com
Password : Test1234!
Then Assert/Verify that the expected user id
testtechproed@gmail.com using different assertions
     */

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();// bunu yukarıda neden yapmıyor???
        driver.get("http://a.testaddressbook.com/sign_in");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void login(){
        WebElement emailBox=driver.findElement(By.id("session_email"));
        emailBox.sendKeys("testtechproed@gmail.com");
        WebElement passBox=driver.findElement(By.id("session_password"));
        passBox.sendKeys("Test1234!");
        WebElement logInButton=driver.findElement(By.name("commit"));
        logInButton.click();
    }

    @Test(dependsOnMethods = "login")
    public void homePage() {
        WebElement wellcomeMessage = driver.findElement(By.xpath("//h1"));
        System.out.println(wellcomeMessage.getText());//
        Assert.assertTrue(wellcomeMessage.isDisplayed());//hard assertion==> if else statement yerine bunlar kullanılıyormuş!
        System.out.println("this line will not run if hard assertion fails! ");
        //to fail, use ! sign before wellcomeMessage.isDisplayed().

        //SOFT ASSERT
        //step 1: create the object.
        SoftAssert softAssert=new SoftAssert();

        //step 2: use that object for assertion.
        softAssert.assertTrue(wellcomeMessage.isDisplayed());//pass
        softAssert.assertTrue(!wellcomeMessage.isDisplayed());//fail
        softAssert.assertEquals(3,5);//bunlar fail olsa da method çalışmaya devam eder.
        // ama assertAll() kullanılsa idi soft assert olarak, o zaman test orda fail verir ve devam etmez. çünkü
        //assertAll() hard assert gibi davranır.

        WebElement idElement=driver.findElement(By.className("navbar-text"));
        String actualId=idElement.getText();
        String expectedId="testtechproed@gmail";
        softAssert.assertEquals(expectedId,actualId);

//softAssert.assertAll() kills whole method if there is
//a false for soft assertion.
        softAssert.assertAll();//we use that for quick report.
//assertAll() is real assertion, it cancel everything after itsels
//it behaves like hard assertion.
        System.out.println("after all assertion");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
