package com.oussama;

import finalProject.base.CommonAPI;
import finalProject.pages.oussama.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductGalleryTest extends CommonAPI {

    Logger log = LogManager.getLogger(ProductGalleryTest.class.getName());

    //---------------------------------------------------------------------------------------------------------------
    // ***********************************( Test case for Product Gallery )**************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @Test (enabled = true,groups = {"Integration"})
    public void productGallery() {
        HeaderPage headerPage = new HeaderPage(getDriver());
        ShopPage shopPage = new ShopPage(getDriver());
        SingleProductPage singleProductPage = new SingleProductPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Enter a valid search query in the search box.
        headerPage.typeOnSearchBar("Mac Book Charger 61W 87W 96W USB-C Power Adapter Compatible with Apple Laptop /Smartphones/Tablets",getDriver());

        // Click on the search button or press Enter.
        headerPage.pressEnterOnSearchBar();

        //Click On Product Gallery
        shopPage.clickOnProductGallery(getDriver());

        //Click On Next Product Picture
        shopPage.clickOnNextProductPicture(getDriver());

        //Verify that the next product picture displayed.
        String expectedProductPictureName ="H4b4cc31e5a204ff5b6906fef197ea0272.jpg_960x960";
        String actualProductPictureName = shopPage.getProductPictureName(getDriver());
        Assert.assertEquals(actualProductPictureName,expectedProductPictureName);
        log.info("Successfully displayed the next product picture");
    }
}
