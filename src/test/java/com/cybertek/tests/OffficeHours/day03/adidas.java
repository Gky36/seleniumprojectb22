package com.cybertek.tests.OffficeHours.day03;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.OfficeHoursUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class adidas
{
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.demoblaze.com/index.html");
    }
    public void productAdder(String category, String product){
        driver.findElement(By.xpath("//a[.='"+category+"']")).click();
        BrowserUtils.sleep(1);
        driver.findElement(By.xpath("//a[.='"+product+"']")).click();
        BrowserUtils.sleep(1);
        driver.findElement(By.xpath("//a[.='Add to cart']")).click();
        BrowserUtils.sleep(1);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        BrowserUtils.sleep(1);
        driver.findElement(By.xpath("(//a[@class='nav-link'])[1]")).click();
    }

    @Test
    public void adidasTest(){
        // Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart".
        productAdder("Laptops","Sony vaio i5");

        OfficeHoursUtils.productAdder(driver,"Laptops","Sony vaio i5");
        // Navigate to "Phones" → "Samsung galaxy s6" and click on "Add to cart".
        OfficeHoursUtils.productAdder(driver,"Phones","Samsung galaxy s6");
        // Navigate to "Monitors" → "Apple monitor 24" and click on "Add to cart".
        OfficeHoursUtils.productAdder(driver,"Monitors","Apple monitor 24");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
