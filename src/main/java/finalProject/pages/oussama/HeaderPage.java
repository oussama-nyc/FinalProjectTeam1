package finalProject.pages.oussama;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends CommonAPI {
    Logger log = LogManager.getLogger(HeaderPage.class.getName());

    public HeaderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Locators )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "//a[@title='My Account']")
    WebElement myAccountLink;

    @FindBy(css = "a[href='https://www.oussama-achour.com/contact-us/']")
    WebElement contactUsPageLink;

    @FindBy(css = "a[title='Stores']")
    WebElement storesLink;

    @FindBy(css = "a[class='dropdown-toggle'] i[class='ec ec-user']")
    WebElement myAccountIcon;

    @FindBy(xpath = "//li[@class='menu-item']//a[contains(text(),'Logout')]")
    WebElement logoutLink;

    @FindBy(css = "li[id='menu-item-4099'] a[title='Shop']")
    WebElement shopLink;

    @FindBy(css = "#search")
    WebElement searchBar;

    @FindBy(css = "a[title='Track Your Order']")
    WebElement trackYourOrderLink;

    @FindBy(css = ".ec.ec-compare")
    WebElement compareIcon;

    //----------------------------------------------------------------------------------------------------------------
    // ****************************************( Reusable Methods )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    public void clickOnMyAccountIcon() {
        clickOn(myAccountIcon);
        log.info("The My Account page opened successfully.");
    }

    public void clickOnShopLink() {
        clickOn(shopLink);
        log.info("The Shop page opened successfully.");
    }


    public void hoverOverAndClickOnLogoutLink(WebDriver driver) {
        hoverOverAndClickOn(driver,logoutLink);
        log.info("click on logout link success");
    }

    public void typeOnSearchBar(String yourSearchTerm) {
        type(searchBar,yourSearchTerm);
        log.info("The search query is entered correctly and without any errors.");
    }

    public void pressEnterOnSearchBar() {
        pressKey(searchBar,Keys.ENTER);
        log.info("The search feature returns relevant results without any errors.");
    }
    public void clickOnTrackYourOrderLink() {
        clickOn(trackYourOrderLink);
        log.info("The  Track Your Order page opened successfully.");
    }

    public void clickOnMyAccountLink() {
        clickOn(myAccountLink);
        log.info("The My Account page opened successfully.");
    }

    public void clickOnContactUsLink() {
        clickOn(contactUsPageLink);
        log.info("The contact us page opened successfully.");
    }

    public void clickOnStoresLink() {
        clickOn(storesLink);
        log.info("The stores page opened successfully.");
    }

    public void clickOnCompareIcon() {
        clickOn(compareIcon);
        log.info("The Compare page is open and displayed on the screen Successfully");
    }
}
