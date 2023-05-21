package com.oussama;

import finalProject.base.CommonAPI;
import finalProject.pages.oussama.HeaderPage;
import finalProject.pages.oussama.TrackYourOrderPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TrackYourOrderTest extends CommonAPI {
    Logger log = LogManager.getLogger(TrackYourOrderTest.class.getName());

    //------------------------------------------------------------------------------------------------------- --------
    // ***************( Test case for Track Your Order Feature )**************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @Test
    public void trackYourOrder() {
        HeaderPage headerPage = new HeaderPage(getDriver());
        TrackYourOrderPage trackYourOrderPage = new TrackYourOrderPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Click on the "Track Your Order" link to go to the Track Your Order page
         headerPage.clickOnTrackYourOrderLink();

        //Verify that the Order ID and Billing email fields are mandatory
        // by leaving them empty and clicking on the "Track" button.
        trackYourOrderPage.clickOnTrackButton(getDriver());

        String expectedTextAlert = "Please enter a valid order ID";
        String actualTextAlert = trackYourOrderPage.getAlertErrorText();
        Assert.assertEquals(actualTextAlert,expectedTextAlert);

        //  Verify that appropriate error messages are displayed when the user enters invalid input
        //  in either the Order ID or Billing email field .
        trackYourOrderPage.enterOrderID("5513");
        trackYourOrderPage.enterOrderEmail("guest@gmail.com");
        trackYourOrderPage.clickOnTrackButton(getDriver());

        String expectedInvalidAlert = "Sorry, the order could not be found. Please contact us if you are having difficulty finding your order details.";
        String actualInvalidAlert = trackYourOrderPage.getAlertErrorText();
        Assert.assertEquals(actualInvalidAlert,expectedInvalidAlert);

        //Verify that the order status is displayed correctly when the user enters valid input
        // in both the Order ID and Billing email fields.
        trackYourOrderPage.clearOrderIDField();
        trackYourOrderPage.clearOrderEmailField();
        trackYourOrderPage.enterOrderID("5573");
        trackYourOrderPage.enterOrderEmail("guest@gmail.com");
        trackYourOrderPage.clickOnTrackButton(getDriver());

        String expectedValidAlert = "Order details";
        String actualValidAlert = trackYourOrderPage.getOrderDetailsTitle();
        Assert.assertEquals(actualValidAlert,expectedValidAlert);

       //Verify that the user is able to track other orders by entering a new Order ID.
        headerPage.clickOnTrackYourOrderLink();
        trackYourOrderPage.enterOrderID("5572");
        trackYourOrderPage.enterOrderEmail("oussama_nyc@hotmail.fr");
        trackYourOrderPage.clickOnTrackButton(getDriver());

        String expectedText = "Order details";
        String actualText = trackYourOrderPage.getOrderDetailsTitle();
        Assert.assertEquals(actualText,expectedText);

    }
}
