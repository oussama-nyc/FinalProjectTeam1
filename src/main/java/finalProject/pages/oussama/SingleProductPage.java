package finalProject.pages.oussama;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingleProductPage extends CommonAPI {
    Logger log = LogManager.getLogger(SingleProductPage.class.getName());

    public SingleProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Locators )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @FindBy(css = ".product_title.entry-title")
    WebElement productTitle;


    @FindBy(css = "a[href='#tab-reviews']")
    WebElement tabReviews;


    @FindBy(css = ".star-5")
    WebElement fiveStar;

    @FindBy(css = "#comment")
    WebElement descriptionField;

    @FindBy(css = "#author")
    WebElement nameField;

    @FindBy(css = "#email")
    WebElement emailField;

    @FindBy(css = "#submit")
    WebElement addReviewButton;

    @FindBy(xpath = "(//p[@class='meta'])[8]")
    WebElement confirmationReviewText;

    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//input[@inputmode='numeric']")
    WebElement productQuantityField;

    @FindBy(xpath = "//div[@role='alert']")
    WebElement addToCartAlertText;

    @FindBy(css = "div[role='alert'] a[class='button wc-forward wp-element-button']")
    WebElement viewCartButton;


    //----------------------------------------------------------------------------------------------------------------
    // ****************************************( Reusable Methods )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    public String getProductTitle() {
        String text = getElementText(productTitle);
        log.info("get product title text success");
        return text;
    }

    public void clickOnTabReviews(WebDriver driver) {
        scrollToElement(tabReviews,driver);
        waitFor(1);
        clickOn(tabReviews);
        log.info("Reviews Tap opened successfully");
    }

    public void clickOnFiveStar() {
        clickOn(fiveStar);
        log.info(" selected star rating Successfully.");
    }

    public void typeYourDescription(String yourDescription) {
        type(descriptionField,yourDescription);
        log.info("Successfully entered Description");
    }

    public void typeYourName(String yourName) {
        type(nameField,yourName);
        log.info("Successfully entered Name");
    }

    public void typeYourEmail(String yourEmail) {
        type(emailField,yourEmail);
        log.info("Successfully entered Email");
    }

    public void clickOnAddReviewButton() {
        clickOn(addReviewButton);
        log.info("information entered successfully");;
    }

    public String getConfirmationReviewText() {
        String text = getElementText(confirmationReviewText);
        log.info("comment is added Successfully and awaiting approval");
        return text;
    }

    public String getAddToCartButtonText() {
        String text = getElementText(addToCartButton);
        return text;
    }

    public void SelectProductQuantity(WebDriver driver) {
        scrollToElement(productQuantityField,driver);
        waitFor(1);
        clear(productQuantityField);
        type(productQuantityField,"3");
        log.info("Successfully selected the desired quantity of the product.");
    }

    public void clickOnAddProductToTheCart(WebDriver driver) {
        scrollToElement(addToCartButton,driver);
        waitFor(1);
        clickOn(addToCartButton);
        log.info("Successfully added the product to the cart.");
    }

    public String getAddToCartAlertText() {
        String text = getElementText(addToCartAlertText);
        return text;
    }

    public void clickOnViewCartButton() {
        clickOn(viewCartButton);
        log.info("The cart page is displayed successfully");
    }

    public String getSecondSliderProductTitle() {
        String text = getElementText(productTitle);
        return text;
    }

    public String getThirdSliderProductTitle() {
        String text = getElementText(productTitle);
        return text;
    }

}
