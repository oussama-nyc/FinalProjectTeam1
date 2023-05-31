package com.oussama;

import finalProject.base.CommonAPI;
import finalProject.pages.oussama.ContactUsPage;
import finalProject.pages.oussama.HeaderPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends CommonAPI {

    Logger log = LogManager.getLogger(ContactUsTest.class.getName());

    //------------------------------------------------------------------------------------------------------- --------
    // ***************( Test case for Contact Us page )**************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @Test (enabled = true,groups = {"Sanity"})
    public void contactUs() {
        ContactUsPage contactUsPage = new ContactUsPage(getDriver());
        HeaderPage headerPage = new HeaderPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        // Navigate to the Contact Us page on the website
        headerPage.clickOnContactUsLink(getDriver());

        // Fill in the required fields in the contact form, including Name, Email, and Comment or Message.
        contactUsPage.enterFirstNameField("OUSSAMA");
        contactUsPage.enterLastNameField("ACHOUR");
        contactUsPage.enterEmailAddressFieldField("achournyc@hotmail.com",getDriver());
        contactUsPage.enterMessageField("I'm having trouble locating my order ID. Can you please resend it to me?");

        // Click on the "Send Message" button.
        contactUsPage.clickOnSubmitButton();

        // Confirmation
        String expectedAlertText = "Thanks for contacting us! We will be in touch with you shortly.";
        String actualAlertText = contactUsPage.getConfirmationAlertText();
        Assert.assertEquals(actualAlertText,expectedAlertText);
    }
}
