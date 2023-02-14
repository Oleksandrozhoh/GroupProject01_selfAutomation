package groupProject.Pages;

import groupProject.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MeetSkyDashboard {

    public MeetSkyDashboard(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (css = "li[data-id='files']")
    public WebElement filesButton;


    public void goToFiles(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(filesButton));
        filesButton.click();
    }

}
