package com.oussama;

import finalProject.base.CommonAPI;
import finalProject.pages.oussama.HeaderPage;
import finalProject.pages.oussama.ShopPage;
import finalProject.pages.oussama.SingleProductPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductReviewsAndRatingsTest extends CommonAPI {
    Logger log = LogManager.getLogger(ProductReviewsAndRatingsTest.class.getName());

    //----------------------------------------------------------------------------------------------------------------
    // ************************************( Test Product Reviews And Ratings )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @Test
    public void ProductReviewsAndRatings() {
        HeaderPage headerPage = new HeaderPage(getDriver());
        ShopPage shopPage = new ShopPage(getDriver());
        SingleProductPage singleProductPage = new SingleProductPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Click on the "Shop" link to go to the shop page.
        headerPage.clickOnShopLink();

        //Choose a product from the shop, Click on the product to view its details.
        shopPage.clickOnTabletThinEliteBookRevolve();

        //Click on tab review
        scrollByAmount(0,650);
        singleProductPage.clickOnTabReviews();

        //Select a star rating for the product from 1 to 5
        singleProductPage.clickOnFiveStar();

        //Fill up all the fields
        singleProductPage.typeYourDescription("Great product i like it ");
        singleProductPage.typeYourName("Oussama");
        singleProductPage.typeYourEmail("achournyc@hotmail.com");

        //click On add review button
        singleProductPage.clickOnAddReviewButton();

        // Verify that the success message "Your comment is awaiting approval" is displayed.
        String expectedText = "Your comment is awaiting approval";
        String actualText = singleProductPage.getConfirmationReviewText();
        Assert.assertEquals(actualText,expectedText);
    }
}