package finalProject.pages.nopcommerce;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectronicsPage extends CommonAPI {
    Logger log = LogManager.getLogger(ElectronicsPage.class.getName());

    public ElectronicsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //*********************** Locators************************************

    //click on Electronics link
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']")
    WebElement electronicsLink;

    //click on Electronics link k
    @FindBy(xpath = "//img[@title='Show products in category Cell phones']")
    WebElement cellPhoneLink;

    // Click on Nokia Lumia 1020
    @FindBy(xpath = "//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]")
    WebElement nokiaLumiaLink;

    // Click on Phone's Photo
    @FindBy(css = "#main-product-img-20")
    WebElement nokiaPhoto;

    // close the photo
    @FindBy(xpath = "//button[@title='Close (Esc)']")
    WebElement closeThePhotoXSign;

    // click on Nokia add to cart

    @FindBy(css = "#add-to-cart-button-20")
    WebElement nokiaAddToCartButton;

    //shopping cart link
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement nokiaAddToShoppingCart;

    //Click Check Box nokiaClickCheckBox
    @FindBy(xpath = "//input[@id='termsofservice']")
    WebElement nokiaClickCheckBox;

    // click check-out button nokiaClickOutButton
    @FindBy(xpath = "//button[@id='checkout']")
    WebElement nokiaClickOutButton;

    // Click on Register Button nokiaClickOnRegisterButton
    @FindBy(xpath = "//button[normalize-space()='Register']")
    WebElement nokiaClickOnRegisterButton;

//*********************** Methods************************************
    //click on Electronics link
    public void clickOnElectronicsLink() {
        clickOn(electronicsLink);
        log.info("Click on Electronics Link successfully.");
    }
    //click on Electronics link cellPhoneLink
    public void clickOnCellPhoneLink() {
        clickOn(cellPhoneLink);
        log.info("Click Cell phone Link successfully.");
    }
    // Click on Nokia Lumia 1020
    public void clickOnNokiaLumiaLink() {
        clickOn(nokiaLumiaLink);
        log.info("Click Nokia Lumia Link successfully.");
    }
    // Click on Phone's Photo
    public void clickOnNokiaPhoto() {
        clickOn(nokiaPhoto);
        log.info("Click Nokia Photo successfully.");
    }
    // close the photo closeThePhotoXSign
    public void clickOnCloseThePhotoXSign() {
        clickOn(closeThePhotoXSign);
        log.info("Click on close sign successfully.");
    }
    // click on Nokia add to cart
    public void clickOnNokiaAddToCartButton() {
        clickOn(nokiaAddToCartButton);
        log.info("Click on Add To Cart Button successfully.");
    }
    //shopping cart link
    public void clickOnNokiaAddToShoppingCart() {
        clickOn(nokiaAddToShoppingCart);
        log.info("Click on Add To Shopping Cart Button successfully.");
    }
    //Click Check Box
    public void clickOnNokiaClickCheckBox() {
        clickOn(nokiaClickCheckBox);
        log.info("Click on nokia Check Box successfully.");
    }
    // click check-out button
    public void clickOnNokiaClickOutButton() {
        clickOn(nokiaClickOutButton);
        log.info("Click on nokia Check-out button successfully.");
    }
    // Click on Register Button
    public void clickOnNokiaClickOnRegisterButton() {
        clickOn(nokiaClickOnRegisterButton);
        log.info("Click on Register Button successfully.");
    }

}
