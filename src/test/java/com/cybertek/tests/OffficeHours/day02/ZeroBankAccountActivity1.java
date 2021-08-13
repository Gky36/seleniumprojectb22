package com.cybertek.tests.OffficeHours.day02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ZeroBankAccountActivity1
{
    /*
1. The user navigates to the login page: http://zero.webappsecurity.com/login.html
2. The user logs in with the user "username" and the password "password"
3. The user navigates to Account Activity page
4. Then The page should have the title "Zero - Account Activity"
5. Then Account drop down should have the following options :
(Savings, Checking, Savings, Loan, Credit Card, Brokerage)
6. Brokerage option should have "No results."

     */


    WebDriver driver;

    @BeforeClass
    public void setupClass()
    {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/login.html");

        //login
        driver.findElement(By.cssSelector("[id='user_login']")).sendKeys("username");
        driver.findElement(By.cssSelector("[id *='password']")).sendKeys("password");
        driver.findElement(By.cssSelector("[type *='submit']")).click();
        driver.findElement(By.cssSelector("[id *='primary-button']")).click();
    }

    @Test
    public void accountActivity()
    {
        //    Then The page should have the title "Zero - Account Activity"

        driver.findElement(By.cssSelector("[id*='acco']")).click();
        String expectedTitle = "Zero - Account Activity";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle,"verify Title");

        List<String> expectedOptions = new ArrayList<>(Arrays.asList("Savings", "Checking", "Savings", "Loan",
                "Credit Card", "Brokerage"));

        Select accountsDropDown = new Select(driver.findElement(By.cssSelector("[id*='aa']")));

        List<WebElement> actualOptions = accountsDropDown.getOptions();

        List<String> actualOptionsTexts = new ArrayList<>();
        for (WebElement actualOption : actualOptions) {
            actualOptionsTexts.add(actualOption.getText());

        }

        System.out.println("expectedOptions = " + expectedOptions);
        System.out.println("actualOptions = " + actualOptions);
        System.out.println("actualOptionsTexts = " + actualOptionsTexts);

        Assert.assertEquals(actualOptionsTexts,expectedOptions,"verify Dropdown Options");

    }


    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
