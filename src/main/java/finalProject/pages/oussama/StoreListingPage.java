package finalProject.pages.oussama;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class StoreListingPage extends CommonAPI {
    Logger log = LogManager.getLogger(StoreListingPage.class.getName());

    public StoreListingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Locators )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @FindBy(css = ".dokan-store-list-filter-button.dokan-btn.dokan-btn-theme")
    WebElement filterButton;
    @FindBy(css = "input[placeholder='Search Vendors']")
    WebElement storesSearchbar;

    @FindBy(css = "#apply-filter-btn")
    WebElement applyButton;

    @FindBy(css = "a[href='https://www.oussama-achour.com/store/oussama/']")
    WebElement oussamaElectronicsStore;

    @FindBy(css = "input[placeholder='Your Name']")
    WebElement yourNameField;

    @FindBy(css = "input[placeholder='you@example.com']")
    WebElement yourEmailField;

    @FindBy(css = "textarea[placeholder='Type your messsage...']")
    WebElement yourMessageField;

    @FindBy(css = "input[value='Send Message']")
    WebElement sendMessage;

    @FindBy(css = ".alert.alert-success")
    WebElement ConfirmationTextAlert;


    //----------------------------------------------------------------------------------------------------------------
    // ****************************************( Reusable Methods )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    public void clickOnFilterButton() {
        clickOn(filterButton);
        log.info("The stores search bar appear successfully.");
    }

    public void enterSearchTerm(String searchTerm) {
        type(storesSearchbar,searchTerm);
        log.info("Successfully entered search term");
    }

    public void clickOnApplyButton() {
        clickOn(applyButton);
        log.info("displayed the results based on your search term successfully.");
    }

    public void clickOnOussamaElectronicsStore() {
        clickOn(oussamaElectronicsStore);
        log.info("Access the store page successfully ");
    }

    public void typeYourName(String yourName) {
        type(yourNameField,yourName);
        log.info("Successfully entered Name");
    }

    public void typeYourEmail(String yourEmail) {
        type(yourEmailField,yourEmail);
        log.info("Successfully entered Email");
    }

    public void typeYourMessage(String YourMessage) {
        type(yourMessageField,YourMessage);
        log.info("Successfully entered Message");
    }

    public void clickOnSendMessage() {
        clickOn(sendMessage);
        log.info("information entered successfully");;
    }

    public String getConfirmationTextAlert() {
       String text = getElementText(ConfirmationTextAlert);
        log.info("Email sent successfully!");
        return text;
    }

}
