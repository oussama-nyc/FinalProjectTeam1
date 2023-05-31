package com.scaledupit;

import finalProject.base.CommonAPI;
import finalProject.pages.scaledupit.HomePage;
import finalProject.pages.scaledupit.LoginPage;
import finalProject.pages.scaledupit.ShoppingCategoriesPage;
import finalProject.utility.ConnectDB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCategoriesTest extends CommonAPI {

    Logger log = LogManager.getLogger(ShoppingCategoriesPage.class.getName());

    @Test
    public void AddReview() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        homePage.clickOnMyAccountButton();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "My account – Automation");
        log.info("login title page validation success");
        String username = ConnectDB.getTableColumnData("select * from cred", "username").get(0);
        loginPage.typeusername(username);
        String password = ConnectDB.getTableColumnData("select * from cred", "password").get(0);
        loginPage.typepassword(password);
        loginPage.clickOnLoginButton();
        log.info("login success");
        loginPage.clickOnHomeButton();

        String title1 = getCurrentTitle();
        Assert.assertEquals(title1, "Automation – Automate eCommerce");
        log.info("login title page validation success");
        homePage.clickOnGuitar();

        String title2 = getCurrentTitle();
        Assert.assertEquals(title2, "Guitar – Automation");
        log.info("Guitar page validation success");
        ShoppingCategoriesPage  guitarPage = new  ShoppingCategoriesPage (getDriver());
        guitarPage.clickReviewButton();
        guitarPage.clickRating();
        guitarPage.typeReview("Good");
        guitarPage.clickOnSubmitButton();





    }
}

