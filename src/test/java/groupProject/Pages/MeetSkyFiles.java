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
}
