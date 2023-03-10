package groupProject.Pages;

import groupProject.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MeetSkyGroupChat {
    public MeetSkyGroupChat() {
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = "//ul[@id='appmenu']//a[@aria-label='Talk']//*[name()='svg']//*[name()='image' and contains(@class,'app-icon')]")
    public WebElement talkButton;

    @FindBy(css = "div.wrapper")
    public WebElement createChatButton;

    @FindBy(xpath = "//input[@class='conversation-name']")
    public WebElement conversationName;

    @FindBy(xpath = "//span[contains(text(),'Add participants')]")
    public WebElement addParticipants;

    @FindBy(xpath = "//input[@class='set-contacts__input']")
    public WebElement searchParticipants;

    @FindBy(xpath = "//div[@class='set-contacts']//div[1]//ul[1]//li[1]//div[2]//div[1]//span[1]")
    public WebElement participant;

    @FindBy(xpath = "//span[contains(text(),'Create conversation')]")
    public WebElement conversationButton;

    @FindBy(className = "title")
    public WebElement groupChatName;

    @FindBy(xpath = "//div[@class='trigger']/button[@class='icon action-item__menutoggle action-item__menutoggle--default-icon']")
    public WebElement dotsButton;

    @FindBy(xpath = "//div[@class='list-item-content__wrapper']")
    public WebElement chat;

    @FindBy(xpath = "//div[@class='popover__inner']//li")
    public List<WebElement> channelActions;

    public void navigateToTalkPage(){
        MeetSkyLogin loginPage = new MeetSkyLogin();
        loginPage.login();
        talkButton.click();
    }

    @FindBy (xpath = "//span[.='Copy link']")
    public WebElement copyLinkOption;

    @FindBy (xpath = "//div[@class='toastify on dialogs toast-success toastify-right toastify-top']")
    public WebElement conversationLinkCopiedToClipboard;

    @FindBy (xpath = "//span[.='Add to favorites']")
    public WebElement addToFavouritesOption;

    @FindBy (xpath = "//p[.='Remove from favorites']")
    public WebElement removeFromFavourites;

    @FindBy (xpath = "//span[@class='icon icon-favorite']")
    public WebElement starIcon;







}
