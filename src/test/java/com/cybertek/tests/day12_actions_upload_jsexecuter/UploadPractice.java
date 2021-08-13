package com.cybertek.tests.day12_actions_upload_jsexecuter;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadPractice
{
    @Test
    public void upload_test(){
        //1. Go to http://practice.cybertekschool.com/upload
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");

        //2. Find some small file from your computer, and get the path of it.
        String path = "/Users/gokayyazar/Library/Mobile Documents/com~apple~CloudDocs/Desktop/download.jpeg";

        // 3. Upload the file.
        WebElement chooseFile = Driver.getDriver().findElement(By.id(("file-upload")));

        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));


        //Sending the file path to the chooseFile WebElement
        chooseFile.sendKeys(path);

        //click to upload button
        uploadButton.click();

        //4. Assert:
        //-File uploaded text is displayed on the page
        WebElement fileUploadedMessage = Driver.getDriver().findElement(By.tagName("h3"));

        Assert.assertTrue(fileUploadedMessage.isDisplayed());

        Driver.closeDriver();
    }
}
/*
   How do we handle Downdload using selenim library?
    - We don't.
    - We can NOT directly handle download using Selenium.
    - Because the folder structor of our OS is out of scope for selenium we cannot verify if a file is downloaded.

    - We can click to a link and download something.
    - But we can not go in our computer folder structure using SELENIUM to verify it is actually downloaded.

How do we handle UPLOAD using selenium?
    - We locate the input web element that accepts files.
    - We use .sendKeys(), and send the path of the file we want to upload.
    - Finally we can verify if any web element is displayed on the page after we uploaded.
 */