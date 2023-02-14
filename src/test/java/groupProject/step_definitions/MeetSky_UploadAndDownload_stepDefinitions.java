package groupProject.step_definitions;

import groupProject.Pages.MeetSkyDashboard;
import groupProject.Pages.MeetSkyFiles;
import groupProject.Pages.MeetSkyLogin;
import groupProject.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class MeetSky_UploadAndDownload_stepDefinitions {

    @Given("User is at the file page")
    public void user_is_at_the_file_page() {
        Driver.getDriver().get("https://qa.meetsky.net/");
        MeetSkyLogin login = new MeetSkyLogin();
        login.login();

        MeetSkyDashboard dashboard = new MeetSkyDashboard();
        dashboard.goToFiles();

    }
    @When("user clicks on the + icon")
    public void user_clicks_on_the_icon() {
        MeetSkyFiles filesPage = new MeetSkyFiles();
        filesPage.plusButton.click();
    }
    @When("user select upload file from pop up menu")
    public void user_select_from_pop_up_menu() {
        MeetSkyFiles filesPage = new MeetSkyFiles();
        filesPage.uploadFileOption.sendKeys("\"C:\\Users\\oleks\\OneDrive\\Desktop\\Screenshots\\251077486_227333759502218_5718729936563081174_n.jpg\"");
    }
    @When("user choose file and clicks open button")
    public void user_choose_file_and_clicks_button() {

    }
    @Then("file name should be displayed on the file page after successful upload.")
    public void file_name_should_be_displayed_on_the_file_page_after_successful_upload() {

    }

    @When("user clicks on the 3 dots icon")
    public void user_clicks_on_the_dots_icon() {
       MeetSkyFiles filesPage = new MeetSkyFiles();
       filesPage.treeDotsIcon_2ndRow.click();
    }
    @When("user select rename from pop up menu")
    public void user_select_rename_from_pop_up_menu() {
        MeetSkyFiles filesPage = new MeetSkyFiles();
        filesPage.renameOption.click();
    }
    @When("user types new file name")
    public void user_types_new_file_name() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys("renamed"+ Keys.ENTER).perform();
    }
    @Then("file name should be different after renaming it")
    public void file_name_should_be_different_after_renaming_it() {
        MeetSkyFiles filesPage = new MeetSkyFiles();
        String actualName = filesPage.fileNameSecondRow.getText();
        String expectedName = "renamed";
        Assert.assertEquals(actualName,expectedName);
    }

    @When("user select download from pop up menu")
    public void user_select_download_from_pop_up_menu() {
        MeetSkyFiles filesPage = new MeetSkyFiles();
        filesPage.downloadOption.click();
    }

    @Then("file should be downloaded to users computer")
    public void file_should_be_downloaded_to_users_computer() {
        MeetSkyFiles filesPage = new MeetSkyFiles();
        File file = new File("C:\\Users\\oleks\\Downloads\\"+filesPage.fileNameSecondRow.getText()+".zip");
        Assert.assertTrue(file.exists());
    }
}
