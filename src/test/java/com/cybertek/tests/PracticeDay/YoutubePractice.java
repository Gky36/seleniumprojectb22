package com.cybertek.tests.PracticeDay;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class YoutubePractice
{
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.youtube.com/");

        WebElement searchesBox =driver.findElement(By.xpath("//input[@id='search']"));
        searchesBox.sendKeys("Muslum gurses");
        searchesBox.submit();

        String openInNewTab = Keys.chord(Keys.CONTROL, Keys.COMMAND.ENTER);
        Thread.sleep(5000);
        List <WebElement> sarkilar = driver.findElements(By.xpath("//a[@id='video-title']"));

        for (int i=0; i<5; i++)
        {
            sarkilar.get(i).sendKeys(openInNewTab);
        }
    }
}
