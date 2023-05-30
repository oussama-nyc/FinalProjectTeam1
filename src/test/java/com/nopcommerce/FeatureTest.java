package com.nopcommerce;

import com.github.javafaker.Faker;
import finalProject.base.CommonAPI;
import finalProject.pages.nopcommerce.FeaturePage;
import finalProject.pages.nopcommerce.HomePage;
import finalProject.pages.nopcommerce.LoginPage;
import finalProject.pages.nopcommerce.RegisterPage;
import finalProject.utility.ExcelReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FeatureTest extends CommonAPI {
    String currentDir = System.getProperty("user.dir");
    String path = currentDir+ File.separator+"data"+File.separator+"oussama-data.xlsx";
    ExcelReader excelReader = new ExcelReader(path);
    Faker faker = new Faker();
   // String fullName ="ABU YOUSUF";
  String fullName =excelReader.getDataFromCell("oussama-data",12,1);
  String firstName =excelReader.getDataFromCell("oussama-data",7,1);
    String lastName =excelReader.getDataFromCell("oussama-data",8,1);
    String company =excelReader.getDataFromCell("oussama-data",9,1);
    String password =excelReader.getDataFromCell("oussama-data",10,1);
    String confirmPassword =excelReader.getDataFromCell("oussama-data",11,1);
    String message =excelReader.getDataFromCell("oussama-data",14,1);
    //String email =excelReader.getDataFromCell("oussama-data",13,1);
    String senderEmail =excelReader.getDataFromCell("oussama-data",21,1);
    String email=  faker.internet().emailAddress();
    //String email =excelReader.getDataFromCell("oussama-data",6,1);
    //String email= "abuyousuf@yahoo.com";
//    String message = "\"Please feel free to contact me \" +\n" +
//            "                \"via email at emai786@gmail.com or by phone \" +\n" +
//            "                \"at 212-222-2222 to discuss further  details or \" +\n" +
//            "                \"provide any necessary information.";

    Logger log = LogManager.getLogger(FeatureTest.class.getName());

    @Test(priority = 1)
    public void wishListTest(){
       //Wish list Test
        HomePage homePage = new HomePage(getDriver());
        RegisterPage registerPage = new RegisterPage(getDriver());
        FeaturePage featurePage = new FeaturePage(getDriver());

        featurePage.WishLink();

        // Wish list Test validation

    }
    @Test(priority = 2)
    public void shoppingCartTest(){
        HomePage homePage = new HomePage(getDriver());
        RegisterPage registerPage = new RegisterPage(getDriver());
        FeaturePage featurePage = new FeaturePage(getDriver());
        //Shopping cart Test
        featurePage.shoppingCart();

        //Shopping cart validation

    }
    @Test(priority = 3)
    public void contactUs(){
        HomePage homePage = new HomePage(getDriver());
        RegisterPage registerPage = new RegisterPage(getDriver());
        FeaturePage featurePage = new FeaturePage(getDriver());
        scrollByAmount(0, 300);
        featurePage.clickOnContactUsButton();
        scrollByAmount(0, 250);
        featurePage.typeFullName(fullName);
        featurePage.typeEmail(email);
        featurePage.typeInTextFieldBox(message);
        featurePage.clickOnSubmitButton();




    }
    @Test(priority = 4)
    // Apply for Vendor Account
    public void applyForVendorAccount() {
        String expectedTitle = "nopCommerce demo store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("Lended to right website successfully");

        HomePage homePage = new HomePage(getDriver());
        RegisterPage registerPage = new RegisterPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        FeaturePage featurePage =new FeaturePage(getDriver());
        scrollByAmount(0,3200);

        homePage.clickOnApplyForVendorAccount();
        registerPage.clickOnRegisterButtonOnTheLeft();

        //to register

        // process for registration
        scrollByAmount(0, 200);

        registerPage.typeFristName(firstName);

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
        scrollByAmount(0,150);
        homePage.clickOnApplyForVendorAccount();
        featurePage.clickOnVendorNameField();
        featurePage.typeInVendorNameField(fullName);
        featurePage.clickOnVendorEmailField();
        featurePage.typeInVendorEmailField("");
        featurePage.clickOnVendorDescriptionField();
        featurePage.typeInVendorDescriptionField(message);
        scrollByAmount(0,300);
        waitFor(1);
        featurePage.clickOnVendorSubmitButton();
        waitFor(1);


        // Vendor Submission validation
        String expectedText = "Your request has been submitted successfully. We'll contact you soon.";
        String actualText = registerPage.registrationValidationText();
        Assert.assertEquals(actualText, expectedText);
        log.info("Vendor Submission validation successfully.");
    }
    @Test(priority = 5)
    //subscribe Newsletter
    public void subscribeNewsletter(){
        FeaturePage featurePage = new FeaturePage(getDriver());

        scrollByAmount(0,3200);
        featurePage.typeEmailNewsletterSubscribeField(email);
        featurePage.clickOnSubscribeButton();

        // validation
        String expectedText = "Newsletter";
        String actualText = featurePage.subscribeNewsletterValidationText();
        Assert.assertEquals(actualText, expectedText);
        log.info("Subscribe Newsletter Validation successfully.");



    }
    //***********( Email a friend )***********
    @Test(priority = 6)
    public void emailAFried(){
        FeaturePage featurePage = new FeaturePage(getDriver());
        featurePage.clickOnDigitalDownloadsLink();
        scrollByAmount(0,150);
        featurePage.clickOnIfYouWaitDonationLink();
        scrollByAmount(0,150);
        featurePage.clickOnEmailAFriendLink();
        scrollByAmount(0,150);
        featurePage.typeFriendEmailField(email);
        featurePage.typeYourEmailAddressField(senderEmail);
        featurePage.typePersonalMessageField(message);
    }

    }
    

