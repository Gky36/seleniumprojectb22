package com.cybertek.tests.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class mainTest extends baseTest
{
    @Test
    public void Test1()
    {
        WebElement simpleDropDown = getDriver().findElement(By.xpath("//select[@id='dropdown']"));
        Select selectForDD = new Select(simpleDropDown);
        String actualSimple = selectForDD.getFirstSelectedOption().getText();
        String expectedSimple ="Please select an option";

        Assert.assertEquals(actualSimple,expectedSimple);

        WebElement stateSelection = getDriver().findElement(By.xpath("//select[@id='state']"));
        Select selectSelection = new Select(stateSelection);
        String actualSelection = selectSelection.getFirstSelectedOption().getText();
        String expectedSelection = "Select a State";

        Assert.assertEquals(actualSelection,expectedSelection);
    }

    @Test
    public void Test2(){

        WebElement stateSelector = getDriver().findElement(By.xpath("//select[@id='state']"));
        Select selectorForState = new Select(stateSelector);

        //3.Select Illinois
        selectorForState.selectByVisibleText("Illinois");

        //4.Select Virginia
        selectorForState.selectByValue("VA");

        //5.Select California
        selectorForState.selectByIndex(5);

       // 6. Verify final selected option is California.
        // Use all Select options.(visible text, value, index)
        String actualOptions= selectorForState.getFirstSelectedOption().getText();
        String expectedChoice = "California";

        Assert.assertEquals(actualOptions,expectedChoice);
    }

    @Test
    public void Test3()
    {
        //TC #3: Selecting date on dropdown and verifying
        // 1.Open Chrome browser
        // 2.Go to http://practice.cybertekschool.com/dropdown

        // 3.Select “December 1st, 1922” and verify it is selected.
        // Select year using: visible text
        WebElement year = driver.get().findElement(By.xpath("//select[@id='year']"));
        Select selectorForYear = new Select(year);
        selectorForYear.selectByVisibleText("1922");

        // Select month using : value attribute
        WebElement month = driver.get().findElement(By.xpath("//select[@id='month']"));
        Select selectorForMonth = new Select(month);
        selectorForMonth.selectByValue("11");

        // Select day using: index number
        WebElement day = driver.get().findElement(By.xpath("//select[@id='day']"));
        Select selectorForDay = new Select(day);
        selectorForDay.selectByIndex(0);

        // Selecting date on dropdown and verifying
        String actualYear = selectorForYear.getFirstSelectedOption().getText();
        String expectedYear = "1922";
        Assert.assertEquals(actualYear,expectedYear);

        String actualMonth = selectorForMonth.getFirstSelectedOption().getText();
        String expectedMonth = "December";
        Assert.assertEquals(actualMonth,expectedMonth);

        String actualDay = selectorForDay.getFirstSelectedOption().getText();
        String expectedDay = "1";
        Assert.assertEquals(actualDay,expectedDay);


    }

    @Test
    public void Test4()
    {
        //TC #4: Selecting value from multiple select dropdown
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown

        // 3. Select all the options from multiple select dropdown.
        WebElement languages =driver.get().findElement(By.xpath("//select[@name='Languages']"));
        Select selectForLanguage= new Select(languages);
        selectForLanguage.selectByIndex(0);
        selectForLanguage.selectByValue("js");
        selectForLanguage.selectByVisibleText("C#");
        selectForLanguage.selectByVisibleText("Python");
        selectForLanguage.selectByValue("ruby");
        selectForLanguage.selectByIndex(5);

        // 4. Print out all selected values.
        List<WebElement> myOptions = selectForLanguage.getAllSelectedOptions();
        myOptions.forEach(each -> System.out.println(each.getText()+ " ,"));

        //5. Deselect all values.
        selectForLanguage.deselectAll();
        Assert.assertTrue(selectForLanguage.getAllSelectedOptions().isEmpty());
    }

    @Test
    public void Test5() throws InterruptedException {

        //TC #5: Selecting value from non-select dropdown
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown

        // 3. Click to non-select dropdown
        WebElement lastDD = driver.get().findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        lastDD.click();
        //4. Select Facebook from dropdown
        WebElement selectFacebook = driver.get().findElement(By.xpath("//a[.='Facebook']"));
        selectFacebook.click();
        Thread.sleep(2000);

        //5. Verify title is “Facebook - Log In or Sign Up”
        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle =driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
