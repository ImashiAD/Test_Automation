package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loggingIn(properties.getProperty("username"), properties.getProperty("password"));
    }

    @Test(priority = 1, testName = "Test Logo in Homepage")
    public void homePageLogoTest() {
        boolean flag = homePage.validateActiTimeLogo();
        Assert.assertTrue(flag, "Cannot find the Logo");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
