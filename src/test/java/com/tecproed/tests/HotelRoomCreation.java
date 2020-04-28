package com.tecproed.tests;

import com.tecproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class HotelRoomCreation extends TestBase {

/*
Create a class: HotelRoomCreation
Create a Method: RoomCreateTest()
When user goes to http://www.fhctrip.com/admin/HotelRoomAdmin
And fills out all of the required fields
Then click on save button
And Verify the text message on the pop up “HotelRoom was inserted successfully”
*/

@Test
public void hotelRoomCreateTest() throws InterruptedException {
    driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");
    WebElement userNameBox=driver.findElement(By.xpath("//input[@id='UserName']"));
    WebElement passBox=driver.findElement(By.xpath("//input[@id='Password']"));
WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));


    userNameBox.sendKeys("manager2");
    passBox.sendKeys("Man1ager2!");
    loginButton.click();


    //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    Thread.sleep(5000);

    WebElement addHotelRoom=driver.findElement(By.xpath("//span[@class='hidden-480']"));
    //WebElement addHotelRoom=driver.findElement(By.partialLinkText("Add Hotelroom "));
    addHotelRoom.click();

    Thread.sleep(5000);

    //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    WebElement createHotelRoom=driver.findElement(By.xpath("//div[@class='caption']"));
    Assert.assertTrue(createHotelRoom.isDisplayed());

    Thread.sleep(5000);

    //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    WebElement idHotel=driver.findElement(By.xpath("(//select[@class='form-control input-lg required'])[1]"));
    Select select=new Select(idHotel);

    Thread.sleep(5000);

    select.selectByVisibleText("Hilton Hotel-1");

    Thread.sleep(5000);

    //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    WebElement code=driver.findElement(By.id("Code"));
    code.sendKeys("1234567890");

    Thread.sleep(5000);

    //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    WebElement name=driver.findElement(By.id("Name"));
    name.sendKeys("halil baba");

    WebElement description=driver.findElement(By.xpath("//div[@id='cke_1_contents']//textarea"));
    description.sendKeys("this room is only for babas");

    Thread.sleep(5000);

    //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    WebElement from700=driver.findElement(By.xpath("//li[@data-id='700']"));
    WebElement toBox=driver.findElement(By.xpath("(//input[@data-val='true'])[1]"));
    actions.dragAndDrop(from700,toBox).perform();// this is important part!!

    Thread.sleep(5000);

    //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    WebElement roomType=driver.findElement(By.xpath("(//select[@class='form-control input-lg required'])[2]"));
    Select options=new Select(roomType); //this is for dropdown menu!!
    options.selectByIndex(6);

    Thread.sleep(5000);

    //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    WebElement adultNum=driver.findElement(By.id("MaxAdultCount"));
    adultNum.sendKeys("2");

    Thread.sleep(5000);

    //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    WebElement maxChildCount=driver.findElement(By.id("MaxChildCount"));
    maxChildCount.sendKeys("5");

    Thread.sleep(7000);

    //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    WebElement clickApproved=driver.findElement(By.id("IsAvailable"));
    clickApproved.click();
    clickApproved.isSelected();// isSelected is used for true/false
    

    Thread.sleep(6000);

    //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    WebElement saveButton=driver.findElement(By.id("btnSubmit"));
    saveButton.click();

//pup up checking
//<div class="bootbox-body">HotelRoom was inserted successfully</div>


    //Verifying text is equal to HotelRoom was inserted successfully
    //Thread.sleep(5000);//This is not good way to solve the issue.
    //Implicit wait also didn't work. I alrady have 10 seconds
    //So I will try explicit wait fir this condition
    boolean isTrue=wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='bootbox-body']"),"HotelRoom was inserted successfully"));
    Assert.assertTrue(isTrue);
    //textToBe --> it means what wait for that web element, after pop up of that element
    //then check the text which appears with the pop up!!!


WebElement popUpMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
popUpMessage.isDisplayed();
    System.out.println(popUpMessage.getText());

    Thread.sleep(4000);

    //clicking ok!
WebElement clickingOk=driver.findElement(By.xpath("//button[@data-bb-handler='ok']"));
clickingOk.click();

    Thread.sleep(10000);

//clicking Hotel Rooms
//<a href="/admin/HotelRoomAdmin">
//							            <i class="icon-calendar"></i>
//							            Hotel Rooms</a>

//WebElement clickHotelRooms=driver.findElement(By.partialLinkText("Hotel Rooms"));

