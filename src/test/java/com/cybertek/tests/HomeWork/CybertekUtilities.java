package com.cybertek.tests.HomeWork;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CybertekUtilities {

    List<WebElement> allInputTabs;
    List<WebElement> gender;
    List<WebElement> languages;

    //input[@class='form-control']
    public List<WebElement> allInputTabs(WebDriver driver) {
        allInputTabs = driver.findElements(By.xpath("//input[@class='form-control']"));

        return allInputTabs;
    }

    public void fillInTheForm(WebDriver driver, List<WebElement> allInputTabs) {
        int i = 0;
        for (i = 0; i < allInputTabs.size(); i++) {
//        allInputTabs.get(i).sendKeys();
            Faker faker = new Faker();
            switch (i) {
                case 0:
                    allInputTabs.get(i).sendKeys(faker.name().firstName());
                    break;
                case 1:
                    allInputTabs.get(i).sendKeys(faker.name().lastName());
                    break;
                case 2:
                    allInputTabs.get(i).sendKeys(faker.name().username().replace(".", ""));
                    break;
                case 3:
                    allInputTabs.get(i).sendKeys("email@email.com");
                    break;
                case 4:
                    allInputTabs.get(i).sendKeys("123qwerty!@#");
                    break;
                case 5:
                    allInputTabs.get(i).sendKeys("571-231-3211");
                    break;
                case 6:
                    allInputTabs.get(i).sendKeys("12/20/1990");
                    break;
            }
        }
    }

    public List<WebElement> genderSelection(WebDriver driver, List<WebElement> gender) {
        gender = driver.findElements(By.xpath("//input[@type='radio' and @name='gender']"));
        return gender;
    }

    public void dealWithSelectMenu(WebDriver driver) {
        Select select = new Select(driver.findElement(By.xpath("//select[@name='department' and @class='form-control selectpicker']")));
        select.selectByVisibleText("Department of Engineering");

        Select selectTwo = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        selectTwo.selectByIndex(4);
    }

    public void selectLanguage(WebDriver driver) {

        languages = driver.findElements(By.xpath("//input[@class='form-check-input']"));
        for (WebElement each : languages) {
            each.click();
        }
    }

    public WebElement doneButton(WebDriver driver) {
        return driver.findElement(By.xpath("//button[@id='wooden_spoon']"));
    }

    public WebElement result(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id='content']/div/div/p"));
    }

    public void SOLVE(WebDriver driver, List<WebElement> allInputTabs, List<WebElement> gender, List<WebElement> languages)
    {

    }
}

