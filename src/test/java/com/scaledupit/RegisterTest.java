package com.scaledupit;

import finalProject.base.CommonAPI;
import finalProject.pages.scaledupit.HomePage;
import finalProject.pages.scaledupit.RegisterPage;
import finalProject.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class RegisterTest extends CommonAPI {

    Logger log = LogManager.getLogger(RegisterTest.class.getName());

    Properties prop = Utility.loadProperties();


    @Test(priority = 2)
    public void registerUser() {

        RegisterPage registrationPage = new RegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on register
        homePage.clickOnSignInButton();
        waitFor(3);

        // enter email adress , password, and click on register button

        registrationPage.enterEmail(registrationPage.enterNewFakeRegistrationEmail());
        waitFor(3);

        registrationPage.enterPassword(registrationPage.enterNewFakeRegistrationPassword());
        waitFor(3);


        registrationPage.clickOnRegisterBtn();
        waitFor(3);


        // check user is sign up successfully
        Assert.assertTrue(registrationPage.checkPresenceOfLoginPageHeader());

        String expectedLoginPageHeader = "My account";
        String actualLoginPageHeader = registrationPage.getLoginPageHeadertext();
        Assert.assertEquals(expectedLoginPageHeader, actualLoginPageHeader);
        log.info("user is registred success");
        waitFor(3);

    }

    @Test(priority = 3)
    public void registerUsingValidEmail() {

        RegisterPage registrationPage = new RegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on register
        homePage.clickOnSignInButton();
        waitFor(3);

        registrationPage.enterEmail(registrationPage.enterNewFakeRegistrationEmail());
        waitFor(3);


        registrationPage.clickOnRegisterBtn();
        waitFor(3);


        // check user is sign up successfully
        Assert.assertTrue(registrationPage.checkPresenceOfValidUsernameErrorMessage());
        String expectedErrorMessage1 = "Error: Please enter an account password.";
        String actualErrorMessage1 = registrationPage.getValidUsernameErrorMessage();
        Assert.assertEquals(expectedErrorMessage1, actualErrorMessage1);
        waitFor(3);


    }

    @Test( priority = 1)
    public void registerUsingWeekPassword() {
        RegisterPage registrationPage = new RegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on register
        homePage.clickOnSignInButton();
        waitFor(3);

        // enter email adress , password, and click on register button
        registrationPage.enterEmail(registrationPage.enterNewFakeRegistrationEmail());
        waitFor(3);

        registrationPage.enterPassword(registrationPage.entreNewFakeWeakPassword());
        waitFor(3);


        registrationPage.clickOnRegisterBtn();
        waitFor(3);


        // check user is sign up successfully
        waitFor(3);


        // check user is sign up successfully
        Assert.assertTrue(registrationPage.checkPresenceOfLoginPageHeader());
        String expectedLoginPageHeader = "My account";
        String actualLoginPageHeader = registrationPage.getLoginPageHeadertext();
        Assert.assertEquals(expectedLoginPageHeader, actualLoginPageHeader);
        log.info("user is registred success");
        waitFor(3);

    }

    @Test ( priority = 4)
    public void registerUsingShortPassword() {
        RegisterPage registrationPage = new RegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on register
        homePage.clickOnSignInButton();
        waitFor(3);

        // enter email adress , password, and click on register button
        registrationPage.enterEmail(registrationPage.enterNewFakeRegistrationEmail());
        waitFor(3);

        registrationPage.enterPassword(registrationPage.entreNewFakeShortPassword());
        waitFor(3);


        registrationPage.clickOnRegisterBtn();
        waitFor(3);


        // check user is sign up successfully
        waitFor(3);


        // check user is sign up successfully
        Assert.assertTrue(registrationPage.checkPresenceOfLoginPageHeader());
        String expectedLoginPageHeader = "My account";
        String actualLoginPageHeader = registrationPage.getLoginPageHeadertext();
        Assert.assertEquals(expectedLoginPageHeader, actualLoginPageHeader);
        log.info("user is registred success");
        waitFor(3);

    }
}
