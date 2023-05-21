package finalProject.pages.oussama;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutPage extends CommonAPI {
    Logger log = LogManager.getLogger(CheckoutPage.class.getName());

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Locators )***************************************************
    // ---------------------------------------------------------------------------------------------------------------


    @FindBy(css = "#billing_first_name")
    WebElement firstNameField;

    @FindBy(css = "#billing_last_name")
    WebElement lastNameField;

    @FindBy(css = "#billing_country")
    WebElement countryRegionField;

    @FindBy(css = "#billing_address_1")
    WebElement streetAddressField;

    @FindBy(css = "#billing_address_2")
    WebElement apartmentSuiteUnitField;

    @FindBy(css = "#billing_city")
    WebElement townCityField;

    @FindBy(css = "#billing_postcode")
    WebElement ZIPCodeField;

    @FindBy(css = "#billing_phone")
    WebElement phoneNumberField;

    @FindBy(css = "#billing_email")
    WebElement emailField;

    @FindBy(css = "#payment_method_cod")
    WebElement CashOnDeliveryOption;

    @FindBy(css = "#terms")
    WebElement termsAndConditionsCheckbox;

    @FindBy(css = "#place_order")
    WebElement placeOrderButton;


    @FindBy(css = ".entry-title")
    WebElement orderReceivedAlert;

    @FindBy(css = "#billing_state")
    WebElement stateCountyField;

    //----------------------------------------------------------------------------------------------------------------
    // ****************************************( Reusable Methods )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    public void enterValidFirstName(String firstName) {
        clear(firstNameField);
        type(firstNameField,firstName);
        log.info("Successfully entered First name ");
    }
    public void enterValidLastName(String lastName) {
        clear(lastNameField);
        type(lastNameField,lastName);
        log.info("Successfully entered Last name ");
    }

    public void enterValidAddress(String streetAddress,String apartmentSuiteUnit ) {
        clear(streetAddressField);
        type(streetAddressField,streetAddress);
        clear(apartmentSuiteUnitField);
        type(apartmentSuiteUnitField,apartmentSuiteUnit);
        log.info("Successfully entered Street address");
    }

    public void enterValidTownCity(String townCity) {
        clear(townCityField);
        type(townCityField,townCity);
        log.info("Successfully entered Town/City");
    }

    public void enterValidZIPCode(String ZIPCode) {
        clear(ZIPCodeField);
        type(ZIPCodeField,ZIPCode);
        log.info("Successfully entered ZIP Code");
    }

    public void enterValidPhoneNumber(String phoneNumber) {
        clear(phoneNumberField);
        type(phoneNumberField,phoneNumber);
        log.info("Successfully entered Phone number");
    }

    public void enterValidEmail(String email) {
        clear(emailField);
        type(emailField,email);
        log.info("Successfully entered email");
    }

    public void clickOnCashOnDeliveryOption(WebDriver driver) {
        scrollToElement(CashOnDeliveryOption,driver);
        waitFor(2);
        clickOn(CashOnDeliveryOption);
        log.info("Successfully selected payment method ");
    }

    public void acceptTheTermsAndConditions() {
        waitFor(2);
        clickOn(termsAndConditionsCheckbox);
        log.info("The terms and conditions are accepted Successfully");
    }

    public void clickOnPlaceOrderButton() {
        waitFor(2);
        clickOn(placeOrderButton);
        log.info("The order placed successfully.");
    }

    public String getOrderReceivedAlertText() {
        String text = getElementText(orderReceivedAlert);
        log.info("The order is successfully confirmed.");
        return text;
    }

    public void selectCountryRegion(String CountryCode,WebDriver driver) {
        scrollToElement(countryRegionField,driver);
        waitFor(1);
        selectOptionFromDropDown(countryRegionField,CountryCode);
        log.info("Successfully selected Country/Region");
    }


    public void typeValidStateCounty(String stateCounty,WebDriver driver) {
        scrollToElement(stateCountyField,driver);
        waitFor(1);
        clear(stateCountyField);
        type(stateCountyField,stateCounty);
        log.info("Successfully selected State/County");
    }

    public void selectValidStateCounty(String stateCountyCode,WebDriver driver) {
        scrollToElement(stateCountyField,driver);
        waitFor(1);
        selectOptionFromDropDown(stateCountyField,stateCountyCode);
        log.info("Successfully selected State/County");
    }
}
