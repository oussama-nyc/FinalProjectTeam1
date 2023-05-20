package com.nopcommerce;

import com.github.javafaker.Faker;
import finalProject.base.CommonAPI;
import finalProject.pages.nopcommerce.FeaturePage;
import finalProject.pages.nopcommerce.HomePage;
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

    String email=  faker.internet().emailAddress();
    //String email =excelReader.getDataFromCell("oussama-data",6,1);
    //String email= "abuyousuf@yahoo.com";
//    String message = "\"Please feel free to contact me \" +\n" +
//            "                \"via email at emai786@gmail.com or by phone \" +\n" +
//            "                \"at 212-222-2222 to discuss further  details or \" +\n" +
//            "                \"provide any necessary information.";
    String message =excelReader.getDataFromCell("oussama-data",14,1);
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





}
