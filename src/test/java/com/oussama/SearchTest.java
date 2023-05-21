package com.oussama;

import finalProject.base.CommonAPI;
import finalProject.pages.oussama.HeaderPage;
import finalProject.pages.oussama.SingleProductPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends CommonAPI {

    Logger log = LogManager.getLogger(SearchTest.class.getName());

    //---------------------------------------------------------------------------------------------------------------
    // ************************************( Test case for search feature )**************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @Test
    public void searchFeature() {
        HeaderPage headerPage = new HeaderPage(getDriver());
        SingleProductPage singleProductPage = new SingleProductPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Enter a valid search query in the search box.
        headerPage.typeOnSearchBar("Full Color LaserJet Pro M452dn",getDriver());

       // Click on the search button or press Enter.
        headerPage.pressEnterOnSearchBar();

       // Verify that the search results page is displayed and contains relevant results.
        String expectedResultsText = "Full Color LaserJet Pro M452dn";
        String actualResultsText = singleProductPage.getProductTitle();
        Assert.assertEquals(actualResultsText,expectedResultsText);
        log.info("The search results page is displayed and contains relevant results.");

       // Repeat the search with another query and verify the results.
        headerPage.typeOnSearchBar("Wireless Audio System Multiroom 360",getDriver());

        // Click on the search button or press Enter.
        headerPage.pressEnterOnSearchBar();

       // Verify that the search results page is displayed and contains relevant results.
        String expectedNewResultsText = "Wireless Audio System Multiroom 360";
        String actualNewResultsText = singleProductPage.getProductTitle();
        Assert.assertEquals(actualNewResultsText,expectedNewResultsText);
        log.info("The search results page displays relevant results for the new query entered.");

    }
}
