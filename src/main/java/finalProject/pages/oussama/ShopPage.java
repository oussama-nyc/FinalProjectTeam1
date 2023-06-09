package finalProject.pages.oussama;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage extends CommonAPI {
    Logger log = LogManager.getLogger(HomePage.class.getName());

    public ShopPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Locators )***************************************************
    // ---------------------------------------------------------------------------------------------------------------


    @FindBy(css = "div[class='product type-product post-2932 status-publish first instock product_cat-smart-phones-tablets product_cat-smartphones has-post-thumbnail featured shipping-taxable purchasable product-type-simple'] img[class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail']")
    WebElement tabletThinEliteBookRevolve;


    @FindBy(xpath = "//div[@class='price_slider ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content']//span[1]")
    WebElement minPrice;

    @FindBy(xpath = "//div[@class='price_slider ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content']//span[2]")
    WebElement maxPrice;

    @FindBy(css = "button[class='button wp-element-button']")
    WebElement filterButton;

    @FindBy(css = "select[name='orderby']")
    WebElement orderByOption;

    @FindBy(css = "li[class='product type-product post-2861 status-publish first instock product_cat-accessories-laptops-computers product_cat-laptops-computers has-post-thumbnail shipping-taxable purchasable product-type-simple'] div[class='product-loop-header product-item__header'] h2[class='woocommerce-loop-product__title']")
    WebElement lowestProductWithFilter;

    @FindBy(xpath = "//div[@class='product-loop-header product-item__header']//h2[@class='woocommerce-loop-product__title'][contains(text(),'Magnetic Silicone Charging Holder for Magsafe Appl')]")
    WebElement lowestProductWithOutFilter;

    @FindBy(css = ".ui-slider-range.ui-corner-all.ui-widget-header")
    WebElement filterSlider;

    @FindBy(css = "div[class='summary entry-summary'] a[class='add-to-compare-link']")
    WebElement addToComparePageLink;

    @FindBy(css = "div[class='product type-product post-2928 status-publish outofstock product_cat-smart-phones-tablets product_cat-smartphones has-post-thumbnail featured shipping-taxable purchasable product-type-simple'] img[class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail']")
    WebElement Smartphone6S128GBLTE;

    @FindBy(xpath = "//div[contains(@class,'summary entry-summary')]//span[contains(text(),'Add to wishlist')]")
    WebElement AddToWishListPageLink;

    @FindBy(css = "li[class='product type-product post-5552 status-publish first instock product_cat-chargers has-post-thumbnail sale shipping-taxable purchasable product-type-simple'] div[class='product-loop-header product-item__header'] h2[class='woocommerce-loop-product__title']")
    WebElement macBookCharger;

    @FindBy(css = "img[alt='\uD83D\uDD0D']")
    WebElement productGallery;

    @FindBy(css = "button[aria-label='Next (arrow right)']")
    WebElement nextProductPicture;

    @FindBy(css = "div[class='pswp__caption'] div[class='pswp__caption__center']")
    WebElement productPictureName;






    //----------------------------------------------------------------------------------------------------------------
    // ****************************************( Reusable Methods )***************************************************
    // ---------------------------------------------------------------------------------------------------------------


    public void clickOnTabletThinEliteBookRevolve() {
        clickOn(tabletThinEliteBookRevolve);
        log.info("The selected product details page opened Successfully");
    }

    public void moveSliderMinPrice(int x,int y,WebDriver driver) {
        moveSlider(minPrice, x, y, driver);
        log.info("The minimum price set successfully.");
    }

    public void moveSliderMaxPrice(int x,int y, WebDriver driver) {
        moveSlider(maxPrice, x, y, driver);
        log.info("The maximum price set successfully.");
    }

    public void clickOnFilterButton() {
        clickOn(filterButton);
        log.info("The price range set successfully.");
    }

    public void orderByPriceLowToHigh(WebDriver driver) {
        scrollToElement(orderByOption,driver);
        waitFor(1);
        selectOptionFromDropDown(orderByOption,"price");
        log.info("The results successfully ordered by price low to high.");
    }
    public String getLowestProductTitleWithFilter(WebDriver driver) {
        scrollToElement(lowestProductWithFilter,driver);
        String text = getElementText(lowestProductWithFilter);
        log.info("The products displayed are filtered according to the price range set in the filter.");
        return text;
    }

    public String getLowestProductTitleWithOutFilter() {
        String text = getElementText(lowestProductWithOutFilter);
        log.info("The products displayed on the shop page reset to the default view successfully.");
        return text;
    }

    public void scrollToFilterSlider(WebDriver driver) {
        scrollToElement(filterSlider,driver);
        log.info("successfully");
    }

    public void clickOnAddToComparePageLink() {
        clickOn(addToComparePageLink);
        log.info("The selected product is successfully added to the Compare page");
    }

    public void clickOnSmartphone6S128GBLTE() {
        clickOn(Smartphone6S128GBLTE);
        log.info("The selected product's details are displayed Successfully");
    }

    public void clickOnAddToWishListPageLink() {
        clickOn(AddToWishListPageLink);
        log.info("The selected product is successfully added to the wishlist page");
    }

    public void clickOnMacBookCharger(WebDriver driver) {
        scrollToElement(macBookCharger,driver);
        waitFor(2);
        clickOn(macBookCharger);
        log.info("The selected product details page opened Successfully");
    }

    public void clickOnProductGallery(WebDriver driver) {
        scrollToElement(productGallery,driver);
        waitFor(2);
        clickOn(productGallery);
        log.info("The product Gallery opened Successfully");
    }

    public void clickOnNextProductPicture(WebDriver driver) {
        scrollToElement(nextProductPicture,driver);
        waitFor(2);
        clickOn(nextProductPicture);
        log.info("Successfully clicked On Next Product Picture");
    }

    public String getProductPictureName(WebDriver driver) {
        scrollToElement(productPictureName,driver);
        waitFor(1);
        String text = getElementText(productPictureName);
        return text;
    }



}
