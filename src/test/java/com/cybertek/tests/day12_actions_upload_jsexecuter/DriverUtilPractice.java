package com.cybertek.tests.day12_actions_upload_jsexecuter;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverUtilPractice
{
    @Test
    public void simple_google_search_test(){

        //1- Go to google.com
        // Driver.getDriver() --> creates driver instance and ready to use
        Driver.getDriver().get(ConfigurationReader.getProperty("googleUrl"));

        //2- Search for a value
        // this is the way we locate the webElement after Driver get.driver
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));

        //String searchValue = "There is no spoon";
        //asadaki gibi yaparsak configuration properties tanitmamiz gerekiyr string and sonrada search value yapistiriyruz
        String searchValue = ConfigurationReader.getProperty("searchValue");


        //send the keyword and press enter
        searchBox.sendKeys(searchValue + Keys.ENTER);


        //3- Verify value is contained in the title
        String actualTitle = Driver.getDriver().getTitle();
       // this is coming from config properties and dynamic
        String expectedInTitle = searchValue;

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

        // if we can use .quit we can get -->> NoSuchSessionException: Session ID is null
        //Driver.getDriver().quit();

        // if we use .close --> NoSuchSessionException: invalid session id, if we use close
        //Driver.getDriver().close();

        // This will terminate the session and assign driver value to null
        Driver.closeDriver();
        Driver.getDriver().get("https://etsy.com");

    }
}
