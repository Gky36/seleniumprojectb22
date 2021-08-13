package com.cybertek.tests.day8_windows_javafaker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice
{
    @Test
    public void test1()
    {
        Faker faker = new Faker();

        String fullName = faker.name().fullName();
        System.out.println("fullName = " + fullName);

        String firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);

        String chuckNorries = faker.chuckNorris().fact();
        System.out.println("chuckNorries = " + chuckNorries);
    }
}
