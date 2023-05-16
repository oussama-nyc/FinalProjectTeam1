package com.oussama;

import finalProject.base.CommonAPI;
import finalProject.pages.oussama.HeaderPage;
import finalProject.pages.oussama.MyAccountPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PasswordStrengthValidation extends CommonAPI {
    Logger log = LogManager.getLogger(PasswordStrengthValidation.class.getName());


//--------------------------------------------------------------------------------------------------------------------
//**************************************( Test case for password strength validation )********************************
// -------------------------------------------------------------------------------------------------------------------

    @Test
    public void passwordStrengthValidation()  {

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        HeaderPage headerPage = new HeaderPage(getDriver());

        headerPage.clickOnMyAccountLink();

        myAccountPage.enterRegisterEmailField("achour_nyc@hotmail.fr");

        //********************( Very weak )**************************

        scrollByAmount(0,300);

        myAccountPage.enterRegisterPasswordField("Qwerty");

        waitFor(2);

        //Verify that A message is displayed under the password field indicating that the password is Very weak
        String expectedDisplayedVeryWeakText = "Very weak - Please enter a stronger password.";
        String actualDisplayedVeryWeakText = myAccountPage.getShortPasswordStrengthAlertText();
        Assert.assertEquals(actualDisplayedVeryWeakText,expectedDisplayedVeryWeakText);

        //********************( Weak strength password )**************************

        //Clear RegPassword Field
        myAccountPage.clearRegPasswordField();

        myAccountPage.enterRegisterPasswordField("Qwerty&");

        waitFor(2);

        //Verify that A message is displayed under the password field indicating that the password is Weak
        String expectedDisplayedWeakText = "Weak - Please enter a stronger password.";
        String actualDisplayedWeakText = myAccountPage.getBadPasswordStrengthAlertText();
        Assert.assertEquals(actualDisplayedWeakText,expectedDisplayedWeakText);

        //********************( Medium strength password )**************************

        //Clear RegPassword Field
        myAccountPage.clearRegPasswordField();

        myAccountPage.enterRegisterPasswordField("Qwerty&1234567");
        waitFor(2);

        //Verify that A message is displayed under the password field indicating that the password is Medium
        String expectedDisplayedMediumText = "Medium";
        String actualDisplayedMediumText = myAccountPage.getGoodPasswordStrengthAlertText();
        Assert.assertEquals(actualDisplayedMediumText,expectedDisplayedMediumText);

        //********************( Strong strength password )**************************

        //Clear RegPassword Field
        myAccountPage.clearRegPasswordField();

        myAccountPage.enterRegisterPasswordField("Qwerty&1234567891011");

        waitFor(2);

        //Verify that A message is displayed under the password field indicating that the password is Strong
        String expectedDisplayedStrongText = "Strong";
        String actualDisplayedStrongText = myAccountPage.getStrongPasswordStrengthAlertText();
        Assert.assertEquals(actualDisplayedStrongText,expectedDisplayedStrongText);

    }
}
