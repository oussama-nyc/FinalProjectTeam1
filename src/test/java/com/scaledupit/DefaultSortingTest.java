package com.scaledupit;


import finalProject.base.CommonAPI;
import finalProject.pages.scaledupit.DefaultSortingPage;
import finalProject.pages.scaledupit.HomePage;
import finalProject.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class DefaultSortingTest extends CommonAPI {
    Logger log = LogManager.getLogger(ProductSearchTest.class.getName());

    Properties prop = Utility.loadProperties();


    @Test
    public void clickOnMenCollection() {
        DefaultSortingPage defaultSortingPage = new DefaultSortingPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        homePage.clickOnMenCollection();
        waitFor(3);

      //  defaultSortingPage.selectOption();
     //   waitFor(3);

       // defaultSortingPage.addBeltToYourCart(getDriver());

      // waitFor(3);


    }

    @Test
    public void selectOption() {
        DefaultSortingPage defaultSortingPage = new DefaultSortingPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        homePage.clickOnMenCollection();
        waitFor(3);

        defaultSortingPage.selectOption();
        waitFor(3);

    }
    @Test
    public void addBeltToYourCart(){
        DefaultSortingPage defaultSortingPage = new DefaultSortingPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        homePage.clickOnMenCollection();
        waitFor(3);

        defaultSortingPage.selectOption();
        waitFor(3);


        defaultSortingPage.addBeltToYourCart(getDriver());
        waitFor(3);


    }
}



