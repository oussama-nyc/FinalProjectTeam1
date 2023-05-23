package finalProject.pages.luma;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenHoodieSweatshirtPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(WomenHoodieSweatshirtPage.class.getName());

    public WomenHoodieSweatshirtPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    WebElement SizeStatus;

    //ELEMENTS
    @FindBy(xpath = "//button[@title='Add to Cart']")
    WebElement addToCart;

    @FindBy(xpath = "//div[@class=\"products wrapper grid products-grid\"]//ol//li//div//div//div[2]//div//div//div[3]")
    WebElement mediumSize;

    @FindBy (xpath = "//div[@class=\"products wrapper grid products-grid\"]//ol//li//div//div//div[2]//div[@class=\"swatch-attribute color\"]//div[2]")
    WebElement greenColor;

    //USEFUL METHODS
    public void clickOnMediumSize(){
        clickOn(mediumSize);
    }

    public boolean getSizeStatus(){

        String status = mediumSize.getAttribute("aria-checked");

        if(status.equalsIgnoreCase("true")){
            return true;
        }
        return false;
    }

    public void clickOnGreenColor(){
        clickOn(greenColor);
    }

    public boolean getColorStatus(){

        String status = greenColor.getAttribute("aria-checked");

        if(status.equalsIgnoreCase("true")){
            return true;
        }
        return false;
    }

    public void clickAddToCart(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(greenColor).build().perform();

        clickOn(addToCart);

    }
}
