package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;

import base.TestBase;
import utils.Log;

public class LoginPage extends TestBase {

    //Page Factory - Object Repository
    @FindBy(xpath = "//input[@name='username']")
    @CacheLookup
    WebElement userName;

    @FindBy(xpath = "//input[@type='password'and @name='pwd']")
    WebElement passWord;

    @FindBy(xpath = "//a[@id='loginButton']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@class='atLogoImg']")
    WebElement actiTimeLogo;

    @FindBy(xpath = "//span[@class='errormsg']")
    WebElement errorMsg;

    //initialization
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //Action/Methods
    public Boolean validateActiTimeLogo() {
        return actiTimeLogo.isDisplayed();
    }

    public HomePage loggingIn(String uName, String pword){
        userName.sendKeys(uName);
        passWord.sendKeys(pword);
        loginButton.click();
        return new HomePage();
    }

    public void validLogin() {
        userName.sendKeys(properties.getProperty("username"));
        passWord.sendKeys(properties.getProperty("password"));
        loginButton.click();
    }
    public void invalidLogin() {
        userName.sendKeys(properties.getProperty("username"));
        passWord.sendKeys(properties.getProperty("wrong_password"));
        loginButton.click();
    }

    public Boolean validateErrorMsg() {
        return errorMsg.isDisplayed();
    }
}
