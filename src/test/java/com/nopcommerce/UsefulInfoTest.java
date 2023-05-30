package com.nopcommerce;

import finalProject.base.CommonAPI;
import finalProject.pages.nopcommerce.UsefulInfoPage;
import finalProject.utility.ExcelReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.File;

public class UsefulInfoTest extends CommonAPI {
    Logger log = LogManager.getLogger(UsefulInfoTest.class.getName());
    String title = "Delicate Blooms: A Review of the Flower Girl Bracelet";
    String currentDir = System.getProperty("user.dir");

    String path = currentDir + File.separator + "data" + File.separator + "oussama-data.xlsx";
    ExcelReader excelReader = new ExcelReader(path);
    String reviewText = excelReader.getDataFromCell("oussama-data", 16, 1);

    //*************Information**************
    //Sitemap
    @Test(priority = 1)
    public void sitemap() {
        UsefulInfoPage usefulInfoPage = new UsefulInfoPage(getDriver());

        usefulInfoPage.clickOnSitemap();
    }

    // Shipping & returns
    @Test(priority = 2)
    public void shippingAndReturns() {
        UsefulInfoPage usefulInfoPage = new UsefulInfoPage(getDriver());

        usefulInfoPage.clickOnShippingAndReturns();
    }

    //Privacy notice
    @Test(priority = 3)
    public void privacyNotice() {
        UsefulInfoPage usefulInfoPage = new UsefulInfoPage(getDriver());

        usefulInfoPage.clickOnPrivacyNotice();
    }

    //Conditions of Use conditionsOfUse
    @Test(priority = 4)
    public void conditionsOfUse() {
        UsefulInfoPage usefulInfoPage = new UsefulInfoPage(getDriver());

        usefulInfoPage.clickOnConditionsOfUse();
    }

    @Test(priority = 5)
    //About us
    public void aboutUs() {
        UsefulInfoPage usefulInfoPage = new UsefulInfoPage(getDriver());

        usefulInfoPage.clickOnAboutUs();
    }

    //Contact us contactUs
    @Test(priority = 6)
    public void contactUs() {
        UsefulInfoPage usefulInfoPage = new UsefulInfoPage(getDriver());

        usefulInfoPage.clickOnContactUs();

    }

    //****************Customer service*************
    //Search
    @Test(priority = 7)
    public void search() {
        UsefulInfoPage usefulInfoPage = new UsefulInfoPage(getDriver());

        usefulInfoPage.clickOnSearch();

    }


    //News
    @Test(priority = 8)
    public void news() {
        UsefulInfoPage usefulInfoPage = new UsefulInfoPage(getDriver());

        usefulInfoPage.clickOnNews();

    }

    //Blog
    @Test(priority = 9)
    public void blog() {
        UsefulInfoPage usefulInfoPage = new UsefulInfoPage(getDriver());

        usefulInfoPage.clickOnBlog();

    }


    //Recently viewed products
    @Test(priority = 10)
    public void recentlyViewedProducts() {
        UsefulInfoPage usefulInfoPage = new UsefulInfoPage(getDriver());

        usefulInfoPage.clickOnRecentlyViewedProducts();

    }


    //Compare products list
    @Test(priority = 11)
    public void compareProductsList() {
        UsefulInfoPage usefulInfoPage = new UsefulInfoPage(getDriver());

        usefulInfoPage.clickOnCompareProductsList();

    }

    //New products newProducts
    @Test(priority = 12)
    public void newProducts() {
        UsefulInfoPage usefulInfoPage = new UsefulInfoPage(getDriver());

        usefulInfoPage.clickOnNewProducts();

    }

    //*************My account*******************
    //My account myAccount
    @Test(priority = 13)
    public void myAccount() {
        UsefulInfoPage usefulInfoPage = new UsefulInfoPage(getDriver());

        usefulInfoPage.clickOnMyAccount();

    }

    //Orders
    @Test(priority = 14)
    public void orders() {
        UsefulInfoPage usefulInfoPage = new UsefulInfoPage(getDriver());

        usefulInfoPage.clickOnOrders();

    }

    //Addresses
    @Test(priority = 15)
    public void addresses() {
        UsefulInfoPage usefulInfoPage = new UsefulInfoPage(getDriver());

        usefulInfoPage.clickOnAddresses();

    }


    //Shopping cart
    @Test(priority = 16)
    public void shoppingCart() {
        UsefulInfoPage usefulInfoPage = new UsefulInfoPage(getDriver());

        usefulInfoPage.clickOnShoppingCart();

    }

    //Wishlist
    @Test(priority = 17)
    public void wishlist() {
        UsefulInfoPage usefulInfoPage = new UsefulInfoPage(getDriver());

        usefulInfoPage.clickOnWishlist();

    }

    @Test(priority = 18)
    //Apply for vendor account
    public void applyForVendorAccount() {
        UsefulInfoPage usefulInfoPage = new UsefulInfoPage(getDriver());

        usefulInfoPage.clickOnApplyForVendorAccount();

    }

    // *************New online store is open*****************
    @Test(priority = 19)
    public void newOnlineStoreIsOpen() {
        UsefulInfoPage usefulInfoPage = new UsefulInfoPage(getDriver());
        usefulInfoPage.clickOnNewOnlineStoreIsOpen();
        usefulInfoPage.typeOnTitleOnlineStoreIsOpenField(title);
        usefulInfoPage.typeOnCommentOnlineStoreIsOpenField(reviewText);
        usefulInfoPage.clickOnNewCommentOnlineStoreIsOpenButton();
    }

    // ************* nopCommerce new release! ***********
    @Test(priority = 20)
    public void NewRelease() {
        UsefulInfoPage usefulInfoPage = new UsefulInfoPage(getDriver());
        usefulInfoPage.clickOnNewRelease();
        usefulInfoPage.typeOnNewReleaseTitleField(title);
        usefulInfoPage.typeOnNewReleaseCommentField(reviewText);
        usefulInfoPage.clickOnNewReleaseCommentButton();

    }
    @Test(priority = 21)
    public void apple() {
        UsefulInfoPage usefulInfoPage = new UsefulInfoPage(getDriver());
        usefulInfoPage.clickOnBook();
        usefulInfoPage.clickOnApple();
    }
    @Test(priority = 22)
    public void hp() {
        UsefulInfoPage usefulInfoPage = new UsefulInfoPage(getDriver());
        usefulInfoPage.clickOnBook();
        usefulInfoPage.clickOnHp();
    }


}


