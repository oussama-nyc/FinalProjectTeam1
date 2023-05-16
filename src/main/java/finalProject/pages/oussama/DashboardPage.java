package finalProject.pages.oussama;

import finalProject.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends CommonAPI {
    Logger log = LogManager.getLogger(DashboardPage.class.getName());

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //----------------------------------------------------------------------------------------------------------------
    // ************************************************( Locators )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    @FindBy(css = ".entry-title")
    WebElement MyDashboardTitle;


    //----------------------------------------------------------------------------------------------------------------
    // ****************************************( Reusable Methods )***************************************************
    // ---------------------------------------------------------------------------------------------------------------

    public String getMyDashboardTitle() {
        String text = getElementText(MyDashboardTitle);
        log.info("get error message text success");
        return text;
    }

}
