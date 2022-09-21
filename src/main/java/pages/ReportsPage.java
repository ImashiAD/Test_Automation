package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsPage extends TestBase {

    // Web Element Xpath
    @FindBy(xpath = "//div[.='Reports']/parent::a")
    WebElement viewReportLink;

    @FindBy(xpath = "//div[@class=\"config-name\"][contains(text(), 'Leaves')]")
    WebElement selectLeaveCard;

    @FindBy(xpath = "//div[@class=\"reportName\"][contains(text(), 'Leaves')]")
    WebElement viewLeaveReport;

    //initialization
    public ReportsPage() {
        PageFactory.initElements(driver, this);
    }

    //Action/Methods
    public void clickOnReportsLink() {
        viewReportLink.click();
    }

    public void clickOnLeaveReportsCard() {
        selectLeaveCard.click();
    }

    public Boolean validateViewLeaveReport() {
        return viewLeaveReport.isDisplayed();
    }

}
