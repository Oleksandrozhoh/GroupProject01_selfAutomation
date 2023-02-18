package groupProject.Pages;

import groupProject.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MeetSkyPhotosPage {

    public MeetSkyPhotosPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li/a[@aria-label='Photos'][1]")
    public WebElement photo;

    @FindBy(id = "hole")
    public WebElement photos;

@FindBy(xpath = "//button[@class='settings-button']")
public WebElement settingButton;

@FindBy(id = "app-settings__content")
public WebElement view;


@FindBy(xpath = "//button[@class='action-item action-item--single app-navigation-toggle undefined undefined has-tooltip']")
public WebElement navigationButton;




    @FindBy(xpath = "//span[@title='Your photos']")
    public WebElement yourPhotos;

    @FindBy(xpath = "//span[@title='Favorites']")
    public WebElement favorites;

   @FindBy(xpath = "//span[@title='Your videos']")
    public WebElement videos;

  @FindBy(xpath = "//span[@title='On this day']")
    public WebElement onThisDay;


  @FindBy(xpath = "//span[@title='Your folders']")
    public WebElement yourFolder;


  @FindBy(xpath = "//span[@title='Shared with you']")
    public WebElement sharedWithYou;

 @FindBy(xpath = "//span[@title='Tagged photos']")
    public WebElement taggedPhotos;




}

