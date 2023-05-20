package com.nopcommerce;

import finalProject.base.CommonAPI;
import finalProject.pages.nopcommerce.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class CheckOutTest extends CommonAPI {
    Logger log = LogManager.getLogger(InvalidCredentialsTest.class.getName());
@Test(priority = 1)
    public void checkOut(){
       // HomePage homePage = new HomePage(getDriver());
       // RegisterPage registerPage = new RegisterPage(getDriver());
       // FeaturePage featurePage = new FeaturePage(getDriver());
        CheckOutPage checkOutPage = new CheckOutPage(getDriver());
        //LoginPage loginPage = new LoginPage(getDriver());
        checkOutPage.clickOnJewelry();
        scrollByAmount(0,150);
        checkOutPage.clickOnFlowerGirlBracelet();
        checkOutPage.clickOnAddToCart();
        scrollByAmount(0,200);
        checkOutPage.clickOnAgreeCheckBox();
        checkOutPage.clickOnCheckOut();
        checkOutPage.clickOnCheckOutAsAGuest();
    }
@Test(priority = 2)
    public void emptyCart(){
        CheckOutPage checkOutPage = new CheckOutPage(getDriver());

        checkOutPage.clickOnJewelry();
        scrollByAmount(0,150);
        checkOutPage.clickOnFlowerGirlBracelet();
        checkOutPage.clickOnAddToCart();
        checkOutPage.clickOnRemoveItem();


    }
        @Test(priority = 3)
    public void updateQuantity(){
        CheckOutPage checkOutPage = new CheckOutPage(getDriver());

        checkOutPage.clickOnJewelry();
        scrollByAmount(0,150);
        checkOutPage.clickOnFlowerGirlBracelet();
        checkOutPage.clickOnAddToCart();
        checkOutPage.clickOnUpdateQty();
        checkOutPage.typeQuantity("3");
        checkOutPage.clickOnUpdateButton();

        waitFor(1);
    }
}
