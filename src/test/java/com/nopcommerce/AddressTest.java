package com.nopcommerce;

import com.github.javafaker.Faker;
import finalProject.base.CommonAPI;
import finalProject.pages.nopcommerce.*;
import finalProject.utility.ExcelReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.PipedReader;

public class AddressTest extends CommonAPI {
    Logger log = LogManager.getLogger(AddressTest.class.getName());

    String currentDir = System.getProperty("user.dir");
    String path = currentDir+ File.separator+"data"+File.separator+"oussama-data.xlsx";
    ExcelReader excelReader = new ExcelReader(path);
    Faker faker = new Faker();

    //String fristName = "ABU";
    String fristName =excelReader.getDataFromCell("oussama-data",7,1);
    //String lastName  = "YOUSUF";
    String lastName =excelReader.getDataFromCell("oussama-data",8,1);
    //String email  = "email2001@gmail.com";
    String email=  faker.internet().emailAddress();

    //String email =excelReader.getDataFromCell("oussama-data",6,1);
    //String company  = "US BANGLA CORP";
    String company =excelReader.getDataFromCell("oussama-data",9,1);
    //String password = "Admin1234";
    String password =excelReader.getDataFromCell("oussama-data",10,1);
    // String confirmPassword = "Admin1234";
    String confirmPassword =excelReader.getDataFromCell("oussama-data",11,1);
    @Test(priority = 1)

    public void addAddress(){
        String expectedTitle = "nopCommerce demo store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("Lended to right website successfully");

        HomePage homePage = new HomePage(getDriver());
        RegisterPage registerPage = new RegisterPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        FeaturePage featurePage =new FeaturePage(getDriver());
        AddressPage addressPage = new AddressPage(getDriver());
        scrollByAmount(0,3200);

        homePage.clickOnApplyForVendorAccount();
        registerPage.clickOnRegisterButtonOnTheLeft();


        //to register

        // process for registration
        scrollByAmount(0, 200);
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
        // captureScreenshot();
        registerPage.clickOnRegisterButton();

        loginPage.clickOnLoginLink();
        loginPage.typeUsername(email);
        waitFor(1);
        loginPage.typePassword(password);
        waitFor(1);
        scrollByAmount(0,100);
        loginPage.clickOnLoginButton();
        loginPage.clickOnMyAccountLink();
        loginPage.clickOnOrdersLink();
        // from here Account Address
        addressPage.clickOnAddressLink();
        addressPage.clickOnAddNewButton();
        addressPage.clickOnFirstNameField();
        addressPage.typeOnFirstNameField(fristName);
        addressPage.clickOnLastNameField();
        addressPage.typeOnLastNameField(lastName);
        addressPage.clickOnEmailNameField();
        addressPage.typeEmail(email);
        scrollByAmount(0,150);
        //addressPage.typeCountryName();
        addressPage.clickOnCountryOption();
        addressPage.clickOnBangladesh();
        waitFor(1);
        addressPage.clickOnCityFieldField();
        addressPage.typeOnCityNameField("Woodside");//Type City Name

        scrollByAmount(0,150);
        addressPage.clickOnAddressField();
        addressPage.typeOnAddressNameField("1000 wOODSIDE");//Type Address
        addressPage.clickOnZipCodeField();
        addressPage.typeOnZipCodeField("1212"); //Type ZipCode
        addressPage.clickOnPhoneNumberField();
        addressPage.typeOnPhoneNumberField("212-222-222");//Type PhoneNumber
        scrollByAmount(0,150);
        addressPage.clickOnSaveButton();

        // Address add validation
         String expectedText = "Delete";
        String actualText = addressPage.addAddressValidationText();
        Assert.assertEquals(expectedText,actualText);
        log.info("Address validation Success");

    }

    //Change Password
    @Test(priority = 2)
    public void passwordChange(){
//        String expectedTitle = "nopCommerce demo store";
//        String actualTitle = getCurrentTitle();
//        Assert.assertEquals(expectedTitle, actualTitle);
//        log.info("Lended to right website successfully");

        HomePage homePage = new HomePage(getDriver());
        RegisterPage registerPage = new RegisterPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        FeaturePage featurePage =new FeaturePage(getDriver());
        AddressPage addressPage = new AddressPage(getDriver());
        scrollByAmount(0,3200);

        homePage.clickOnApplyForVendorAccount();
        registerPage.clickOnRegisterButtonOnTheLeft();


        //to register

        // process for registration
        scrollByAmount(0, 200);
//        registerPage.typeFristName(fristName);
//        registerPage.typeLastName(lastName);
//        registerPage.typeDateOfBirthDay();
//        registerPage.typeDateOfBirthMonth();
//        registerPage.typeDateOfBirthYear();
//        registerPage.typeEmail(email);
//        scrollByAmount(0, 200);
//        registerPage.typeCompany(company);
//        scrollByAmount(0, 500);
//        registerPage.typePassword(password);
//        registerPage.typeConfirmPassword(confirmPassword);
//        // captureScreenshot();
//        registerPage.clickOnRegisterButton();

        loginPage.clickOnLoginLink();
        loginPage.typeUsername(email);
        waitFor(1);
        loginPage.typePassword(password);
        waitFor(1);
        scrollByAmount(0,100);
        loginPage.clickOnLoginButton();
        loginPage.clickOnMyAccountLink();
        loginPage.clickOnOrdersLink();
        // from here Account Address
        addressPage.clickOnAddressLink();
        scrollByAmount(0,100);
        addressPage.clickOnChangePasswordLink();
        addressPage.typeOldPassword(password);// old password
        addressPage.typeNewPassword("Admin12345");//new Password
        addressPage.typeConfirmNewPassword("Admin12345");//confirm password
        scrollByAmount(0,100);
        addressPage.clickOnChangePasswordButton();

        // Password Change validation
        String expectedText = "Password was changed";
        String actualText = addressPage.changePasswordValidationText();
        Assert.assertEquals(expectedText,actualText);
        log.info("Password Change validation Success");


    }

}
