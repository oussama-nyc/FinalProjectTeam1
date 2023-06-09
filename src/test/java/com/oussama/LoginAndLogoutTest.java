package com.oussama;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import finalProject.base.CommonAPI;
import finalProject.pages.oussama.DashboardPage;
import finalProject.pages.oussama.HeaderPage;
import finalProject.pages.oussama.MyAccountPage;

public class LoginAndLogoutTest extends CommonAPI {
    Logger log = LogManager.getLogger(LoginAndLogoutTest.class.getName());

 //--------------------------------------------------------------------------------------------------------------------
// ***************( Test case for Login and logout as a Customer and Verify Redirect to My Account Page )**************
// --------------------------------------------------------------------------------------------------------------------

    @Test (enabled = true,priority = 2, groups = {"Smoke"})
    public void loginAndLogoutAsCustomer() {
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        HeaderPage headerPage = new HeaderPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Click on the "My Account" button located at the top right corner of the website's header
        headerPage.clickOnMyAccountLink();

        //Enter a valid Email address in the " Email address " field. Under the Login form on the Left side
        myAccountPage.enterValidEmailLoginCustomer();

        //Enter a valid Password in the " Password " field
        myAccountPage.enterValidPasswordLoginCustomer();

        //Click on the " Login " button to submit the form.
        myAccountPage.clickOnLoginButton(getDriver());

        //Verify that the customer is redirected to the My Account page.
        String expectedMyAccountPageTitle = "My Account";
        String actualMyAccountPageTitle = myAccountPage.getMyAccountTitle();
        Assert.assertEquals(actualMyAccountPageTitle,expectedMyAccountPageTitle);
        log.info("Successfully redirected to My Account page");

        headerPage.clickOnMyAccountIcon();
        waitFor(2);

        headerPage.hoverOverAndClickOnLogoutLink(getDriver());

        //Verify that the Customer is redirected to the Home page.
        String expectedTitleAfterCustomerLogout = "My Account – Welcome to Worldwide Electronics Store";
        String actualTitleAfterCustomerLogout = getCurrentTitle();
        Assert.assertEquals(actualTitleAfterCustomerLogout, expectedTitleAfterCustomerLogout);
        log.info("Successfully redirected to Home page");
    }

 //--------------------------------------------------------------------------------------------------------------------
// ***************( Test case for Login and logout  as a vendor and Verify Redirect to Dashboard page )**************
// --------------------------------------------------------------------------------------------------------------------
    @Test (enabled = true,priority = 1,groups = {"Smoke"})
    public void loginAndLogoutAsVendor() {
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        HeaderPage headerPage = new HeaderPage(getDriver());
        DashboardPage dashboardPage = new DashboardPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Click on the "My Account" button located at the top right corner of the website's header
        headerPage.clickOnMyAccountLink();

        //Enter a valid Email address in the " Email address " field. Under the Login form on the Left side
        myAccountPage.enterValidEmailLoginVendor();

        //Enter a valid Password in the " Password " field
        myAccountPage.enterValidPasswordLoginVendor();

        //Click on the " Login " button to submit the form.
        myAccountPage.clickOnLoginButton(getDriver());

        //Verify that the vendor is redirected to the Dashboard page.
        String expectedMyDashboardPageTitle = "Dashboard";
        String actualMyDashboardTitle = dashboardPage.getMyDashboardTitle();
        Assert.assertEquals(actualMyDashboardTitle,expectedMyDashboardPageTitle);
        log.info("Successfully redirected to dashboard page");

        headerPage.clickOnMyAccountIcon();
        waitFor(2);

        headerPage.hoverOverAndClickOnLogoutLink(getDriver());

        //Verify that the vendor is redirected to the Home page.
        String expectedTitleAfterVendorLogout = "My Account – Welcome to Worldwide Electronics Store";
        String actualTitleAfterVendorLogout = getCurrentTitle();
        Assert.assertEquals(actualTitleAfterVendorLogout, expectedTitleAfterVendorLogout);
        log.info("Successfully redirected to Home page");
    }

}
