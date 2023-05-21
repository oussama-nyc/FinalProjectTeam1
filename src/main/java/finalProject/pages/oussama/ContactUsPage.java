package finalProject.pages.oussama;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends CommonAPI {
    Logger log = LogManager.getLogger(ContactUsPage.class.getName());

    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Locators )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @FindBy(css = "#wpforms-5345-field_0")
    WebElement firstNameField;

    @FindBy(css = "#wpforms-5345-field_0-last")
    WebElement lastNameField;

    @FindBy(css = "#wpforms-5345-field_1")
    WebElement emailAddressField;

    @FindBy(css = "#wpforms-5345-field_2")
    WebElement messageField;

    @FindBy(css = "#wpforms-submit-5345")
    WebElement submitButton;

    @FindBy(css = "div[id='wpforms-confirmation-5345'] p")
    WebElement confirmationAlertText;

    //----------------------------------------------------------------------------------------------------------------
    // ****************************************( Reusable Methods )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    public void enterFirstNameField(String firstName ) {
        type(firstNameField,firstName);
        log.info("Successfully entered first name");
    }

    public void enterLastNameField(String lastName) {
        type(lastNameField,lastName);
        log.info("Successfully entered last Name");
    }

    public void enterEmailAddressFieldField(String emailAddress,WebDriver driver ) {
        scrollToElement(emailAddressField,driver);
        waitFor(1);
        type(emailAddressField,emailAddress);
        log.info("Successfully entered email address");
    }

    public void enterMessageField(String message) {
        type(messageField,message);
        log.info("Successfully entered message");
    }

    public void clickOnSubmitButton() {
        clickOn(submitButton);
        log.info("Successfully clicked on submit button");
    }

    public String getConfirmationAlertText() {
        String text =  getElementText(confirmationAlertText);
        log.info("The success message is displayed on the page.");
        return text;
    }

}

