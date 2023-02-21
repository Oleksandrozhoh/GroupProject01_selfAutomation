package groupProject.Pages;

import groupProject.Utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MeetSkyFiles {

    public MeetSkyFiles(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//tr/td[@class='selection']/label")
    public List<WebElement> allFilesAndFOldersCheckboxes;

    @FindBy (xpath = "//label[@for='select_all_files']")
    public WebElement selectAllCheckbox;

    @FindBy (xpath = "//a[@class='button new']")
    public WebElement plusButton;

    ////span[.='Upload file']
    @FindBy (xpath = "//input[@type='file']")
    public WebElement uploadFileOption;

    @FindBy (xpath = "//span[.='New folder']")
    public WebElement newFolderOption;

    @FindBy (xpath = "//input[@value='New folder']")
    public WebElement inputNewFolderNameOption;

    @FindBy (xpath = "(//a[@class='action action-menu permanent'])[2]")
    public WebElement treeDotsIcon_2ndRow;

    @FindBy (xpath = "//a[@class='menuitem action action-rename permanent']")
    public WebElement renameOption;

    @FindBy (xpath = "(//span[@class='innernametext'])[2]")
    public WebElement fileNameSecondRow;

    @FindBy (xpath = "//a[@data-action='Download']")
    public WebElement downloadOption;

    @FindBy (xpath = "//span[@class='nametext']")
    public List<WebElement> listOfFIleNames;


    @FindBy (xpath = "//ul[@id='appmenu']//a[@aria-label='Activity']//*[name()='svg']//*[name()='image' and contains(@class,'app-icon')]")
    public WebElement activityPage;

    @FindBy (xpath = "//span[normalize-space()='Today']")
    public WebElement getActivityPage;

    public static void new_folder_display_verification(String nameOfCreatedFolder){

        WebElement newfolder= Driver.getDriver().findElement(By.xpath("//span/span[.='"+nameOfCreatedFolder+"']"));
        Assert.assertTrue(newfolder.isDisplayed());
    }

    @FindBy (xpath = "//input[@type='file']")
    public WebElement uploadFileTag;

    @FindBy (xpath = "//span[@class='innernametext']")
    public List<WebElement> allFileAndFolderNames;


}
