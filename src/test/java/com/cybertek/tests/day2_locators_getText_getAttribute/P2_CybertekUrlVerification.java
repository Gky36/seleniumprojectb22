package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_CybertekUrlVerification
{
    public static void main(String[] args)
    {
        //1. Open Chrome browser
        WebDriverManager.chromedriver();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //maximize the page
        driver.manage().window().maximize();

        //2. Go to http://practice.cybertekschool.com/
        driver.get("http://practice.cybertekschool.com/");

        //3. Verify URL contains
        //Expected: cybertekschool

        String expectedUrl = "cybertekschool";
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.contains(expectedUrl))
        {
            System.out.println("Url verification PASSED");
        }
        else
        {
            System.out.println("URL verification FAILED!");
        }

        //Expected: Practice
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle))
        {
            System.out.println("Title verification PASSED!");
        }
        else
        {
            System.out.println("Title verification FAILED!");
        }
    }
}
