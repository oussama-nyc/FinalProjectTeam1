package finalProject.pages.oussama;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartPage extends CommonAPI {
    Logger log = LogManager.getLogger(CartPage.class.getName());

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Locators )***************************************************
    // ---------------------------------------------------------------------------------------------------------------


    @FindBy(css = "td[class='actions'] a[class='checkout-button button alt wc-forward wp-element-button']")
    WebElement proceedToCheckoutButton;

    @FindBy(css = "#coupon_code")
    WebElement couponCodeField;

    @FindBy(css = "button[value='Apply coupon']")
    WebElement applyCouponButton;

    @FindBy(css = "ul[role='alert'] li")
    WebElement couponAlertText;

    @FindBy(css = "div[role='alert']")
    WebElement couponAppliedSuccessfullyText;

    @FindBy(css = "tr[class='cart-discount coupon-macbookpro30off'] th")
    WebElement specificProductsCouponText;

    @FindBy(css = "input[title='Qty']")
    WebElement productQuantityField;

    @FindBy(css = "button[value='Update cart']")
    WebElement updateCartButton;

    @FindBy(css = "div[role='alert']")
    WebElement alertMessage;



    //----------------------------------------------------------------------------------------------------------------
    // ****************************************( Reusable Methods )***************************************************
    // ---------------------------------------------------------------------------------------------------------------


    public void clickOnProceedToCheckoutButton(WebDriver driver) {
        scrollToElement(proceedToCheckoutButton,driver);
        waitFor(1);
        clickOn(proceedToCheckoutButton);
        log.info("The checkout page is displayed successfully.");
    }

    public void enterCouponCode(String couponCode,WebDriver driver) {
        scrollToElement(couponCodeField,driver);
        waitFor(1);
        clear(couponCodeField);
        type(couponCodeField,couponCode);
        clickOn(applyCouponButton);
        log.info("Successfully entering a coupon code");
        waitFor(2);
    }

    public String getCouponAlertText() {
        String text = getElementText(couponAlertText);
        waitFor(2);
        return text;

    }

    public String getCouponAppliedSuccessfullyText() {
        String text = getElementText(couponAppliedSuccessfullyText);
        return text;
    }

    public String getSpecificProductsCouponText(WebDriver driver) {
        scrollToElement(specificProductsCouponText,driver);
        waitFor(1);
        String text = getElementText(specificProductsCouponText);
        return text;
    }

    public void typeProductQuantity(WebDriver driver) {
        scrollToElement(productQuantityField,driver);
        waitFor(1);
        clear(productQuantityField);
        type(productQuantityField,"9");
        log.info("Successfully selected the desired quantity of the product.");
    }

    public void clickOnUpdateCartButton(WebDriver driver) {
        scrollToElement(updateCartButton,driver);
        waitFor(1);
        clickOn(updateCartButton);
        log.info("Clicked On Update Cart Button successfully.");
    }

    public String getAlertMessage(WebDriver driver) {
        scrollToElement(alertMessage,driver);
        waitFor(1);
        String text = getElementText(alertMessage);
        return text;
    }
}
