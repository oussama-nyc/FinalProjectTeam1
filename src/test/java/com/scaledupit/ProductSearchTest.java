package com.scaledupit;

import finalProject.base.CommonAPI;
import finalProject.pages.nopcommerce.SearchPage;
import finalProject.pages.scaledupit.HomePage;
import finalProject.pages.scaledupit.ProductSearchPage;
import finalProject.utility.ExcelReader;
import finalProject.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Properties;

public class ProductSearchTest extends CommonAPI {

    Logger log = LogManager.getLogger(ProductSearchTest.class.getName());

    Properties prop = Utility.loadProperties();


    @Test
    public void searchConverse() {
        ProductSearchPage ProductSearchPage = new ProductSearchPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on searchbar and type converse , and click on search button
        homePage.typeItemToSearch("converse");
        waitFor(3);

        homePage.clickOnSearchButton();
        waitFor(3);

        // user is landed to the converse page
        String expectedSearchPageHeader = "Search Results for: converse";
        String actualSearchageHeader = ProductSearchPage.getSearchPageTitle();
        Assert.assertEquals(expectedSearchPageHeader, actualSearchageHeader);
        log.info("converse  page header text validate ");
        waitFor(3);

    }

    @Test
    public void searchHondaCar() {
        ProductSearchPage productSearchPage = new ProductSearchPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on  and type T-shirt , and click on search button
        homePage.typeItemToSearch("T-shirt");
        waitFor(3);

        homePage.clickOnSearchButton();
        waitFor(3);

        // get error message
        String expectedErrorMessage = "Sorry, but nothing matched your search terms. Please try again with some different keywords.";
        String actualErrorMessage = productSearchPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        log.info("error message  text validate ");
        waitFor(3);

    }

}




