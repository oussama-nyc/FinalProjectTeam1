package com.oussama;

import finalProject.base.CommonAPI;
import finalProject.pages.oussama.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishListPageTest extends CommonAPI {
    Logger log = LogManager.getLogger(WishListPageTest.class.getName());

    //----------------------------------------------------------------------------------------------------------------
    // *************************************( Test Wish List Page For Logged In Users )*******************************
    // ---------------------------------------------------------------------------------------------------------------

    @Test
    public void wishListPageForLoggedInUsers() {
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        HeaderPage headerPage = new HeaderPage(getDriver());
        WishListPage wishListPage = new WishListPage(getDriver());
        ShopPage shopPage = new ShopPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Click on the "My Account" Link
        headerPage.clickOnMyAccountLink();

        //Enter a valid Email address in the " Email address " field.
        myAccountPage.enterValidEmailLoginCustomer();

        //Enter a valid Password in the " Password " field
        myAccountPage.enterValidPasswordLoginCustomer();

        // scrolled down the page
        scrollByAmount(0, 200);

        //Click on the " Login " button
        myAccountPage.clickOnLoginButton();

        //Verify that the customer is redirected to the My Account page.
        String expectedMyAccountPageTitle = "My Account";
        String actualMyAccountPageTitle = myAccountPage.getMyAccountTitle();
        Assert.assertEquals(actualMyAccountPageTitle, expectedMyAccountPageTitle);
        log.info("Successfully redirected to My Account page");

        //Click on the "Wishlist" icon
        headerPage.clickOnWishlistIcon();

        //Verify that the Wishlist page is empty
        String expectedWishListPageText = "No products added to the wishlist";
        String actualWishListPageText = wishListPage.getWishlistPageIsEmptyText();
        Assert.assertEquals(actualWishListPageText,expectedWishListPageText);


        //Click on the "Shop" Link
        headerPage.clickOnShopLink();

        //Choose a product from the shop, Click on the product to view its details.
        shopPage.clickOnTabletThinEliteBookRevolve();

        //Click on the "Add to wishlist" link to add it to the wishlist page.
        shopPage.clickOnAddToWishListPageLink();

        //Click on the "Shop" Link
        headerPage.clickOnShopLink();

        //Choose another product from the shop, Click on the product to view its details.
        shopPage.clickOnSmartphone6S128GBLTE();

        //Click on the "Add to wishlist" link to add it to the wishlist page.
        shopPage.clickOnAddToWishListPageLink();

        //Click on the "wishlist" icon go to the wishlist page.
        headerPage.clickOnWishlistIcon();

        // scrolled down the page
        scrollByAmount(0, 200);

        //Verify that the two products are displayed on the wishlist page.
        String expectedProduct1 = "Smartphone 6S 128GB LTE";
        String actualProduct1 = wishListPage.getSmartphoneLTEOnWishListTitle();
        Assert.assertEquals(actualProduct1,expectedProduct1);

        String expectedProduct2 = "Tablet Thin EliteBook Revolve 810 G6";
        String actualProduct2 = wishListPage.getTabletThinEliteBooOnWishListTitle();
        Assert.assertEquals(actualProduct2,expectedProduct2);

        //Remove the products from the wishlist page
        wishListPage.clickOnToRemoveProductFromTheWishListPage();

        //Verify that the 1st Product successfully removed
        String expectedRemovedProductText1 = "Product successfully removed.";
        String actualRemovedProductText1 = wishListPage.getProductRemovedAlertText();
        Assert.assertEquals(actualRemovedProductText1,expectedRemovedProductText1);

        waitFor(3);

        wishListPage.clickOnToRemoveSecondProductFromTheWishListPage();

        //Verify that the 2nd Product successfully removed
        String expectedRemovedProductText2 = "Product successfully removed.";
        String actualRemovedProductText2 = wishListPage.getProductRemovedAlertText();
        Assert.assertEquals(actualRemovedProductText2,expectedRemovedProductText2);

        //Verify that the wishlist page is empty
        String expectedWishListPageEmptyText = "No products added to the wishlist";
        String actualWishListPageEmptyText = wishListPage.getWishlistPageIsEmptyText();
        Assert.assertEquals(actualWishListPageEmptyText,expectedWishListPageEmptyText);

    }


    //----------------------------------------------------------------------------------------------------------------
    // ***********************************( Test Wish List Page For Guest Users )*************************************
    // ---------------------------------------------------------------------------------------------------------------

    @Test
    public void wishListPageForGuestUsers() {
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        HeaderPage headerPage = new HeaderPage(getDriver());
        ShopPage shopPage = new ShopPage(getDriver());
        WishListPage wishListPage = new WishListPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Click on the "Wishlist" icon
        headerPage.clickOnWishlistIcon();

        //Verify that the Wishlist page is empty
        String expectedWishListPageText = "No products added to the wishlist";
        String actualWishListPageText = wishListPage.getWishlistPageIsEmptyText();
        Assert.assertEquals(actualWishListPageText,expectedWishListPageText);

        //Click on the "Shop" Link
        headerPage.clickOnShopLink();

        //Choose a product from the shop, Click on the product to view its details.
        shopPage.clickOnTabletThinEliteBookRevolve();


        //Click on the "Add to wishlist" link to add it to the compare page.
        shopPage.clickOnAddToWishListPageLink();

        //Click on the "Shop" Link
        headerPage.clickOnShopLink();

        //Choose another product from the shop, Click on the product to view its details.
        shopPage.clickOnSmartphone6S128GBLTE();

        //Click on the "Add to wishlist" link to add it to the wishlist page.
        shopPage.clickOnAddToWishListPageLink();

        //Click on the "wishlist" icon go to the wishlist page.
        headerPage.clickOnWishlistIcon();

        // scrolled down the page
        scrollByAmount(0, 200);

        //Verify that the two products are displayed on the wishlist page.
        String expectedProduct1 = "Smartphone 6S 128GB LTE";
        String actualProduct1 = wishListPage.getSmartphoneLTEOnWishListTitle();
        Assert.assertEquals(actualProduct1,expectedProduct1);

        String expectedProduct2 = "Tablet Thin EliteBook Revolve 810 G6";
        String actualProduct2 = wishListPage.getTabletThinEliteBooOnWishListTitle();
        Assert.assertEquals(actualProduct2,expectedProduct2);

        //Remove the products from the wishlist page
        wishListPage.clickOnToRemoveProductFromTheWishListPage();

        //Verify that the 1st Product successfully removed
        String expectedRemovedProductText1 = "Product successfully removed.";
        String actualRemovedProductText1 = wishListPage.getProductRemovedAlertText();
        Assert.assertEquals(actualRemovedProductText1,expectedRemovedProductText1);

        waitFor(2);

        wishListPage.clickOnToRemoveSecondProductFromTheWishListPage();

        //Verify that the 1st Product successfully removed
        String expectedRemovedProductText2 = "Product successfully removed.";
        String actualRemovedProductText2 = wishListPage.getProductRemovedAlertText();
        Assert.assertEquals(actualRemovedProductText2,expectedRemovedProductText2);
        log.info("1st Product successfully removed");

        //Verify that the wishlist page is empty
        String expectedWishListPageEmptyText = "No products added to the wishlist";
        String actualWishListPageEmptyText = wishListPage.getWishlistPageIsEmptyText();
        Assert.assertEquals(actualWishListPageEmptyText,expectedWishListPageEmptyText);

    }

    //------------------------------------------------------------------------------------------------------- --------
    // ***************( Test Case For Adding Wishlist Items To The Cart )*********
    // ---------------------------------------------------------------------------------------------------------------

    @Test
    public void addingWishlistItemsToTheCart() {
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        HeaderPage headerPage = new HeaderPage(getDriver());
        ShopPage shopPage = new ShopPage(getDriver());
        WishListPage wishListPage = new WishListPage(getDriver());
        DashboardPage dashboardPage = new DashboardPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Click on the "My Account" Link
        headerPage.clickOnMyAccountLink();

        //Enter a valid Email address in the " Email address " field.
        myAccountPage.enterValidEmailLoginVendor();

        //Enter a valid Password in the " Password " field
        myAccountPage.enterValidPasswordLoginVendor();

        // scrolled down the page
        scrollByAmount(0, 200);

        //Click on the " Login " button
        myAccountPage.clickOnLoginButton();

        //Verify that the vendor is redirected to the Dashboard page.
        String expectedMyDashboardPageTitle = "Dashboard";
        String actualMyDashboardTitle = dashboardPage.getMyDashboardTitle();
        Assert.assertEquals(actualMyDashboardTitle,expectedMyDashboardPageTitle);
        log.info("Successfully redirected to dashboard page");

        //Click on the "Wishlist" icon
        headerPage.clickOnWishlistIcon();

        //Verify that the Wishlist page is empty
        String expectedWishListPageText = "No products added to the wishlist";
        String actualWishListPageText = wishListPage.getWishlistPageIsEmptyText();
        Assert.assertEquals(actualWishListPageText,expectedWishListPageText);

        //Click on the "Shop" Link
        headerPage.clickOnShopLink();

        //Choose a product from the shop, Click on the product to view its details.
        shopPage.clickOnTabletThinEliteBookRevolve();

        //Click on the "Add to wishlist" link to add it to the wishlist page.
        shopPage.clickOnAddToWishListPageLink();

        //Click on the "Shop" Link
        headerPage.clickOnShopLink();

        //Choose another product from the shop, Click on the product to view its details.
        shopPage.clickOnSmartphone6S128GBLTE();

        //Click on the "Add to wishlist" link to add it to the wishlist page.

        shopPage.clickOnAddToWishListPageLink();

        headerPage.clickOnWishlistIcon();

        // scrolled down the page
        scrollByAmount(0, 300);

         waitFor(2);

        //Verify that the two products are displayed on the wishlist page.
        String expectedProduct1 = "Smartphone 6S 128GB LTE";
        String actualProduct1 = wishListPage.getSmartphoneLTEOnWishListTitle();
        Assert.assertEquals(actualProduct1,expectedProduct1);

        String expectedProduct2 = "Tablet Thin EliteBook Revolve 810 G6";
        String actualProduct2 = wishListPage.getTabletThinEliteBooOnWishListTitle();
        Assert.assertEquals(actualProduct2,expectedProduct2);

        //Click on the "Add to Cart" link to add the product to the cart
        wishListPage.clickOnToAddToCartFromWishListPage();

        scrollByAmount(0,-400);

        String expectedCartText = "Product added to cart successfully";
        String actualCartText = wishListPage.getProductAddedToCartAlertText();
        Assert.assertEquals(actualCartText,expectedCartText);

    }

}
