package com.nopcommerce;

import finalProject.base.CommonAPI;
import finalProject.pages.nopcommerce.HomePage;
import finalProject.pages.nopcommerce.LoginPage;
import finalProject.pages.nopcommerce.RegisterPage;
import finalProject.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class LoginTest extends CommonAPI {
    Logger log = LogManager.getLogger(LoginTest.class.getName());
    //********** Data ******************

//    Properties prop = Utility.loadProperties();
//    String email =Utility.decode(prop.getProperty("email"));
//    String password =Utility.decode(prop.getProperty("password"));

    String email  = "email2001@gmail.com";
    String password = "Admin1234";
@Test (priority = 1)
    public void loginTest(){
        HomePage homePage = new HomePage(getDriver());
        RegisterPage registerPage = new RegisterPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnLoginLink();
        loginPage.typeUsername(email);
        waitFor(2);
        loginPage.typePassword(password);
        waitFor(2);
        scrollByAmount(0,100);
        loginPage.clickOnLoginButton();

        String expectedText="Log out";
        String actualText = loginPage.loginValidationText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Test(priority = 2)
    public void logOutTest(){
        HomePage homePage = new HomePage(getDriver());
        RegisterPage registerPage = new RegisterPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnLoginLink();
        loginPage.typeUsername(email);
        waitFor(2);
        loginPage.typePassword(password);
        waitFor(2);
        scrollByAmount(0,100);
        loginPage.clickOnLoginButton();
        waitFor(5);
        loginPage.clickOnLogOutButton();
    }

}
