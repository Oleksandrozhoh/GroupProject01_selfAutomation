package groupProject.Pages;

import groupProject.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MeetSkyPhotosPage {

    public MeetSkyPhotosPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@data-id='photos'][1]")

    public WebElement photo;


    @FindBy(xpath = "//div[@class='grid']")
    public WebElement photos;

}