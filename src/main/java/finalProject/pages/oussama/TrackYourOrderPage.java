package finalProject.pages.oussama;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrackYourOrderPage extends CommonAPI {
    Logger log = LogManager.getLogger(HomePage.class.getName());

    public TrackYourOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Locators )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @FindBy(css = "button[value='Track']")
    WebElement trackButton;

    @FindBy(css = "ul[role='alert'] li")
    WebElement alertErrorText;

    @FindBy(css = ".woocommerce-order-details__title")
    WebElement orderDetailsTitle;

    @FindBy(css = "#orderid")
    WebElement orderIDField;

    @FindBy(css = "#order_email")
    WebElement orderEmailField;


    //----------------------------------------------------------------------------------------------------------------
    // ****************************************( Reusable Methods )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    public void clickOnTrackButton(WebDriver driver) {
        scrollToElement(trackButton,driver);
        waitFor(1);
        clickOn(trackButton);
        log.info("successfully clicked on the Track button.");
    }

    public String getAlertErrorText() {
     String text = getElementText(alertErrorText);
        log.info("The alert error message is displayed on the page.");
        return text;
    }

    public String getOrderDetailsTitle() {
        String text = getElementText(orderDetailsTitle);
        log.info("the order status is displayed successfully");
        return text;
    }

    public void enterOrderID(String orderID) {
        type(orderIDField,orderID);
        log.info("Successfully entered Order ID");
    }

    public void enterOrderEmail(String orderEmail) {
        type(orderEmailField,orderEmail);
        log.info("Successfully entered Order Email");
    }


    public void clearOrderIDField() {
        clear(orderIDField);
        log.info("Successfully cleared the Order ID field.");
    }

    public void clearOrderEmailField() {
        clear(orderEmailField);
        log.info("Successfully cleared the Order Email field.");
    }

}
