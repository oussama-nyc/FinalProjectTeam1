package com.oussama;

import finalProject.base.CommonAPI;
import finalProject.pages.oussama.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpToNewsletterTest extends CommonAPI {

    Logger log = LogManager.getLogger(SignUpToNewsletterTest.class.getName());

    //---------------------------------------------------------------------------------------------------------------
    // ************************************( Test case for Sign Up To Newsletter )**************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @Test (enabled = true,groups = {"Smoke"})
    public void signUpToNewsletter() {
        HomePage homePage = new HomePage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        // Sign up for the newsletter with an invalid email.
        homePage.typeEmailAddress(getDriver(),"oussama_nyc@hotmail");
        homePage.clickOnSignUpButton(getDriver());

        //Verify that the error message is displayed successfully.
        waitFor(2);
        String expectedErrorAlertText = "Please enter a valid email address.";
        String actualErrorAlertText = homePage.getSignUpErrorAlertText(getDriver());
        Assert.assertEquals(actualErrorAlertText,expectedErrorAlertText);
        log.info("Error message display successfully.");

        // Sign up for the newsletter with a valid email.
        homePage.typeEmailAddress(getDriver(),"oussama_nyc@hotmail.fr");
        homePage.clickOnSignUpButton(getDriver());

        //Verify that the confirmation message is displayed successfully.
        waitFor(2);
        String expectedConfirmationMessage = "Thank You for Signing Up for Our Newsletter.";
        String actualConfirmationMessage = homePage.getConfirmationMessage(getDriver());
        Assert.assertEquals(actualConfirmationMessage,expectedConfirmationMessage);
        log.info("Confirmation message display successfully.");
    }
}
