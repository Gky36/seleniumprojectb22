package com.cybertek.tests.PracticeDay;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AttributeAndGetText
{
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver();
        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");

        WebElement zeroBacklink = driver.findElement(By.className("brand"));
        //VERIFY link text from the left top
        String expectedLinkText = "Zero Bank";
        String actualLinkText = zeroBacklink.getText();

        if (actualLinkText.equals(expectedLinkText))
        {
            System.out.println("PASSED!!");
        }
        else
        {
            System.out.println("Failed!!!");
        }

        //attribution verification
        String expectedHrefValue = "index.html";
        String actualHrefValue = zeroBacklink.getAttribute("href");

        if (actualHrefValue.contains(expectedHrefValue))
        {
            System.out.println("PASSED!!");
        }
        else
        {
            System.out.println("Failed!!!");
        }
    }
}
