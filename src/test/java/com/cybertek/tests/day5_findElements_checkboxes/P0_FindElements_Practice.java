package com.cybertek.tests.day5_findElements_checkboxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P0_FindElements_Practice
{
    public static void main(String[] args)
    {
        //TC #0: FINDELEMENTS
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // if web element is not found, this will wait UP TO given seconds
        // if web element is located before 15 second, it will move on
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //WE NEED TO CREATE A LOCATOR THAT RETURNS US ALL THE LINKS ON THE PAGE
        //body//a ----> This locator will return all of the links on the page

        // Surekli kullanmamiz icin List Webelement icin store yapmamiz gerekiyor
        // we are storing all of the links that are returned by findElements method
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        //3. Print out the texts of all links
        //iter  is shortcut foreach loop
        //fori  is for regular for loop

        for (WebElement each : listOfLinks)
        {
            System.out.println(each.getText());
            System.out.println(each.getAttribute("href"));
        }

        //4. Print out how many total link
        int numberOfLinks = listOfLinks.size();
        System.out.println("numberOfLinks = " + numberOfLinks);

        //System.out.println(listOfLinks.size()); shortest way

    }
}
