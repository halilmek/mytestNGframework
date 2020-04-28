package com.tecproed.tests;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import com.tecproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;

public class UploadFile extends TestBase {

    @Test
    public void uploadFile() {
        driver.get("https://the-internet.herokuapp.com/upload");
//<input id="file-upload" type="file" name="file">
        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        //chooseFile.click();//this does not work, it is browse button!

//1. determine the path of any file, which is wanted to be uploaded, with the name.
String filePath="C:\\Users\\halil\\Desktop\\for uploading.txt";
chooseFile.sendKeys(filePath);

//<input class="button" id="file-submit" type="submit" value="Upload">

        
       WebElement uploadButton=driver.findElement(By.id("file-submit"));

        uploadButton.click();

//to verify upload is ok or not!
        WebElement fileUploadTextVerifying=driver.findElement(By.tagName("h3"));

        Assert.assertTrue(fileUploadTextVerifying.getText().equals("File Uploaded!"));
    }
}
