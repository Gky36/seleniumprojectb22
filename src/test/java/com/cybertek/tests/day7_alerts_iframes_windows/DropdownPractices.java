package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownPractices
{
    WebDriver driver;

    @BeforeClass
    public void setupClass()
    {
        //TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
        //1.Open Chrome browser
        //2.Go to http://practice.cybertekschool.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    @Test
    public void tc1_simple_dropdown_test(){

        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”
        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        //returning me Web element
        WebElement currentlySelectedOption = simpleDropdown.getFirstSelectedOption();
        String actualTextOfCurrentOption = currentlySelectedOption.getText();
        String expectedText ="Please select an option";

        Assert.assertTrue(actualTextOfCurrentOption.equals(expectedText));
        //Assert.assertEquals(actualTextOfCurrentOption,expectedText);


         //4.Verify“State selection” default selected value is correct
        //Expected: “Select a State”

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        String actualStateDropdownText = stateDropdown.getFirstSelectedOption().getText();
        String expectedStateDropDown = "Select a State";

        Assert.assertEquals(actualStateDropdownText,expectedStateDropDown);
    }

    @AfterClass
    public void teardownClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void tc2_state_dropdown_test()
    {
      //TC #2: Selecting state from State dropdown and verifying result
        // 1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //3. Select Illinois
        stateDropdown.selectByVisibleText("Illinois");
        //4. Select Virginia
        stateDropdown.selectByValue("VA");
        //5. Select California
        stateDropdown.selectByIndex(5);

        //6. Verify final selected option is California.
        //Use all Select options. (visible text, value, index)
        String expectedOptionText = "California";
        String actualOptionText = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOptionText, expectedOptionText,"this message will be printed out only if assertion fails");
        //Assert.assertTrue(stateDropdown.getFirstSelectedOption().getText().equals("California"));
    }
}
