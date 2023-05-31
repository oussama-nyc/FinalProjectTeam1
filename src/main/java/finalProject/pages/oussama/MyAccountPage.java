package finalProject.pages.oussama;

import finalProject.base.CommonAPI;
import com.github.javafaker.Faker;
import finalProject.utility.ConnectDB;
import finalProject.utility.ExcelReader;
import finalProject.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.File;



public class MyAccountPage extends CommonAPI {

    Logger log = LogManager.getLogger(MyAccountPage.class.getName());


     public MyAccountPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Data From Excel )*******************************************************
    // ---------------------------------------------------------------------------------------------------------------

    String currentDir = System.getProperty("user.dir");
    String path = currentDir+File.separator+"data"+File.separator+"oussama-data.xlsx";
    ExcelReader excelReader = new ExcelReader(path);
    String loginEmailForCustomer = Utility.decode(excelReader.getDataFromCell("oussama-data",0,1));
    String loginPasswordForCustomer = Utility.decode(excelReader.getDataFromCell("oussama-data",1,1));
    String loginEmailForVendor = Utility.decode(excelReader.getDataFromCell("oussama-data",2,1));
    String loginPasswordForVendor = Utility.decode(excelReader.getDataFromCell("oussama-data",3,1));
    String loginEmailForVendor2 = Utility.decode(excelReader.getDataFromCell("oussama-data",4,1));
    String loginPasswordForVendor2 = Utility.decode(excelReader.getDataFromCell("oussama-data",5,1));

    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Data From Excel Password Change )*******************************************************
    // ---------------------------------------------------------------------------------------------------------------
    String loginEmail = Utility.decode(excelReader.getDataFromCell("PasswordChange",0,1));
    String loginPassword = Utility.decode(excelReader.getDataFromCell("PasswordChange",1,1));
    String newPassword = Utility.decode(excelReader.getDataFromCell("PasswordChange",2,1));

    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Data From Excel Edit Billing Address )*******************************************************
    // ---------------------------------------------------------------------------------------------------------------
    String billingFirstName = excelReader.getDataFromCell("Billing-Shipping-Addresses",1,1);
    String billingLastName = excelReader.getDataFromCell("Billing-Shipping-Addresses",2,1);
    String billingCountryCode = excelReader.getDataFromCell("Billing-Shipping-Addresses",3,1);
    String billingStreetAddress = excelReader.getDataFromCell("Billing-Shipping-Addresses",4,1);
    String billingCity = excelReader.getDataFromCell("Billing-Shipping-Addresses",6,1);
    String billingState = excelReader.getDataFromCell("Billing-Shipping-Addresses",7,1);
    String billingZIPCode = excelReader.getDataFromCell("Billing-Shipping-Addresses",8,1);
    String billingPhoneNumber = excelReader.getDataFromCell("Billing-Shipping-Addresses",9,1);
    String billingEmail = excelReader.getDataFromCell("Billing-Shipping-Addresses",10,1);

    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Data From Excel Edit Billing Address )*******************************************************
    // ---------------------------------------------------------------------------------------------------------------
    String shippingFirstName = excelReader.getDataFromCell("Billing-Shipping-Addresses",1,2);
    String shippingLastName = excelReader.getDataFromCell("Billing-Shipping-Addresses",2,2);
    String shippingCountryCode = excelReader.getDataFromCell("Billing-Shipping-Addresses",3,2);
    String shippingStreetAddress = excelReader.getDataFromCell("Billing-Shipping-Addresses",4,2);
    String shippingCity = excelReader.getDataFromCell("Billing-Shipping-Addresses",6,2);
    String shippingState = excelReader.getDataFromCell("Billing-Shipping-Addresses",7,2);
    String shippingZIPCode = excelReader.getDataFromCell("Billing-Shipping-Addresses",8,2);

    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Data From DB )*******************************************************
    // ---------------------------------------------------------------------------------------------------------------
    //ConnectDB connectDB = new ConnectDB();
    //List<String> customerEmail = connectDB.getTableColumnData("select * from oussama_data;","loginEmailForCustomer");
    //String loginEmailForCustomer = Utility.decode(customerEmail.get(0));
    //List<String> customerPassword = connectDB.getTableColumnData("select * from oussama_data;","loginPasswordForCustomer");
    //String loginPasswordForCustomer = Utility.decode(customerPassword.get(0));
    //List<String> vendorEmail = connectDB.getTableColumnData("select * from oussama_data;","loginEmailForVendor");
    //String loginEmailForVendor = Utility.decode(vendorEmail.get(0));
    //List<String> vendorPassword = connectDB.getTableColumnData("select * from oussama_data;","loginPasswordForVendor");
    //String loginPasswordForVendor = Utility.decode(vendorPassword.get(0));
    //List<String> vendor2Email = connectDB.getTableColumnData("select * from oussama_data;","loginEmailForVendor2");
    //String loginEmailForVendor2 = Utility.decode(vendor2Email.get(0));
    //List<String> vendor2Password = connectDB.getTableColumnData("select * from oussama_data;","loginPasswordForVendor2");
    //String loginPasswordForVendor2 = Utility.decode(vendor2Password.get(0));

    //---------------------------------------------------------------------------------------------------------------
    // ********************************************( Fake Data  )****************************************************
    // --------------------------------------------------------------------------------------------------------------

    Faker faker = new Faker();
    public String fakeEmailAddress() {
        return faker.internet().emailAddress();
    }
    public String fakePassword() {
        return faker.internet().password(14,16,true);
    }
    public String fakeShopName() {
        return faker.name().username();
    }
    public String fakeFirstName() {
        return faker.name().firstName();
    }
    public String fakeLastName() {
        return faker.name().lastName();
    }
    public String fakePhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Locators )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "//input[@type='email']")
    WebElement registerEmailField;

    @FindBy(xpath = "//input[@id='reg_password']")
    WebElement registerPasswordField;

    @FindBy(xpath = "//label[normalize-space()='I am a customer']")
    WebElement registerCustomerOption;

    @FindBy(xpath = "//label[normalize-space()='I am a vendor']")
    WebElement registerVendorOption;

    @FindBy(css = "#first-name")
    WebElement registerFirstNameField;

    @FindBy(css = "#last-name")
    WebElement registerLastNameField;

    @FindBy(css = "#company-name")
    WebElement registerShopNameField;

    @FindBy(xpath = "//input[@id='seller-url']")
    WebElement registerShopURLField;

    @FindBy(css = "#shop-phone")
    WebElement registerPhoneNumberField;

    @FindBy(css = "button[value='Register']")
    WebElement registerButton;

    @FindBy(css = "#username")
    WebElement loginEmailField;

    @FindBy(css = "#password")
    WebElement loginPasswordField;

    @FindBy(css = "button[value='Log in']")
    WebElement loginButton;

    @FindBy(xpath = "//a[normalize-space()='Not right now']")
    WebElement skipStoreConfigurationSteps;

    @FindBy(css = ".entry-title")
    WebElement MyAccountTitle;


    @FindBy(css = "#url-alart-mgs")
    WebElement TextDisplayedAboveTheShopURL;

    @FindBy(css = ".woocommerce-password-strength.short")
    WebElement shortPasswordStrengthAlertText ;

    @FindBy(css = ".woocommerce-password-strength.bad")
    WebElement badPasswordStrengthAlertText;

    @FindBy(css = ".woocommerce-password-strength.good")
    WebElement goodPasswordStrengthAlertText;

    @FindBy(css = ".woocommerce-password-strength.strong")
    WebElement strongPasswordStrengthAlertText;

    @FindBy(css = "li[class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--edit-account'] a")
    WebElement accountDetailsLink;

    @FindBy(css = "#password_current")
    WebElement currentPasswordField;

    @FindBy(css = "#password_1")
    WebElement newPasswordField;

    @FindBy(css = "#password_2")
    WebElement confirmNewPasswordField;

    @FindBy(css = "button[value='Save changes']")
    WebElement saveChangesButton;

    @FindBy(css = "div[role='alert']")
    WebElement alertText;

    @FindBy(xpath = "(//a[contains(text(),'Addresses')])[2]")
    WebElement addressesLink;

    @FindBy(xpath = "(//a[@class='edit'][normalize-space()='Edit'])[1]")
    WebElement billingAddressEditLink;

    @FindBy(xpath = "(//a[@class='edit'][normalize-space()='Edit'])[2]")
    WebElement shippingAddressEditLink;

    @FindBy(css = "#billing_first_name")
    WebElement billingFirstNameField;

    @FindBy(css = "#billing_last_name")
    WebElement billingLastNameField;

    @FindBy(css = "#billing_country")
    WebElement billingCountryField;

    @FindBy(css = "#billing_address_1")
    WebElement billingStreetAddressField;

    @FindBy(css = "#billing_city")
    WebElement billingCityField;

    @FindBy(css = "#billing_state")
    WebElement billingStateField;

    @FindBy(css = "#billing_postcode")
    WebElement billingZIPCodeField;

    @FindBy(css = "#billing_phone")
    WebElement billingPhoneNumberField;

    @FindBy(css = "#billing_email")
    WebElement billingEmailField;

    @FindBy(css = "button[value='Save address']")
    WebElement saveBillingAddressButton;

    @FindBy(css = "div[role='alert']")
    WebElement addressChangedAlertText;

    @FindBy(css = "#shipping_first_name")
    WebElement shippingFirstNameField;

    @FindBy(css = "#shipping_last_name")
    WebElement shippingLastNameField;

    @FindBy(css = "#shipping_country")
    WebElement shippingCountryField;

    @FindBy(css = "#shipping_address_1")
    WebElement shippingStreetAddressField;

    @FindBy(css = "#shipping_city")
    WebElement shippingCityField;

    @FindBy(css = "#shipping_state")
    WebElement shippingStateField;

    @FindBy(css = "#shipping_postcode")
    WebElement shippingZIPCodeField;

    @FindBy(xpath = "//a[normalize-space()='Lost your password?']")
    WebElement lostYourPasswordLink;

    //----------------------------------------------------------------------------------------------------------------
    // ****************************************( Reusable Methods )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    public void enterRegisterEmailFieldFakeData() {
       type(registerEmailField,fakeEmailAddress());
        log.info("Successfully entered email address");
    }

    public void enterRegisterPasswordFieldFakeData(WebDriver driver) {
        scrollToElement(registerPasswordField,driver);
        type(registerPasswordField,fakePassword());
        log.info("Successfully entered Password");
    }

    public void selectRegisterCustomerOption(WebDriver driver) {
        scrollToElement(registerCustomerOption,driver);
        waitFor(1);
        clickOn(registerCustomerOption);
        log.info("The I am a customer registration type is selected Successfully");
    }

    public void selectRegisterVendorOption(WebDriver driver) {
        scrollToElement(registerVendorOption, driver);
        waitFor(1);
        clickOn(registerVendorOption);
        log.info("The I am a customer registration type is selected Successfully");
    }

    public void clickOnRegisterButton( WebDriver driver) {
        scrollToElement(registerButton,driver);
        waitFor(1);
        clickOn(registerButton);
        log.info("Successfully clicked on Register Button");
        waitFor(1);
    }

    public void enterRegisterFirstNameField() {
        type(registerFirstNameField,fakeFirstName());
        log.info("Successfully entered First Name");
    }

    public void enterRegisterLastNameField() {
        type(registerLastNameField,fakeLastName());
        log.info("Successfully entered Last Name");
    }

    public void enterRegisterShopNameField(WebDriver driver) {
        scrollToElement(registerShopNameField,driver);
        type(registerShopNameField,fakeShopName());
        log.info("Successfully entered Last Name");
    }

    public void enterRegisterShopURLField(String URL) {
        type(registerShopURLField,URL);
        log.info("Successfully entered Last Name");
    }

    public void enterRegisterPhoneNumberField() {
        type(registerPhoneNumberField,fakePhoneNumber());
        log.info("Successfully entered Phone Number");
    }

    public void skipStoreConfigurationSteps() {
        clickOn(skipStoreConfigurationSteps);
        log.info("Successfully clicked on Not right now button");
    }

    public void clickInsideTheShopURLField(WebDriver driver) {
        scrollToElement(registerShopURLField,driver);
        waitFor(1);
        clickOn(registerShopURLField);
        log.info("The Shop URL field is automatically populated with The same data entered in Shop Name ");
    }
    public void clickInsideTheShopNameField(WebDriver driver) {
        scrollToElement(registerShopNameField,driver);
        waitFor(1);
        clickOn(registerShopNameField);
        log.info("Successfully clicked in side  Shop Name field");
        waitFor(2);
    }

    //Enter a valid Email address in the " Email address " field. Under the Login form on the Left side

    public void enterValidEmailLoginVendor() {
        type(loginEmailField,loginEmailForVendor);
        log.info("Successfully entered email address");
    }

    public void enterValidPasswordLoginVendor() {
        type(loginPasswordField,loginPasswordForVendor);
        log.info("Successfully entered Password");
    }
    public void enterValidEmailLoginVendor2() {
        type(loginEmailField,loginEmailForVendor2);
        log.info("Successfully entered email address");
    }

    public void enterValidPasswordLoginVendor2() {
        type(loginPasswordField,loginPasswordForVendor2);
        log.info("Successfully entered Password");
    }

    public void enterValidEmailLoginCustomer() {
        type(loginEmailField,loginEmailForCustomer);
        log.info("Successfully entered email address");
    }
    public void enterValidPasswordLoginCustomer() {
        type(loginPasswordField,loginPasswordForCustomer);
        log.info("Successfully entered Password");
    }
    public void clickOnLoginButton(WebDriver driver) {
        scrollToElement(loginButton,driver);
        waitFor(1);
        clickOn(loginButton);
        log.info("Successfully clicked on Login button");
    }

    public String getMyAccountTitle() {
        String text = getElementText(MyAccountTitle);
        log.info("get error message text success");
        return text;
    }
    public String getTextDisplayedAboveTheShopURL() {
        String text = getElementText(TextDisplayedAboveTheShopURL);
        log.info("get error message text success");
        return text;
    }

    public void enterRegisterEmailField(String regEmailAddress ) {
        type(registerEmailField,regEmailAddress);
        log.info("Successfully entered email address");
    }

    public void enterRegisterPasswordField(String regPassword,WebDriver driver) {
        scrollToElement(registerPasswordField,driver);
        waitFor(1);
        type(registerPasswordField,regPassword);
        log.info("Successfully entered Password");
    }

    public void clearRegPasswordField() {
        clear(registerPasswordField);
        log.info("Successfully cleared Reg Password Field");
    }

    public String getShortPasswordStrengthAlertText(WebDriver driver) {
        scrollToElement(shortPasswordStrengthAlertText,driver);
        waitFor(1);
       String text =  getElementText(shortPasswordStrengthAlertText);
        log.info("A message displayed under the password field indicating that the password is very weak");
       return text;
    }
    public String getBadPasswordStrengthAlertText(WebDriver driver) {
        scrollToElement(badPasswordStrengthAlertText,driver);
       waitFor(1);
        String text = getElementText(badPasswordStrengthAlertText);
        log.info("A message displayed under the password field indicating that the password is weak");
        return text;
    }
    public String getGoodPasswordStrengthAlertText(WebDriver driver) {
        scrollToElement(goodPasswordStrengthAlertText,driver);
        waitFor(1);
        String text = getElementText(goodPasswordStrengthAlertText);
        log.info("A message displayed under the password field indicating that the password is Medium");
        return text;
    }
    public String getStrongPasswordStrengthAlertText(WebDriver driver) {
        scrollToElement(strongPasswordStrengthAlertText,driver);
        waitFor(1);
      String text =  getElementText(strongPasswordStrengthAlertText);
        log.info("A message displayed under the password field indicating that the password is Strong");
      return text;
    }


    public void enterValidEmail() {
        type(loginEmailField,loginEmail);
        log.info("Successfully entered email address");
    }

    public void enterValidPassword() {
        type(loginPasswordField,loginPassword);
        log.info("Successfully entered Password");
    }

    public void clickOnAccountDetailsLink(WebDriver driver) {
        scrollToElement(accountDetailsLink,driver);
        waitFor(1);
        clickOn(accountDetailsLink);
        log.info("Successfully clicked on account details link");
    }

    public void enterCurrentPassword(WebDriver driver ) {
        scrollToElement(currentPasswordField,driver);
        clear(currentPasswordField);
        waitFor(1);
        type(currentPasswordField,loginPassword);
        log.info("Successfully entered current password");
    }

    public void enterNewPassword(WebDriver driver ) {
        scrollToElement(newPasswordField,driver);
        clear(newPasswordField);
        waitFor(1);
        type(newPasswordField,newPassword);
        log.info("Successfully entered new passwords");
    }

    public void confirmNewPassword(WebDriver driver ) {
        scrollToElement(confirmNewPasswordField,driver);
        clear(confirmNewPasswordField);
        waitFor(1);
        type(confirmNewPasswordField,newPassword);
        log.info("Successfully confirmed new password");
    }

    public void clickOnSaveChangesButton(WebDriver driver) {
        scrollToElement(saveChangesButton,driver);
        waitFor(1);
        clickOn(saveChangesButton);
        log.info("Successfully clicked on account save changes button");
    }

    public String getAlertText(WebDriver driver){
        scrollToElement(alertText,driver);
        waitFor(1);
        String AlertText =  getElementText(alertText);
        return AlertText;
    }

    public void clickOnAddressesLink(WebDriver driver) {
        scrollToElement(addressesLink,driver);
        waitFor(1);
        clickOn(addressesLink);
        log.info("Successfully clicked on addressesLink link");
    }

    public void clickOnBillingAddressEditLink(WebDriver driver) {
        scrollToElement(billingAddressEditLink,driver);
        waitFor(1);
        clickOn(billingAddressEditLink);
        log.info("Successfully clicked on billing address edit Link ");
    }

    public void enterValidBillingFirstName(WebDriver driver) {
        scrollToElement(billingFirstNameField,driver);
        waitFor(1);
        clear(billingFirstNameField);
        type(billingFirstNameField,billingFirstName);
        log.info("Successfully entered billing first name");
    }

    public void enterValidBillingLastName(WebDriver driver) {
        scrollToElement(billingLastNameField,driver);
        waitFor(1);
        clear(billingLastNameField);
        type(billingLastNameField,billingLastName);
        log.info("Successfully entered billing first name");
    }

    public void selectBillingCountryRegion(WebDriver driver) {
        scrollToElement(billingCountryField,driver);
        waitFor(1);
        selectOptionFromDropDown(billingCountryField,billingCountryCode);
        log.info("Successfully selected Country/Region");
    }

    public void enterValidBillingStreetAddress(WebDriver driver) {
        scrollToElement(billingStreetAddressField,driver);
        waitFor(1);
        clear(billingStreetAddressField);
        type(billingStreetAddressField,billingStreetAddress);
        log.info("Successfully entered billing street address");
    }

    public void enterValidBillingCity(WebDriver driver) {
        scrollToElement(billingCityField,driver);
        waitFor(1);
        clear(billingCityField);
        type(billingCityField,billingCity);
        log.info("Successfully selected billing city");
    }
    public void selectBillingState(WebDriver driver) {
        scrollToElement(billingStateField,driver);
        waitFor(1);
        selectOptionFromDropDown(billingStateField,billingState);
        log.info("Successfully selected billing State");
    }

    public void enterValidBillingZIPCode(WebDriver driver) {
        scrollToElement(billingZIPCodeField,driver);
        waitFor(1);
        clear(billingZIPCodeField);
        type(billingZIPCodeField,billingZIPCode);
        log.info("Successfully entered ZIP Code");
    }

    public void enterValidBillingPhoneNumber(WebDriver driver) {
        scrollToElement(billingPhoneNumberField,driver);
        waitFor(1);
        clear(billingPhoneNumberField);
        type(billingPhoneNumberField,billingPhoneNumber);
        log.info("Successfully entered Phone number");
    }

    public void enterValidBillingEmail(WebDriver driver) {
        scrollToElement(billingEmailField,driver);
        waitFor(1);
        clear(billingEmailField);
        type(billingEmailField,billingEmail);
        log.info("Successfully entered email");
    }

    public void clickOnSaveAddressButton(WebDriver driver) {
        scrollToElement(saveBillingAddressButton,driver);
        waitFor(1);
        clickOn(saveBillingAddressButton);
        log.info("Successfully clicked on save billing address button");
    }

    public String getAddressChangedAlertText(WebDriver driver){
        scrollToElement(addressChangedAlertText,driver);
        waitFor(1);
        String AlertText =  getElementText(addressChangedAlertText);
        return AlertText;
    }

    public void clickOnShippingAddressEditLink(WebDriver driver) {
        scrollToElement(shippingAddressEditLink,driver);
        waitFor(1);
        clickOn(shippingAddressEditLink);
        log.info("Successfully clicked on shipping address edit link");
    }

    public void enterValidShippingFirstName(WebDriver driver) {
        scrollToElement(shippingFirstNameField,driver);
        waitFor(1);
        clear(shippingFirstNameField);
        type(shippingFirstNameField,shippingFirstName);
        log.info("Successfully entered billing first name");
    }

    public void enterValidShippingLastName(WebDriver driver) {
        scrollToElement(shippingLastNameField,driver);
        waitFor(1);
        clear(shippingLastNameField);
        type(shippingLastNameField,shippingLastName);
        log.info("Successfully entered billing first name");
    }

    public void selectShippingCountryRegion(WebDriver driver) {
        scrollToElement(shippingCountryField,driver);
        waitFor(1);
        selectOptionFromDropDown(shippingCountryField,shippingCountryCode);
        log.info("Successfully selected Country/Region");
    }

    public void enterValidShippingStreetAddress(WebDriver driver) {
        scrollToElement(shippingStreetAddressField,driver);
        waitFor(1);
        clear(shippingStreetAddressField);
        type(shippingStreetAddressField,shippingStreetAddress);
        log.info("Successfully entered billing street address");
    }

    public void enterValidShippingCity(WebDriver driver) {
        scrollToElement(shippingCityField,driver);
        waitFor(1);
        clear(shippingCityField);
        type(shippingCityField,shippingCity);
        log.info("Successfully selected billing city");
    }
    public void selectShippingState(WebDriver driver) {
        scrollToElement(shippingStateField,driver);
        waitFor(1);
        selectOptionFromDropDown(shippingStateField,shippingState);
        log.info("Successfully selected billing State");
    }

    public void enterValidShippingZIPCode(WebDriver driver) {
        scrollToElement(shippingZIPCodeField,driver);
        waitFor(1);
        clear(shippingZIPCodeField);
        type(shippingZIPCodeField,shippingZIPCode);
        log.info("Successfully entered ZIP Code");
    }

    public void clickOnLostYourPasswordLink(WebDriver driver) {
        scrollToElement(lostYourPasswordLink,driver);
        waitFor(1);
        clickOn(lostYourPasswordLink);
        log.info("Successfully clicked on lost Your Password Link");
    }



}
