package com.cybertek.tests.day10_webtable_properties_practices;

import com.cybertek.utilities.Driver;
import org.testng.annotations.Test;

public class DriverUsingExample {

    //    WebDriver driver;
//
//    @BeforeMethod
//    public void setupMethod(){
//
//        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.get("http://library2.cybertekschool.com/login.html");
//
//    }
//
    @Test
    public void how_to_use_driver(){
        //Driver.getDriver() ===> driver

        Driver.getDriver().get("http://library2.cybertekschool.com/login.html");
    }


}
