package com.nopcommerce;

import com.github.javafaker.Faker;
import finalProject.base.CommonAPI;
import finalProject.pages.nopcommerce.ElectronicsPage;
import finalProject.utility.ExcelReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.File;

public class ElectronicsTest extends CommonAPI {
    Logger log = LogManager.getLogger(ElectronicsTest.class.getName());
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

    @Test (priority = 1)
public void shopNokiaPhone(){

    ElectronicsPage electronicsPage = new ElectronicsPage(getDriver());

    electronicsPage.clickOnElectronicsLink();
    scrollByAmount(0,70);
    electronicsPage.clickOnCellPhoneLink();
    scrollByAmount(0,100);
    electronicsPage.clickOnNokiaLumiaLink();
    scrollByAmount(0,100);
    electronicsPage.clickOnNokiaPhoto();
    electronicsPage.clickOnCloseThePhotoXSign();
    electronicsPage.clickOnNokiaAddToCartButton();
    electronicsPage.clickOnNokiaAddToShoppingCart();
    scrollByAmount(0,150);
    electronicsPage.clickOnNokiaClickCheckBox();
    electronicsPage.clickOnNokiaClickOutButton();

}

}
