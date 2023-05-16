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


    @FindBy(css = "//div[@class='price_slider ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content']//span[1]")
    WebElement minPrice;

    @FindBy(css = "//div[@class='price_slider ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content']//span[2]")
    WebElement maxPrice;

    @FindBy(css = "button[class='button wp-element-button']")
    WebElement filterButton;

    @FindBy(css = "select[name='orderby']")
    WebElement orderByOption;

    @FindBy(css = "li[class='product type-product post-2441 status-publish first instock product_cat-accessories product_cat-headphone-accessories has-post-thumbnail shipping-taxable purchasable product-type-simple'] div[class='product-loop-header product-item__header'] h2[class='woocommerce-loop-product__title']")
    WebElement lowestProductWithFilter;

    @FindBy(xpath = "//div[@class='product-loop-header product-item__header']//h2[@class='woocommerce-loop-product__title'][contains(text(),'Magnetic Silicone Charging Holder for Magsafe Appl')]")
    WebElement lowestProductWithOutFilter;

    //----------------------------------------------------------------------------------------------------------------
    // ****************************************( Reusable Methods )***************************************************
    // ---------------------------------------------------------------------------------------------------------------


    public void clickOnTabletThinEliteBookRevolve() {
        clickOn(tabletThinEliteBookRevolve);
        log.info("The selected product details page opened Successfully");
    }

    public void moveSliderMinPrice(int x,int y) {
        moveSlider(minPrice, x, y);
        log.info("The minimum price set successfully.");
    }

    public void moveSliderMaxPrice(int x,int y) {
        moveSlider(maxPrice, x, y);
        log.info("The maximum price set successfully.");
    }

    public void clickOnFilterButton() {
        clickOn(filterButton);
        log.info("The price range set successfully.");
    }

    public void orderByPriceLowToHigh() {
        selectOptionFromDropDown(orderByOption,"price");
        log.info("The results successfully ordered by price low to high.");
    }
    public String getLowestProductTitleWithFilter() {
        String text = getElementText(lowestProductWithFilter);
        log.info("The products displayed are filtered according to the price range set in the filter.");
        return text;
    }

    public String getLowestProductTitleWithOutFilter() {
        String text = getElementText(lowestProductWithFilter);
        log.info("The products displayed on the shop page reset to the default view successfully.");
        return text;
    }

}
