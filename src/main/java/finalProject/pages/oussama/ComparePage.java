package finalProject.pages.oussama;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComparePage extends CommonAPI {
    Logger log = LogManager.getLogger(ComparePage.class.getName());

    public ComparePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Locators )***************************************************
    // ---------------------------------------------------------------------------------------------------------------


    @FindBy(css = ".lead-title.text-center.cart-empty")
    WebElement comparePageIsEmptyText;

    @FindBy(xpath = "//h3[contains(text(),'Tablet Thin EliteBook')]")
    WebElement tabletThinEliteBookRevolveTitle;

    @FindBy(xpath = "//h3[normalize-space()='Smartphone 6S 128GB LTE']")
    WebElement smartPhoneLTETitle;

    @FindBy(xpath = "//tbody/tr/td[1]/a[1]/i[1]")
    WebElement RemoveProductFromTheComparePageIcon;


    //----------------------------------------------------------------------------------------------------------------
    // ****************************************( Reusable Methods )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    public String getComparePageIsEmptyText() {
        String text = getElementText(comparePageIsEmptyText);
        log.info("The Compare page is empty");
        return text;
    }

    public String getTabletThinEliteBookRevolveTitle() {
        String text = getElementText(tabletThinEliteBookRevolveTitle);
        return text;
    }

    public String getSmartPhoneLTETitle() {
        String text = getElementText(smartPhoneLTETitle);
        return text;
    }

    public void clickOnToRemoveProductFromTheComparePage(WebDriver driver) {
        scrollToElement(RemoveProductFromTheComparePageIcon,driver);
        waitFor(1);
        clickOn(RemoveProductFromTheComparePageIcon);
        log.info("Product are successfully removed from the Compare page.");
    }

}
