package com.oussama;

import finalProject.base.CommonAPI;
import finalProject.pages.oussama.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends CommonAPI {


    Logger log = LogManager.getLogger(CheckoutTest.class.getName());

    //------------------------------------------------------------------------------------------------------- --------
    // ***************( Test case for Checkout For Logged In Users )**************************************************
    // ---------------------------------------------------------------------------------------------------------------


    @Test
    public void checkoutForLoggedInUsers() {
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        HeaderPage headerPage = new HeaderPage(getDriver());
        ShopPage shopPage = new ShopPage(getDriver());
        SingleProductPage singleProductPage = new SingleProductPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Click on the "My Account" button
        headerPage.clickOnMyAccountLink();

        //Enter a valid Email address
        myAccountPage.enterValidEmailLoginCustomer();

        //Enter a valid Password
        myAccountPage.enterValidPasswordLoginCustomer();

        // scrolled down the page
        scrollByAmount(0, 200);

        //Click on the " Login " button
        myAccountPage.clickOnLoginButton();

        //Verify that the customer is redirected to the My Account page.
        String expectedMyAccountPageTitle = "My Account";
        String actualMyAccountPageTitle = myAccountPage.getMyAccountTitle();
        Assert.assertEquals(actualMyAccountPageTitle,expectedMyAccountPageTitle);
        log.info("Successfully redirected to My Account page");

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
        // Choose the desired quantity of the product to be added to the cart
        singleProductPage.SelectProductQuantity();

        // Click on the "Add to Cart" button
        singleProductPage.clickOnAddProductToTheCart();

        //Verify that the selected product added to your cart.
        String expectedAlertText = "View cart\n" +
                "3 × “Tablet Thin EliteBook Revolve 810 G6” have been added to your cart.";
        String actualAlertText = singleProductPage.getAddToCartAlertText();
        Assert.assertEquals(actualAlertText,expectedAlertText);
        log.info("Product successfully added to the cart with the desired quantity of 3.");

        //Click on the "View Cart" button to proceed to the cart page.
        singleProductPage.clickOnViewCartButton();

        //Click on the "Proceed to Checkout" button to proceed to the checkout page.
        cartPage.clickOnProceedToCheckoutButton();

        //Enter a valid First name in the " First name " field
        checkoutPage.enterValidFirstName("oussama");

        //Enter a valid Last name in the " Last name " field
        checkoutPage.enterValidLastName("achour");

        scrollByAmount(0,400);
        //Select a Country/Region from the " Country/Region  " field
         //log.info("Successfully selected Country/Region");
        checkoutPage.selectCountryRegion("US");

        //Enter a valid Street
        checkoutPage.enterValidAddress("17 Bolton Rd","Apt 100x");

        //Enter a valid Town/City
        checkoutPage.enterValidTownCity("Bronx");

         scrollByAmount(0,400);

        //Select a State from the "State" field
        //log.info("Successfully selected State");
        checkoutPage.selectValidStateCounty("NY");


        //Enter a valid ZIP Code in the ZIP Code
        checkoutPage.enterValidZIPCode("10462");

        //Enter a valid Phone in the Phone number
        checkoutPage.enterValidPhoneNumber("1234567890");

        //Enter a valid email in the email
        checkoutPage.enterValidEmail("oussama_nyc@hotmail.fr");

        //Choose the payment method: "Check payments" or "Cash on delivery".
        checkoutPage.clickOnCashOnDeliveryOption();

        //Accept the terms and conditions by ticking the checkbox.
        checkoutPage.acceptTheTermsAndConditions();



        //Click on the "Place order" button.
        checkoutPage.clickOnPlaceOrderButton();

        //Verify that the order confirmation page is displayed and that the order details are correct.
        waitFor(2);
        String expectedOrderConfirmationText = "Order received";
        String actualOrderConfirmationText = checkoutPage.getOrderReceivedAlertText();
        Assert.assertEquals(actualOrderConfirmationText,expectedOrderConfirmationText);
        //log.info("The order is successfully confirmed.");

    }


    //---------------------------------------------------------------------------------------------------------------
    // ***************************( Test case for Checkout For Guest Users )****************************************
    // ---------------------------------------------------------------------------------------------------------------


  @Test
    public void checkoutForGuestUsers() {
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
      // Choose the desired quantity of the product to be added to the cart
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

      //Click on the "Proceed to Checkout" button to proceed to the checkout page.
      cartPage.clickOnProceedToCheckoutButton();

      //Enter a valid First name in the " First name " field
      checkoutPage.enterValidFirstName("Tom");

      //Enter a valid Last name in the " Last name " field
      checkoutPage.enterValidLastName("Jerry");

      scrollByAmount(0,400);

      //Select a Country/Region from the " Country/Region  " field
      checkoutPage.selectCountryRegion("GB");

      //Enter a valid Street address in the " Street address " field
      checkoutPage.enterValidAddress("4 Royal Oak Way North","Apt N");


      //Enter a valid Town/City in the " Town/City " field
      checkoutPage.enterValidTownCity("DAVENTRY");

      scrollByAmount(0,400);

      //Select a State from the "State/County" field
      checkoutPage.typeValidStateCounty("Northamptonshire");

      //Enter a valid ZIP Code in the ZIP Code field
      checkoutPage.enterValidZIPCode("NN11 8QL");


      //Enter a valid Phone in the Phone number field
      checkoutPage.enterValidPhoneNumber("1234567890");

      //Enter a valid Email in the " Email " field
      checkoutPage.enterValidEmail("guest@gmail.com");


      //Choose the payment method: "Check payments" or "Cash on delivery".
      checkoutPage.clickOnCashOnDeliveryOption();


      //Accept the terms and conditions by ticking the checkbox.
      checkoutPage.acceptTheTermsAndConditions();

      //Click on the "Place order" button.
      checkoutPage.clickOnPlaceOrderButton();

      //Verify that the order confirmation page is displayed and that the order details are correct.
      waitFor(2);
      String expectedOrderConfirmationText = "Order received";
      String actualOrderConfirmationText = checkoutPage.getOrderReceivedAlertText();
      Assert.assertEquals(actualOrderConfirmationText,expectedOrderConfirmationText);
      //log.info("The order is successfully confirmed.");


  }


}
