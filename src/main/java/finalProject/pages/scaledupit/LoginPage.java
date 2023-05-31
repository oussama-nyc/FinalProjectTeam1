package finalProject.pages.scaledupit;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage extends CommonAPI {
    Logger log = LogManager.getLogger(LoginPage.class.getName());

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //objects
    @FindBy(css = "#username")
    WebElement usernameField;

    @FindBy(css = "#password")
    WebElement passwordField;

    @FindBy(css = "#reg_email")
    WebElement emailField;

    @FindBy(css = "#reg_password")
    WebElement passwordregField;


    @FindBy(xpath = "(//input[@name='_wp_http_referer']//preceding::button)[2]")
    WebElement LoginButton;

    @FindBy(xpath = "//div[@class='woocommerce-notices-wrapper']")
    WebElement ErrorMessage;

    @FindBy(xpath = "//button[@name='register']")
    WebElement RegisterButton;
    @FindBy(xpath = "//span[text()='Home']")
    WebElement homeButton;
    @FindBy(xpath = "//li[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--customer-logout']")
    WebElement logOutButton;


    //reusable methods
    public void typeusername(String username) {
        type(usernameField, username);
        log.info("type username success");
    }

    public void typepassword(String password) {
        type(passwordField, password);
        log.info("type password success");
    }

    public void clickOnLoginButton() {
        clickOn(LoginButton);
        log.info("click Login button success");
    }

    public void typeEmailAddress(String EmailAddress) {
        type(emailField, EmailAddress);
        log.info("type EmailAddress success");
    }

    public void typepasswordRegister(String passwordRegister) {
        type(passwordregField, passwordRegister);
        log.info("type password success");
    }

    public void clickOnRegisterButton() {
        clickOn(RegisterButton);
        log.info("click Login button success");
    }

    public String getErrorMessage() {
        return getTextFromElement(ErrorMessage);
        //LOG.info("error message success");

    }

    public void clickOnHomeButton() {
        clickOn(homeButton);
        log.info("click Home button success");
    }

    public void clickOnLogOut() {
        clickOn(logOutButton);
        log.info("click log out button success");
    }
}