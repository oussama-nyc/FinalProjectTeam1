package com.nopcommerce;

import finalProject.base.CommonAPI;
import finalProject.pages.nopcommerce.HomePage;
import finalProject.pages.nopcommerce.RegisterPage;
import finalProject.utility.ExcelReader;
import finalProject.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Properties;

public class RegisterTest extends CommonAPI {

    Logger log = LogManager.getLogger(RegisterTest.class.getName());


    //********** Data ******************
//    Properties prop = Utility.loadProperties();
//    String fristName = Utility.decode(prop.getProperty("fristName"));
//    String lastName  = Utility.decode(prop.getProperty("lastName"));
//    String email  = Utility.decode(prop.getProperty("email"));
//    String company  = Utility.decode(prop.getProperty("company"));
//    String password = Utility.decode(prop.getProperty("password"));
//    String confirmPassword = Utility.decode(prop.getProperty("confirmPassword"));



    String currentDir = System.getProperty("user.dir");
    String path = currentDir+ File.separator+"data"+File.separator+"oussama-data.xlsx";
    ExcelReader excelReader = new ExcelReader(path);

    String fristName = "ABU";
    String lastName  = "YOUSUF";
    //String email  = "email20011@gmail.com";
    String email =excelReader.getDataFromCell("oussama-data",6,1);
    String company  = "US BANGLA CORP";
    String password = "Admin1234";
    String confirmPassword = "Admin1234";
    @Test(priority = 1)
    public void registerTest() {
        String expectedTitle = "nopCommerce demo store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("Lended to right website successfully");

        HomePage homePage = new HomePage(getDriver());
        RegisterPage registerPage = new RegisterPage(getDriver());

        //to register
        homePage.clickOnRegisterLink();

        // process for registration
        scrollByAmount(0, 200);

        registerPage.clickOnRegisterLink();

        registerPage.typeFristName(fristName);

        registerPage.typeLastName(lastName);

        registerPage.typeDateOfBirthDay();

        registerPage.typeDateOfBirthMonth();

        registerPage.typeDateOfBirthYear();

        registerPage.typeEmail(email);

        scrollByAmount(0, 200);

        registerPage.typeCompany(company);

        scrollByAmount(0, 500);

        registerPage.typePassword(password);

        registerPage.typeConfirmPassword(confirmPassword);

        registerPage.clickOnRegisterButton();

        // registration validation
        String expectedText="Your registration completed";
        String actualText = registerPage.registrationValidationText();
        Assert.assertEquals(expectedText,actualText);



    }

    @Test(priority = 2)
    public void registerWithExistingEmail() {
        String expectedTitle = "nopCommerce demo store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("Lended to right website successfully");

        HomePage homePage = new HomePage(getDriver());
        RegisterPage registerPage = new RegisterPage(getDriver());

        //to register
        homePage.clickOnRegisterLink();

        // process for registration
        scrollByAmount(0, 200);

        registerPage.clickOnRegisterLink();

        registerPage.typeFristName(fristName);

        registerPage.typeLastName(lastName);

        registerPage.typeDateOfBirthDay();

        registerPage.typeDateOfBirthMonth();

        registerPage.typeDateOfBirthYear();

        scrollByAmount(0,100);

        registerPage.typeEmail(email);

        scrollByAmount(0, 200);

        registerPage.typeCompany(company);

        scrollByAmount(0, 500);

        registerPage.typePassword(password);
        registerPage.typeConfirmPassword(confirmPassword);
        registerPage.clickOnRegisterButton();

        // re registration validation
     String expectedresult = "The specified email already exists";
        String actualText = registerPage.reRegistrationValidationText();
        Assert.assertEquals(expectedresult,actualText);

    }
}