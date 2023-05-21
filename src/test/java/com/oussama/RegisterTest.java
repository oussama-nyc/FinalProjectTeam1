package com.oussama;

import finalProject.pages.oussama.HeaderPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import finalProject.base.CommonAPI;
import finalProject.pages.oussama.DashboardPage;
import finalProject.pages.oussama.MyAccountPage;

public class RegisterTest extends CommonAPI {

    Logger log = LogManager.getLogger(RegisterTest.class.getName());

     //---------------------------------------------------------------------------------------------------------------
     //**************************************( Test case for registering as a customer )******************************
     // --------------------------------------------------------------------------------------------------------------
    @Test (priority = 1)
    public void RegisterAsCustomer()  {
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        HeaderPage headerPage = new HeaderPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Click on the "My Account" Link
        headerPage.clickOnMyAccountLink();

        //Enter a valid Email address in the " Email address " field.
        myAccountPage.enterRegisterEmailFieldFakeData();

        //Enter a valid Password in the " Password " field
        myAccountPage.enterRegisterPasswordFieldFakeData(getDriver());

        //Select I am a customer as the registration type.
        myAccountPage.selectRegisterCustomerOption();

        //Click on the " Register " button to submit the form.
        myAccountPage.clickOnRegisterButton(getDriver());

        //Verify that the customer is redirected to the My Account page.
        String expectedMyAccountPageTitle = "My Account";
        String actualMyAccountPageTitle = myAccountPage.getMyAccountTitle();
        Assert.assertEquals(actualMyAccountPageTitle,expectedMyAccountPageTitle);
        log.info("Successfully redirected to My Account page");
    }

     //---------------------------------------------------------------------------------------------------------------
     // ************************************( Test case for registering as a vendor )*********************************
     // --------------------------------------------------------------------------------------------------------------

    @Test (priority = 2)
   public void RegisterAsVendor()  {
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
        myAccountPage.selectRegisterVendorOption();

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
   }

}
