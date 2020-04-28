package com.tecproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Assertions {

    WebDriver driver;

    @Before //is not a test method. it is just a setup method.
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void titleTest(){
        String actualTitle=driver.getTitle();
        String expectedTit="Google";

//Assert class is coming from JUnit.
//assertEquals() takes two string and checks if they are equal.
//it fails if they are not equal.
        Assert.assertEquals(actualTitle,expectedTit);
    }

    @Test
    public void titleTest1(){
        String actualTitle=driver.getTitle();
        String expectedTit="Google1";

//Assert class is coming from JUnit.
//assertEquals() takes two string and checks if they are equal.
//it fails if they are not equal.
        Assert.assertEquals(actualTitle,expectedTit);
    }

    @Test
    public void imageTest() {

//verify google image is displayed or not!
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver=new ChromeDriver();
        //driver.get("https://www.google.com/");
//<div style="display:inline-block;position:relative;height:196px;width:550px" id="hplogo"><a href="/search?sxsrf=ALeKk03GSjF8a0ugjsgit-NpBmAJPXcn_g:1586344880810&amp;q=%CE%88%CE%BD%CE%B1+%CE%BC%CE%B5%CE%B3%CE%AC%CE%BB%CE%BF+%CE%B5%CF%85%CF%87%CE%B1%CF%81%CE%B9%CF%83%CF%84%CF%8E+%CF%83%CE%B5+%CF%8C%CE%BB%CE%BF%CF%85%CF%82+%CF%8C%CF%83%CE%BF%CF%85%CF%82+%CE%BC%CE%AC%CF%87%CE%BF%CE%BD%CF%84%CE%B1%CE%B9+%CE%B5%CE%BD%CE%AC%CE%BD%CF%84%CE%B9%CE%B1+%CF%83%CF%84%CE%BF%CE%BD+%CE%BA%CE%BF%CF%81%CF%89%CE%BD%CE%BF%CF%8A%CF%8C&amp;oi=ddle&amp;ct=153203455&amp;hl=el&amp;sa=X&amp;ved=0ahUKEwj9h_CY29joAhXitYsKHb4EDd4QPQgN"><img alt="Σε όλους τους εργαζομένους στις υπηρεσίες έκτακτης ανάγκης, σας ευχαριστούμε" border="0" height="196" src="/logos/doodles/2020/thank-you-emergency-services-workers-6753651837108755-law.gif" style="padding-top:5px" title="Σε όλους τους εργαζομένους στις υπηρεσίες έκτακτης ανάγκης, σας ευχαριστούμε" width="550" data-atf="1"></a><div><style data-iml="1586344879984">.fOwUFe{height:26px;opacity:0.8;position:absolute;width:26px}.fOwUFe:hover{opacity:1}.dnNgC,.fJOQGe{height:22px;position:absolute;width:22px}.dnNgC{border-radius:6px;left:0;top:0}.fJOQGe{left:2px;top:2px}a:active .dnNgC,a:active .fJOQGe{margin:2px}</style><div class="fOwUFe" style="left:514px;top:165px"><a href="#" data-async-trigger="ddlshare" title="Share" jsaction="async.u" data-ved="0ahUKEwj9h_CY29joAhXitYsKHb4EDd4Q4zgIDg"><div class="dnNgC" style="background-color:#ffffff;border:2px solid #ffffff;opacity:0"></div><input value="//g.co/doodle/9qiaq" class="ddl-shortlink" type="hidden"><input value="//g.co/doodle/qyur5" class="ddl-facebooklink" type="hidden"><input value="//g.co/doodle/skvwa" class="ddl-twitterlink" type="hidden"><input value="" class="ddl-emaillink" type="hidden"><input value="//g.co/doodle/mpj52" class="ddl-copylink" type="hidden"><img class="fJOQGe" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABYAAAAWCAYAAADEtGw7AAAAoklEQVR42mMwTvvPQAZ2AOKZQPwAimdCxeBqyDX0DBD/R8NnkA0nx+CZWAyF4ZmUGPwAj8EPBp3BzkB8mdSgwBfTMkC8EsmAW8RGHq6YPgu14DOUD6IrgNiF2OSGL6ZheDUQyxEbbMREyCcgdiU1kkmKaXIMxhcUlylxMa7Iu0VpGONKbqDYL6ckVRDCZKdjmua84VkI0bQ8plkNQrM6jygMAODsqWK79M8/AAAAAElFTkSuQmCC" border="0" height="22" width="22" data-iml="1586344879985" data-atf="1"></a></div><div style="display:none" data-jiis="up" data-async-type="ddlshare" id="ddlshare" class="y yp" jsaction="asyncFilled:ddls.show"></div></div></div>
        WebElement image = driver.findElement(By.id("hplogo"));
//if else statement is not professional, so we need to use assertions.
        /*if (image.isDisplayed()) {
            System.out.println("pass!!");
            System.out.println(image.isDisplayed());
        } else {
            System.out.println("fail??");
        }*/
        // driver.quit();
        Assert.assertTrue(image.isDisplayed());
//we are expecting true, therefore we need to use assertTrue.
//this will pass if image.isDisplayed() is true. it will fail if the image.isDisplayed()
// is false.
        //Assert.assertFalse(image.isDisplayed()); ==> we should put it in another method.
    }

    @Test
    public void imageTest1() {

        WebElement image = driver.findElement(By.id("hplogo"));
//by using assertions we can remove if else statement.
//we are expecting true, therefore we need to use assertTrue.
//this will pass if image.isDisplayed() is true. it will fail if the image.isDisplayed()
// is false.
        Assert.assertFalse(image.isDisplayed());
    }


    @After
    public void tearDown(){
        driver.quit();

    }

}
