package com.cybertek.tests.day6_testng_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro
{
    @BeforeClass
    public void setupClass(){
        System.out.println("---> Before CLASS is running...");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("-----> After Class is running...");
    }

    @BeforeMethod
    public void setup_method(){
        System.out.println("---> Before method is running...");

    }

    @AfterMethod
    public void teardownMethod()
    {
        System.out.println("---> After method is running...");
    }

    //First annotations is coming from TestNG
    @Test (priority = 1)
    public void test1()
    {
        System.out.println("Running test 1...");

        String actual = "apple";
        String expected = "apples";

        Assert.assertEquals(actual,expected);
        // if first assert fail, rest of them not working. We might want to consider crating a different
        // @test for the second assertion

    }

    @Test (priority = 2)
    public void test2()
    {
        System.out.println("Running test 2...");
        String actual = "apple";
        String expected = "apples";

        Assert.assertTrue(actual.equals(expected));
        // Assert.assertFalse(false);
        

    }

}
