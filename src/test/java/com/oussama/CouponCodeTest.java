package com.oussama;

import finalProject.base.CommonAPI;
import finalProject.pages.oussama.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CouponCodeTest extends CommonAPI {
    Logger log = LogManager.getLogger(CouponCodeTest.class.getName());

    //------------------------------------------------------------------------------------------------------- --------
    // ***************( Test Case for Coupon Code Functionality )**************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @Test
    public void couponCode() {
        HeaderPage headerPage = new HeaderPage(getDriver());
        ShopPage shopPage = new ShopPage(getDriver());
        SingleProductPage singleProductPage = new SingleProductPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Click on the "Shop" Link
        headerPage.clickOnShopLink();

        //Choose a product from the shop, Click on the product to view its details.
        shopPage.clickOnTabletThinEliteBookRevolve();

        // Verify that the product is available and in stock.
        String expectedText = "Add to cart";
        String actualText = singleProductPage.getAddToCartButtonText();
        Assert.assertEquals(actualText,expectedText);
        log.info("The product is available and in stock.");

        scrollByAmount(0,300);
        // Choose the desired quantity of the product to be added to the cart and
        singleProductPage.SelectProductQuantity();

        // Click on the "Add to Cart" button to add the product to the cart.
        singleProductPage.clickOnAddProductToTheCart();

        //Verify that the selected product added to your cart.
        String expectedAlertText = "View cart\n" +
                "3 × “Tablet Thin EliteBook Revolve 810 G6” have been added to your cart.";
        String actualAlertText = singleProductPage.getAddToCartAlertText();
        Assert.assertEquals(actualAlertText,expectedAlertText);
        log.info("Product successfully added to the cart with the desired quantity of 3.");

        //Click on the "View Cart" button to proceed to the cart page.
        singleProductPage.clickOnViewCartButton();

        //Verify that the coupon code field only accepts valid codes by entering an invalid code
        // and verifying the error message.
        cartPage.enterCouponCode("oussama80off");

        waitFor(2);

        String expectedInvalidAlert = "Coupon \"oussama80off\" does not exist!";
        String actualInvalidAlert = cartPage.getCouponAlertText();
        Assert.assertEquals(actualInvalidAlert,expectedInvalidAlert);
        log.info("Error message is displayed successfully");

        waitFor(2);

        //Verify that expired coupons cannot be used
        cartPage.enterCouponCode("oussama75off");

        waitFor(2);

        String expectedExpiredTextAlert = "This coupon has expired.";
        String actualExpiredTextAlert = cartPage.getCouponAlertText();
        Assert.assertEquals(actualExpiredTextAlert,expectedExpiredTextAlert);
        log.info("Error message is displayed successfully");

        waitFor(2);

       // Verify that valid coupon can be used
        cartPage.enterCouponCode("oussama50off");

        waitFor(2);

        String expectedValidTextAlert = "Coupon code applied successfully.";
        String actualValidTextAlert = cartPage.getCouponAppliedSuccessfullyText();
        Assert.assertEquals(actualValidTextAlert,expectedValidTextAlert);
        log.info("Coupon code applied successfully.");

        // Verify that specific coupons can only apply to specific products
        scrollByAmount(0,-200);
        headerPage.typeOnSearchBar("Apple MacBook Pro MF841HN/A 13-inch Laptop");
        headerPage.pressEnterOnSearchBar();
        scrollByAmount(0,300);
        singleProductPage.clickOnAddProductToTheCart();
        singleProductPage.clickOnViewCartButton();
        scrollByAmount(0,200);

        cartPage.enterCouponCode("MacBookPro30Off");

        waitFor(2);

        scrollByAmount(0,400);
        String expectedSpecificCouponsTextAlert = "Coupon: macbookpro30off";
        String actualSpecificCouponsTextAlert = cartPage.getSpecificProductsCouponText();
        Assert.assertEquals(actualSpecificCouponsTextAlert,expectedSpecificCouponsTextAlert);
        log.info("Coupon code MacBookPro30Off applied successfully.");
    }
}