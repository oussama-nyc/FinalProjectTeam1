package com.scaledupit;

import com.github.javafaker.Faker;
import finalProject.base.CommonAPI;
import finalProject.pages.scaledupit.HomePage;
import finalProject.pages.scaledupit.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginTest extends CommonAPI {
    Logger log = LogManager.getLogger(LoginTest.class.getName());

    Faker fakeData = new Faker();
    String username =fakeData.internet().emailAddress();


    @Test
    public void loginWithValidcredential() {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        homePage.clickOnMyAccountButton();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "My account – Automation");
        log.info("login title page validation success");

        loginPage.typeusername(username);

        loginPage.clickOnLoginButton();
        log.info("login success");
    }

    @Test
    public void loginWithInValidemail() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        homePage.clickOnMyAccountButton();

        String title = getCurrentTitle();
        Assert.assertEquals(title, "My account – Automation");
        log.info("login title page validation success");
        loginPage.typeusername("baruamousumi@aol");
        loginPage.typepassword("asd1245");
        loginPage.clickOnLoginButton();
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Error: The username baruamousumi@aol is not registered on this site. If you are unsure of your username, try your email address instead.");
        log.info("error message validation success");


    }


    @Test
    public void loginWithMissingPassword() {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        homePage.clickOnMyAccountButton();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "My account – Automation");
        log.info("login title page validation success");
        //String username = ConnectDB.getTableColumnData("select * from cred", "username").get(0);
        loginPage.typeusername(username);
        loginPage.typepassword("");
        loginPage.clickOnLoginButton();
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Error: The password field is empty.");
        log.info("login Unsuccess");

    }





}















