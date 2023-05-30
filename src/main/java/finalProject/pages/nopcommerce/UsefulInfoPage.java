package finalProject.pages.nopcommerce;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsefulInfoPage extends CommonAPI {
    Logger log = LogManager.getLogger(UsefulInfoPage.class.getName());

    public UsefulInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //----------------------------------------------------------------------
    // *********************************( Locators )****************************
    // ----------------------------------------------------------------------

    //*************Information**************
    //Sitemap
    @FindBy(xpath = "//a[normalize-space()='Sitemap']")
    WebElement sitemap;

    // Shipping & returns
    @FindBy(xpath = "//a[normalize-space()='Shipping & returns']")
    WebElement shippingAndReturns;

    //Privacy notice
    @FindBy(xpath = "//a[normalize-space()='Privacy notice']")
    WebElement privacyNotice;

    //Conditions of Use
    @FindBy(xpath = "//a[normalize-space()='Conditions of Use']")
    WebElement conditionsOfUse;

    //About us
    @FindBy(xpath = "//a[normalize-space()='About us']")
    WebElement aboutUs;

    //Contact us
    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    WebElement contactUs;

    //****************Customer service*************
    //Search
    @FindBy(xpath = "//a[normalize-space()='Search']")
    WebElement search;

    //News
    @FindBy(xpath = "//a[normalize-space()='News']")
    WebElement news;

    //Blog
    @FindBy(xpath = "//a[normalize-space()='Blog']")
    WebElement blog;

    //Recently viewed products
    @FindBy(xpath = "//a[normalize-space()='Recently viewed products']")
    WebElement recentlyViewedProducts;

    //Compare products list compareProductsList
    @FindBy(xpath = "//a[normalize-space()='Compare products list']")
    WebElement compareProductsList;

    //New products newProducts
    @FindBy(xpath = "//a[normalize-space()='New products']")
    WebElement newProducts;

    //*************My account*******************
    //My account
    @FindBy(xpath = "//a[normalize-space()='My account']")
    WebElement myAccount;

    //Orders
    @FindBy(xpath = "//a[normalize-space()='Orders']")
    WebElement orders;

    //Addresses
    @FindBy(xpath = "//a[normalize-space()='Addresses']")
    WebElement addresses;

    //Shopping cart
    @FindBy(xpath = "//a[normalize-space()='Shopping cart']")
    WebElement shoppingCart;

    //Wishlist
    @FindBy(xpath = "//a[normalize-space()='Wishlist']")
    WebElement wishlist;

    //Apply for vendor account applyForVendorAccount
    @FindBy(xpath = "//a[normalize-space()='Apply for vendor account']")
    WebElement applyForVendorAccount;

    // *************New online store is open*****************
    //New online store is open!
    @FindBy(xpath = "//a[normalize-space()='New online store is open!']")
    WebElement newOnlineStoreIsOpen;

    // Title field
    @FindBy(xpath = "//input[@id='AddNewComment_CommentTitle']")
    WebElement titleOnlineStoreIsOpenField;

    // Comment Field
    @FindBy(xpath = "//textarea[@id='AddNewComment_CommentText']")
    WebElement commentOnlineStoreIsOpenField;

    //add-comment button
    @FindBy(xpath = "//button[@name='add-comment']")
    WebElement newCommentOnlineStoreIsOpenButton;

    // ************* nopCommerce new release! *****************
    //nopCommerce new release!
    @FindBy(xpath = "//a[normalize-space()='nopCommerce new release!']")
    WebElement newRelease;

    //Release Title
    @FindBy(xpath = "//input[@id='AddNewComment_CommentTitle']")
    WebElement newReleaseTitleField;

    //Release Comment field
    @FindBy(xpath = "//textarea[@id='AddNewComment_CommentText']")
    WebElement newReleaseCommentField;

    // Comment button
    @FindBy(xpath = "//button[@name='add-comment']")
    WebElement newReleaseCommentButton;

    // to see apple products
    // click book
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Books']")
    WebElement book;
    // click Apple
    @FindBy(xpath = "//a[normalize-space()='Apple']")
    WebElement apple;
    //------------------------------------------------------------
    //HP
    @FindBy(xpath = "//a[normalize-space()='HP']")
    WebElement hp;


    //----------------------------------------------------------------------
    // *********************************( Methods )****************************
    // ----------------------------------------------------------------------

    //*************Information**************
    //Sitemap
    public void clickOnSitemap() {
        clickOn(sitemap);
        log.info(" Click On sitemap successfully");
    }

    // Shipping & returns
    public void clickOnShippingAndReturns() {
        clickOn(shippingAndReturns);
        log.info(" Click On Shipping & returns successfully");
    }

    //Privacy notice
    public void clickOnPrivacyNotice() {
        clickOn(privacyNotice);
        log.info(" Click On Privacy notice  successfully");
    }

    //Conditions of Use conditionsOfUse
    public void clickOnConditionsOfUse() {
        clickOn(conditionsOfUse);
        log.info(" Click On Conditions of Use successfully");
    }

    //About us
    public void clickOnAboutUs() {
        clickOn(aboutUs);
        log.info(" Click On About us successfully");
    }

    //Contact us contactUs
    public void clickOnContactUs() {
        clickOn(contactUs);
        log.info(" Click On Contact us successfully");
    }

    //****************Customer service*************
    //Search
    public void clickOnSearch() {
        clickOn(search);
        log.info(" Click On Search successfully");
    }

    //News
    public void clickOnNews() {
        clickOn(news);
        log.info(" Click On News successfully");
    }

    //Blog
    public void clickOnBlog() {
        clickOn(blog);
        log.info(" Click On blog successfully");
    }

    //Recently viewed products
    public void clickOnRecentlyViewedProducts() {
        clickOn(recentlyViewedProducts);
        log.info(" Click On Recently viewed products successfully");
    }

    //Compare products list
    public void clickOnCompareProductsList() {
        clickOn(compareProductsList);
        log.info(" Click On Compare products list successfully");
    }

    //New products newProducts
    public void clickOnNewProducts() {
        clickOn(newProducts);
        log.info(" Click On new Products successfully");
    }

    //*************My account*******************

    //My account myAccount
    public void clickOnMyAccount() {
        clickOn(myAccount);
        log.info(" Click on my Account successfully");
    }

    //Orders
    public void clickOnOrders() {
        clickOn(orders);
        log.info(" Click on Orders successfully");
    }

    //Addresses
    public void clickOnAddresses() {
        clickOn(addresses);
        log.info(" Click on Addresses successfully");
    }

    //Shopping cart shoppingCart
    public void clickOnShoppingCart() {
        clickOn(shoppingCart);
        log.info(" Click on shopping Cart successfully");
    }

    //Wishlist
    public void clickOnWishlist() {
        clickOn(wishlist);
        log.info(" Click on Wishlist successfully");
    }

    //Apply for vendor account applyForVendorAccount
    public void clickOnApplyForVendorAccount() {
        clickOn(applyForVendorAccount);
        log.info(" Click on apply For Vendor Account successfully");
    }

    // *************New online store is open******************
    //New online store is open!
    public void clickOnNewOnlineStoreIsOpen() {
        clickOn(newOnlineStoreIsOpen);
        log.info("Click on new Online Store Is Open successfully");
    }

    // Title field
    public void typeOnTitleOnlineStoreIsOpenField(String typeTitle) {
        type(titleOnlineStoreIsOpenField, typeTitle);
        log.info("Type title successfully");
    }

    // Comment Field
    public void typeOnCommentOnlineStoreIsOpenField(String typeComment) {
        type(commentOnlineStoreIsOpenField, typeComment);
        log.info("Type comment successfully");
    }

    //add-comment button
    public void clickOnNewCommentOnlineStoreIsOpenButton() {
        clickOn(newCommentOnlineStoreIsOpenButton);
        log.info("Click on new Online new comment button successfully");
    }

    // ************* nopCommerce new release! ***********
    //nopCommerce new release!
    public void clickOnNewRelease() {
        clickOn(newRelease);
        log.info("Click successfully");
    }
    //Release Title
    public void typeOnNewReleaseTitleField(String typeTitle) {
        type(newReleaseTitleField, typeTitle);
        log.info("Type Title successfully");
    }
    //Release Comment field
    public void typeOnNewReleaseCommentField(String typeComment) {
        type(newReleaseCommentField, typeComment);
        log.info("Type Comment successfully");
    }
    // Comment button
    public void clickOnNewReleaseCommentButton() {
        clickOn(newReleaseCommentButton);
        log.info("Click successfully");
    }
    public void clickOnBook() {
        clickOn(book);
        log.info("Click on book successfully");
    }
    public void clickOnApple() {
        clickOn(apple);
        log.info("Click on Apple successfully");
    }
    public void clickOnHp() {
        clickOn(hp);
        log.info(" Click On HP successfully");
    }
}

