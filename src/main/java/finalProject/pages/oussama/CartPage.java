package finalProject.pages.oussama;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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



    //----------------------------------------------------------------------------------------------------------------
    // ****************************************( Reusable Methods )***************************************************
    // ---------------------------------------------------------------------------------------------------------------


    public void clickOnProceedToCheckoutButton() {
        clickOn(proceedToCheckoutButton);
        log.info("The checkout page is displayed successfully.");
    }

    public void enterCouponCode(String couponCode) {
        clear(couponCodeField);
        type(couponCodeField,couponCode);
        clickOn(applyCouponButton);
        log.info("Successfully entering a coupon code");
    }

    public String getCouponAlertText() {
        String text = getElementText(couponAlertText);
        return text;
    }

    public String getCouponAppliedSuccessfullyText() {
        String text = getElementText(couponAppliedSuccessfullyText);
        return text;
    }


    public String getSpecificProductsCouponText() {
        String text = getElementText(specificProductsCouponText);
        return text;
    }



}
