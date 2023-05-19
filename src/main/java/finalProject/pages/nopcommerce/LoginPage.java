package finalProject.pages.nopcommerce;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonAPI {
    Logger log = LogManager.getLogger(RegisterPage.class.getName());

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    //--------------------------------------------------------------------------------
    // ****************************************( Locators )***************************
    // -------------------------------------------------------------------------------
    //Login Button
    @FindBy(xpath = "//a[normalize-space()='Log in']")
    WebElement loginLink;

    //Login Username Field
    @FindBy(xpath = "//input[@id='Email']")
    WebElement loginUsernameField;

    //Login password Field
    @FindBy(xpath = "//input[@id='Password']")
    WebElement loginPasswordField;

    //click on login button

    @FindBy(xpath = "//button[normalize-space()='Log in']")
    WebElement LoginButton;

    // Login validation
    @FindBy(xpath = "//a[@class='ico-logout']")
    WebElement loginValidation;

    // Logout button
    @FindBy(xpath = "//a[@class='ico-logout']")
    WebElement LogOutButton;


//--------------------------------------------------------------------------
// *********************************( Reusable Methods )**************************
// ------------------------------------------------------------------------------

    //Login Button
    public void clickOnLoginLink() {
        clickOn(loginLink);
        log.info(" Click On LoginLink successfully.");

    }

    //type username
    public void typeUsername(String username) {
        type(loginUsernameField, username);
        log.info(" Type username successfully");
    }

    //type password
    public void typePassword(String password) {
        type(loginPasswordField, password);
        log.info(" Type password successfully");
    }

    //    Click on login button
    public void clickOnLoginButton() {
        clickOn(LoginButton);
        log.info(" Click On LoginButton successfully");
    }

    // Login   Validation
    public String loginValidationText() {
        String text = getElementText(loginValidation);
        log.info("  login Validation successfully");
        return text;
    }

    public void clickOnLogOutButton() {
        clickOn(LogOutButton);
        log.info(" Click On LogOutButton successfully");
    }
}