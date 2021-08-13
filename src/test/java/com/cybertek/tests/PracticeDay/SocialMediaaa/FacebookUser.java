package com.cybertek.tests.PracticeDay.SocialMediaaa;

import java.time.LocalTime;
import java.util.ArrayList;

public class FacebookUser extends SocialMedia implements hasGroups {
    private String username;
    private String password;
    private String fullName;
    private int age;
    private int numberOfFriends;
    private ArrayList<Post> posts;
    private int countOfGroup;

    static {
        platform = "Facebook";
    }

    public FacebookUser(String username, String password) {
        this.username = username;

        if (!password.contains(username)) {
            this.password = password;
        } else {
            this.password = "password";
            System.out.println("Password contained username. Default password created");
        }
        this.personalUrl = "facebook.com/" + this.username;

        posts = new ArrayList<Post>();
    }

    public FacebookUser(String username, String password, String fullName) {
        this(username, password);
        boolean noSpecialChars = true;
        for (int i = 0; i < username.length(); i++) {
            if (!Character.isLetter(fullName.charAt(i))) {
                noSpecialChars = false;
                break;
            }
        }

        if (noSpecialChars) {
            this.fullName = fullName;
        } else {
            this.fullName = "no name";
            System.out.println("Invalid username. Default name: \"no name\" assigned.");
        }


        this.fullName = fullName;
    }

    public FacebookUser(String username, String password, String fullName, int age, int numberOfFriends) {
        this(username, password, fullName);

        if (age > 0) {
            this.age = age;
        } else {
            this.age = 0;
        }

        if (numberOfFriends < 5000 && numberOfFriends >= 0) {
            this.numberOfFriends = numberOfFriends;
        } else {
            this.numberOfFriends = 0;
        }
    }

    @Override
    public void directMessaging(String username, String message) {
        System.out.println(message + " sent to " + username);
    }

    @Override
    public void post(String body) {
        //Post post = new Post(body); other way around
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
    public String toString() {
        return "FacebookUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", numberOfFriends=" + numberOfFriends +
                ", posts=" + posts +
                '}';
    }

    public boolean sendFriendRequest(FacebookUser user) {
        boolean resultYou = false;
        boolean resultFriend = false;
        if (this.numberOfFriends >= 5000) {
            System.out.println("You have reached the limit of friends");
            resultYou = false;
        } else {
            resultYou = true;
        }

        if (user.numberOfFriends >= 5000) {
            System.out.println(user.username +"can not accept any more friends request");
            resultFriend = false;
        } else {
            resultFriend = true;
        }

        if (resultYou && resultFriend) {
            this.numberOfFriends++;
            user.numberOfFriends++;
        }

        return resultYou && resultFriend;
    }

    @Override
    public void joinGroup(String group) {
        System.out.println(this.username + " has joined group "+group);
        this.countOfGroup++;
    }

    @Override
    public void leaveGroup(String group) {
        System.out.println(this.username+ " has left "+ group);
        this.countOfGroup--;
    }
}