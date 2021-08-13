package com.cybertek.tests.PracticeDay;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TeamPractice
{
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.id("signin_button")).click();

        Thread.sleep(2000);

        WebElement userLogin = driver.findElement(By.id("user_login"));
        userLogin.sendKeys("username");

        WebElement userPassword = driver.findElement(By.name("user_password"));
        userPassword.sendKeys("password");

        driver.findElement(By.id("user_remember_me")).click();

        driver.findElement(By.className("btn-primary")).click();

        driver.findElement(By.id("details-button")).click();

        driver.findElement(By.linkText("Proceed to zero.webappsecurity.com (unsafe)")).click();

        Thread.sleep(2000);
        driver.findElement(By.linkText("Transfer Funds")).click();

        WebElement mydropFromAccount = driver.findElement(By.id("tf_fromAccountId"));

        Thread.sleep(2000);
        Select menu = new Select(mydropFromAccount);
        menu.selectByValue("3");

        Thread.sleep(2000);
        WebElement myToAccount = driver.findElement(By.id("tf_toAccountId"));
        Select menu2 = new Select(myToAccount);
        menu.selectByValue("5");

        Thread.sleep(2000);
        driver.findElement(By.id("tf_amount")).sendKeys("600");

        driver.findElement(By.id("tf_description")).sendKeys("money money"+ Keys.ENTER);
        driver.findElement(By.id("btn_submit")).click();

        String expectedTitle = "You successfully submitted your transaction.";
        String actualTitle = driver.findElement(By.className("alert-success")).getText();

        if (actualTitle.equals(expectedTitle))
        {
            System.out.println("verification pass!");
        }
        else
        {
            System.out.println("verification failed!!!");
        }



    }
}
