package finalProject.pages.luma;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(HomePage.class.getName());

    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //WebElement

    @FindBy(id = "name")
    WebElement inputName;

    @FindBy(id = "email")
    WebElement inputEmail;

    @FindBy(id = "comment")
    WebElement inputComment;

    @FindBy(xpath = "//button[@title='Submit']")
    WebElement submitButton;

    @FindBy(xpath = "//div[@role='alert']")
    WebElement sentMsg;

    @FindBy(id = "email-error")
    WebElement invalidEmailMsg;


    public void setInputName(String name){
        type(inputName,name);
    }
    public void setInputEmail(String email){
        type(inputEmail,email);
    }
    public void setInputComment(String comment){
        type(inputComment,comment);
    }
    public void clickOnSubmitButton(){
        clickOn(submitButton);
    }

    public String getSentMsg() throws InterruptedException {
        Thread.sleep(2000);
        return getElementText(sentMsg);
    }

    public String getInvalidEmailMsg() throws InterruptedException {
        Thread.sleep(2000);
        return getElementText(invalidEmailMsg);
    }

}
