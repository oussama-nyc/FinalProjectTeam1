package finalProject.pages.oussama;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage extends CommonAPI {
    Logger log = LogManager.getLogger(WishListPage.class.getName());

    public WishListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Locators )***************************************************
    // ---------------------------------------------------------------------------------------------------------------


    @FindBy(css = ".wishlist-empty")
    WebElement wishlistPageIsEmptyText;

    @FindBy(xpath = "//a[contains(text(),'Smartphone 6S 128GB LTE')]")
    WebElement smartphoneLTEOnWishList;

    @FindBy(xpath = "//a[contains(text(),'Tablet Thin EliteBook')]")
    WebElement tabletThinEliteBookOnWishList;

    @FindBy(css = "tr[id='yith-wcwl-row-2928'] a[title='Remove this product']")
    WebElement removeProductFromTheWishListPage;

    @FindBy(xpath = "//a[normalize-space()='×']")
    WebElement RemoveSecondProductFromTheWishListPage;

    @FindBy(css = "div[role='alert']")
    WebElement ProductRemovedAlertText;

    @FindBy(xpath = "//a[normalize-space()='Add to cart']")
    WebElement addToCartFromWishListPage;

    @FindBy(xpath = "//div[@role='alert']")
    WebElement productAddedToCartAlert;

    //----------------------------------------------------------------------------------------------------------------
    // ****************************************( Reusable Methods )***************************************************
    // ---------------------------------------------------------------------------------------------------------------


    public String getWishlistPageIsEmptyText(WebDriver driver) {
        scrollToElement(wishlistPageIsEmptyText,driver);
        waitFor(3);
        String text = getElementText(wishlistPageIsEmptyText);
        log.info("The wishlist page is empty");
        return text;
    }

    public String getSmartphoneLTEOnWishListTitle(WebDriver driver) {
        scrollToElement(smartphoneLTEOnWishList,driver);
        waitFor(1);
        String text = getElementText(smartphoneLTEOnWishList);
        log.info("smartphone LTE are added to the wishlist page Successfully");
        return text;
    }

    public String getTabletThinEliteBooOnWishListTitle(WebDriver driver) {
        scrollToElement(tabletThinEliteBookOnWishList,driver);
        String text = getElementText(tabletThinEliteBookOnWishList);
        log.info("tablet Thin EliteBook are added to the wishlist page Successfully");
        return text;
    }


    public void clickOnToRemoveProductFromTheWishListPage(WebDriver driver) {
        scrollToElement(removeProductFromTheWishListPage,driver);
        clickOn(removeProductFromTheWishListPage);
        log.info("The product are successfully removed from the wishlist page.");
    }

    public void clickOnToRemoveSecondProductFromTheWishListPage(WebDriver driver) {
        scrollToElement(RemoveSecondProductFromTheWishListPage,driver);
        waitFor(2);
        clickOn(RemoveSecondProductFromTheWishListPage);
        log.info("The product are successfully removed from the wishlist page.");
    }

    public String getProductRemovedAlertText() {
        String text = getElementText(ProductRemovedAlertText);
        log.info("Product successfully removed");
        return text;
    }

    public void clickOnToAddToCartFromWishListPage(WebDriver driver) {
        scrollToElement(addToCartFromWishListPage,driver);
        waitFor(1);
        clickOn(addToCartFromWishListPage);
    }


    public String getProductAddedToCartAlertText(WebDriver driver) {
        scrollToElement(productAddedToCartAlert,driver);
        String text = getElementText(productAddedToCartAlert);
        log.info("Product added to cart successfully");
        return text;
    }



}
