package com.oussama;

import finalProject.base.CommonAPI;
import finalProject.pages.oussama.DashboardPage;
import finalProject.pages.oussama.HeaderPage;
import finalProject.pages.oussama.LostPasswordPage;
import finalProject.pages.oussama.MyAccountPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PasswordRecoveryTest extends CommonAPI {

    Logger log = LogManager.getLogger(PaymentMethodForVendorTest.class.getName());

    //---------------------------------------------------------------------------------------------------------------
    // ***********************************( Test case for Payment Method For Vendor  )**************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @Test  (enabled = true,groups = {"Sanity"})
    public void passwordRecovery() {
        HeaderPage headerPage = new HeaderPage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        LostPasswordPage lostPasswordPage = new LostPasswordPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Click on the "My Account" Link
        headerPage.clickOnMyAccountLink();

        //Click on "Lost your password?" Link
        myAccountPage.clickOnLostYourPasswordLink(getDriver());

        //enter invalid Email Address
        lostPasswordPage.enterUsernameOrEmailAddress(getDriver(),"amine-nyc@gmail.com");

        //Click On Rest Password Button
        lostPasswordPage.clickOnRestPasswordButton(getDriver());

        //Verify that the Invalid username or email alert displayed.
        String expectedErrorAlert ="Invalid username or email.";
        String actualErrorAlert = lostPasswordPage.getRestPasswordErrorAlertMessage(getDriver());
        Assert.assertEquals(actualErrorAlert,expectedErrorAlert);
        log.info("Successfully displayed Invalid username or email alert");

        captureScreenshot();

        //enter valid Email Address
        lostPasswordPage.enterUsernameOrEmailAddress(getDriver(),"oussama_nyc@hotmail.fr");

        //Click On Rest Password Button
        lostPasswordPage.clickOnRestPasswordButton(getDriver());

        //Verify that the Password reset email has been sent alert displayed.
        String expectedSuccessAlert ="Password reset email has been sent.";
        String actualSuccessAlert = lostPasswordPage.getSuccessAlertMessage(getDriver());
        Assert.assertEquals(actualSuccessAlert,expectedSuccessAlert);
        log.info("Successfully displayed Password reset email has been sent.");

        takeScreenshot("Password reset success Alert Message");

    }
}