//WebElement clickHotelRooms=driver.findElement(By.xpath("/ul/li[2]/ul/li[2]/a"));
//WebElement clickHotelRooms=driver.findElement(By.xpath("//a[@href='/admin/HotelRoomAdmin']"));
    //Thread.sleep(6000);
    actions.sendKeys(Keys.PAGE_UP).perform();
    actions.sendKeys(Keys.PAGE_UP).perform();
WebElement clickHotelRooms=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href='/admin/HotelRoomAdmin']"))));
    Thread.sleep(6000);
actions.doubleClick(clickHotelRooms);
//clickHotelRooms.click();


    Thread.sleep(6000);

//verifying list of hotel room is displayed
WebElement verifyHotelRoomsIsDisplayed=driver.findElement(By.xpath("//span[@class='caption-subject font-green-sharp bold uppercase']"));
Assert.assertTrue(verifyHotelRoomsIsDisplayed.isDisplayed());


    Thread.sleep(7000);

//verifying room is created.
WebElement sendingName=driver.findElement(By.xpath("(//input[@type='text'])[4]"));
sendingName.sendKeys("halil");

//clicking search
WebElement clickingSearch=driver.findElement(By.xpath("//button[@class='btn btn-sm yellow filter-submit margin-bottom']"));
clickingSearch.click();

    Thread.sleep(6000);

//verifying the text appers!!
WebElement verifyHalilBaba=driver.findElement(By.xpath("//*[text()='halil baba']"));



/*
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
public class HotelRoomCreation extends TestBase {
    @Test
    public void RoomCreateTest() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,10);
        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");
        WebElement userNameBox=driver.findElement(By.id("UserName"));
        WebElement passwordBox=driver.findElement(By.id("Password"));
        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        userNameBox.sendKeys("manager2");
        passwordBox.sendKeys("Man1ager2!");
        loginButton.click();
        WebElement addHotelRoomButton=driver.findElement(By.xpath("//span[@class='hidden-480']"));
        addHotelRoomButton.click();
        //Verify if Create Hotel Room Page is displayed
        WebElement createHotelRoomText=driver.findElement(By.xpath("//div[@class='caption']"));
        Assert.assertTrue(createHotelRoomText.isDisplayed());
        //IdHotel
        WebElement idHotel=driver.findElement(By.id("IDHotel"));
        Select select=new Select(idHotel);
        select.selectByIndex(1);//selecting the first dropdown option
        select.selectByVisibleText("Hilton Hotel");
        //Code
        driver.findElement(By.id("Code")).sendKeys("Royal");
        //Name
        driver.findElement(By.id("Name")).sendKeys("347");
        //Description
        driver.findElement(By.xpath("//div[@id='cke_1_contents']//textarea")).sendKeys("This room is only for Royal families");
        //Price
        WebElement source = driver.findElement(By.xpath("//li[@data-id='700']"));
        WebElement target=driver.findElement(By.name("Price"));
        //We can drag and drop using Actions class
        //Drag and Drop takes twp parameter, first one is Source, second one is Target
        Thread.sleep(3000);//Since there is a Sycnronization issue, We have to use wait
        //Thread.sleep works, but not recommended.
        //implicitly wait is not also working properly
        //HOMEWORK: Solve This issue using Explicit wait. Do not use Thread.sleep
        actions.dragAndDrop(source,target).perform();
        //room type
        WebElement roomType=driver.findElement(By.id("IDGroupRoomType"));
        Select options=new Select(roomType);
        options.selectByIndex(6);
        //max adult count
        driver.findElement(By.id("MaxAdultCount")).sendKeys("2");
        //max children count
        driver.findElement(By.id("MaxChildCount")).sendKeys("5");
        //click on save button
        driver.findElement(By.id("btnSubmit")).click();
        //Verifying text is equal to HotelRoom was inserted successfully
        //Thread.sleep(5000);//This is not good way to solve the issue.
        //Implicit wait also didn't work. I alrady have 10 seconds
        //So I will try explicit wait fir this condition
        boolean isTrue=wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='bootbox-body']"),"HotelRoom was inserted successfully"));
        Assert.assertTrue(isTrue);
        //WebElement popUpMessage=driver.findElement(By.xpath("//div[@class='bootbox-body']"));
        //String actualTextMessage=popUpMessage.getText();
        //String expectedTestMessage="HotelRoom was inserted successfully";
        //Assert.assertEquals(actualTextMessage,expectedTestMessage);
    }
}

 */




}


}
