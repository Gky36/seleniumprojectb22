package com.cybertek.tests.PracticeDay;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch
{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //go to page
        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.className("brand")).click();

        Thread.sleep(3000);
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("signin_button")).click();
        driver.findElement(By.id("user_login")).sendKeys("username" + Keys.TAB);

        driver.findElement(By.id("user_password")).sendKeys("password"
                + Keys.TAB +Keys.SPACE +Keys.TAB +Keys.ENTER);
    }
}
