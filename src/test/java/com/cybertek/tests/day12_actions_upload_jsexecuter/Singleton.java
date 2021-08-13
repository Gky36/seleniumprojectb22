package com.cybertek.tests.day12_actions_upload_jsexecuter;

/*
    We will create similar logic we created in Driver utility class.
    But it will be for a String

 */

public class Singleton
{
    // Create private constructor

    private Singleton(){}

    // Create a private String
    // we will ensure we create access only through our getter method
    private static String word;

    // because we are not getting driver, so this time we are getting word with getWord
    //We allow user to access to 'word' in the way we want them to have
    public static String getWord(){

        if (word==null)
        {
            System.out.println("First time call. Word object is null."+ "Assigning value to it now");
            word = "something";
        }else{
            System.out.println("word already has a value.");
        }
        return word;
    }
    
}
