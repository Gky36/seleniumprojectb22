package com.cybertek.tests.PracticeDay.SocialMediaaa;

/**
 * /**
 *      * Create an abstract class for Social Media that has the following features:
 *      * -Direct messaging(String username, String message)
 *      * -Post(String body)-Notifications()
 *      * The Social Mediawill also have the following fields:
 *      * -Personal URl (String)-Account length (int)-Platform (static String)
 *      */



public abstract class SocialMedia
{
    String personalUrl;
    int accountLength;
    static  String platform;

    public abstract void directMessaging(String username, String message);

    public abstract void post(String body);

    public abstract void notifications();


}
