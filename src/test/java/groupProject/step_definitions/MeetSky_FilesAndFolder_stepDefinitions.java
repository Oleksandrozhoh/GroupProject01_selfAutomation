package groupProject.step_definitions;

import groupProject.Pages.MeetSkyDashboard;
import groupProject.Pages.MeetSkyFiles;
import groupProject.Pages.MeetSkyLogin;
import groupProject.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class MeetSky_FilesAndFolder_stepDefinitions {
    @Given("user are at the home page.")
    public void user_are_at_the_home_page() {
        Driver.getDriver().get("https://qa.meetsky.net/index.php/login");
        MeetSkyLogin meetSkyLogin = new MeetSkyLogin();
        meetSkyLogin.login();
    }

    @When("user clicks on the Files module..")
    public void user_clicks_on_the_files_module() {
        MeetSkyDashboard dashboard = new MeetSkyDashboard();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(dashboard.filesButton));
        dashboard.filesButton.click();
    }

    @Then("user launched to the Files page")
    public void user_launched_to_the_files_page() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Files - QA - Meetsky"));
    }
    @When("user clicks on any file or folder checkbox")
    public void user_clicks_on_any_file_or_folder_checkbox() {

        SoftAssert softAssert = new SoftAssert();
        MeetSkyFiles files = new MeetSkyFiles();
        for (WebElement eachCheckbox : files.allFilesAndFOldersCheckboxes) {
            eachCheckbox.click();
            softAssert.assertTrue(eachCheckbox.isSelected());
        }
    }

    @Then("User should see the checkbox selected indicating that the file or folder is selected.")
    public void user_should_see_the_checkbox_selected_indicating_that_the_file_or_folder_is_selected() {
            Driver.driverClose();
    }

    @When("User should be able to click the {string} checkbox.")
    public void user_should_be_able_to_click_the_checkbox(String string) {
        MeetSkyFiles files = new MeetSkyFiles();
        files.selectAllCheckbox.click();
    }
    @Then("User should see all the files and folders checkboxes selected automatically.")
    public void user_should_see_all_the_files_and_folders_checkboxes_selected_automatically() {
        SoftAssert softAssert = new SoftAssert();
        MeetSkyFiles files = new MeetSkyFiles();
        for (WebElement each : files.allFilesAndFOldersCheckboxes) {
            softAssert.assertTrue(each.isSelected());
        }
        Driver.driverClose();
    }

}
