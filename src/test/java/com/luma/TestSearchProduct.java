package com.luma;

import finalProject.base.CommonAPI;
import finalProject.pages.luma.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSearchProduct extends CommonAPI {

    @Test
    public void testSearchExistingItem() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.searchItem("shirt");
        Assert.assertTrue(homePage.isVisibleResult());

    }

    @Test
    public void testSearchNoExistingItem() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.searchItem("iphone");
        Assert.assertTrue(homePage.getNoResultMsg().contains("Your search returned no results."));
    }
}
