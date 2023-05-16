package com.oussama;

import finalProject.base.CommonAPI;
import finalProject.pages.oussama.HeaderPage;
import finalProject.pages.oussama.ShopPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterTest extends CommonAPI {


    Logger log = LogManager.getLogger(FilterTest.class.getName());

    //---------------------------------------------------------------------------------------------------------------
    // ***********************************( Test case for filter feature )**************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @Test
    public void filterFeature() {
        HeaderPage headerPage = new HeaderPage(getDriver());
        ShopPage shopPage = new ShopPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        // Click on the "Shop" button
        headerPage.clickOnShopLink();

        // Select the price range filter option
        scrollByAmount(0,1000);
        shopPage.moveSliderMinPrice(15,0);
        shopPage.moveSliderMaxPrice(-46,0);
        shopPage.clickOnFilterButton();

        // Verify that the products displayed on the page have been filtered according to the selected filter option
        scrollByAmount(0,400);
        shopPage.orderByPriceLowToHigh();

        scrollByAmount(0,600);
        String expectedAlertText = "Protection Plan for MacBook Air / 13 inch MacBook Pro";
        String actualAlertText = shopPage.getLowestProductTitleWithFilter();
        Assert.assertEquals(actualAlertText,expectedAlertText);
        log.info("The products displayed are filtered according to the price range set in the filter.");

        // Clear the selected filter option
        scrollByAmount(0,400);
        shopPage.moveSliderMinPrice(-40,0);
        shopPage.moveSliderMaxPrice(70,0);
        shopPage.clickOnFilterButton();

        // Verify that the products displayed on the page have been reset to the default view
        scrollByAmount(0,350);
        shopPage.orderByPriceLowToHigh();
        String expectedAlertText1 = "Magnetic Silicone Charging Holder for Magsafe Apple IPhone 13 Pro Mac Safe Wireless Charger Dock Station Stand";
        String actualAlertText1 = shopPage.getLowestProductTitleWithOutFilter();
        Assert.assertEquals(actualAlertText1,expectedAlertText1);

    }

}



