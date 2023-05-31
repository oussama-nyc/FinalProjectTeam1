package com.oussama;

import finalProject.base.CommonAPI;
import finalProject.pages.oussama.DashboardPage;
import finalProject.pages.oussama.HeaderPage;
import finalProject.pages.oussama.MyAccountPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentMethodForVendorTest extends CommonAPI {

    Logger log = LogManager.getLogger(PaymentMethodForVendorTest.class.getName());

    //---------------------------------------------------------------------------------------------------------------
    // ***********************************( Test case for Payment Method For Vendor  )**************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @Test  (enabled = true,groups = {"Smoke"})
    public void paymentMethodForVendor() {
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        HeaderPage headerPage = new HeaderPage(getDriver());
        DashboardPage dashboardPage = new DashboardPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Click on the "My Account" Link
        headerPage.clickOnMyAccountLink();

        //Enter a valid Email address in the " Email address " field.
        myAccountPage.enterRegisterEmailFieldFakeData();

        //Select I am a vendor as the registration type.
        myAccountPage.selectRegisterVendorOption(getDriver());

        //Enter a valid Password in the " Password " field
        myAccountPage.enterRegisterPasswordFieldFakeData(getDriver());

        //Enter a valid First Name in the " First Name " field
        myAccountPage.enterRegisterFirstNameField();

        //Enter a valid Last Name  in the " Last Name  " field
        myAccountPage.enterRegisterLastNameField();

        //Enter a valid Shop Name  in the " Shop Name  " field
        myAccountPage.enterRegisterShopNameField(getDriver());

        //Click inside The  " Shop URL"  field.
        myAccountPage.clickInsideTheShopURLField(getDriver());

        //Click inside The  " Shop Name"  field.
        myAccountPage.clickInsideTheShopNameField(getDriver());

        //Verify that A message is displayed above the Shop URL field indicating whether the shop URL is Available.
        String expectedDisplayedText = "Available";
        String actualDisplayedText = myAccountPage.getTextDisplayedAboveTheShopURL();
        Assert.assertEquals(actualDisplayedText,expectedDisplayedText);
        log.info(" the shop URL is Available.");

        //Enter a valid Phone Number  in the " Phone Number " field
        myAccountPage.enterRegisterPhoneNumberField();

        //Click on the " Register " button to submit the form.
        myAccountPage.clickOnRegisterButton(getDriver());

        //Click on " Not right now " button to skip store configuration steps
        myAccountPage.skipStoreConfigurationSteps();

        //Verify that the vendor is redirected to the Dashboard page.
        String expectedMyDashboardPageTitle = "Dashboard";
        String actualMyDashboardTitle = dashboardPage.getMyDashboardTitle();
        Assert.assertEquals(actualMyDashboardTitle,expectedMyDashboardPageTitle);
        log.info("Successfully redirected to dashboard page");

        //click On Payment Methods
        dashboardPage.clickOnPaymentMethods(getDriver());

        //click On Add Payment Methods
        dashboardPage.clickOnAddPaymentMethods(getDriver());

        //enter Valid PayPal Email
        dashboardPage.enterValidPayPalEmail(getDriver());

        //click On Update Settings Button
        dashboardPage.clickOnUpdateSettingsButton(getDriver());

        //Verify that the information has been saved
        String expectedAlertMessage = "Your information has been saved successfully";
        String actualAlertMessage = dashboardPage.getPaymentMethodAlertSuccessMessage();
        Assert.assertEquals(actualAlertMessage,expectedAlertMessage);
        log.info("Your information has been saved successfully");
    }
}
