package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WindowPractice
{
    WebDriver driver;

    @BeforeMethod
    public void SetupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/windows");
    }

    @AfterClass
    public void teardownClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void window_practice()
    {
        //Printing out the window handle of the first page opened
        //Storing the first windowHandle into a string is a useful practice for future needs when we need
        // to switch back to it
        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);

        //4. Assert: Title is “Practice”
        String actualTitleBeforeClick = driver.getTitle();
        String expectedTitleBeforeClick = "Practice";

        //5. Click to: “Click Here” text
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        for (String eachWindow : driver.getWindowHandles())
        {
          driver.switchTo().window(eachWindow);
            System.out.println("Current title while switching : " + driver.getTitle());
        }


        String actualTitleAfterClick = driver.getTitle();

        System.out.println("actualTitleAfterClick = " + actualTitleAfterClick);
        //6. Switch to new Window.
        //7. Assert: Title is “New Window”
    }
}

