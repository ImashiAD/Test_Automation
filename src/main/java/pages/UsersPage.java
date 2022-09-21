package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage extends TestBase {

    // Web Element Xpath
    @FindBy(xpath = "//div[.='Users']/parent::a")
    WebElement viewUsersLink;

    @FindBy(xpath = "//span[contains(text(), 'List of Users')]")
    WebElement viewUserList;

    @FindBy(xpath = "//span[contains(text(), 'Alvarez, Daniel')]/ancestor::tr[@class=contains(text(), 'userListRow linkedNotNull linkedWithActiplans')][1]")
    WebElement selectUser;

    @FindBy(xpath = "//div[@class='header userPanel_panelHeader'][1]/div[.='Daniel Alvarez']")
    WebElement viewUserInfo;

    //initialization
    public UsersPage() {
        PageFactory.initElements(driver, this);
    }

    //Action/Methods
    public void clickOnUsersLink() {
        viewUsersLink.click();
    }

    public Boolean validateViewUsers() {
        return viewUserList.isDisplayed();
    }

    public void clickOnUserRecord() {
        selectUser.click();
    }


    public Boolean validateViewUserInfo() {
        return viewUserInfo.isDisplayed();
    }
}
