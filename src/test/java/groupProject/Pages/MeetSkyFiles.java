package groupProject.Pages;

import groupProject.Utilities.Driver;
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
    @FindBy (xpath = "//input[@class='max_human_file_size']")
    public WebElement uploadFileOption;

    @FindBy (xpath = "(//a[@class='action action-menu permanent'])[2]")
    public WebElement treeDotsIcon_2ndRow;

    @FindBy (xpath = "//a[@class='menuitem action action-rename permanent']")
    public WebElement renameOption;

    @FindBy (xpath = "(//span[@class='innernametext'])[2]")
    public WebElement fileNameSecondRow;

    @FindBy (xpath = "//a[@data-action='Download']")
    public WebElement downloadOption;

}
