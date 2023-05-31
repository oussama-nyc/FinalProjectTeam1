package com.oussama;

import finalProject.base.CommonAPI;
import finalProject.pages.oussama.HomePage;
import finalProject.pages.oussama.SingleProductPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageSliderTest extends CommonAPI {


    Logger log = LogManager.getLogger(HomePageSliderTest.class.getName());

    //---------------------------------------------------------------------------------------------------------------
    // ***********************************( Test case for Home Page Slider )**************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @Test (enabled = true,groups = {"Sanity"})
    public void homePageSlider() {
        HomePage homePage = new HomePage(getDriver());
        SingleProductPage singleProductPage = new SingleProductPage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Click On Second Slider
        homePage.clickOnSecondSlider(getDriver());

        //Click On Second Slider Button
        homePage.clickOnSecondSliderButton(getDriver());

        //Verify product title text
        String expectedSecondSliderProduct ="Wireless Audio System Multiroom 360";
        String actualSecondSliderProduct = singleProductPage.getSecondSliderProductTitle();
        Assert.assertEquals(actualSecondSliderProduct,expectedSecondSliderProduct);
        log.info("get product title text success");

        //Click On Home Page Logo
        homePage.clickOnHomePageLogo(getDriver());

        //Click On Third Slider
        homePage.clickOnThirdSlider(getDriver());

        //Click On Third Slider Button
        homePage.clickOnThirdSliderButton(getDriver());

        //Verify product title text
        String expectedThirdSliderProduct="Smartphone 6S 128GB LTE";
        String actualThirdSliderProduct = singleProductPage.getThirdSliderProductTitle();
        Assert.assertEquals(actualThirdSliderProduct,expectedThirdSliderProduct);
        log.info("get product title text success");

        //Click On Home Page Logo
        homePage.clickOnHomePageLogo(getDriver());
    }
}
