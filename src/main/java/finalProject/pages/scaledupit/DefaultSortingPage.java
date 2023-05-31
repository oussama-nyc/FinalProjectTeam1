package finalProject.pages.scaledupit;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DefaultSortingPage extends CommonAPI {
    Logger log = LogManager.getLogger(ProductSearchPage.class.getName());

    public DefaultSortingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//li[@id='menu-item-297']//a[normalize-space()='Men Collection']")
    WebElement clickOnMenCollection;


    @FindBy(xpath = "//select[@name='orderby']")
    WebElement clickOnDefaultSorting;

    @FindBy(css = "select[name='orderby']")
    WebElement selectOption;

    @FindBy(css = "a[aria-label='Add “Belt” to your cart']")
    WebElement addBeltToYourCart;


    public void clickOnMenCollection() {
        clickOn(clickOnMenCollection);
        log.info("click on Register/Login button success");
    }

    public void clickOnDefaultSorting() {
        clickOn(clickOnDefaultSorting);
        log.info("click success");
    }

    public void ClickOnSortByLast() {
        clickOn(clickOnDefaultSorting);
        log.info("click success");

    }

    public void selectOption() {
        selectOptionFromDropDown(selectOption,"popularity");
        log.info(" success");

    }

    public void addBeltToYourCart (WebDriver driver) {
        scrollToElement(addBeltToYourCart,driver);
        clickOn(addBeltToYourCart);

        log.info(" success");

    }
}


