package com.scaledupit;

import finalProject.base.CommonAPI;
import finalProject.pages.scaledupit.CartPage;
import finalProject.pages.scaledupit.HomePage;
import finalProject.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class AddProductToCartTest extends CommonAPI {
    Logger log = LogManager.getLogger(AddProductToCartTest.class.getName());

    Properties prop = Utility.loadProperties();


    @Test (priority = 2)
    public void addProductToCart() {
        HomePage homePage = new HomePage(getDriver());
        CartPage cart =new CartPage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on shop button
        homePage.clickOnShopButton();
        log.info("click on shop button success");

        // click on bag collection
        cart.clickOnBagCollection();
        log.info("click on Bag collection  success");

        // click on add to cart
        cart.clickOnAddToCartButton();
        log.info("click on add to cart success");
        waitFor(3);

        // check 1 item has added to the cart
        String expectedCartCount = "1";
        String actualCartCount= cart.getCartCountText();
        Assert.assertEquals(expectedCartCount,actualCartCount);
        cart.clickOnCart();
        waitFor(3);
        log.info("1 item added to cart success");

    }
    @Test (priority = 1)
    public void addToCart() {
        HomePage homePage = new HomePage(getDriver());
        CartPage cart=new CartPage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // hover over on catefgories
        homePage.hoverOverOnCategoriesButton(getDriver());
        waitFor(3);

        // click on food and beverage
        homePage.hoverOverOnClothingButton(getDriver());
        waitFor(3);

        // click on hoddies
        homePage.clickOnHoddiesButton();
        waitFor(3);

        cart.clickOnPatientNinjaButton();
        waitFor(3);

        cart.clickOnAddToCartButton();
        waitFor(3);

        // check 1 item has added to the cart
        String expectedCartCount = "1";
        String actualCartCount= cart.getCartCountText();
        Assert.assertEquals(expectedCartCount,actualCartCount);
        cart.clickOnCart();
        waitFor(3);
        log.info("1 item added to cart success");
    }
}




