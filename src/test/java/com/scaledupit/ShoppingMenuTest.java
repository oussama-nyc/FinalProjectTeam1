package com.scaledupit;

import finalProject.base.CommonAPI;
import finalProject.pages.scaledupit.HomePage;
import finalProject.pages.scaledupit.CouponsPage;
import finalProject.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class ShoppingMenuTest extends CommonAPI {
    Logger log = LogManager.getLogger(CouponsPage.class.getName());


    Properties prop = Utility.loadProperties();



        @Test
        public void addCouponsWithInvalidCoupons () {

            CouponsPage coupons = new CouponsPage(getDriver());
            HomePage homePage = new HomePage(getDriver());

            // user land to the browser
            String expectedTitle = "Automation – Automate eCommerce";
            String actualTitle = getCurrentTitle();
            Assert.assertEquals(expectedTitle, actualTitle);
            log.info("user landed successfully to the website ");
            waitFor(3);

            homePage.hoverOverOnCategoriesButton(getDriver());
            waitFor(3);

            homePage.clickOnFoodAndBeverageButton();
            waitFor(3);

            // check user if he landed to the food and beverage page
            Assert.assertTrue(coupons.checkFoodAndBeveragePageHeader());
            String expectedFoodAndBeveragePageHeader = "Food & Beverage";
            String actualFoodAndBeveragePageHeader = coupons.getFoodAndBeveragePageHeaderText();
            Assert.assertEquals(expectedFoodAndBeveragePageHeader, actualFoodAndBeveragePageHeader);
            log.info("Food and Beverage Page header text validate  success");


            coupons.clickOnNoodlesButton();
            waitFor(3);

            // check user if he landed to the Noodles page
            Assert.assertTrue(coupons.checkNoodlesPageHeader());
            String expectedFNoodlesPageHeader = "Noodles";
            String actualNoodlesPageHeader = coupons.getNoodlesPageHeaderText();
            Assert.assertEquals(expectedFNoodlesPageHeader, actualNoodlesPageHeader);
            log.info("Noodles Page header text validate  success");

            // click on add cart
            coupons.clickOnAddToCartButton();
            waitFor(3);

            // check 1 item is added to the cart
            Assert.assertTrue(coupons.checkCartCount());
            String expectedCartCount = "1";
            String actualCartCount = coupons.getCartCountText();
            Assert.assertEquals(expectedCartCount, actualCartCount);
            coupons.clickOnCart();
            waitFor(3);
            log.info("1 item added to cart success");

            // enter coupons
            coupons.enterCoupons("2345");
            waitFor(3);

            // click on apply coupons
            coupons.clickOnApplyCoupons();
            waitFor(3);

            // user get error message
            String expectedCouponsErrorMessage = "Coupon \"2345\" does not exist!";
            String actualCouponsErrorMessage = coupons.getErrorMessageHeaderText();
            Assert.assertEquals(expectedCouponsErrorMessage, actualCouponsErrorMessage);
            log.info("error message  text validate ");
            waitFor(3);

        }
        @Test
        public void applyCouponWithoutCoupon () {

            CouponsPage coupons = new CouponsPage(getDriver());
            HomePage homePage = new HomePage(getDriver());

            // user land to the browser
            String expectedTitle = "Automation – Automate eCommerce";
            String actualTitle = getCurrentTitle();
            Assert.assertEquals(expectedTitle, actualTitle);
            log.info("user landed successfully to the website ");
            waitFor(3);

            // hover over on catefgories
            homePage.hoverOverOnCategoriesButton(getDriver());
            waitFor(3);

            // click on food and beverage
            homePage.clickOnFoodAndBeverageButton();
            waitFor(3);

            // check user if he landed to the food and beverage page
            Assert.assertTrue(coupons.checkFoodAndBeveragePageHeader());
            String expectedFoodAndBeveragePageHeader = "Food & Beverage";
            String actualFoodAndBeveragePageHeader = coupons.getFoodAndBeveragePageHeaderText();
            Assert.assertEquals(expectedFoodAndBeveragePageHeader, actualFoodAndBeveragePageHeader);
            log.info("Food and Beverage Page header text validate  success");

            // click on pizza
            coupons.clickOnNoodlesButton();
            waitFor(3);

            // check user if he landed to the Noodles page
            Assert.assertTrue(coupons.checkNoodlesPageHeader());
            String expectedFNoodlesPageHeader = "Noodles";
            String actualNoodlesPageHeader = coupons.getNoodlesPageHeaderText();
            Assert.assertEquals(expectedFNoodlesPageHeader, actualNoodlesPageHeader);
            log.info("Pizza Page header text validate  success");

            // click on add cart
            coupons.clickOnAddToCartButton();
            waitFor(3);

            // check 1 item is added to the cart
            Assert.assertTrue(coupons.checkCartCount());
            String expectedCartCount = "1";
            String actualCartCount = coupons.getCartCountText();
            Assert.assertEquals(expectedCartCount, actualCartCount);
            coupons.clickOnCart();
            waitFor(3);
            log.info("1 item added to cart success");


            // click on apply coupons
            coupons.clickOnApplyCoupons();
            waitFor(3);

            // user get error message
            Assert.assertTrue(coupons.checkNoCouponsErrorMessageHeader());
            String expectedNoCouponsErrorMessage = "Please enter a coupon code.";
            String actualNoCouponsErrorMessage = coupons.getNoCouponsErrorMessageHeaderText();
            Assert.assertEquals(expectedNoCouponsErrorMessage, actualNoCouponsErrorMessage);
            log.info("No coupons error message  text validate ");
            waitFor(3);
            takeScreenshot("scalledupit final coupon test");

        }

    }


