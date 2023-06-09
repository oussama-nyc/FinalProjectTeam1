package com.scaledupit;

import finalProject.base.CommonAPI;
import finalProject.pages.scaledupit.DeleteItemPage;
import finalProject.pages.scaledupit.HomePage;
import finalProject.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class DeleteItemTest extends CommonAPI {
    Logger log = LogManager.getLogger(DeleteItemTest.class.getName());

    Properties prop = Utility.loadProperties();

    @Test
    public void DeleteItem() {

        DeleteItemPage delete = new DeleteItemPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // user land to the browser
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);


        homePage.clickOnCartButton();
        waitFor(3);

        Assert.assertTrue(delete.checkPresenceOfCartHeaderText());
        String expectedCartPageHeader = "Cart";
        String actualCartPageHeader= delete.getCartPageHeaderText();
        Assert.assertEquals(expectedCartPageHeader, actualCartPageHeader);

        delete.clickOnReturnToShopBtn();
        waitFor(3);

        delete.clickOnBeltBtn();
        waitFor(3);

        delete.clickOnAddToCartButton();
        waitFor(3);

        // check 1 item has added to the cart
        String expectedCartCount = "1";
        String actualCartCount= delete.getCartCountText();
        Assert.assertEquals(expectedCartCount,actualCartCount);
        waitFor(3);
        log.info("1 item added to cart success");

        delete.clickOnCart();
        waitFor(3);

        delete.clickOnX();
        waitFor(3);

        delete.checkPresenceOfCartEmptyHeaderText();
        String expectedCartEmpty = "Your cart is currently empty.";
        String actualCartEmpty= delete.getCartEmptyPageHeaderText();
        Assert.assertEquals(expectedCartEmpty,actualCartEmpty);
        waitFor(3);
        log.info("1 item added to cart success");
    }
}


