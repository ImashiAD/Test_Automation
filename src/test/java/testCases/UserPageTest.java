package testCases;

import base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UsersPage;

public class UserPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    UsersPage usersPage;

    public UserPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loggingIn(properties.getProperty("username"), properties.getProperty("password"));
        usersPage = new UsersPage();
    }

    @Test(testName = "View user details")
    public void viewTimeTrackDetails() throws InterruptedException {
        usersPage.clickOnUsersLink();
        usersPage.validateViewUsers();
        usersPage.clickOnUserRecord();
        usersPage.validateViewUserInfo();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
