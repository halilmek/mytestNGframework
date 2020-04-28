package com.tecproed.tests;

import com.tecproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/*
- 1 .Finding size of the entire table body.

 */
public class WebTables extends TestBase {

   // @Test//if i delete this method(), can i make this method work?
    //TestNG allows us to do that.
    public void login(){
driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");
WebElement userNameBox=driver.findElement(By.id("UserName"));
WebElement passBox=driver.findElement(By.id("Password"));
WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));

userNameBox.sendKeys("manager2");
passBox.sendKeys("Man1ager2!");
loginButton.click();
    }

    @Test
    public void entireTable() throws InterruptedException {
        login();//for readability and reusability i can make another method
//work in this method.
// 1. how many td do you have?
        Thread.sleep(3000);
        WebElement tBody=driver.findElement(By.xpath("//tbody"));
        System.out.println(tBody.getText());

        //above one and below one are working for same reason, so they
        //produce same results.

        List<WebElement> contentOfAllCells=driver.findElements(By.xpath("//tbody//tr"));
        for (WebElement row: contentOfAllCells){
            System.out.println("printing content of cells "+row.getText());
        }

// 1. find the size. ==> how many cells you have.
        List<WebElement> table=driver.findElements(By.xpath("//tbody//td"));
        System.out.println("number of table cell where is open "+table.size());

         }

@Test
public void printRows(){

// 2. find the total number rows and cells in the table body.
login();
//driver.findElements(By.xpath("//tbody//tr")).size()
System.out.println("number of the rows in the table "+driver.findElements(By.xpath("//tbody//tr")).size());
         }

 @Test
 public void printCells(){

login();
System.out.println("number of whole cell in table in the first page "+driver.findElements(By.xpath("//tbody//td")));

    }

 @Test
 public void numberOfColumn(){

        login();
     System.out.println("number of column in the table "+driver.findElements(By.xpath("//tr[2]//td")).size());
 }

 @Test
public void printingContentOfRows(){

        List<WebElement> contentOfAllCells=driver.findElements(By.xpath("//tbody//tr"));
        for (WebElement row: contentOfAllCells){
            System.out.println(row.getText());
        }
 }

@Test
public void printingHeader(){

login();
        List<WebElement> allHeader=driver.findElements(By.xpath("//th"));

    System.out.println("below ones are coming from lambda!!");
    allHeader.stream().map(h->h.getText()).forEach(System.out::println);
}

@Test
public void printing4thRowsElements(){
login();
List<WebElement> printing4thRow=driver.findElements(By.xpath("//tr[4]//td"));
for(WebElement w: printing4thRow){
    System.out.println("this is coming from enhanced loop "+w.getText());
}
System.out.println("another lambda expression");
printing4thRow.stream().map(k->k.getText()).forEach(System.out::println);

}

@Test
public void printing5thColumn(){

login();
List<WebElement> pr5thColumnInBody=driver.findElements(By.xpath("//tbody//td[5]"));

    for (WebElement w: pr5thColumnInBody) {
        System.out.println("enhanced loops ==> "+w.getText());
    }

    System.out.println("below ones are coming from lambda expression");
    pr5thColumnInBody.stream().map(r->r.getText()).forEach(System.out::println);

}

}
