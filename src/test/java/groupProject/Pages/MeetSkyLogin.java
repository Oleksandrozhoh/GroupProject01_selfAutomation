package groupProject.Pages;

import groupProject.Utilities.ConfigurationReader;
import groupProject.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MeetSkyLogin {

    public MeetSkyLogin(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "user")
    public WebElement usernameInputBox;

    @FindBy (id = "password")
    public WebElement passwordInputBox;

    @FindBy (id = "submit-form")
    public WebElement loginButton;

    // method to login to the meetSky app
    public void login(){
        usernameInputBox.sendKeys(ConfigurationReader.getProperty("meetSkyUsername"));
        passwordInputBox.sendKeys(ConfigurationReader.getProperty("meetSkyPassword"));
        loginButton.click();
    }

}
