package com.cybertek.tests.PracticeDay.SocialMediaaa;

import java.time.LocalTime;
import java.util.ArrayList;

public class Instagram extends SocialMedia implements Pictures
{
    static {
        platform = "Instagram";
    }
    private String username;
    private String password;
    private int numberOfFollowing;
    private int getNumberOfFollowers;
    private ArrayList<Post> posts;

    public Instagram(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.personalUrl = "Instagram.com" + username;
    }


    @Override
    public void directMessaging(String username, String message) {
        System.out.println(message+ " message sent to "+username);
    }

    @Override
    public void post(String body) {

    this.posts = new ArrayList<Post>();
    posts.add(new Post(body));
    }

    @Override
    public void notifications() {
        if (LocalTime.now().getHour() > 8 && LocalTime.now().getHour() < 17) {
            System.out.println("Notification");
        } else {
            System.out.println("Sleep mode");
        }
    }

    @Override
    public void likePicture() {
        System.out.println("Liked pictured");
    }

    @Override
    public void unLikePicture() {
        System.out.println("Unliked pictured");
    }

    @Override
    public void sharePicture() {
        System.out.println("Share pictured");
    }
}
