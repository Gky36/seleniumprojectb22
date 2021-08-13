package com.cybertek.tests.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T1_Cybertek_ForgetPassword_Xpath {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
// 1. Open Chrome browser
// 2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");
// 3. Locate all the WebElements on the page using XPATH locator only (total of 6)
// “Home” link.
        WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
// “Forgot password” header.
        WebElement header = driver.findElement(By.xpath("//h2['Forgot Password']"));
// “E-mail” text.
        WebElement email = driver.findElement(By.xpath("//label[@for='email']"));
// E-mail input box.
        WebElement emailBox = driver.findElement(By.xpath("//input[@type='text']"));
// “Retrieve password” button.
        WebElement retrievePassword = driver.findElement(By.xpath("//i[text()='Retrieve password']"));
// “Powered byCybertek School” text 4.
        WebElement poweredBy = driver.findElement(By.xpath("(//a[.='Cybertek School']//..)[1]"));
//        System.out.println(poweredBy.getText());
// Verify all WebElements are displayed.
 // 4. Verify all WebElements are displayed.
//        System.out.println(homeLink.isDisplayed());
//        System.out.println(forgotPassword.isDisplayed());
//        System.out.println(emailText.isDisplayed());
//        System.out.println(emailInputBox.isDisplayed());
//        System.out.println(retrievePassword.isDisplayed());
//        System.out.println(poweredText.isDisplayed());

        List<WebElement> isAllDisplayed = new ArrayList<>(Arrays.asList(homeLink, header, email, emailBox, retrievePassword, poweredBy));
        int displayed = 0;
        int notDisplayed = 0;
        for (WebElement each : isAllDisplayed) {
            if (each.isDisplayed()) {
                displayed++;
            } else {
                notDisplayed++;
            }
        }
        if (displayed == isAllDisplayed.size()) {
            System.out.println("Everything is displayed TEST PASS");
        } else {
            System.out.println("Missing TEST FAIL");
        }
    }
}








