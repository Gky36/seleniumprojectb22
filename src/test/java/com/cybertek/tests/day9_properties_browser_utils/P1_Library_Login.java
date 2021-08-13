package com.cybertek.tests.day9_properties_browser_utils;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.LibraryUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P1_Library_Login {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://library1.cybertekschool.com/login.html");

    }

    @Test
    public void login_link_count_test(){
        //Task #1: Library software link verification
        //loginMethod calling to login library app
        LibraryUtils.loginToLibrary(driver);

        //3. Enter username: “”
        WebElement inputUsername =driver.findElement(By.xpath("//input[@id='inputEmail']"));
        inputUsername.sendKeys("student11@library");
        //4. Enter password: “”
        WebElement inputPassword =driver.findElement(By.xpath("//input[@id='inputPassword']"));
        inputUsername.sendKeys("student11@library");

        //5. Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//button[.='Sign in']"));
        loginButton.click();

        //6. Print out count of all the links on landing page
        BrowserUtils.sleep(2);

        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));

        System.out.println("allLinks.size() = " + allLinks.size());

        //7. Print out each link text on this page

        for (WebElement each : allLinks) {
            System.out.println(each.getText());
        }
    }


}