package finalProject.pages.nopcommerce;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApparelPage extends CommonAPI {
    Logger log = LogManager.getLogger(ApparelPage.class.getName());

    public ApparelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //----------------------------------------------------------------------
    // *********************************( Locators )****************************
    // ----------------------------------------------------------------------



    //click on Apparel
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Apparel']")
    WebElement apparelLink;

    // click on shoes
    @FindBy(xpath = "//a[@title='Show products in category Shoes'][normalize-space()='Shoes']")
    WebElement shoesLink;

    // click on 80's runner shoes
    @FindBy(xpath = "//h2[@class='product-title']//a[contains(text(),'adidas Consortium Campus 80s Running Shoes')]")
    WebElement runner80sShoesLink;

    // Click on Select size
    @FindBy(css ="#product_attribute_9")
    WebElement select80sShoesSizeLink;

    // Select 9 Size
    @FindBy(xpath ="//option[normalize-space()='9']")
    WebElement select80sShoesSize9;

    //Select color red
    @FindBy(xpath ="//span[@title='Red']//span[@class='attribute-square']")
    WebElement select80sRedColor;

    //Select color blue
    @FindBy(xpath ="//span[@title='Blue']//span[@class='attribute-square']")
    WebElement select80sBlueColor;

    //Select color silver
    @FindBy(xpath ="//span[@title='Silver']//span[@class='attribute-square']")
    WebElement select80sSilverColor;

    //Select color red shoes image
    @FindBy(xpath ="//div[@class='product-essential']//a[1]//img[1]")
    WebElement redShoesImage;

    //Image close x sign
    @FindBy(xpath ="//button[@title='Close (Esc)']")
    WebElement imageCloseXSign;

    // 80's running shoes validation  RunningShoes80sValidation
    @FindBy(css ="#price-value-25")
    WebElement runningShoes80sValidation;

    // *************************Apparel Methods*******************************
    //Click on  apparel link
    public void clickOnApparelLink() {
        clickOn(apparelLink);
        log.info(" Click apparel Link successfully.");
    }
    // click on shoes
    public void clickOnShoesLink() {
        clickOn(shoesLink);
        log.info(" Click shoes Link successfully.");
    }
    // click on 80's runner shoes
    public void clickOnRunner80sShoesLink() {
        clickOn(runner80sShoesLink);
        log.info(" Click runner 80s Shoes Link successfully.");
    }
    // Click on Select size
    public void clickOnSelect80sShoesSizeLink() {
        clickOn(select80sShoesSizeLink);
        log.info("Click on select 80s Shoes Size Link successfully.");
    }
    // Select 9 Size
    public void clickOnSelect80sShoesSize9() {
        clickOn(select80sShoesSize9);
        log.info("Click on select 80s Shoes Size 9 successfully.");
    }

    //Select color red select80sRedColor
    public void clickOnSelect80sRedColor() {
        clickOn(select80sRedColor);
        log.info("Click on Red color successfully.");
    }
    //Select color blue select80sBlueColor
    public void clickOnSelect80sBlueColor() {
        clickOn(select80sBlueColor);
        log.info("Click on Blue color successfully.");
    }

    //Select color silver select80sSilverColor
    public void clickOnSelect80sSilverColor() {
        clickOn(select80sSilverColor);
        log.info("Click on Silver color successfully.");
    }
    //Select color red shoes image redShoesImage
    public void clickOnRedShoesImage() {
        clickOn(redShoesImage);
        log.info("Click red Shoes Image successfully.");
    }
    //Image close x sign  imageCloseXSign
    public void clickOnImageCloseXSign() {
        clickOn(imageCloseXSign);
        log.info("Click image Clos X Sign successfully.");
    }
    // 80's running shoes validation
    public String runningShoes80sValidationText() {
        String text = getElementText(runningShoes80sValidation);
        log.info("Running Shoes 80s Validation success");
        return text;
    }
}
