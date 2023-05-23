package com.luma;

import finalProject.base.CommonAPI;
import finalProject.pages.luma.BagsPage;
import finalProject.pages.luma.Base;
import finalProject.pages.luma.CheckoutPage;
import finalProject.pages.luma.WatchesPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class CheckoutTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(CheckoutTest.class.getName());

    @Test
    public void purchaseItem() throws InterruptedException {
        Base base = new Base(getDriver());
        BagsPage bagsPage=new BagsPage(getDriver());
        WatchesPage watchesPage=new WatchesPage(getDriver());
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());

        base.clickOnBags(getDriver());
        String bagsPageTitle = getCurrentTitle();
        Assert.assertEquals(bagsPageTitle, "Bags - Gear");
        LOG.info("Bags page validation success");

        bagsPage.addMessengerBagToCart(getDriver());

        base.clickOnWatches(getDriver());
        watchesPage.addClamberWatchToCart(getDriver());
        String watchesPageTitle = getCurrentTitle();
        Assert.assertEquals(watchesPageTitle, "Watches - Gear");
        LOG.info("Watches page validation success");

        watchesPage.addClamberWatchToCart(getDriver());
        Thread.sleep(3000);

        base.clickOnCartIcon();
        base.clickOnCheckout();
        String checkoutTitle = getCurrentTitle();
        Assert.assertEquals(checkoutTitle,"Checkout");
        LOG.info("land on checkout page success");
        Thread.sleep(3000);

        LOG.info(checkoutPage.fakePhoneNumber());
        String email = checkoutPage.fakeEmailAddress();
        checkoutPage.inputEmailAddress(email);

        String firstName = checkoutPage.fakeFirstName();
        checkoutPage.inputFirstName(firstName);

        String lastName = checkoutPage.fakeLastName();
        checkoutPage.inputLastName(lastName);

        String address = checkoutPage.fakeAddress();
        checkoutPage.inputAddress(address);

        String city = checkoutPage.fakeCity();
        checkoutPage.inputCity(city);

        Random randomValue = new Random();
        checkoutPage.selectRegion(randomValue.nextInt(65));

        String zipcode = checkoutPage.fakeZipcode();
        checkoutPage.inputZipcode(zipcode);

        checkoutPage.selectCountry(randomValue.nextInt(65));

        String phoneNumber = checkoutPage.fakePhoneNumber();
        checkoutPage.inputPhoneNumber(phoneNumber);

        checkoutPage.selectFixedShippingMethod();

        checkoutPage.clickNextButton();

        Thread.sleep(3000);

        checkoutPage.clickPlaceOrderButton();
        String successfulPurchaseText = checkoutPage.getThankYouText();
        Assert.assertEquals(successfulPurchaseText,"Thank you for your purchase!");
        LOG.info("Purchase completed successfully");

    }

}
