package finalProject.pages.nopcommerce;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
public class HomePage extends CommonAPI {
    Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage(WebDriver driver) {PageFactory.initElements(driver, this);}

    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Locators )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "//a[@class='ico-register']")
    WebElement registerLink;



    //----------------------------------------------------------------------------------------------------------------
    // ****************************************( Reusable Methods )***************************************************
    // ---------------------------------------------------------------------------------------------------------------


    public void clickOnRegisterLink() {
        clickOn(registerLink);
        log.info("The Register page opened successfully.");
    }


    public void typeItemAndClickSearch(String itemName) {
    }

}