package com.nopcommerce;

import finalProject.base.CommonAPI;
import finalProject.pages.nopcommerce.*;
import finalProject.utility.ConnectDB;
import finalProject.utility.ExcelReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class ReviewTest extends CommonAPI {

    Logger log = LogManager.getLogger(RegisterTest.class.getName());
    ConnectDB connectDB = new ConnectDB();

   List<String> myEmail = connectDB.getTableColumnData("select * from abuyousuf_data;","email");
    String email= myEmail.get(0);
  //String email  = "email2001@gmail.com";
    String password = "Admin1234";
    String confirmPassword = "Admin1234";
   // String fristName="Abu";
   // String lastName= "yousuf";
    String company = "Hello";
    String title ="Delicate Blooms: A Review of the Flower Girl Bracelet";
    String currentDir = System.getProperty("user.dir");
    String path = currentDir+ File.separator+"data"+File.separator+"oussama-data.xlsx";
    ExcelReader excelReader = new ExcelReader(path);
   String reviewText =excelReader.getDataFromCell("oussama-data",16,1);
    @DataProvider(name = "review")
    public static Object[][] getData() {  Object[][] data = { { "ABU", "YOUSUF"},{ "RANA","AHMED" }} ;
        return data;     }

    @Test (dataProvider = "review")

    public void reviewTest(String firstName, String lastName ){
        HomePage homePage = new HomePage(getDriver());
        RegisterPage registerPage = new RegisterPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        CheckOutPage checkOutPage = new CheckOutPage(getDriver());
        ReviewPage reviewPage = new ReviewPage(getDriver());

        //to register
        homePage.clickOnRegisterLink();

        // process for registration
        scrollByAmount(0, 200);

        registerPage.clickOnRegisterLink();

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

        registerPage.clickOnRegisterButton();


        loginPage.clickOnLoginLink();
        loginPage.typeUsername(email);
        waitFor(1);
        loginPage.typePassword(password);
        waitFor(1);
        scrollByAmount(0,100);
        loginPage.clickOnLoginButton();
        checkOutPage.clickOnJewelry();

        scrollByAmount(0,500);
        reviewPage.clickOnFlowerGirlBracelet();
        scrollByAmount(0,150);
        reviewPage.clickOnAddYourReview();
        scrollByAmount(0,150);
        reviewPage.clickOnReviewTitleField();
        waitFor(1);
        reviewPage.typeOnReviewTitleField(title);
        reviewPage.clickOnReviewFieldText();
        reviewPage.typeOnReviewFieldText(reviewText);
        waitFor(1);
        reviewPage.clickOnSubmitReviewButton();
        waitFor(3);
         captureScreenshot();

        // Review Validation
        String expectedText="Product review is successfully added.";
        String actualText = reviewPage.reviewValidationValidationText();
        Assert.assertEquals(expectedText,actualText);
        log.info("Review validation Success");
    }
}
