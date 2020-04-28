package com.tecproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Priority_DependsOnMethod {

    /*
    in testing, test methods runs by alphabetical order. they dont run
    from to bottom.
    to prioritize test cases, we use priority annotation.
     */

    @Test(priority = 1)//if you use priority for one method
    //after every method selenium run or considers it lastly.
    //therefore in order to run priority completely,
    //you should give priority keyword for every method.
    public void login() {
        System.out.println("this is login!");
    }

    @Test(priority = 2)
    public void homePage() {
        System.out.println("this is homePage!");
    }

    @Test(priority = 3, dependsOnMethods = "login")
//chain dependency is not allowed.==> is it true?
    public void search() {
        System.out.println("this is search!");
        Assert.assertTrue(false);//this
//method will fail.
//since this method fails, result() method will be
//ignored or skipped.
    }

    //make result() depends on search().
    @Test(priority = 4, dependsOnMethods = "search")
    public void result() {
        System.out.println("this is result!");
    }
//we can run every single method one by one if we
    //click play sign where is at the right of that
    // method. but if we use dependsOnMethods
    // with that method with another, they both run
    //together.
}
