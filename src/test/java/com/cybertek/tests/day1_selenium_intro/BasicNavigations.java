package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {
        //1- setup the browser driver
        WebDriverManager.chromedriver().setup();

        //2- create instance of selenium web driver
        // this line open a browser
        WebDriver driver = new ChromeDriver();

        // this line will basically maximize the browser size
        // this is very important for selenium
        driver.manage().window().maximize();

        // will work only for Mac, will not work for windows
        driver.manage().window().fullscreen();

        //3- get the page for Tesla.com
        driver.get("https://www.tesla.com");

        System.out.println("Current title: " + driver.getTitle());

        String currentUrl = driver.getCurrentUrl();

        System.out.println("currentUrl = " + currentUrl);

        // putting 3 seconds of wait/ stops the code for 3 sec
        Thread.sleep(3000);

        // Going back to using navigations
        driver.navigate().back();

        // putting 3 seconds of wait/ stops the code for 3 sec
        // purpose of this command we want to see
        Thread.sleep(3000);

        //Going forward using navigations
        driver.navigate().forward();

        //refreshing the page using navigations
        driver.navigate().refresh();

        // going to another url using .to() method
        driver.navigate().to("https://www.google.com");

        System.out.println("Current title: " + driver.getTitle());

        currentUrl = driver.getCurrentUrl();

        System.out.println("currentUrl = " + currentUrl);
        //this method will close currently opened browser
        //it will only close 1 browser or 1 tab
        driver.close();

    }
}
/*

.get method();
    - This gets the given URL(link) in an already opened browser.

    Does it accept any argument?
       - This is method accepts a STRING argument.
    Does it return anything?
    - void

-basic navigations
    -driver.navigate()
    -driver.navigate().back() --> will take to the previous page
    -driver.navigate().forward() --> will take to forward page
    -driver.navigate().refresh --> will reflesh the page

    -driver.navigate().to();
        - .get() method and .navigate().to method do exactly the same thing.
        -  the difference is .get() method  will wait until the page is loaded before
        going to next step
        - .to()  method will not wait.
        - therefore we will not be using .navigate().to() method a lot

     -.getTitle():
        -What does it do?
            - Goes in the <html> page
            - finds <find> tag
            - returns title
        -Does this accept any argument?
            -No. It does not accept.
      -. getCurrentUrl();
        - Returns string that is currently URL on browser
        - Good for confirming that you are on

      - driver.manage().window().maximize();
        -maximizes the current window
        -helps selenium browser driver to see everything on the page

      - driver.close()
        - will close currently focused page or tab

      - driver.quit()
        - will close all if the opened browsers or tabs within the same sessions.

      - What is a sessions?
        - A driver session is created when we click run. And it ends when selenium code stops.
        - Or when we say driver.quit
 */