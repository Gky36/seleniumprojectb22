package com.cybertek.tests.OffficeHours.day05;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MoneyGamingTask
{
    @Test
    public void Task1()
    {
        //1. Navigate to: https://moneygaming.qa.gameaccount.com/
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://moneygaming.qa.gameaccount.com/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Click the JOIN NOW button to open the registration page
        WebElement joinButton = driver.findElement(By.xpath("//a[@href='/sign-up.shtml']"));
        joinButton.click();
        //3. Select a title value from the dropdown
        WebElement titleElement = driver.findElement(By.id("title"));

        // we need to create our select object so we can reach select class method
        Select titleDropDown = new Select(titleElement);

        //we are going to add a Mr a gaming
        titleDropDown.selectByVisibleText("Mr");

        //verify that Mr is selected
        String expectedTitle = "Mr";
        String actualTitle = titleDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualTitle,expectedTitle,"verify the title");

        //4. Enter your first name and surname in the form
        WebElement first =driver.findElement(By.xpath("//input[@id='forename']"));
        WebElement lastname = driver.findElement(By.xpath("//input[@name='map(lastName)']"));

        first.sendKeys("Gok");
        lastname.sendKeys("money");

        //5. Check the tickbox with text 'I accept the Terms and Conditions and certify that I am over the age of 18.'
        WebElement termBox = driver.findElement(By.xpath("(//input[@id='checkbox'])[1]"));
        termBox.click();

        //6. Submit the form by clicking the JOIN NOW button
        WebElement submitButton = driver.findElement(By.xpath("//input[@id='form']"));
        submitButton.click();

        //7. Validate that a validation message with text ‘ This field is required’ appears under the date of
        String expectedError= "This field is required";
        String actualError = driver.findElement(By.xpath("//label[@for='dob']")).getText();

        Assert.assertEquals(expectedError,actualError,"verify date of birthbox");
    }
}
