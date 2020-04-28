package com.tecproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
//what is the abstract class?
//Where did you use abstract in your framework?
//i used abstract in my TestBase class. i had TestBase in my framework
//that was an abstract class. the purpose of that is not to create
//an object, but just to use its method. so we can keep clean our
//framework.


//we use TestBase for repeated actions such as setting up driver.
//creating the driver, maximizing the window.
//we have also wait in the TestBase Class.
//we have tearDown() method to close the browser after we are done with the test.
   protected WebDriver driver;// to be able to reach another class, i need to
// change the access modifier of this. its access modifier is default
//it means package private.
// it can be public but it is not safer. so i can use protected, then
//i can reach here from the child class.

    protected Actions actions;

    protected WebDriverWait wait;



    @BeforeMethod// is more dynamic than @BeforeClass
//annotations with Method is more dynamic than annotations with Class.
//it depends on the case when we choose method or class


    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        actions=new Actions(driver);

        wait=new WebDriverWait(driver,10);
        //Select select=new Select(); --> we can not use this here. because using
        //this class depend on any webelement which is local, not global.


        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
//implicit wait is global wait

//in case of not working one of timeouts, we put second one due to
//slowness of website.
        driver.manage().window().maximize();


    }

    @AfterMethod
    public void tearDown(){

        //driver.quit();

    }
}
