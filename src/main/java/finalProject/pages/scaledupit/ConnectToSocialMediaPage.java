package finalProject.pages.scaledupit;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConnectToSocialMediaPage extends CommonAPI {

    Logger log = LogManager.getLogger(ProductSearchPage.class.getName());

    public ConnectToSocialMediaPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='header-right']//i[@class='fa fa-facebook']")
    WebElement clickOnFaceBookButton;

    @FindBy(xpath = "//div[@class='header-right']//i[@class='fa fa-camera-retro']")
    WebElement clickOnSnapChatButton;

    public void clickOnFaceBookButton() {
        clickOn(clickOnFaceBookButton);
        log.info("click  success");
    }

    public void clickOnSnapChatButton() {
        clickOn(clickOnSnapChatButton);
        log.info("click  success");
    }
}