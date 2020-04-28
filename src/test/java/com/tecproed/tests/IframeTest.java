package com.tecproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {

    /*
    create class
     */

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void iframeTest(){

        //print the text on the parent iframe
        System.out.println(driver.findElement(By.xpath("//h3")).getText());
//i will not get exception when locating below (printing the
// sentence which is appearing inside the iframe), because
//that is not inside the iframe (appearance is misleading).
// everytime to use iframe we should switch the driver to iframe
// trying to type in the box.
        //WebElement textBoxForIframe=driver.findElement(By.xpath("//p"));
        //checking of the webelement is correct.
        //checking if i have a wait problem.
        //then check the page if you have some iframe.
        //i have iframe on the page. so i have to switch to that
        //iframe first.
        //there are 3 ways to switch to an iframe: 1.index,
        //2. id, 3. webelement
       // driver.switchTo().frame(0);// first switch, then create
        //webelement.
        driver.switchTo().frame("mce_0_ifr");
       // driver.switchTo().frame("//iframe[@id='mce_0_ifr']");
        //driver.switchTo().frame(textBoxForIframe);
        WebElement textBox=driver.findElement(By.xpath("//p"));
        textBox.clear();
        textBox.sendKeys("hello world! ya sen nasıl bir insansın");
// if we use driver keyword for whole methods, we should get out from where
//iframe that was switched to.
//print "elemental selenium" text part
//first switch back to parent frame.
//driver.switchTo().parentFrame();

// driver.switchTo().defaultContent();
//WebElement seleniumText=driver.findElement(By.linkText("Elemental Selenium"));
//System.out.println(seleniumText.getText());

    }
}
