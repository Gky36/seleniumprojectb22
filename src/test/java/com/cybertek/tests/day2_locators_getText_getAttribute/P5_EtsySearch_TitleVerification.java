package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_EtsySearch_TitleVerification
{
    public static void main(String[] args)
    {
     /*
TC #2: Zero Bank header verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html 3. Verify header text
Expected: “Log in to ZeroBank”
      */
        //TC #1: Etsy Title Verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver();
        driver.manage().window().maximize();

        //2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");

        //3. Search for “wooden spoon” AND click to wooden spoon
        // First We need to locate the search bar
        // 2nd - We enter search value
        // 3rd - We press ENTER
        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("wooden spoon" + Keys.ENTER);

        //4.Verify title:
        //Expected: “Wooden spoon | Etsy”
        String expectedTitle = "Wooden spoon | Etsy";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle))
        {
            System.out.println("Title verification PASSED!");
        }
        else
        {
            System.out.println("Title verification FAILED!!!");
        }
    }
}
