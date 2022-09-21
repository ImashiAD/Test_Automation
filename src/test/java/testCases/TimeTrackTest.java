package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.TimeTrackPage;
import pages.LoginPage;

public class TimeTrackTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    TimeTrackPage timeTrackPage;

    public TimeTrackTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loggingIn(properties.getProperty("username"), properties.getProperty("password"));
        timeTrackPage = new TimeTrackPage();
    }

    @Test(testName = "Review leaves of an employee")
    public void viewTimeTrackDetails() {
        timeTrackPage.clickOnViewTimeTrackLink();
        timeTrackPage.validateViewTimeTrack();
        timeTrackPage.clickOnEmpDropdown();
        timeTrackPage.selectTimeTrackEmp(properties.getProperty("employee"));
        timeTrackPage.validateViewTimeTrackEmp();
    }

    @Test(testName = "Approve timesheet record an employee")
    public void approveTimesheetRecord() {
        timeTrackPage.clickOnApproveTime();
        timeTrackPage.selectRecord();
        timeTrackPage.clickApproveBtn();
        timeTrackPage.viewApprovedRecord();
    }

    @Test(testName = "Reject timesheet record an employee")
    public void rejectTimesheetRecord() {
        timeTrackPage.clickOnApproveTime();
        timeTrackPage.selectRecord();
        timeTrackPage.clickRejectBtn();
        timeTrackPage.RejectRecord(properties.getProperty("reason"));
        timeTrackPage.viewRejectedRecord();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
