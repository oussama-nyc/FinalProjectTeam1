package finalProject.pages.scaledupit;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCategoriesPage extends CommonAPI {
    Logger log = LogManager.getLogger( ShoppingCategoriesPage .class.getName());

    public  ShoppingCategoriesPage  (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //objects

    @FindBy(xpath = "//input[@class='submit']")
    WebElement submitButton;
    @FindBy(xpath = "//li[@id='tab-title-reviews']/a")
    WebElement reviewButton;
    @FindBy(xpath = "//a[@class='star-5']")
    WebElement ratingButton;
    @FindBy(id = "comment")
    WebElement reviewField;



    //reusable methods
    public void clickOnSubmitButton() {

        clickOn(submitButton);
        log.info("click on submit button success");

    }

    public void clickReviewButton() {
        clickOn(reviewButton);
        log.info("click on submit button success");

    }

    public void clickRating() {
        clickOn(ratingButton);
        log.info("click on Rating button success");

    }

    public void typeReview(String review) {
        type(reviewField, review);
        log.info("type review success");
    }

}




