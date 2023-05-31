package finalProject.pages.oussama;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LostPasswordPage extends CommonAPI {
    Logger log = LogManager.getLogger(LostPasswordPage.class.getName());

    public LostPasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Locators )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @FindBy(css = "#user_login")
    WebElement usernameOrEmailAddressField;

    @FindBy(css = "button[value='Reset password']")
    WebElement restPasswordButton;

    @FindBy(css = "ul[role='alert'] li")
    WebElement restPasswordErrorAlert;

    @FindBy(xpath = "//div[@role='alert']")
    WebElement successAlertMessage;


    //----------------------------------------------------------------------------------------------------------------
    // ****************************************( Reusable Methods )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    public void enterUsernameOrEmailAddress(WebDriver driver,String email) {
        scrollToElement(usernameOrEmailAddressField,driver);
        waitFor(2);
        clear(usernameOrEmailAddressField);
        type(usernameOrEmailAddressField,email);
        log.info("Successfully entered email address");
    }

    public void clickOnRestPasswordButton(WebDriver driver) {
        scrollToElement(restPasswordButton,driver);
        waitFor(2);
        clickOn(restPasswordButton);
        log.info("Successfully clicked On Rest Password Button");
    }

    public String getRestPasswordErrorAlertMessage(WebDriver driver) {
        scrollToElement(restPasswordErrorAlert, driver);
        waitFor(1);
        String text = getElementText(restPasswordErrorAlert);
        return text;
    }

    public String getSuccessAlertMessage(WebDriver driver) {
        scrollToElement(successAlertMessage, driver);
        waitFor(1);
        String text = getElementText(successAlertMessage);
        return text;
    }
}
