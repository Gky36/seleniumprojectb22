package com.cybertek.tests.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class baseTest
{
    protected static ThreadLocal<ChromeDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        getDriver().get("http://practice.cybertekschool.com/dropdown");
        //getDriver().manage().window().maximize();
    }

    public WebDriver getDriver()
    {
        return driver.get();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException{

        Thread.sleep(3000);
        driver.get().quit();

    }
}
