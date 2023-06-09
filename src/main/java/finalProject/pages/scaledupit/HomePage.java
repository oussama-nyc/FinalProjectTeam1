package finalProject.pages.scaledupit;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class HomePage extends CommonAPI {
        Logger log = LogManager.getLogger(HomePage.class.getName());

        public HomePage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }
//    @FindBy(css = ".custom-logo")
//    WebElement mainHeader;

        @FindBy(xpath = "//a[text()='Logout']")
        WebElement logoutLink;

        @FindBy(xpath = "//a[text()='Login/Register']")
        WebElement SignInButton;

        @FindBy(css = "#wp-block-search__input-1")
        WebElement searchField;

        @FindBy(css = ".search-icon")
        WebElement searchButton;

        @FindBy(xpath = "//li[@id='menu-item-308']/a[1]")
        WebElement shopButton;
        @FindBy(xpath = "//a[@href='https://automation.scaledupit.com/blog/']")
        WebElement blogButton;

        @FindBy(css = ".fa.fa-angle-down.angle-down")
        WebElement categoriesButton;

        @FindBy(xpath = "//li[@id='menu-item-295']/a[1]")
        WebElement foodAndBeverageButton;

        @FindBy(xpath = "//a[text()='Clothing']")
        WebElement clothingButton;

        @FindBy(xpath = "//li[@id='menu-item-309']/a[1]")
        WebElement hoddiesButton;

        @FindBy(xpath = "//li[@id='menu-item-297']/a[1]")
        WebElement menCollectionButton;
        @FindBy(xpath = "//a[@class='my-account']")
        WebElement myAccountbutton;

        @FindBy(css = ".fa.fa-instagram")
        WebElement instagramPagebutton;

        @FindBy(css = ".fa.fa-shopping-cart")
        WebElement cartButton;
        @FindBy(css = ".woocommerce-loop-product__title")
        WebElement kidsCollectionBtn;

        @FindBy(xpath = "//li[@class='product type-product post-211 status-publish instock product_cat-featured-beside has-post-thumbnail shipping-taxable purchasable product-type-simple']/a[2]")
        WebElement addKidsToCartButton;

        @FindBy(xpath = "//select[@name='orderby']")
        WebElement clickOnDefaultSorting;

        @FindBy(xpath = "//select[@name='orderby']")
        WebElement clickOnSortByLast;

        @FindBy(css = "//div[@class='header-right']//i[@class='fa fa-facebook']")
        WebElement clickOnFaceBookButton;

        public void clickOnSignInButton() {
            clickOn(SignInButton);
            log.info("click on Register/Login button success");
        }

        public void ClickOnLogoutLink() {
            clickOn(logoutLink);
            log.info("click on logout link success");
        }

        public void typeItemToSearch(String item) {
            type(searchField, item);
            log.info("item name type success");
        }

        public void clickOnSearchButton() {
            clickOn(searchButton);
            log.info("click on  search button  success");
        }

        public void clickOnShopButton() {
            clickOn(shopButton);
            log.info("click on shop button  success");
        }

        public void clickOnBlogButton() {
            clickOn(blogButton);
            log.info("click on blog button  success");
        }

        public void hoverOverOnCategoriesButton(WebDriver driver) {
            Actions actions = new Actions(driver);
            actions.moveToElement(categoriesButton).build().perform();
            log.info("hover over on categories success");
        }

        public void clickOnFoodAndBeverageButton() {
            clickOn(foodAndBeverageButton);
            log.info("click on food and beverage  success");
        }

        public void hoverOverOnClothingButton(WebDriver driver) {
            Actions actions = new Actions(driver);
            actions.moveToElement(clothingButton).build().perform();
            log.info("hover over on clothing button success");
        }

        public void clickOnHoddiesButton() {
            clickOn(hoddiesButton);
            log.info("click on hoddies button success");
        }

        public void clickOnMenCollection() {
            clickOn(menCollectionButton);
            log.info("click on  Men Collection button success");

        }

        public void clickOnMyAccountButton() {
            clickOn(myAccountbutton);
            log.info("click on my account  success");
        }

        public void clickOnInstagramButton() {
            clickOn(instagramPagebutton);
            log.info("click on instagram  success");
        }

        public void clickOnCartButton() {
            clickOn(cartButton);
            log.info("click on cart button success");
        }

        public boolean checkKidsCollectionButtonIsVisible() {
            boolean iskidsCollectionBtnVisible = isVisible(kidsCollectionBtn);
            log.info("kids Collection button is visible");
            return iskidsCollectionBtnVisible;
        }

        public void scrollToKidsBtnWCoordinates(WebDriver driver) {

            scrollByAmount(0, 1500);
        }

        public void scrollToKidsCollectionBtnwJS(WebDriver driver) {

            scrollToElement(kidsCollectionBtn, driver);
        }

        public void clickOnKidsCollectionJS(WebDriver driver) {
            clickWithJavascript(kidsCollectionBtn, driver);
        }

        public void clickOnaddKidsToCartButton() {
            clickOn(addKidsToCartButton);
            log.info("click on add kids Collection to cart success");
        }

        public void clearSearchField() {
            clear(searchField);
            log.info("clear search file success ");
        }

        public void clickOnFaceBookButton() {
            clickOn(clickOnFaceBookButton);
            log.info("click  success");

        }


        public void clickOnGuitar() {

        }
    }
