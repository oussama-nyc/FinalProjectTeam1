package finalProject.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import finalProject.utility.Utility;

public class CommonAPI {
    Logger log = LogManager.getLogger(CommonAPI.class.getName());

    Properties prop = Utility.loadProperties();
    String browserstackUsername = prop.getProperty("browserstack.username");
    String browserstackPassword = prop.getProperty("browserstack.password");
    String implicitWait = prop.getProperty("implicit.wait","5");
    String windowMaximize = prop.getProperty("browser.maximize","true");
    String takeScreenshots = prop.getProperty("take.screenshots","false");


    public void getCloudDriver(String envName, String os, String osVersion, String browserName, String browserVersion, String username, String password) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("os", os);
        cap.setCapability("os_version", osVersion);
        cap.setCapability("browser", browserName);
        cap.setCapability("browser_version", browserVersion);
        if (envName.equalsIgnoreCase("browserstack")){
            cap.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("http://"+username+":"+password+"@hub-cloud.browserstack.com:80/wd/hub"),cap);
        } else if (envName.equalsIgnoreCase("saucelabs")) {
            driver = new RemoteWebDriver(new URL("http://"+username+":"+password+"@ondemand.saucelabs.com:80/wd.hub"),cap);
        }
    }

    public void getLocalDriver(String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
            log.info("chrome browser open success");
        }else if (browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            log.info("firefox browser open success");
        }else if (browserName.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
            log.info("edge browser open success");
        }
    }

    @Parameters({"useCloudEnv","envName","os","osVersion","browserName","browserVersion","url"})
    @BeforeMethod
    public void setUp(@Optional("false") String useCloudEnv, @Optional("browserstack") String envName, @Optional("windows") String os,
                      @Optional("10") String osVersion, @Optional("chrome") String browserName, @Optional("110") String browserVersion,
                      @Optional("https://www.google.com") String url) throws MalformedURLException {
        if (useCloudEnv.equalsIgnoreCase("true")){
            getCloudDriver(envName,os,osVersion,browserName,browserVersion,browserstackUsername,browserstackPassword);
        } else if(useCloudEnv.equalsIgnoreCase("false")){
            getLocalDriver(browserName);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(implicitWait)));

        if (windowMaximize.equalsIgnoreCase("true")){
            driver.manage().window().maximize();
        }

        driver.get(url);
    }
    @AfterMethod
   public void tearDown(){
        //close browser
       driver.quit();
      log.info("browser close success");
  }

    WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                              selenium methods
    //------------------------------------------------------------------------------------------------------------------.
    public String getCurrentTitle(){
        return driver.getTitle();
    }

    public String getElementText(WebElement element){
            return element.getText();
    }

    public void clickOn(WebElement element){
            element.click();
    }

    public void type(WebElement element, String text){
            element.sendKeys(text);
    }
    public void hoverOver(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
    public void hoverOverAndClickOn(WebDriver driver,WebElement element){

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    public void waitFor(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isVisible(WebElement element){
            return element.isDisplayed();
    }

    public boolean isInteractible(WebElement element){
            return element.isEnabled();
    }

    public boolean isChecked(WebElement element){
            return element.isSelected();
    }


    //------------------------------------------------------------------------------------------------------------------
    //                                          selenium methods added by OUSSAMA
    //------------------------------------------------------------------------------------------------------------------.


    // scroll Page By Amount
    public void scrollByAmount(int x,int y) {
        Actions actions = new Actions(driver);
        actions.scrollByAmount(x, y).perform();
        log.info("Successfully scrolled down the page");
    }

    // clear field
    public void clear(WebElement element){
             element.clear();
    }

    // press Key
    public void pressKey(WebElement element, Keys key) {
            element.sendKeys(key);
    }

    // Move Slider
    public void moveSlider(WebElement element, int xOffset, int yOffset) {
        WebElement slider = element;
        Actions builder = new Actions(driver);
        builder.clickAndHold(slider);
        builder.moveByOffset(xOffset, yOffset).build().perform();
        builder.release().build().perform();
    }

    // Select Option From DropDown
    public void selectOptionFromDropDown(WebElement element, String value){
        WebElement dropdown = element;
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    //Switch to the specified tab by index
    public void switchToTab(int index) {
        // Get a list of all the open window handles
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        // Switch to the specified tab by index
        driver.switchTo().window(tabs.get(index));
    }

    //Switch To Currently Active Window
    public void switchToCurrentlyActiveWindow() {
        // Get the handle of the currently active window
        String currentHandle = driver.getWindowHandle();
        // Loop through all the open windows and switch to the next one
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(currentHandle)) {
                driver.switchTo().window(handle);
                return;
            }
        }
    }
    public String getTextFromElement(WebElement element){
        return element.getText();
    }

    public void typeTextEnter(WebElement element, String text){
        element.clear();
        element.sendKeys(text, Keys.ENTER);
    }

    public void clickWithJavascript(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", element);
    }
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }


}
