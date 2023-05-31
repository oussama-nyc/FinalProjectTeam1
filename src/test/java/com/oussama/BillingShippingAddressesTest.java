package com.oussama;

import finalProject.base.CommonAPI;
import finalProject.pages.oussama.HeaderPage;
import finalProject.pages.oussama.MyAccountPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BillingShippingAddressesTest extends CommonAPI {
    Logger log = LogManager.getLogger(BillingShippingAddressesTest.class.getName());

    //------------------------------------------------------------------------------------------------------- --------
    // ***************( Test Case for Billing Shipping Addresses Update  )**************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @Test (enabled = true,priority = 1,groups = {"Sanity"})
    public void shippingAddresses() {
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        HeaderPage headerPage = new HeaderPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Click on the "My Account" button located at the top right corner of the website's header
        headerPage.clickOnMyAccountLink();

        //Enter a valid Email address in the " Email address " field. Under the Login form on the Left side
        myAccountPage.enterValidEmail();

        //Enter a valid Password in the " Password " field
        myAccountPage.enterValidPassword();

        //Click on the " Login " button to submit the form.
        myAccountPage.clickOnLoginButton(getDriver());

        //Click on "Addresses" Link
        myAccountPage.clickOnAddressesLink(getDriver());

        //Click on "Shipping Address Edit" Link
        myAccountPage.clickOnShippingAddressEditLink(getDriver());

        //Enter a valid Billing First name in the " First name " field
        myAccountPage.enterValidShippingFirstName(getDriver());

        //Enter a valid Shipping Last name in the " Last name " field
        myAccountPage.enterValidShippingLastName(getDriver());

        //Select a Shipping Country/Region from the " Country/Region  " field
        myAccountPage.selectShippingCountryRegion(getDriver());

        //Enter a valid Shipping Street address in the " Street address " field
        myAccountPage.enterValidShippingStreetAddress(getDriver());

        //Enter a valid Shipping Town/City in the " Town/City " field
        myAccountPage.enterValidShippingCity(getDriver());

        //Select a Shipping State from the "State/County" field
        myAccountPage.selectShippingState(getDriver());

        //Enter a valid Shipping ZIP Code in the ZIP Code field
        myAccountPage.enterValidShippingZIPCode(getDriver());

        //Click on Save Shipping Address Button
        myAccountPage.clickOnSaveAddressButton(getDriver());

        //Verify that the Address changed successfully.
        String expectedAlertText = "Address changed successfully.";
        String actualAlertText = myAccountPage.getAddressChangedAlertText(getDriver());
        Assert.assertEquals(actualAlertText,expectedAlertText);
        log.info("Address changed successfully.");
    }

    @Test (enabled = true,priority = 2,groups = {"Sanity"})
    public void billingAddresses() {
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        HeaderPage headerPage = new HeaderPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Click on the "My Account" button located at the top right corner of the website's header
        headerPage.clickOnMyAccountLink();

        //Enter a valid Email address in the " Email address " field. Under the Login form on the Left side
        myAccountPage.enterValidEmail();

        //Enter a valid Password in the " Password " field
        myAccountPage.enterValidPassword();

        //Click on the " Login " button to submit the form.
        myAccountPage.clickOnLoginButton(getDriver());

        //Click on "Addresses" Link
        myAccountPage.clickOnAddressesLink(getDriver());

        //Click on "Billing Address Edit" Link
        myAccountPage.clickOnBillingAddressEditLink(getDriver());

        //Enter a valid Billing First name in the " First name " field
        myAccountPage.enterValidBillingFirstName(getDriver());

        //Enter a valid Billing Last name in the " Last name " field
        myAccountPage.enterValidBillingLastName(getDriver());

        //Select a Billing Country/Region from the " Country/Region  " field
        myAccountPage.selectBillingCountryRegion(getDriver());

        //Enter a valid Billing Street address in the " Street address " field
        myAccountPage.enterValidBillingStreetAddress(getDriver());

        //Enter a valid Billing Town/City in the " Town/City " field
        myAccountPage.enterValidBillingCity(getDriver());

        //Select a Billing State from the "State/County" field
        myAccountPage.selectBillingState(getDriver());

        //Enter a valid Billing ZIP Code in the ZIP Code field
        myAccountPage.enterValidBillingZIPCode(getDriver());

        //Enter a valid Billing Phone in the Phone number field
        myAccountPage.enterValidBillingPhoneNumber(getDriver());

        //Enter a valid Billing Email in the " Email " field
        myAccountPage.enterValidBillingEmail(getDriver());

        //Click on Save Billing Address Button
        myAccountPage.clickOnSaveAddressButton(getDriver());

        //Verify that the Address changed successfully.
        String expectedAlertText = "Address changed successfully.";
        String actualAlertText = myAccountPage.getAddressChangedAlertText(getDriver());
        Assert.assertEquals(actualAlertText,expectedAlertText);
        log.info("Address changed successfully.");
    }
}
