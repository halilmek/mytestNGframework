package com.tecproed.tests;

import org.testng.annotations.*;

//create a method, name it setUp() and use @BeforeMethod annotation.

public class TestNGAnnotations {
    //first TestNG class

    @Ignore //it does not work, because this annotation considers  @ sign.
    @BeforeMethod
    //@BeforeMethod runs before each method that @Test annotations.
    public void setUp() {
        System.out.println("this is BeforeMethod");
    }

    @AfterMethod
    //this will run after every @Test annotation.
    public void afterMethod(){
        System.out.println("this is AfterMethod. there are 3 @ signs, therefore this method works four times");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("this is AfterMethod. here there is just one class, therefore this method works just once!");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("this is BeforeClass annotation. there is one class, therefore it works just once!");
    }

    @Test
    public void test1() {

        // @Test is used to create test cases or test method.
        //@Test annotation helps us run the test.
        System.out.println("this is test 1 method.");

    }

    @Test
    public void test2() {
        System.out.println("this is test 2 method.");
    }

    //how do you skip @Test 3
    @Ignore
    @Test
    public void test3() {
        System.out.println("this is test 3 method.");
    }
}









