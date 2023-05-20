package finalProject.pages.nopcommerce;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends CommonAPI {
    Logger log = LogManager.getLogger(CheckOutPage.class.getName());

    public CheckOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    //click on Jewelry
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Jewelry']")
    WebElement jewelry;
    //scrollByAmount(0,150);

    //click flower Girl Bracelet;
    @FindBy(xpath = "//div[@class='products-wrapper']//div[2]//div[1]//div[2]//div[3]//div[2]//button[1]")
    WebElement flowerGirlBracelet;

    //click for Compare flower Girl Bracelet;
    @FindBy(xpath = "//div[@class='products-wrapper']//div[2]//div[1]//div[2]//div[3]//div[2]//button[1]")
    WebElement compareClowerGirlBracelet;

    //click for Compare Elegant Gemstone

    @FindBy(css = "body > div:nth-child(7) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > div:nth-child(2) > button:nth-child(2)")
    WebElement compareElegantGemstone;

    //product comparison
    @FindBy(xpath = "//a[normalize-space()='product comparison']")
    WebElement comparison;

    //click on add to cart
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement addToCart;

    //scrollByAmount(0,200);
    //click on agree check box
    @FindBy(xpath = "//input[@id='termsofservice']")
    WebElement agreeCheckBox;


    //click on  check out button
    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkOut;

    //click on  check out as a guest
    @FindBy(xpath = "//button[normalize-space()='Checkout as Guest']")
    WebElement checkOutAsAGuest;

    // scrollByAmount(0,150);

    //type all personal info
    @FindBy(xpath = "//input[@id='BillingNewAddress_FirstName']")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@id='BillingNewAddress_LastName']")
    WebElement lastNameField;

    //remove item
    @FindBy(xpath = " //button[@class='remove-btn']")
    WebElement removeItem;

    //Update Quantity
    @FindBy(xpath = " //input[@id='itemquantity11223']")
    WebElement updateQuantity;

    //update Cart
    @FindBy(xpath = " //button[@id='updatecart']")
    WebElement updateCart;

    //remove item validation
    @FindBy(xpath = "  //div[@class='no-data']")
    WebElement removeItemValidation;
    //Check out validation
    @FindBy(xpath = "//h2[normalize-space()='Billing address']")
    WebElement CheckOutValidation;

    // compare Validation

    @FindBy(xpath = "//h1[normalize-space()='Compare products']")
    WebElement compareValidation;

    //***************************************Methods*************************************************
    public void clickOnJewelry() {
        clickOn(jewelry);
        log.info(" Click On jewelry Link successfully.");
    }
    //flowerGirlBracelet

    public void clickOnFlowerGirlBracelet() {
        clickOn(flowerGirlBracelet);
        log.info(" Click On flowerGirlBracelet Link successfully.");
    }
    // compare Clower Gir lBracelet
    public void clickOnFlowerGirlBraceletCompare() {
        clickOn(compareClowerGirlBracelet);
        log.info(" Click On flowerGirlBracelet Link successfully.");
    }
    //click On compare Vintage Style EngagementRing
    public void clickOncomparecompareElegantGemstone() {
        clickOn(compareElegantGemstone);
        log.info(" Click On compare Vintage Style Engagement Ring Link successfully.");
    }
    //product comparison
    public void clickOnComparison() {
        clickOn(comparison);
        log.info(" Click On comparison Link successfully.");
    }
    //addToCart
    public void clickOnAddToCart() {
        clickOn(addToCart);
        log.info(" Click On addToCart successfully.");
    }

    //agreeCheckBox
    public void clickOnAgreeCheckBox() {
        clickOn(agreeCheckBox);
        log.info(" Click On agreeCheckBox successfully.");
    }

    //checkOut
    public void clickOnCheckOut() {
        clickOn(checkOut);
        log.info(" Click On checkOut successfully.");
    }

    //checkOutAsAGuest
    public void clickOnCheckOutAsAGuest() {
        clickOn(checkOutAsAGuest);
        log.info(" Click On checkOut successfully.");
    }

    //Shopping Cart Validation
    public String CheckOutValidation() {
        String text = getElementText(CheckOutValidation);
        log.info(" Check Out Validation validation successfully.");
        return text;


    }

    public void clickOnRemoveItem() {
        clickOn(removeItem);
        log.info(" Click On remove Item successfully.");
    }

    //removeItemValidation
    public void removeItemValidation() {
        clickOn(removeItemValidation);
        log.info(" remove Item successfully.");
    }
//updateQuantity
public void clickOnUpdateQty() {
    clickOn(updateQuantity);
    clear(updateQuantity);
    log.info(" remove Item successfully.");
}

    public void typeQuantity(String Qty) {
        type(updateQuantity, Qty);
        log.info(" Type Quantity successfully");
    }

    // updateCart
    public void clickOnUpdateButton() {
        clickOn(updateCart);
        log.info(" update Cart successfully.");
    }
        // compare Validation
    public String compareValidationText() {
        String text = getElementText(compareValidation);
        log.info("  Compare Validation succeeded");
        return text;
    }
}