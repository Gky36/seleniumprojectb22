package com.cybertek.tests.day2_locators_getText_getAttribute;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_NavigationAndTitleVerification
{
    public static void main(String[] args)
    {
        //1.Open Chrome browser
        WebDriverManager.chromedriver();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //maximize the page
        driver.manage().window().maximize();
        //2. Go to website
        driver.get("https://www.google.com/");

        //3. Click to Gmail from top right
        // locating the web element------ <click>
        //driver.findElement(By.linkText("Gmail")).click();
        driver.findElement(By.partialLinkText("mail")).click();

        //4- Verify title contains
        // Expected: Gmail
        String expectedInTitle = "Gmail";
        String actualTitle= driver.getTitle();

        if (actualTitle.contains(expectedInTitle))
        {
            System.out.println("Title verification PASSED");
        }
        else
        {
            System.out.println("Title verification FAILED!");
        }
        //Command + D: multiplies the current line
        // moving the line up and down: command +shift+up

        //5- Go back to Google by using the .back();
        driver.navigate().back();
        //6- Verify title equals:
        //Expected: Google
        String expectedGoogleTitle = "Google";
        String actualGoogleTitle = driver.getTitle();

        if (actualGoogleTitle.equals(expectedGoogleTitle))
        {
            System.out.println("Title verification PASSED");
        }
        else
        {
            System.out.println("Title verification FAILED!");
        }
    }
}
