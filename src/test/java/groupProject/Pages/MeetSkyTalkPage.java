package groupProject.Pages;

import groupProject.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MeetSkyTalkPage {

    public MeetSkyTalkPage() {

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "(//a[@aria-label='Talk'])[1]")
    public WebElement talkButton;

    @FindBy(xpath = "//button[@aria-controls='app-navigation-vue']")
    public WebElement navigationToggle;

    @FindBy(xpath = "(//input[@class='app-navigation-search__input'])[1]")
    public WebElement searchBox;

    @FindBy(id = "conversation_9qwe33tz")
    public WebElement user20;

    @FindBy(xpath = "//div[@role='textbox']")
    public WebElement messageBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement sendBtn;

    @FindBy (xpath = "//div[.='Hello']")
    public WebElement sentMessage;

    @FindBy (xpath = "//div[.='You created the conversation']")
    public WebElement conversationCreatedMessage;


}
