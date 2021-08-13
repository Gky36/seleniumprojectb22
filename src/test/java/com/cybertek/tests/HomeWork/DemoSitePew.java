package com.cybertek.tests.HomeWork;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoSitePew {

    String longBoringText = "Enter your login details you added on the previous page and test the login.\n" +
            "The success or failure will be shown above.";
    public String username = "";
    public String password = "";
    Faker faker = new Faker();
    public String LoginPageTittle = "Login example page to test the PHP MySQL online system";

    public WebElement getUserNameField(WebDriver driver){
        return driver.findElement(By.cssSelector("[name='username']"));
    }
    public WebElement getPasswordField(WebDriver driver){
        return driver.findElement(By.cssSelector("[name='password']"));
    }
    public WebElement getSubmitButton(WebDriver driver){
        return driver.findElement(By.cssSelector("[name='FormsButton2']"));
    }

    public void assignLoginCredentials(WebDriver driver){
        this.username = faker.name().username().replace(" ", "");
        this.password = faker.name().username().replace(" ", "");;
    }

    public void perfomLogin(WebDriver driver){
        getUserNameField(driver).sendKeys(this.username);
        getPasswordField(driver).sendKeys(this.password);
        getSubmitButton(driver).click();
    }

    public void navigateBackToLogin(WebDriver driver){
        driver.findElement(By.xpath("//a[@href='login.php']")).click();
    }

    public String grabLoginHeaderText(WebDriver driver){
        return driver.findElement(By.xpath("(//strong)[3]")).getText();
    }

    public String checkStatusMessage(WebDriver driver){
        return driver.findElement(By.xpath("(//b)[3]")).getText();
    }

    public String checkInfoMessage(WebDriver driver){
        return driver.findElement(By.xpath("(//p)[6]")).getText();
    }

}