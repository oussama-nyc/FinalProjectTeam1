package com.luma;

import finalProject.base.CommonAPI;
import finalProject.pages.luma.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class TestSubscribeNewsLetter extends CommonAPI {



    @Test
    public void testSubscribeValidEmail() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        Random r = new Random();
        int num = r.nextInt(1000);// generate random email
        homePage.setInputSubscribe( num + "@gmail.com");
        homePage.clickOnSubscribe();
        Assert.assertEquals(homePage.getSubscribeMsg(),"Thank you for your subscription.");

    }
    @Test
    public void testSubscribeExisting() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.setInputSubscribe( "fouad.alili89@gmail.com");
        homePage.clickOnSubscribe();
        Assert.assertEquals(homePage.getSubscribeMsg(),"This email address is already subscribed.");

    }
    @Test
    public void testSubscribeInvalidEmail() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.setInputSubscribe( "fouad.");
        homePage.clickOnSubscribe();
        Assert.assertEquals(homePage.getInvalidEmailMsg(),"Please enter a valid email address (Ex: johndoe@domain.com).");

    }
}
