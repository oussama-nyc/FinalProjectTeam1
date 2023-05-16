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

    @Test
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

        // Click on the store name in the search results to access the store page.
        scrollByAmount(0,500);
        storeListingPage.clickOnOussamaElectronicsStore();

        // Fill out the message form with a valid name, email, and message content.
        // Click on the "Send Message" button to submit the message.
        scrollByAmount(0,2000);

        storeListingPage.typeYourName("maryam");
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
