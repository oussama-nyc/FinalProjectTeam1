package com.nopcommerce;

import com.github.javafaker.App;
import finalProject.base.CommonAPI;
import finalProject.pages.nopcommerce.ApparelPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApparelTest extends CommonAPI {
    Logger log = LogManager.getLogger(ApparelTest.class.getName());
        @Test (priority = 1)
    public void apparelShoes(){
        ApparelPage apparelPage = new ApparelPage(getDriver());
        apparelPage.clickOnApparelLink();
        apparelPage.clickOnShoesLink();
        scrollByAmount(0,150);
        apparelPage.clickOnRunner80sShoesLink();
        scrollByAmount(0,150);
        apparelPage.clickOnSelect80sShoesSizeLink();
        apparelPage.clickOnSelect80sShoesSize9();
        scrollByAmount(0,150);
        apparelPage.clickOnSelect80sRedColor();
        waitFor(1);
        apparelPage.clickOnSelect80sBlueColor();
        waitFor(1);
        apparelPage.clickOnSelect80sSilverColor();
        waitFor(1);
        apparelPage.clickOnRedShoesImage();
        waitFor(1);
        apparelPage.clickOnImageCloseXSign();

            // 80's running shoes validation
            String expectedResult = "$27.56";
            String actualText = apparelPage.runningShoes80sValidationText();
            Assert.assertEquals(expectedResult,actualText);
            log.info("Running Shoes 80s Validation success");


    }

}
