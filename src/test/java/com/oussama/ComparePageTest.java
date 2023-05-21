package com.oussama;

import finalProject.base.CommonAPI;
import finalProject.pages.oussama.ComparePage;
import finalProject.pages.oussama.HeaderPage;
import finalProject.pages.oussama.MyAccountPage;
import finalProject.pages.oussama.ShopPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComparePageTest extends CommonAPI {
    Logger log = LogManager.getLogger(ComparePageTest.class.getName());

    //------------------------------------------------------------------------------------------------------- --------
    // ***************( Test case for Compare Page For Logged In Users )*********
    // ---------------------------------------------------------------------------------------------------------------

    @Test (priority = 1)
    public void comparePageForLoggedInUsers() {
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        HeaderPage headerPage = new HeaderPage(getDriver());
        ComparePage comparePage = new ComparePage(getDriver());
        ShopPage shopPage = new ShopPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Click on the "My Account" Link
        headerPage.clickOnMyAccountLink();

        //Enter a valid Email address in the " Email address " field
        myAccountPage.enterValidEmailLoginCustomer();

        //Enter a valid Password in the " Password " field
        myAccountPage.enterValidPasswordLoginCustomer();

        //Click on the " Login " button to submit the form.
        myAccountPage.clickOnLoginButton(getDriver());

        //Verify that the customer is redirected to the My Account page.
        String expectedMyAccountPageTitle = "My Account";
        String actualMyAccountPageTitle = myAccountPage.getMyAccountTitle();
        Assert.assertEquals(actualMyAccountPageTitle,expectedMyAccountPageTitle);
        log.info("Successfully redirected to My Account page");

        //Click on the "Compare" icon to open The Compare page
        headerPage.clickOnCompareIcon();

        //Verify that the Compare page is empty
        String expectedComparePageText = "No products were added to the compare table";
        String actualComparePageText = comparePage.getComparePageIsEmptyText();
        Assert.assertEquals(actualComparePageText,expectedComparePageText);

        //Click on the "Shop" Link
        headerPage.clickOnShopLink(getDriver());

        //Choose a product from the shop, Click on the product to view its details.
        shopPage.clickOnTabletThinEliteBookRevolve();

        //Click on the "Compare" link to add it to the compare page.
        shopPage.clickOnAddToComparePageLink();

        //Click on the "Shop" Link
        headerPage.clickOnShopLink(getDriver());

        //Choose another product from the shop, Click on the product to view its details.
        shopPage.clickOnSmartphone6S128GBLTE();

        //Click on the "Add to Compare" link to add it to the Compare page.
        shopPage.clickOnAddToComparePageLink();

        waitFor(2);

        //Click on the "Compare" icon to go to the Compare page.
        headerPage.clickOnCompareIcon();

        //Verify that the two products are displayed on the Compare page.
        String expectedProduct1 = "Tablet Thin EliteBook Revolve 810 G6";
        String actualProduct1 = comparePage.getTabletThinEliteBookRevolveTitle();
        Assert.assertEquals(actualProduct1,expectedProduct1);
        log.info("The 1st selected product are displayed on the Compare page Successfully");

        String expectedProduct2 = "Smartphone 6S 128GB LTE";
        String actualProduct2 = comparePage.getSmartPhoneLTETitle();
        Assert.assertEquals(actualProduct2,expectedProduct2);
        log.info("The 2nd selected product are displayed on the Compare page Successfully");

        //Remove the products from the Compare page
        comparePage.clickOnToRemoveProductFromTheComparePage(getDriver());

        waitFor(2);

        comparePage.clickOnToRemoveProductFromTheComparePage(getDriver());

        //Verify that the Compare page is empty
        String expectedEmptyComparePageText = "No products were added to the compare table";
        String actualEmptyComparePageText = comparePage.getComparePageIsEmptyText();
        Assert.assertEquals(actualEmptyComparePageText,expectedEmptyComparePageText);

   }

    //------------------------------------------------------------------------------------------------------- --------
    // ***************( Test case for Compare Page For Guest Users )*********
    // ---------------------------------------------------------------------------------------------------------------

    @Test (priority = 2)
    public void comparePageForGuestUsers() {
        HeaderPage headerPage = new HeaderPage(getDriver());
        ComparePage comparePage = new ComparePage(getDriver());
        ShopPage shopPage = new ShopPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Click on the "Compare" icon to open The Compare page
        headerPage.clickOnCompareIcon();

        //Verify that the Compare page is empty
        String expectedComparePageText = "No products were added to the compare table";
        String actualComparePageText = comparePage.getComparePageIsEmptyText();
        Assert.assertEquals(actualComparePageText,expectedComparePageText);

        //Click on the "Shop" Link
        headerPage.clickOnShopLink(getDriver());

        //Choose a product from the shop, Click on the product to view its details.
        shopPage.clickOnTabletThinEliteBookRevolve();

        //Click on the "Compare" link to add it to the compare page.
        shopPage.clickOnAddToComparePageLink();

        //Click on the "Shop" Link
        headerPage.clickOnShopLink(getDriver());

        //Choose another product from the shop, Click on the product to view its details.
        shopPage.clickOnSmartphone6S128GBLTE();

        //Click on the "Add to Compare" link to add it to the Compare page.
        shopPage.clickOnAddToComparePageLink();

        waitFor(2);

        //Click on the "Compare" icon to go to the Compare page.
        headerPage.clickOnCompareIcon();

        //Verify that the two products are displayed on the Compare page.
        String expectedProduct1 = "Tablet Thin EliteBook Revolve 810 G6";
        String actualProduct1 = comparePage.getTabletThinEliteBookRevolveTitle();
        Assert.assertEquals(actualProduct1,expectedProduct1);
        log.info("The 1st selected product are displayed on the Compare page Successfully");

        String expectedProduct2 = "Smartphone 6S 128GB LTE";
        String actualProduct2 = comparePage.getSmartPhoneLTETitle();
        Assert.assertEquals(actualProduct2,expectedProduct2);
        log.info("The 2nd selected product are displayed on the Compare page Successfully");

        //Remove the products from the Compare page
        comparePage.clickOnToRemoveProductFromTheComparePage(getDriver());

        waitFor(2);

        comparePage.clickOnToRemoveProductFromTheComparePage(getDriver());

        //Verify that the Compare page is empty
        String expectedEmptyComparePageText = "No products were added to the compare table";
        String actualEmptyComparePageText = comparePage.getComparePageIsEmptyText();
        Assert.assertEquals(actualEmptyComparePageText,expectedEmptyComparePageText);

    }

}
