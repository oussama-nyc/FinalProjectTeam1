package com.oussama;

import finalProject.base.CommonAPI;
import finalProject.pages.oussama.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateCartTest extends CommonAPI {

    Logger log = LogManager.getLogger(UpdateCartTest.class.getName());

    //---------------------------------------------------------------------------------------------------------------
    // ***********************************( Test case for Update Cart )**************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @Test (enabled = true,groups = {"Sanity"})
    public void UpdateCart() {
        HeaderPage headerPage = new HeaderPage(getDriver());
        ShopPage shopPage = new ShopPage(getDriver());
        SingleProductPage singleProductPage = new SingleProductPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Click on the "Shop" Link
        headerPage.clickOnShopLink(getDriver());

        //Choose a product from the shop, Click on the product to view its details.
        shopPage.clickOnTabletThinEliteBookRevolve();

        // Verify that the product is available and in stock.
        String expectedText = "Add to cart";
        String actualText = singleProductPage.getAddToCartButtonText();
        Assert.assertEquals(actualText,expectedText);
        log.info("The product is available and in stock.");

        // Choose the desired quantity of the product to be added to the cart
        singleProductPage.SelectProductQuantity(getDriver());

        // Click on the "Add to Cart" button to add the product to the cart.
        singleProductPage.clickOnAddProductToTheCart(getDriver());

        //Verify that the selected product added to your cart.
        String expectedAlertText = "View cart\n" +
                "3 × “Tablet Thin EliteBook Revolve 810 G6” have been added to your cart.";
        String actualAlertText = singleProductPage.getAddToCartAlertText();
        Assert.assertEquals(actualAlertText,expectedAlertText);
        log.info("Product successfully added to the cart with the desired quantity of 3.");

        //Click on the "View Cart" button to proceed to the cart page.
        singleProductPage.clickOnViewCartButton();

        //type Product Quantity
        cartPage.typeProductQuantity(getDriver());

        //click On Update Cart Button
        cartPage.clickOnUpdateCartButton(getDriver());

        //Verify that the cart successfully updated.
        String expectedAlertMessage="Cart updated.";
        String actualAlertMessage = cartPage.getAlertMessage(getDriver());
        Assert.assertEquals(actualAlertMessage,expectedAlertMessage);
        log.info("Cart successfully updated.");

    }
}
