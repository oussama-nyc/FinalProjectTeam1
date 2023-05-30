package com.scaledupit;

import finalProject.base.CommonAPI;
import finalProject.pages.scaledupit.HomePage;
import finalProject.pages.scaledupit.ProductSearchPage;
import finalProject.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class ProductSearchTest extends CommonAPI {

    Logger log = LogManager.getLogger(ProductSearchTest.class.getName());

    Properties prop = Utility.loadProperties();


    @Test
    public void searchShoes() {
        ProductSearchPage ProductSearchPage = new ProductSearchPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on searchbar and type shoes , and click on search button
        homePage.typeItemToSearch("shoes");
        waitFor(3);

        homePage.clickOnSearchButton();
        waitFor(3);


        String expectedSearchPageHeader = "Search Results for: shoes";
        String actualSearchageHeader = ProductSearchPage.getSearchPageTitle();
        Assert.assertEquals(expectedSearchPageHeader, actualSearchageHeader);
        log.info("t-shirt  text validate ");
        waitFor(3);

    }

    @Test
    public void search() {
        ProductSearchPage productSearchPage = new ProductSearchPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on  and type T-shirt , and click on search button
        homePage.typeItemToSearch("T-shirt");



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




