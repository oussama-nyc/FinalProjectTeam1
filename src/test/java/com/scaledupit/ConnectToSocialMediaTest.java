package com.scaledupit;

import finalProject.base.CommonAPI;
import finalProject.pages.scaledupit.ConnectToSocialMediaPage;
import finalProject.pages.scaledupit.DefaultSortingPage;
import finalProject.pages.scaledupit.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConnectToSocialMediaTest extends CommonAPI {
    Logger log = LogManager.getLogger(ConnectToSocialMediaTest.class.getName());

    @Test
    public void ConnectFaceBook() {
        ConnectToSocialMediaPage connectToSocialMediaPage = new ConnectToSocialMediaPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        connectToSocialMediaPage.clickOnFaceBookButton();
        waitFor(3);

    }

    @Test
    public void ConnectInstagram() {
        ConnectToSocialMediaPage connectToSocialMediaPage = new ConnectToSocialMediaPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        homePage.clickOnInstagramButton();
        waitFor(3);
    }

    @Test
    public void clickOnSnapChat() {
        ConnectToSocialMediaPage connectToSocialMediaPage = new ConnectToSocialMediaPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        connectToSocialMediaPage.clickOnSnapChatButton();
        waitFor(3);
    }
}