package com.scaledupit;

import finalProject.base.CommonAPI;
import finalProject.pages.scaledupit.AddItemPage;
import finalProject.pages.scaledupit.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddItemsTest extends CommonAPI {
    Logger log = LogManager.getLogger(AddItemsTest.class.getName());

    @Test
    public void AddItemPage () throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        AddItemPage addItemPage = new AddItemPage(getDriver());
        addItemPage.clickOnCategoryButton();
        homePage.clickOnMenCollection();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Men Collection – Automation");
        log.info("collection Men page title validation success");

        AddItemPage menCollectionPage  = new AddItemPage(getDriver());
        menCollectionPage.clickOnAddTieButton();
        menCollectionPage.clickOnCategoryButton();
        menCollectionPage.clickOnMusic();
        String title1 = getCurrentTitle();
        Assert.assertEquals(title1, "Music – Automation");
        log.info("music page title validation success");
        AddItemPage musicPage = new AddItemPage(getDriver());


    }

}


