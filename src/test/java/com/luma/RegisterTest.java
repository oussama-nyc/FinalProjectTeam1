package com.luma;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends CommonAPI {

    Logger log = LogManager.getLogger(RegisterTest.class.getName());

    @Test
    public void Login() throws InterruptedException {

        String expectedTitle = "Home Page";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //clickOn("...........");

        //type("...........", "............");
        //type("............", "............");
    }

}
