package finalProject.pages.nopcommerce;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvalidCredentialsPage extends CommonAPI {
    Logger log = LogManager.getLogger(RegisterPage.class.getName());

    public InvalidCredentialsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //--------------------------------------------------------------------------------
    // ****************************************( Locators )***************************
    // -------------------------------------------------------------------------------
    // invalid Email Validation
    @FindBy(xpath = "//span[@id='Email-error']")
    WebElement invalidEmailValidation;

    // unsuccessful Login Validation
    @FindBy(xpath = "div[class='message-error validation-summary-errors'] ul li")
    WebElement unsuccessfulLoginValidation;




    //--------------------------------------------------------------------------
// *********************************( Reusable Methods )**************************
// ------------------------------------------------------------------------------

        // invalid Email Validation
    public String invalidEmailValidationText() {
        String text = getElementText(invalidEmailValidation);
        log.info("  Invalid Email Validation Text successfully");
        return text;
    }

    // unsuccessful Login Validation
    public String unsuccessfulLoginValidationText() {
        String text = getElementText(unsuccessfulLoginValidation);
        log.info("Unsuccessful Login Validation Text successfully");
        return text;
    }
}
