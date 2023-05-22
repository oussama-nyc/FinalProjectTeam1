package com.nopcommerce;

import finalProject.base.CommonAPI;
import finalProject.pages.nopcommerce.HomePage;
import finalProject.pages.nopcommerce.InvalidCredentialsPage;
import finalProject.pages.nopcommerce.LoginPage;
import finalProject.pages.nopcommerce.RegisterPage;
import finalProject.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

import static java.sql.DriverManager.getDriver;

public class InvalidCredentialsTest extends CommonAPI {
    Logger log = LogManager.getLogger(InvalidCredentialsTest.class.getName());

//    Properties prop = Utility.loadProperties();
//
//    String invalidEmail =Utility.decode(prop.getProperty("invalidEmail"));
//    String validEmail =Utility.decode(prop.getProperty("validEmail"));
//    String Password =Utility.decode(prop.getProperty("Password"));

    String invalidEmail  = "email1gmailcom";
    String validEmail  = "email1@gmail.com";
    String Password = "Admin1234";
    String invPassword = "Admin00000";


    @Test(priority = 1)
    public void invalidEmail() {
        HomePage homePage = new HomePage(getDriver());
        RegisterPage registerPage = new RegisterPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        InvalidCredentialsPage invalidCredentialsPage = new InvalidCredentialsPage(getDriver());
        loginPage.clickOnLoginLink();
        loginPage.typeUsername(invalidEmail);
        loginPage.typePassword(Password);
        waitFor(1);
        scrollByAmount(0,1000);
        //asserson
        String expectedText="Wrong email";
        String actualText = invalidCredentialsPage.invalidEmailValidationText();
        Assert.assertEquals(expectedText,actualText);
        log.info("Invalid email validation success ");

    }
        @Test(priority = 2)
    public void unsuccessfulLogin(){
        HomePage homePage = new HomePage(getDriver());
        RegisterPage registerPage = new RegisterPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        InvalidCredentialsPage invalidCredentialsPage = new InvalidCredentialsPage(getDriver());
        loginPage.clickOnLoginLink();
            scrollByAmount(0, 150);
        loginPage.typeUsername(validEmail);
        waitFor(5);
        loginPage.typePassword(invPassword);
            scrollByAmount(0, 100);
        waitFor(1);

        loginPage.clickOnLoginButton();

            String expectedText="No customer account found";
            String actualText = invalidCredentialsPage.unsuccessfulLoginValidationText();
            Assert.assertEquals(expectedText,actualText);
            log.info("Unsuccessful Login validation success ");



    }
}
