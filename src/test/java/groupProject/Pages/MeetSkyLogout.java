package groupProject.Pages;

import groupProject.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MeetSkyLogout {

    public MeetSkyLogout() {
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//div[@id='settings' ]/div/div")
    public WebElement profileBtn;



    @FindBy(xpath = "//li[@data-id='logout']/a")
    public WebElement logoutBtn;



}
