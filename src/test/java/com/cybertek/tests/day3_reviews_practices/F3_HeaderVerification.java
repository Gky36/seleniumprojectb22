package com.cybertek.tests.day3_reviews_practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class F3_HeaderVerification
{
    public static void main(String[] args)
    {
        //TC #2: Facebook incorrect login title verification
        // 1. Open Chrome browser
        //setup browser driver
        WebDriverManager.chromedriver().setup();

        //create driver instance and open browser
        WebDriver driver = new ChromeDriver();

        //use the 'driver' object created to use selenium methods
        //maximize browser
        driver.manage().window().maximize();

        // 2. Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

        //3. Verify header text is as expected
        WebElement header = driver.findElement(By.className("_8eso"));

        //Expected: "Connect with friends and the world around you on Facebook"
        String expectedHeader = "Connect with friends and the world around you on Facebook.";
        String actualHeader = header.getText();

        if (actualHeader.equals(expectedHeader))
        {
            System.out.println("Header verification passed!!!");
        }
        else
        {
            System.out.println("Header verification Failed!!!");
        }

    }

}
