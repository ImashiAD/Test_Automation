package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.ReportsPage;
import pages.LoginPage;

public class ReportPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    ReportsPage reportsPage;

    public ReportPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loggingIn(properties.getProperty("username"), properties.getProperty("password"));
        reportsPage = new ReportsPage();
    }

    @Test(testName = "Review leaves of an employee")
    public void viewTimeTrackDetails() {
        reportsPage.clickOnReportsLink();
        reportsPage.clickOnLeaveReportsCard();
        reportsPage.validateViewLeaveReport();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
