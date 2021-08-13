package com.cybertek.tests.PracticeDay.xpath_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class P1_Xpath_Practice_1
{

    @Test
    public void testNo1()
    {
        //TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");
        //3. Locate all the WebElements on the page using XPATH locator only (total of 6)
        //a. “Home” link
        WebElement homeLink =driver.findElement(By.xpath("//a[@class='nav-link']"));
        //b. “Forgot password” header
        WebElement forgotPassword = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));
        //c. “E-mail” text
        WebElement emailText = driver.findElement(By.xpath("//label[@for='email']"));
        //d. E-mail input box
        WebElement emailBox= driver.findElement(By.xpath("//input[@name='email']"));
        //e. “Retrieve password” button
        WebElement retrievePassword = driver.findElement(By.xpath("//i[text()='Retrieve password']"));
        //f. “Powered by Cybertek School” text
        WebElement poweredByCybertek= driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        //4. Verify all WebElements are displayed.
        List<WebElement> myList = new ArrayList<>(Arrays.asList(homeLink,forgotPassword,emailBox,emailText,retrievePassword,poweredByCybertek));

       int count=0;
       for (int i =0; i<myList.size(); i++)
       {
           if (myList.get(i).isDisplayed())
           {
               count++;
           }
       }
        Assert.assertEquals(myList.size(),count);
    }
}
