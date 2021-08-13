package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_ZeroBnakAttributeVerification
{
    public static void main(String[] args)
    {
        //TC #2: Zero Bank link text verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver();
        driver.manage().window().maximize();

        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        //LOCATE THE LINK WEB ELEMENT AND STORE INSIDE OF WebElement
        WebElement zeroBankLink = driver.findElement(By.className("brand"));
           // WebElement zeroBankLink = driver.findElement(By.linkText("Zero Bank"));
           // WebElement zeroBankLink = driver.findElement(By.tagName("a"));

        // 3. Verify link text from top left:
        //Expected: “Zero Bank”
        String expectedLinkText = "Zero Bank";
        String actualLinkText = zeroBankLink.getText();
        // asadaki gibi surekli yazmamak icin webelement olarak tanimladik
        //driver.findElement(By.className("brand")).getText();

        if (actualLinkText.equals(expectedLinkText))
        {
            System.out.println("Link text verification PASSED!");
        }
        else
        {
            System.out.println("Link text verification FAILED!!!");
        }

        //4. Verify link href attribute value contains:
        //Expected: “index.html”

        String expectedInHrefValue = "index.html";

        String actualHrefValue = zeroBankLink.getAttribute("href");


        if(actualHrefValue.contains(expectedInHrefValue))
        {
            System.out.println("HREF attribute value verification PASSED!");
        }
        else
        {
            System.out.println("HREF attribute value verification FAILED!!!");
        }

        // System.out.println("actualHrefValue" +actualHrefValue);



    }
}
