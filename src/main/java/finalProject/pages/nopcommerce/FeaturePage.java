package finalProject.pages.nopcommerce;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeaturePage extends CommonAPI {
    Logger log = LogManager.getLogger(RegisterPage.class.getName());

    public FeaturePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //--------------------------------------------------------------------------------
    // ****************************************( Locators )***************************
    // -------------------------------------------------------------------------------
    //wish List
    @FindBy(xpath = "//span[@class='wishlist-label']")
    WebElement wishList;
    // validation wish List
    @FindBy(xpath = "div[@class='no-data']")
    WebElement wishListValidation;

    //*******------------*******/////
    //Click on Shopping Cart
    @FindBy(xpath = "//span[@class='cart-label']")
    WebElement shoppingCart;

    //Shopping Cart Validation
    @FindBy(xpath = "//div[@class='no-data']")
    WebElement shoppingCartValidation;
    //*******------------*******/////

    //Contact Us
    //Click on Contact Us button
    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    WebElement clickOnContactUs;

    // full name field
    @FindBy(xpath = "//input[@id='FullName']")
    WebElement FullField;

    // email field
    @FindBy(xpath = "//input[@id='Email']")
    WebElement emailField;

    // type Text field
    @FindBy(xpath = "//textarea[@id='Enquiry']")
    WebElement typeTextField;

    // click on submit button
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement hitSubmitButton;

    // contact us validation
    @FindBy(xpath = "//div[@class='result']")
    WebElement contactUsValidation;

    //Vendor name Field
    @FindBy(xpath = "//input[@id='Name']")
    WebElement vendorNameField;

    //Vendor Email Field
    @FindBy(xpath = "//input[@id='Email']")
    WebElement vendorEmailField;

    //Vendor Description Field
    @FindBy(xpath = "//textarea[@id='Description']")
    WebElement vendorDescriptionField;

    //Vendor Description Field
    @FindBy(xpath = "//button[@id='apply-vendor']")
    WebElement vendorSubmitButton;

    //vendor Submission validation
    @FindBy(xpath = "//div[@class='result']")
    WebElement vendorSubmissionValidation;









    //--------------------------------------------------------------------------
// *********************************( Reusable Methods )**************************
// ------------------------------------------------------------------------------
    //wish List
    public void WishLink() {
        clickOn(wishList);
        log.info(" Click On Wish Link successfully.");
    }

    //wishListValidation
    public String  wishListValidationValidation() {
        String text = getElementText(wishListValidation);
        log.info("Cart Validation successfully.");
        return text;

    }

    //*******------------*******/////
    //Shopping Cart
    public void shoppingCart() {
        clickOn(shoppingCart);
        log.info(" Click on shopping Cart successfully.");
    }

    //Shopping Cart Validation
    public String shoppingCartValidation() {
        String text = getElementText(shoppingCartValidation);
        log.info(" shopping Cart validation successfully.");
        return text;


    }
    //*******------------*******/////

    //********Contact us Methods********

    //Click on Contact Us button
    public void clickOnContactUsButton() {
        clickOn(clickOnContactUs);
        log.info("Click on contact us button successfully");
    }

    //type FullName
    public void typeFullName(String fullName) {
        type(FullField, fullName);
        log.info("Type full Name successfully");
    }

    //type Email
    public void typeEmail(String email) {
        type(emailField, email);
        log.info("Type email successfully");
    }

    //type In TextField Box
    public void typeInTextFieldBox(String typeMessage) {
        type(typeTextField, typeMessage);
        log.info("Type Message successfully");
    }

    //click On Submit Button
    public void clickOnSubmitButton() {
        clickOn(hitSubmitButton);
        log.info("Click successfully");

    }

    // Contact Us validation
    public String contactUsValidation() {
        String text = getElementText(shoppingCartValidation);
        log.info(" shopping Cart validation successfully.");
        return text;
    }


    //Vendor name Field
    public void clickOnVendorNameField() {
        clickOn(vendorNameField);
        log.info("Click successfully");
    }
    //Type Vendor name  Field
    public void typeInVendorNameField(String typeName) {
        type(vendorNameField, typeName);
        log.info("Type Vendor Name successfully");
    }
    //Vendor Email Field
    public void clickOnVendorEmailField() {
        clickOn(vendorEmailField);
        log.info("Click successfully");
    }
    //Type Vendor Email Field
    public void typeInVendorEmailField(String typeEmail) {
        type(vendorEmailField, typeEmail);
        log.info("Type Vendor Email successfully");
    }
    //Vendor Description Field vendorDescriptionField

    public void clickOnVendorDescriptionField() {
        clickOn(vendorDescriptionField);
        log.info("Click successfully");
    }
    //Type Vendor Description Field
    public void typeInVendorDescriptionField(String typeDescription) {
        type(vendorDescriptionField, typeDescription);
        log.info("Type Vendor Description successfully");
    }
    //vendorSubmitButton
    public void clickOnVendorSubmitButton() {
        clickOn(vendorSubmitButton);
        log.info("Click Submit Button successfully");
    }
    //vendor Submission validation vendorSubmissionValidation
    public String vendorSubmissionValidationText() {
        String text = getElementText(vendorSubmissionValidation);
        log.info(" Vendor Submission validation successfully.");
        return text;
    }











}