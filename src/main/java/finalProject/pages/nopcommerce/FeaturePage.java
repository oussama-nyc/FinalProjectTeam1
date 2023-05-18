package finalProject.pages.nopcommerce;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeaturePage extends CommonAPI {
    Logger log = LogManager.getLogger(RegisterPage.class.getName());

    public FeaturePage(WebDriver driver) { PageFactory.initElements(driver, this);}

    //--------------------------------------------------------------------------------
    // ****************************************( Locators )***************************
    // -------------------------------------------------------------------------------

    @FindBy(xpath = "//span[@class='wishlist-label']")
    WebElement wishList;











    //--------------------------------------------------------------------------
// *********************************( Reusable Methods )**************************
// ------------------------------------------------------------------------------

}
