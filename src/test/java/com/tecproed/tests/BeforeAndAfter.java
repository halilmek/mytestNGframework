package com.tecproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;

import javax.xml.transform.sax.SAXSource;
import java.util.concurrent.TimeUnit;

public class BeforeAndAfter {

    WebDriver driver;// globally created for using in each method.

    @Before //we use @Before for repeated pre conditions.
//@Before method is used to setup the driver, or open the browser
// or go to URL. the main aim is to avoid repetitions.
//what repeats in all 3 methods at the beginnings?
//@Before method will run before each @Test method.
//this @Before method will run 3 times before each @Test method
//if internet/browser/website is slow, then you may see
// some exceptions and your test case may fail.
// to avoid from this, we can put some wait in @Before annotation.
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.google.com/");
//we can put implicitly wait for slower website.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
    }


   @Test// we need to use this from junit, because we use @Before.
//otherwise we will get java.lang.NullPointerException.
    public void titleTest(){
//verify if google title ="Google"
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver=new ChromeDriver();
        //driver.get("https://www.google.com/");
        String titleOfGoogle=driver.getTitle();
        String expected="Google";
        if (titleOfGoogle.equals(expected)){
            System.out.println("PASS!!!");
        }else{
            System.out.println("FAIL???");
        }
       // driver.close();
    }

    @Test
    public void titleTest1(){
//verify if google title ="Google"
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver=new ChromeDriver();
        //driver.get("https://www.google.com/");
        if (driver.getTitle().equals("Gooogle")){
            System.out.println("PASS!!!");
        }else{
            System.out.println("FAIL???");
        }
       // driver.close();
    }

    @Test
    public void imageTest() {

//verify google image is displayed or not!
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver=new ChromeDriver();
        //driver.get("https://www.google.com/");
//<div style="display:inline-block;position:relative;height:196px;width:550px" id="hplogo"><a href="/search?sxsrf=ALeKk03GSjF8a0ugjsgit-NpBmAJPXcn_g:1586344880810&amp;q=%CE%88%CE%BD%CE%B1+%CE%BC%CE%B5%CE%B3%CE%AC%CE%BB%CE%BF+%CE%B5%CF%85%CF%87%CE%B1%CF%81%CE%B9%CF%83%CF%84%CF%8E+%CF%83%CE%B5+%CF%8C%CE%BB%CE%BF%CF%85%CF%82+%CF%8C%CF%83%CE%BF%CF%85%CF%82+%CE%BC%CE%AC%CF%87%CE%BF%CE%BD%CF%84%CE%B1%CE%B9+%CE%B5%CE%BD%CE%AC%CE%BD%CF%84%CE%B9%CE%B1+%CF%83%CF%84%CE%BF%CE%BD+%CE%BA%CE%BF%CF%81%CF%89%CE%BD%CE%BF%CF%8A%CF%8C&amp;oi=ddle&amp;ct=153203455&amp;hl=el&amp;sa=X&amp;ved=0ahUKEwj9h_CY29joAhXitYsKHb4EDd4QPQgN"><img alt="Σε όλους τους εργαζομένους στις υπηρεσίες έκτακτης ανάγκης, σας ευχαριστούμε" border="0" height="196" src="/logos/doodles/2020/thank-you-emergency-services-workers-6753651837108755-law.gif" style="padding-top:5px" title="Σε όλους τους εργαζομένους στις υπηρεσίες έκτακτης ανάγκης, σας ευχαριστούμε" width="550" data-atf="1"></a><div><style data-iml="1586344879984">.fOwUFe{height:26px;opacity:0.8;position:absolute;width:26px}.fOwUFe:hover{opacity:1}.dnNgC,.fJOQGe{height:22px;position:absolute;width:22px}.dnNgC{border-radius:6px;left:0;top:0}.fJOQGe{left:2px;top:2px}a:active .dnNgC,a:active .fJOQGe{margin:2px}</style><div class="fOwUFe" style="left:514px;top:165px"><a href="#" data-async-trigger="ddlshare" title="Share" jsaction="async.u" data-ved="0ahUKEwj9h_CY29joAhXitYsKHb4EDd4Q4zgIDg"><div class="dnNgC" style="background-color:#ffffff;border:2px solid #ffffff;opacity:0"></div><input value="//g.co/doodle/9qiaq" class="ddl-shortlink" type="hidden"><input value="//g.co/doodle/qyur5" class="ddl-facebooklink" type="hidden"><input value="//g.co/doodle/skvwa" class="ddl-twitterlink" type="hidden"><input value="" class="ddl-emaillink" type="hidden"><input value="//g.co/doodle/mpj52" class="ddl-copylink" type="hidden"><img class="fJOQGe" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABYAAAAWCAYAAADEtGw7AAAAoklEQVR42mMwTvvPQAZ2AOKZQPwAimdCxeBqyDX0DBD/R8NnkA0nx+CZWAyF4ZmUGPwAj8EPBp3BzkB8mdSgwBfTMkC8EsmAW8RGHq6YPgu14DOUD6IrgNiF2OSGL6ZheDUQyxEbbMREyCcgdiU1kkmKaXIMxhcUlylxMa7Iu0VpGONKbqDYL6ckVRDCZKdjmua84VkI0bQ8plkNQrM6jygMAODsqWK79M8/AAAAAElFTkSuQmCC" border="0" height="22" width="22" data-iml="1586344879985" data-atf="1"></a></div><div style="display:none" data-jiis="up" data-async-type="ddlshare" id="ddlshare" class="y yp" jsaction="asyncFilled:ddls.show"></div></div></div>
        WebElement image = driver.findElement(By.id("hplogo"));
        if (image.isDisplayed()) {
            System.out.println("pass!!");
            System.out.println(image.isDisplayed());
        } else {
            System.out.println("fail??");
        }
       // driver.quit();
    }

    @Test
    public void linkTest(){

//verify gmail link appears or not!
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver=new ChromeDriver();
        //driver.get("https://www.google.com/");
//<a class="gb_g" data-pid="23" href="https://mail.google.com/mail/?tab=wm&amp;authuser=0&amp;ogbl">Gmail</a>

        WebElement gmailElement=driver.findElement(By.linkText("Gmail"));
        System.out.println(gmailElement.isDisplayed());
    //driver.close();
    }

    @Test
    public void linkTest1(){

//verify gmail link appears or not!
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver=new ChromeDriver();
        //driver.get("https://www.google.com/");
//<a class="gb_g" data-pid="23" href="https://mail.google.com/mail/?tab=wm&amp;authuser=0&amp;ogbl">Gmail</a>

        WebElement gmailElement1=driver.findElement(By.linkText("Gmail"));
        if (gmailElement1.isDisplayed()){
            System.out.println("yeupppiii!!");
        }else{
            System.out.println("fail??");
        }
       // driver.close();
    }

    @After //the location of this method is not important. we can put
//put @After method anywhere we want. @After annotation is usually
//used to close the browser or to REPORT.
//this method will run after each @Test annotations
//this method will run 3 times, because we have 3 @Test annotations.
    public void tearDown(){
        driver.close();
    }

}
