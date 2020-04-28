package com.tecproed.tests;

import com.tecproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class FileDowload extends TestBase {

    @Test
    public void isExist() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/download");
        WebElement downloadText=driver.findElement(By.linkText("some-file.txt"));
        downloadText.click();

        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

       // Thread.sleep(5000);

//Then verify if the file downloaded successfully.
        String currentFolder=System.getProperty("user.dir");//gives me the path of the
//current folder.
       /* System.out.println(currentFolder);//==>C:\Users\halil\IdeaProjects\mytestNGframework
        String userFolder=System.getProperty("user.home");
        System.out.println("user folder==> " +userFolder);//==>C:\Users\halil\Downloads\some-file.txt

       String pathOfFile=userFolder+"/Downloads/some-file.txt";
        boolean isFileExist =Files.exists(Paths.get(pathOfFile));

        Assert.assertTrue(isFileExist);
*/

    }

    @Test (dependsOnMethods = "isExist")
    public void isExist1(){
        String userFolder=System.getProperty("user.home");
        String pathOfFile=userFolder+"/Downloads/some-file.txt";

        boolean isFileExist =Files.exists(Paths.get(pathOfFile));
        Assert.assertTrue(isFileExist);
    }


    @Test
    public void downloadTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/download");

        //<a href="download/some-file.txt">some-file.txt</a>
       // WebElement downloadText=driver.findElement(By.linkText("some-file.txt"));
        //downloadText.click();

        WebElement filePng=driver.findElement(By.linkText("upload.jpg"));
        filePng.click();

        Thread.sleep(3000);

        String userFolder=System.getProperty("user.home");
        String pathOfFile=userFolder+"/Dowloads/upload.jpg";

        boolean isDowloaded=Files.exists(Paths.get(pathOfFile));

        Assert.assertFalse(isDowloaded);

    }

}
