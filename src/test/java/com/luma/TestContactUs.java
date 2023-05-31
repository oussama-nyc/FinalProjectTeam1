package com.luma;

import finalProject.base.CommonAPI;
import finalProject.pages.luma.ContactUsPage;
import finalProject.pages.luma.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestContactUs extends CommonAPI {

    @Test
    public void testContactUsPage() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnContactUs();
        Assert.assertEquals(getDriver().getTitle(),"Contact Us");
    }
    @Test
    public void testSendValidEmail() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        ContactUsPage contactUsPage = new ContactUsPage(getDriver());
        homePage.clickOnContactUs();
        contactUsPage.setInputName("fouad");
        contactUsPage.setInputEmail("test123@gmail.com");
        contactUsPage.setInputComment("just a test message");
        contactUsPage.clickOnSubmitButton();
        Assert.assertEquals(contactUsPage.getSentMsg(),"Thanks for contacting us with your comments and questions. We'll respond to you very soon.");

    }
    @Test
    public void sendInvalidEmail() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        ContactUsPage contactUsPage = new ContactUsPage(getDriver());
        homePage.clickOnContactUs();
        contactUsPage.setInputName("fouad");
        contactUsPage.setInputEmail("test123");
        contactUsPage.setInputComment("just a test message");
        contactUsPage.clickOnSubmitButton();
        Assert.assertEquals(contactUsPage.getInvalidEmailMsg(),"Please enter a valid email address (Ex: johndoe@domain.com).");

    }
}
