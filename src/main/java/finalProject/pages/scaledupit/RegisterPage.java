package finalProject.pages.scaledupit;

import com.github.javafaker.Faker;
import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends CommonAPI {
    Logger log = LogManager.getLogger(RegisterPage.class.getName());


    public RegisterPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }
    Faker faker =new Faker();


    @FindBy(css = "#reg_email")
    WebElement emailField;
    @FindBy(css = "#reg_password")
    WebElement passwordField;
    @FindBy(xpath = "//button[text()='Register']")
    WebElement registerBtn;
    @FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']/p[1]")
    WebElement validUsPassRegisterPageHeader;
    @FindBy(xpath = "//ul[@class='woocommerce-error']/li[1]")
    WebElement validEmailErrorMessage;

    @FindBy(xpath = "//h1[text()='My account']")
    WebElement loginPageHeader;



    public void enterEmail(String username) {
        type(emailField, username);

        log.info("enter email address success");
    }

    public void enterPassword(String password) {
        type(passwordField, password);
        log.info("enter password success");
    }


    public void clickOnRegisterBtn() {
        clickOn(registerBtn);
        log.info("click on register  button success");

    }



    public boolean checkPresenceOfLoginPageHeader() {
        boolean loginPageHeaderIsDisplayed = isVisible(loginPageHeader);
        log.info("login page header presence " + loginPageHeaderIsDisplayed);
        return loginPageHeaderIsDisplayed;
    }

    public String getLoginPageHeadertext() {
        String loginPageHeaderText = getElementText(loginPageHeader);
        log.info("login page header text is " + loginPageHeaderText);
        return loginPageHeaderText;

    }
    public boolean checkPresenceOfValidUsernameErrorMessage() {
        boolean loginPageHeaderIsDisplayed = isVisible(validEmailErrorMessage);
        log.info("login page header presence " + loginPageHeaderIsDisplayed);
        return loginPageHeaderIsDisplayed;
    }
    public String getValidUsernameErrorMessage() {
        String text = getElementText(validEmailErrorMessage);
        log.info("get error message text success");
        return text;
    }
    public String enterNewFakeRegistrationEmail(){ return faker.internet().emailAddress(); }

    public String enterNewFakeRegistrationPassword(){ return faker.internet().password(); }
    public String entreNewFakeWeakPassword(){ return faker.internet().password(1,12,false,false,true);}
    public String entreNewFakeShortPassword(){ return faker.internet().password(9,10,true,true,true);}


}



