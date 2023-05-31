package com.oussama;

import finalProject.base.CommonAPI;
import finalProject.pages.oussama.DashboardPage;
import finalProject.pages.oussama.HeaderPage;
import finalProject.pages.oussama.MyAccountPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewProductTest extends CommonAPI {
    Logger log = LogManager.getLogger(AddNewProductTest.class.getName());

    //-----------------------------------------------------------------------------------------------------------------
    // ******************************( Test case for Add New Product to sell )*****************************************
    // ----------------------------------------------------------------------------------------------------------------

    @Test (enabled = true,groups = {"Smoke"})
    public void addNewProduct() {
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        HeaderPage headerPage = new HeaderPage(getDriver());
        DashboardPage dashboardPage = new DashboardPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Click on the "My Account" link
        headerPage.clickOnMyAccountLink();

        //Enter a valid Email address in the " Email address " field. Under the Login form on the Left side
        myAccountPage.enterValidEmailLoginVendor2();

        //Enter a valid Password in the " Password " field
        myAccountPage.enterValidPasswordLoginVendor2();

        //Click on the " Login " button to submit the form.
        myAccountPage.clickOnLoginButton(getDriver());

        //Verify that the vendor is redirected to the Dashboard page.
        String expectedMyDashboardPageTitle = "Dashboard";
        String actualMyDashboardTitle = dashboardPage.getMyDashboardTitle();
        Assert.assertEquals(actualMyDashboardTitle,expectedMyDashboardPageTitle);
        log.info("Successfully redirected to dashboard page");

        // Click on the " Products" link
        dashboardPage.clickOnProductsLink();

        // Click on the " Add new product" button
        dashboardPage.clickOnAddNewProductButton();

        // Add Product Title
        dashboardPage.enterProductTitle();

        // Add Product Title Price and Discounted Price
        dashboardPage.enterProductPrice();
        dashboardPage.enterProductDiscountedPrice();

        // add picture
        dashboardPage.addPictures();

        //select category
        dashboardPage.selectCategory(getDriver());

        //add description
        dashboardPage.enterProductDescription();

        // click on Create product
        dashboardPage.clickOnCreateProductButton();

        // Verify that the product has been successfully created
        dashboardPage.clickOnViewProductButton();

        switchToCurrentlyActiveWindow();

        String expectedProductTitle = "laptop chargers for HP 20V 4.5A 90W";
        String actualProductTitle = dashboardPage.getNewProductTitle();
        Assert.assertEquals(actualProductTitle,expectedProductTitle);
        log.info("The product successfully created and visible on the website.");
    }
}
