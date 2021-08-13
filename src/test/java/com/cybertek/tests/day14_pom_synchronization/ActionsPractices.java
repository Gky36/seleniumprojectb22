package com.cybertek.tests.day14_pom_synchronization;

import com.cybertek.pages.TelerikPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsPractices {

    @Test
    public void drag_and_drop_test(){
        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        TelerikPage telerikPage = new TelerikPage();
        Actions actions = new Actions(Driver.getDriver());

        //Accept cookies by clicking to the button
        BrowserUtils.sleep(2);
        telerikPage.acceptCookiesButton.click();
        BrowserUtils.sleep(2);

        //2. Drag and drop the small circle to bigger circle.
       // actions.dragAndDrop(telerikPage.smallCircle, telerikPage.bigCircle).perform();

        //2. way of doing the same thing: LONGER WAY
        actions.moveToElement(telerikPage.smallCircle).clickAndHold(telerikPage.smallCircle).moveToElement(telerikPage.bigCircle).release().perform();

        //3. Assert:
        //-Text in big circle changed to: “You did great!”
        String expected = "You did great!";
        String actual = telerikPage.bigCircle.getText();

        Assert.assertEquals(actual, expected);

    }


}


