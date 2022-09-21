package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimeTrackPage extends TestBase {
    String employee = properties.getProperty("employee");
    String reason = properties.getProperty("reason");

    //Page Factory - Object Repository
    @FindBy(xpath = "//a[@class='item'][.='View Time-Track']")
    WebElement viewTimeTrackLink;

    @FindBy(xpath = "//td[@class='viewTimeTrackTitle pagetitle']/span")
    WebElement viewTimeTrackTitle;

    @FindBy(xpath = "//div[@class='userNameWrapper']//span[@class='dashedLink']")
    WebElement timeTrackEmpDropdown;

    @FindBy(xpath = "//span[@class='userName'][.='Alvarez, Daniel']")
    WebElement selectTimeTrackEmp;

    @FindBy(xpath = "//div[@class='userNameWrapper']//span[@class='dashedLink'][.='Alvarez, Daniel']")
    WebElement viewTimeTrackEmpDetails;

    @FindBy(xpath = "//a[@class='item'][.='Approve Time-Track']")
    WebElement approveTimeTrackLink;

    @FindBy(xpath = "//div[@class='userNameInfo'][.='Moreno, Andrew']/ancestor::tr[@class='groupingRow']//following-sibling::tr/td/input")
    WebElement selectTimesheetRow;

    @FindBy(xpath = "//span[@id='approveButton']")
    WebElement aprroveBtn;

    @FindBy(xpath = "//div[@class='userNameInfo'][.='Moreno, Andrew']/ancestor::tr[@class='groupingRow']//following-sibling::tr/td[@class='statusCell']/span[.='Approved']")
    WebElement viewApproved;

    @FindBy(xpath = "//span[@id='rejectButton']")
    WebElement rejectBtn;

    @FindBy(xpath = "//textarea[@id='rejectWeekCommentTextArea']")
    WebElement rejectReason;

    @FindBy(xpath = "//span[.='Reject']/parent::button")
    WebElement rejectButton;

    @FindBy(xpath = "//div[@class='userNameInfo'][.='Moreno, Andrew']/ancestor::tr[@class='groupingRow']//following-sibling::tr/td[@class='statusCell']/span[.='Rejected']")
    WebElement viewRejected;


    //initialization
    public TimeTrackPage() {
        PageFactory.initElements(driver, this);
    }

    //Action/Methods
    public void clickOnViewTimeTrackLink() {
        viewTimeTrackLink.click();
    }

    public Boolean validateViewTimeTrack() {
        return viewTimeTrackTitle.isDisplayed();
    }

    public void clickOnEmpDropdown() {
        timeTrackEmpDropdown.click();
    }

    public void selectTimeTrackEmp(String empName) {
        selectTimeTrackEmp.click();
    }

    public Boolean validateViewTimeTrackEmp() {
        return viewTimeTrackEmpDetails.isDisplayed();
    }

    public void clickOnApproveTime() {
        approveTimeTrackLink.click();
    }

    public void selectRecord() {
        selectTimesheetRow.click();
    }

    public void clickApproveBtn() {
        aprroveBtn.click();
    }

    public Boolean viewApprovedRecord() {
        return viewApproved.isDisplayed();
    }

    public void clickRejectBtn() {
        rejectBtn.click();
    }

    public void RejectRecord(String reason) {
        rejectReason.sendKeys(reason);
        rejectButton.click();
    }

    public Boolean viewRejectedRecord() {
        return viewRejected.isDisplayed();
    }

}
