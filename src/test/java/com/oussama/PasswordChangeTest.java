package com.oussama;

import finalProject.base.CommonAPI;
import finalProject.pages.oussama.HeaderPage;
import finalProject.pages.oussama.MyAccountPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PasswordChangeTest extends CommonAPI {
    Logger log = LogManager.getLogger(PasswordChangeTest.class.getName());

    //------------------------------------------------------------------------------------------------------- --------
    // ***************( Test Case for Password Change )**************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @Test  (enabled = true,groups = {"Smoke"})
    public void passwordChange() {
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

        //Click on "Account details" Link

        myAccountPage.clickOnAccountDetailsLink(getDriver());

        //Enter a Current Password in the " CurrentPassword " field
        myAccountPage.enterCurrentPassword(getDriver());

        //Enter a New Password in the " NewPassword " field
        myAccountPage.enterNewPassword(getDriver());

        //Confirm New Password in the " confirmNewPassword " field
        myAccountPage.confirmNewPassword(getDriver());

        //Click on the "Save Changes" button
        myAccountPage.clickOnSaveChangesButton(getDriver());

        //Verify that the details changed successfully
        String expectedAlertText = "Account details changed successfully.";
        String actualAlertText = myAccountPage.getAlertText(getDriver());
        Assert.assertEquals(actualAlertText,expectedAlertText);
        log.info("Account details changed successfully.");


    }
}