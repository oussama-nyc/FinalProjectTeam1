package com.oussama;

import finalProject.base.CommonAPI;
import finalProject.pages.oussama.HeaderPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import finalProject.pages.oussama.StoreListingPage;
public class ContactStoreVendorTest extends CommonAPI {
    Logger log = LogManager.getLogger(ContactStoreVendorTest.class.getName());

    //----------------------------------------------------------------------------------------------------------------
    // ************************************( Test Contact Store Vendor )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @Test (enabled = true,groups = {"Integration"})
    public void ContactStoreVendor() {
        HeaderPage headerPage = new HeaderPage(getDriver());
        StoreListingPage storeListingPage = new StoreListingPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        headerPage.clickOnStoresLink();

        storeListingPage.clickOnFilterButton();

        //Enter the vendor store name in the search field and click the "Apply" button.
        storeListingPage.enterSearchTerm("Oussama Electronics Store");
        storeListingPage.clickOnApplyButton();

        storeListingPage.clickOnOussamaElectronicsStore(getDriver());

        // Fill out the message form with a valid name, email, and message content.
        // Click on the "Send Message" button to submit the message.
        storeListingPage.typeYourName("maryam",getDriver());
        storeListingPage.typeYourEmail("maryam@gmail.com");
        storeListingPage.typeYourMessage("Hey there, how i can track my order? ");
        storeListingPage.clickOnSendMessage();

        //Verify that a success message is displayed, confirming that the message was sent successfully.
        waitFor(1);
        String expectedText = "Email sent successfully!";
        String actualText = storeListingPage.getConfirmationTextAlert();
        Assert.assertEquals(actualText,expectedText);
    }

}
