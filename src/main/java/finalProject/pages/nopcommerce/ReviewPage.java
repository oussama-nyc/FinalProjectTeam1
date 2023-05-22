package finalProject.pages.nopcommerce;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPage extends CommonAPI {

    Logger log = LogManager.getLogger(ReviewPage.class.getName());

    public ReviewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //---------------------------------------------------------------------
    // ***************************( Locators )************************
    // -------------------------------------------------------------------
    //click on Flower Girl Bracelet

    @FindBy(xpath = "//h2[@class='product-title']//a[normalize-space()='Flower Girl Bracelet']")
    WebElement flowerGirlBracelet;

    // Click Add your review
    @FindBy(xpath = "//a[normalize-space()='Add your review']")
    WebElement addYourReview;

    //  Review title field
    @FindBy(xpath = "//input[@id='AddProductReview_Title']")
    WebElement reviewTitleField;

    //  Review  field Text
    @FindBy(xpath = "//textarea[@id='AddProductReview_ReviewText']")
    WebElement reviewFieldText;

    //  Rating select
    @FindBy(xpath = "//textarea[@id='AddProductReview_ReviewText']")
    WebElement ratingSelect;

    // Click on submit review button
    @FindBy(xpath = "//button[@name='add-review']")
    WebElement submitReviewButton;

    //Review Validation
    @FindBy(xpath = "//div[@class='result']")
    WebElement reviewValidation;




//addYourReview
    public void clickOnFlowerGirlBracelet() {
        clickOn(flowerGirlBracelet);
        log.info("click On Flower Girl Bracelet successfully");
    }
    //addYourReview clickOnFlowerGirlBracelet
    public void clickOnAddYourReview() {
        clickOn(addYourReview);
        log.info("click On Add Your Review successfully");
    }
    //review Title Field
    public void clickOnReviewTitleField() {
        clickOn(reviewTitleField);
        log.info("click Review successfully");
    }
    //review Title Field
    public void typeOnReviewTitleField(String text) {
        type(reviewTitleField, text);
        log.info("Type text successfully");
    }

    //review Field Text
    public void clickOnReviewFieldText() {
        clickOn(reviewFieldText);
        log.info("click  successfully");
    }
    //Type review Field Text

    public void typeOnReviewFieldText(String text) {
        type(reviewFieldText, text);
        log.info("Type text successfully");
    }



    //click on review button
    public void clickOnSubmitReviewButton() {
        clickOn(submitReviewButton);
        log.info("click Review successfully");
    }
    //Review Validation

    public String reviewValidationValidationText() {
        String text = getElementText(reviewValidation);
        log.info(" Review Validation validation successfully.");
        return text;


    }



}
