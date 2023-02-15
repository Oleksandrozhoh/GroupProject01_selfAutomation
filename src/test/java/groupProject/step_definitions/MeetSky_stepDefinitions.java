package groupProject.step_definitions;

import groupProject.Pages.MeetSkyDashboard;
import groupProject.Pages.MeetSkyFiles;
import groupProject.Pages.MeetSkyLogin;
import groupProject.Utilities.BrowserUtils;
import groupProject.Utilities.ConfigurationReader;
import groupProject.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MeetSky_stepDefinitions {
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
        BrowserUtils.logout();
    }

    @When("User should be able to click the Select All checkbox.")
    public void user_should_be_able_to_click_the_checkbox() {
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
        BrowserUtils.logout();
    }


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
        List <String> allFileNames = new ArrayList<>();
        String expectedName = "renamed";
        for (WebElement eachFileName : filesPage.listOfFIleNames) {
            allFileNames.add(eachFileName.getText());
            }
        Assert.assertTrue(allFileNames.contains(expectedName));
        BrowserUtils.logout();
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
        BrowserUtils.logout();
    }

    @Given("user is at the login page")
    public void user_is_at_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("meetSkyURL"));
    }
    @When("enters valid username to username input box")
    public void enters_valid_username_to_username_input_box() {
        MeetSkyLogin loginPage = new MeetSkyLogin();
        loginPage.usernameInputBox.sendKeys(ConfigurationReader.getProperty("meetSkyUsername"));
    }
    @When("enters valid password to password input box")
    public void enters_valid_password_to_password_input_box() {
        MeetSkyLogin loginPage = new MeetSkyLogin();
        loginPage.passwordInputBox.sendKeys(ConfigurationReader.getProperty("meetSkyPassword"));
    }
    @When("clicks login button")
    public void clicks_login_button() {
        MeetSkyLogin loginPage = new MeetSkyLogin();
        loginPage.loginButton.click();
    }
    @Then("land on the Dashboard page after successful login.")
    public void land_on_the_page_after_successful_login() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Dashboard";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        BrowserUtils.logout();
    }

    @When("enters invalid username to username input box")
    public void enters_invalid_username_to_username_input_box() {
        MeetSkyLogin loginPage = new MeetSkyLogin();
        loginPage.usernameInputBox.sendKeys("InvalidUsername");
    }
    @Then("user should see the warning message - Wrong username or password")
    public void user_should_see_the_warning_message_invalid_username_or_password() {
        MeetSkyLogin loginPage = new MeetSkyLogin();
        String actualMessage = loginPage.wrongUsernameOrPasswordMessage.getText();
        String expectedText = "Wrong username or password.";
        Assert.assertTrue(actualMessage.contains(expectedText));
    }

    @When("enters password to password input box")
    public void enters_password_to_password_input_box() {
       MeetSkyLogin loginPage = new MeetSkyLogin();
       loginPage.passwordInputBox.sendKeys("mySecretPassword");
    }
    @Then("password text box displays the characters entered by a user as bullet point")
    public void password_text_box_displays_the_characters_entered_by_a_user_as_bullet_point() {
        MeetSkyLogin loginPage = new MeetSkyLogin();
        String typeAttributeValue = loginPage.passwordInputBox.getAttribute("type");
        Assert.assertEquals("password",typeAttributeValue);

    }


}
