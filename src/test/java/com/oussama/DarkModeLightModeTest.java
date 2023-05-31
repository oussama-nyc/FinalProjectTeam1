package com.oussama;

import finalProject.base.CommonAPI;
import finalProject.pages.oussama.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;


public class DarkModeLightModeTest extends CommonAPI {
    Logger log = LogManager.getLogger(DarkModeLightModeTest.class.getName());

    //------------------------------------------------------------------------------------------------------- --------
    // ***************( Test Case for Dark Mode Light  )**************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @Test (enabled = true,groups = {"Smoke"})
    public void darkModeLightMode() {
        HomePage homePage = new HomePage(getDriver());

        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        waitFor(2);
        //Click on dark mode
        homePage.clickOnDarkModeButton();
        waitFor(2);

        // Validate dark mode
        String expectedDarkModeColor = "rgba(24, 24, 24, 1)";
        String actualDarkModeColor = homePage.getBackGroundCssValue();
        assertEquals(expectedDarkModeColor,actualDarkModeColor);
        log.info("Dark mode enabled successfully");

        //Click on light mode
        homePage.clickOnLightModeButton();
        waitFor(2);

        // Validate light mode
        String expectedLightModeColor = "rgba(255, 255, 255, 1)";
        String actualLightModeColor = homePage.getBackGroundCssValue();
        assertEquals(expectedLightModeColor,actualLightModeColor);
        log.info("Light mode enabled successfully");
    }

}
