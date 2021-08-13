package com.cybertek.tests.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Dropdown
{
    WebDriver driver;

    @BeforeMethod
    public void setupClass(){

        //TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
        //1.Open Chrome browser
        //2.Go to http://practice.cybertekschool.com/dropdown

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get("http://practice.cybertekschool.com/dropdown");
        //driver.get("http://practice.cybertekschool.com/javascript_alerts");
        //driver.get("http://practice.cybertekschool.com/iframe");
        //driver.get("http://practice.cybertekschool.com/windows");
        //driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void dropDownPractice(){
        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”

        ////returning me Web element
        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        WebElement currentSelected = simpleDropdown.getFirstSelectedOption();

        String actualTextOfCurrentOption = simpleDropdown.getFirstSelectedOption().getText();
        String expectedText ="Please select an option";

        Assert.assertTrue(actualTextOfCurrentOption.equals(expectedText));

        //4.Verify“State selection” default selected value is correct
        //Expected: “Select a State”

        Select selectDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        String actualSelection = selectDropdown.getFirstSelectedOption().getText();
        String expected = "“Select a State”";

        Assert.assertEquals(actualSelection,expected);
    }

    @Test
    public void tc2_state_dropdown_test() {
        //TC #2: Selecting state from State dropdown and verifying result
        // 1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        //3. Select Illinois
        stateDropdown.selectByVisibleText("Illinois");
        stateDropdown.selectByVisibleText("California");
        stateDropdown.selectByVisibleText("Georgia");
        //4. Select Virginia
        stateDropdown.selectByValue("DE");
        stateDropdown.selectByValue("ID");

        stateDropdown.selectByIndex(3);
        stateDropdown.selectByIndex(4);

        String expected = "Arkansas";
        String actual = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertTrue(actual.equals(expected));

    }

    @Test
    public void tc3_alertPractice(){

        //Location the button for alert to click
        WebElement jsAlert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));

        //3. Click to “Click for JS Alert” button
        jsAlert.click();

        //Switching driver's focus to alert, so we can handle it.
        Alert alert = driver.switchTo().alert();

        //4. Click to OK button from the alert
        alert.accept();
        //5. Verify “You successfuly clicked an alert” text is displayed.

        String expected ="You successfuly clicked an alert";
        String actual = driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertTrue(actual.equals(expected));
    }

    @Test
    public void information_alert_test1() {

        //#1- changing to iframe by index: we pass index number
            //driver.switchTo().frame(0);

        //#2- Locate as a Web Element to switch
            //WebElement iframe=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
            //WebElement iframe2= driver.findElement(By.xpath("//iframe[@title='Rich Text Area. Press ALT-0 for help.']"));

        //#3- If <iframe> tag has id or name attribute, we can pass its attribute value as a string into
        driver.switchTo().frame("mce_0_ifr");

        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));

        //4. Assert: “Your content goes here.” Text is displayed.
        Assert.assertTrue(yourContentGoesHereText.isDisplayed());

        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
    }
    @Test
    public void iframe_practice(){

        driver.switchTo().frame("iframeResult");

        WebElement tytItButton = driver.findElement(By.xpath("//button[text()='Try it']"));
        tytItButton.click();

        WebElement yourContent = driver.findElement(By.xpath("//p[@id='demo']"));

        Assert.assertTrue(yourContent.isDisplayed());

        driver.switchTo().defaultContent();

    }

    @Test
    public void windowHandle_practice(){
        String mainHandle = driver.getWindowHandle();
        System.out.println(mainHandle);

        //4. Assert: Title is “Practice”
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        //Click here
        WebElement clickHereLink = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHereLink.click();

        for (String each : driver.getWindowHandles()){
            driver.switchTo().window(each);
            System.out.println(driver.getTitle());
        }
    }

    @Test
    public void windowHandles_practice2(){
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        for (String eachWindow : driver.getWindowHandles())
        {
            driver.switchTo().window(eachWindow);
            System.out.println("each title in current page: "+driver.getTitle());

            if (driver.getTitle().contains("Etsy"))
            {
                Assert.assertTrue(driver.getTitle().contains("Etsy"));
                break;
            }
        }

    }
}
