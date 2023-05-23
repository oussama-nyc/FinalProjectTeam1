package finalProject.pages.luma;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FitnessEquipmentPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(FitnessEquipmentPage.class.getName());

    public FitnessEquipmentPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //ELEMENTS
    @FindBy(xpath = "//div[@id='authenticationPopup']/following-sibling::div/following-sibling::div//ol//li/following-sibling::li/following-sibling::li/following-sibling::li")
    WebElement spriteFoamRoller;

    @FindBy(xpath = "//form[@data-product-sku='24-WG088']")
    WebElement spriteFoamRollerAddToCart;

    //USEFUL METHODS
    public void clickOnSpriteFoamRoller(){
        clickOn(spriteFoamRoller);
    }
    public void addSpriteFoamRollerToCart(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(spriteFoamRoller).build().perform();
        clickOn(spriteFoamRollerAddToCart);

    }
}
