package com.cybertek.utilities;

public class BrowserUtils
{
    /*
    Method that will accept int arg
    Wait for given second duration
     */

    public static void sleep(int second) {

        second *=1000;

        //1 sec =1000 milli secods
        //1 * 1000 =1

        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

            System.out.println("something happened in the sleep method");
        }
    }

}
