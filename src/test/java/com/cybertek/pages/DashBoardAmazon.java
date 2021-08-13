package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class DashBoardAmazon
{
    public DashBoardAmazon(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    List<WebElement> dashBoardList = new ArrayList<>();

    public void dashBoardTest() {

        for (int i = 9; i <= 13; i++) {
            WebElement dashBordItems = Driver.getDriver().findElement(By.cssSelector("a[data-csa-c-slot-id*=nav_cs_" + i + "]"));
            dashBoardList.add(dashBordItems);
            System.out.println(dashBordItems.getText());
            Assert.assertTrue(dashBordItems.isDisplayed());

        }
        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }

}

