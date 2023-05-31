package finalProject.pages.oussama;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonAPI {
    Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Locators )***************************************************
    // ---------------------------------------------------------------------------------------------------------------


    @FindBy(xpath = "//span[normalize-space()='Dark']")
    WebElement darkModeButton;

    @FindBy(xpath = "//span[normalize-space()='Light']")
    WebElement lightModeButton;

    @FindBy(css = "body")
    WebElement bodyElement;

    @FindBy(css = "background-color")
    WebElement backGround;

    @FindBy(css = "#wpforms-5347-field_1")
    WebElement emailField;

    @FindBy(xpath = "(//button[normalize-space()='SignUp'])[1]")
    WebElement signUpButton;

    @FindBy(css = "#wpforms-5347-field_1-error")
    WebElement signUpAlertError;

    @FindBy(css = "div[id='wpforms-confirmation-5347'] p")
    WebElement confirmationMessage;

    @FindBy(css = "rs-bullet:nth-child(2)")
    WebElement secondSlider;

    @FindBy(css = "rs-bullet:nth-child(3)")
    WebElement thirdSlider;

    @FindBy(css = "#slider-1-slide-2-layer-6")
    WebElement secondSliderButton;

    @FindBy(css = "#slider-1-slide-3-layer-7")
    WebElement thirdSliderButton;

    @FindBy(css = "div[class='header-site-branding'] img[alt='Welcome to Worldwide Electronics Store']")
    WebElement homePageLogo;



    //----------------------------------------------------------------------------------------------------------------
    // ****************************************( Reusable Methods )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    public void clickOnDarkModeButton() {
        clickOn(darkModeButton);
        log.info("Successfully Clicked on the Dark Mode Button. ");
    }

    public void clickOnLightModeButton() {
        clickOn(lightModeButton);
        log.info("Successfully Clicked on the Light Mode Button.");
    }

    public void getBodyColor() {
        clickOn(lightModeButton);
        log.info("Successfully Clicked on the Light Mode Button.");
    }

    public String getBackGroundCssValue(){
        String BackGroundCssValue =  getCssValue( bodyElement,  "background-color");
        return BackGroundCssValue;
    }

    public void typeEmailAddress(WebDriver driver,String email) {
        scrollToElement(emailField,driver);
        clear(emailField);
        type(emailField,email);
        log.info("successfully typing an email address");
        waitFor(2);
    }

    public void clickOnSignUpButton(WebDriver driver) {
        scrollToElement(signUpButton,driver);
        clickOn(signUpButton);
        log.info("successfully clicked On Sign Up Button");
    }

    public String getSignUpErrorAlertText(WebDriver driver){
        scrollToElement(signUpAlertError,driver);
        waitFor(1);
        String AlertText =  getElementText(signUpAlertError);
        return AlertText;
    }

    public String getConfirmationMessage(WebDriver driver){
        scrollToElement(confirmationMessage,driver);
        waitFor(1);
        String AlertText =  getElementText(confirmationMessage);
        return AlertText;
    }

    public void clickOnSecondSlider(WebDriver driver) {
        scrollToElement(secondSlider,driver);
        waitFor(2);
        clickOn(secondSlider);
        waitFor(2);
        log.info("successfully clicked On Second Slider");
    }

    public void clickOnSecondSliderButton(WebDriver driver) {
        scrollToElement(secondSliderButton,driver);
        waitFor(1);
        clickOn(secondSliderButton);
        waitFor(2);
        log.info("successfully clicked On second Slider Button");
    }

    public void clickOnThirdSliderButton(WebDriver driver) {
        scrollToElement(thirdSliderButton,driver);
        waitFor(1);
        clickOn(thirdSliderButton);
        waitFor(2);
        log.info("successfully clicked On third Slider Button");
    }

    public void clickOnThirdSlider(WebDriver driver) {
        scrollToElement(thirdSlider,driver);
        waitFor(1);
        clickOn(thirdSlider);
        waitFor(2);
        log.info("successfully clicked On Third Slider");
    }

    public void clickOnHomePageLogo(WebDriver driver) {
        scrollToElement(homePageLogo,driver);
        waitFor(1);
        clickOn(homePageLogo);
        waitFor(2);
        log.info("successfully clicked On Home Page Logo");
    }



}
