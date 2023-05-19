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

    //----------------------------------------------------------------------------------------------------------------
    // ****************************************( Reusable Methods )***************************************************
    // ---------------------------------------------------------------------------------------------------------------


    public void clickOnProceedToCheckoutButton() {
        clickOn(proceedToCheckoutButton);
        log.info("The checkout page is displayed successfully.");
    }
}
