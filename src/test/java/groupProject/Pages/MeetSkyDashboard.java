package groupProject.Pages;

import groupProject.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MeetSkyDashboard {

    public MeetSkyDashboard(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (css = "li[data-id='files']")
    public WebElement filesButton;


}
