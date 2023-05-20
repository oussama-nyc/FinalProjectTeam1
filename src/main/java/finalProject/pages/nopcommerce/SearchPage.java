package finalProject.pages.nopcommerce;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends CommonAPI {
    Logger log = LogManager.getLogger(SearchPage.class.getName());

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Locators )***************************************************
    // --------------------------------------------------------------------------------------------------
    // search field
    @FindBy(xpath = "//input[@id='small-searchterms']")
    WebElement searchField;

    // Search button
    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;
//-------------------------
    @FindBy(xpath = "//label[@for='advs']")
    WebElement advanceSearch;

    //Search Validation
    @FindBy(xpath = "//div[@class='no-result']")
    WebElement searchValidation;
    @FindBy(xpath = "")
    WebElement b;
    @FindBy(xpath = "")
    WebElement c;
    @FindBy(xpath = "")
    WebElement d;
    @FindBy(xpath = "")
    WebElement e;
    @FindBy(xpath = "")
    WebElement f;
    //--------------------------------------------

    //Buying Desktop
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement Desktop;

    //----------------------------------------------------------------------------------------------------------------
    // ****************************************( Reusable Methods )***************************************************
    // ---------------------------------------------------------------------------------------------------
    public void clickOnSearchField() {
        clickOn(searchField);
        log.info("clicked on search field successfully");
    }

    public void typeOnSearchField(String text) {
        type(searchField, text);
        log.info("text field successfully");
    }
    public void clickOnSearchButtonLink() {
        clickOn(searchButton);
        log.info("text field successfully");
        //-----------------------------------
    }

    public String searchValidationText() {
        String text = getElementText(searchValidation);
        log.info("  Search Validation succeeded");
        return text;
    }



}

//    public void typeDateOfBirthDay() {
//        selectOptionFromDropDown(dateOfBirthDay, "28");
//        log.info("Selected  DateOfBirthDay successfully");