package finalProject.pages.luma;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonAPI {
    Logger LOG = LogManager.getLogger(HomePage.class.getName());

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //ELEMENTS
    @FindBy(css = "#search")
    WebElement searchField;

    @FindBy(xpath = "//button[@class='action search']")
    WebElement searchButton;

    @FindBy(xpath = "//a[@id='ui-id-4']")
    WebElement floatingMenu;

    @FindBy(xpath = "//li[@class='authorization-link']")
    WebElement loginButton;

    @FindBy(xpath = "//a[@id='ui-id-3']")
    WebElement whatsNewMenuItem;

    @FindBy(id = "newsletter")
    WebElement inputSubscribe;

    @FindBy(xpath = "//button[@class='action subscribe primary']")
    WebElement subscribeButton;

    @FindBy(xpath = "//div[@class='page messages']")
    WebElement subscribeMsg;

    @FindBy(xpath = "//div[@class='mage-error']")
    WebElement invalidEmailMsg;

    @FindBy(id = "toolbar-amount")
    WebElement itemResult;

    @FindBy(xpath = "//div[@class='message notice']")
    WebElement noResultMsg;

    @FindBy(linkText = "Contact Us")
    WebElement contactUsLink;


//    @FindBy(xpath = "//span[contains(text(), 'Jackets')]")
//    WebElement jackets;
//    public void clickJackets(){
//
//    }
    //span[contains(text(), 'Jackets')]

//    @FindBy(css = "#searchDropdownBox")
//    WebElement menuDropdown;

    //USEFUL METHODS
    public void typeInSearch(String item){
        type(searchField, item);
        LOG.info("item type success");
    }

    public void clickOnSearchButton(){
        clickOn(searchButton);
        LOG.info("click on search success");
    }

    public void searchItem(String item){
        typeTextEnter(searchField, item);
        LOG.info("type and enter in search bar success");
    }

//    public void selectOptionFromMenuDropdown(String option){
//        selectOptionFromDropdown(menuDropdown, option);
//        LOG.info(option + " option selected from the dropdown");
//    }

    public void hoverOverFloatingMenu(WebDriver driver){
        hoverOver( floatingMenu,driver);
        LOG.info("hover over menu success");
    }

    public void clickOnLoginButton(){
        clickOn(loginButton);
    }

    public void clickOnWhatsNewMenuItem(){
        clickOn(whatsNewMenuItem);
    }
    public void setInputSubscribe(String email){
        type(inputSubscribe,email);
        LOG.info("item type success");
    }
    public void clickOnSubscribe(){
        clickOn(subscribeButton);
    }
    public String getSubscribeMsg() throws InterruptedException {
        Thread.sleep(3000);
        return getElementText(subscribeMsg);
    }

    public String getInvalidEmailMsg() throws InterruptedException {
        Thread.sleep(2000);
        return getElementText(invalidEmailMsg);
    }

    public boolean isVisibleResult() throws InterruptedException {
        Thread.sleep(2000);
        return itemResult.isDisplayed();
    }

    public String getNoResultMsg() throws InterruptedException {
        Thread.sleep(1000);
        return getElementText(noResultMsg);
    }
    public void clickOnContactUs(){
        clickOn(contactUsLink);
    }





}
