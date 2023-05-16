package finalProject.pages.oussama;

import finalProject.base.CommonAPI;
import com.github.javafaker.Faker;
import finalProject.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class MyAccountPage extends CommonAPI {

    Logger log = LogManager.getLogger(MyAccountPage.class.getName());


    public MyAccountPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Data )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    Properties prop = Utility.loadProperties();
    String loginEmailForCustomer = Utility.decode(prop.getProperty("loginEmailForCustomer"));
    String loginPasswordForCustomer = Utility.decode(prop.getProperty("loginPasswordForCustomer"));
    String loginEmailForVendor = Utility.decode(prop.getProperty("loginEmailForVendor"));
    String loginPasswordForVendor = Utility.decode(prop.getProperty("loginPasswordForVendor"));

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

    //----------------------------------------------------------------------------------------------------------------
    // ****************************************( Reusable Methods )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    public void enterRegisterEmailFieldFakeData() {
       type(registerEmailField,fakeEmailAddress());
        log.info("Successfully entered email address");
    }

    public void enterRegisterPasswordFieldFakeData() {
        type(registerPasswordField,fakePassword());
        log.info("Successfully entered Password");
    }

    public void selectRegisterCustomerOption() {
        clickOn(registerCustomerOption);
        log.info("The I am a customer registration type is selected Successfully");
    }

    public void selectRegisterVendorOption() {
        clickOn(registerVendorOption);
        log.info("The I am a customer registration type is selected Successfully");
    }

    public void clickOnRegisterButton() {
        clickOn(registerButton);
        log.info("The I am a customer registration type is selected Successfully");
    }

    public void enterRegisterFirstNameField() {
        type(registerFirstNameField,fakeFirstName());
        log.info("Successfully entered First Name");
    }

    public void enterRegisterLastNameField() {
        type(registerLastNameField,fakeLastName());
        log.info("Successfully entered Last Name");
    }

    public void enterRegisterShopNameField() {
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

    public void clickInsideTheShopURLField() {
        clickOn(registerShopURLField);
        log.info("The Shop URL field is automatically populated with The same data entered in Shop Name ");
    }
    public void clickInsideTheShopNameField() {
        clickOn(registerShopNameField);
        log.info("Successfully clicked in side  Shop Name field");
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

    public void enterValidEmailLoginCustomer() {
        type(loginEmailField,loginEmailForCustomer);
        log.info("Successfully entered email address");
    }
    public void enterValidPasswordLoginCustomer() {
        type(loginPasswordField,loginPasswordForCustomer);
        log.info("Successfully entered Password");
    }
    public void clickOnLoginButton() {
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

    public void enterRegisterPasswordField(String regPassword) {
        type(registerPasswordField,regPassword);
        log.info("Successfully entered Password");
    }

    public void clearRegPasswordField() {
        clear(registerPasswordField);
        log.info("Successfully cleared Reg Password Field");
    }

    public String getShortPasswordStrengthAlertText() {
       String text =  getElementText(shortPasswordStrengthAlertText);
        log.info("A message displayed under the password field indicating that the password is very weak");
       return text;
    }
    public String getBadPasswordStrengthAlertText() {
        String text = getElementText(badPasswordStrengthAlertText);
        log.info("A message displayed under the password field indicating that the password is weak");
        return text;
    }
    public String getGoodPasswordStrengthAlertText() {
        String text = getElementText(goodPasswordStrengthAlertText);
        log.info("A message displayed under the password field indicating that the password is Medium");
        return text;
    }
    public String getStrongPasswordStrengthAlertText() {
      String text =  getElementText(strongPasswordStrengthAlertText);
        log.info("A message displayed under the password field indicating that the password is Strong");
      return text;
    }

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
}
