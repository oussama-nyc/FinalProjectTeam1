package finalProject.pages.scaledupit;

import finalProject.base.CommonAPI;
import finalProject.pages.nopcommerce.SearchPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSearchPage extends CommonAPI {
    Logger log = LogManager.getLogger(ProductSearchPage.class.getName());


    public ProductSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//header[@class='page-header']/h1[1]")
    WebElement shoePageTitle;
    @FindBy(xpath = "//div[@class='page-content']/p[1]")
    WebElement errorMessage;


    public String getSearchPageTitle() {
        String text = getElementText(shoePageTitle);
        log.info("converse page header text is " + shoePageTitle);
        return text;
    }
    public String getErrorMessage() {
        String text = getElementText(errorMessage);
        log.info("get error message text success");
        return text;
    }
}

