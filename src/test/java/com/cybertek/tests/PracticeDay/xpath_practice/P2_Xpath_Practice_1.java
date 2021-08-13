package com.cybertek.tests.PracticeDay.xpath_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P2_Xpath_Practice_1
{
    @Test
    public void TC1() throws InterruptedException
    {
      //TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to http://practice.cybertekschool.com/add_remove_elements/
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        //3. Click to “Add Element” button
        WebElement addElement = driver.findElement(By.xpath("//button[.='Add Element']"));
        addElement.click();
        Thread.sleep(2000);

        //4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton = driver.findElement(By.xpath("//div[@id='elements']"));
        Assert.assertTrue(deleteButton.isDisplayed());

        //5. Click to “Delete” button.
        deleteButton.click();

        //6. Verify “Delete” button is NOT displayed after clicking.
        //negative test case

        try {
            deleteButton.click();

            if (!deleteButton.isDisplayed()) {
                System.out.println("Delete is not displayed after clicking, PASS!");
            } else {
                System.out.println("Delete is not displayed after clicking, FAILED!!!");
            }
        }catch (StaleElementReferenceException exception)
        {
            System.out.println("Delete button is not displayed. Verification Passed");
        }
    }
}
