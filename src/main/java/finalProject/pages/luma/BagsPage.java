package finalProject.pages.luma;


import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BagsPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(BagsPage.class.getName());

    public BagsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //Elements
    @FindBy(xpath = "//div[@id='authenticationPopup']/following-sibling::div/following-sibling::div//ol//li")
    WebElement pushItMessengerBag;

    @FindBy(xpath = "//form[@data-product-sku='24-WB04']")
    WebElement MessengerBagAddToCart;

    @FindBy(xpath = "//ol[@class='products list items product-items']//li//a[@class='action towishlist']")
    WebElement addMessengerBagToWishList;

    //useful methods
    public void addMessengerBagToCart(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(pushItMessengerBag).build().perform();

        clickOn(MessengerBagAddToCart);
    }
    public void addMessengerBagToWishList(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(pushItMessengerBag).build().perform();
        clickOn(addMessengerBagToWishList);
    }

}
