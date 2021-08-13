package com.cybertek.tests.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CybertekRegistrationForm {
/*
TC#6: Cybertek registration form confirmationNote: Use JavaFaker when possible.
1.Open browser
2.Go to website: http://practice.cybertekschool.com/registration_form
3.Enter first name
4.Enter last name
5.Enter username
6.Enter email address
7.Enter password8.Enter phone number
9.Select a gender from radio buttons
10.Enter date of birth11.Select Department/Office
12.Select Job Title
13.Select programming language from checkboxes
14.Clickto sign up button
15.Verify success message “You’ve successfully completed registration.”is displayed.
 */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/registration_form");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(30);
        driver.quit();
    }

    @Test
    public void sadasd()
    {
        CybertekUtilities utils = new CybertekUtilities();

        utils.fillInTheForm(driver, utils.allInputTabs(driver));
        utils.genderSelection(driver,utils.gender).get(1).click();
        utils.dealWithSelectMenu(driver);
        utils.selectLanguage(driver);
        utils.doneButton(driver).click();

        utils.SOLVE(driver, utils.allInputTabs, utils.gender, utils.languages);
        String expected = "You've successfully completed registration!";
        String actual = utils.result(driver).getText();
        Assert.assertEquals(actual, expected);


    }
}
