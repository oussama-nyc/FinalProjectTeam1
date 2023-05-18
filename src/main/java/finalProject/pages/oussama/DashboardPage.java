package finalProject.pages.oussama;

import finalProject.base.CommonAPI;
import finalProject.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends CommonAPI {
    Logger log = LogManager.getLogger(DashboardPage.class.getName());

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Data )***************************************************
    // ---------------------------------------------------------------------------------------------------------------


    //*********( data for adding product )**********
    String title = "laptop chargers for HP 20V 4.5A 90W";
    String price = "30";
    String discountedPrice = "20";
    String description = "wholesale 20V 4.5A 90W USB type C laptop AC adapter chargers  for HP";

    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Locators )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @FindBy(css = ".entry-title")
    WebElement MyDashboardTitle;

    @FindBy(css = "li[class='products'] a")
    WebElement dashboardProductsLink;

    @FindBy(css = ".dokan-btn.dokan-btn-theme.dokan-add-new-product")
    WebElement addNewProductButton;

    @FindBy(xpath = "//input[@placeholder='Product name..']")
    WebElement productTitle;

    @FindBy(css = "#_regular_price")
    WebElement productPrice;

    @FindBy(css = "#_sale_price")
    WebElement productDiscountedPrice;

    @FindBy(css = ".dokan-feat-image-btn.btn.btn-sm")
    WebElement uploadProductCoverImage;

    @FindBy(css = "#menu-item-browse")
    WebElement mediaLibrary;
   @FindBy(css = "body > div:nth-child(138) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > button:nth-child(2)")
   WebElement mediaLibrary1;
    @FindBy(css = "li[aria-label='product-picture1'] div[class='thumbnail']")
    WebElement thumbnailImage;

    @FindBy(xpath = "//button[normalize-space()='Set featured image']")
    WebElement SetFeaturedImageButton;

    @FindBy(css = "a[class='add-product-images']")
    WebElement plusIconToAddProductImages;

    @FindBy(xpath = "(//div[@class='thumbnail'])[39]")
    WebElement productFirstImages;

    @FindBy(xpath = "//button[normalize-space()='Add to gallery']")
    WebElement addToGalleryButton;

    @FindBy(xpath = "//div[@id='dokan-category-open-modal']")
    WebElement categoryOpenModal;

    @FindBy(xpath = "//input[@id='dokan-single-cat-search-input']")
    WebElement categorySearchInput;

    @FindBy(css = ".dokan-cat-search-res-history")
    WebElement SearchResult;

    @FindBy(css = "#dokan-single-cat-select-btn")
    WebElement doneButton;

    @FindBy(css = "textarea[placeholder='Enter some short description about this product...']")
    WebElement productDescription;

    @FindBy(css = "#dokan-create-new-product-btn")
    WebElement createProductButton;

    @FindBy(css = ".dokan-btn.dokan-btn-theme.dokan-btn-sm")
    WebElement ViewProductButton;
    @FindBy(css = ".product_title.entry-title")
    WebElement NewProductTitle;

    //----------------------------------------------------------------------------------------------------------------
    // ****************************************( Reusable Methods )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    public String getMyDashboardTitle() {
        String text = getElementText(MyDashboardTitle);
        log.info("get error message text success");
        return text;
    }

    public void clickOnProductsLink(){
        clickOn(dashboardProductsLink);
        log.info("Successfully clicked on Products link");
    }

    public void clickOnAddNewProductButton(){
        clickOn(addNewProductButton);
        log.info("Successfully clicked on Add new product button");
    }

    public void enterProductTitle() {
        type(productTitle,title);
        log.info("The Product title entered successfully.");
    }

    public void enterProductPrice() {
        type(productPrice,price);
        log.info("The Product price entered successfully.");
    }

    public void enterProductDiscountedPrice() {
        type(productDiscountedPrice,discountedPrice);
        log.info("The Product Discounted price entered successfully.");
    }

    public void addPictures() {
        clickOn(uploadProductCoverImage);
        clickOn(mediaLibrary);
        waitFor(1);
        clickOn(thumbnailImage);
        clickOn(SetFeaturedImageButton);
        log.info("The Product pictures uploaded successfully.");

    }

    public void selectCategory(WebDriver driver) {

        clickOn(categoryOpenModal);
        log.info("1");
        type(categorySearchInput,"charger");
        log.info("2");
        hoverOver(SearchResult,driver);
        log.info("3");
        clickOn(SearchResult);
        log.info("4");
        clickOn(doneButton);
        log.info("The product description successfully entered into the Product Description field.");
    }

    public void enterProductDescription(){
        type(productDescription,description);
        log.info("The product description successfully entered into the Product Description field.");
    }

    public void clickOnCreateProductButton(){
        clickOn(createProductButton);
        log.info("Product has been successfully created.");
    }

    public void clickOnViewProductButton(){
        clickOn(ViewProductButton);
        log.info("A new tab opens with the product listing ");
    }

    public String getNewProductTitle() {
        String text = getElementText(NewProductTitle);
        return text;
    }

}
