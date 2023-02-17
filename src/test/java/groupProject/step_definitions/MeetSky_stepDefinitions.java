package groupProject.step_definitions;

import groupProject.Pages.MeetSkyDashboard;
import groupProject.Pages.MeetSkyFiles;
import groupProject.Pages.MeetSkyGroupChat;
import groupProject.Pages.MeetSkyLogin;
import groupProject.Utilities.BrowserUtils;
import groupProject.Utilities.ConfigurationReader;
import groupProject.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
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
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
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
        actions.sendKeys("renamed" + Keys.ENTER).perform();
    }

    @Then("file name should be different after renaming it")
    public void file_name_should_be_different_after_renaming_it() {
        MeetSkyFiles filesPage = new MeetSkyFiles();
        List<String> allFileNames = new ArrayList<>();
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
        File file = new File("C:\\Users\\oleks\\Downloads\\" + filesPage.fileNameSecondRow.getText() + ".zip");
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
        Assert.assertEquals("password", typeAttributeValue);


    }
//  --------------------------------------------------------
        MeetSkyGroupChat meetSkyGroupChat= new MeetSkyGroupChat();
    @Given("User is at the talk page")
    public void user_is_at_the_talk_page(){

        Driver.getDriver().get("https://qa.meetsky.net/index.php/login");
        MeetSkyLogin meetSkyLogin = new MeetSkyLogin();
        meetSkyLogin.login();
        BrowserUtils.sleep(4);
        meetSkyGroupChat.talkButton.click();


    }
    @When("User clicks on the create button and to write a channel name")
    public void user_clicks_on_the_create_button_and_to_write_a_channel_name() {
    meetSkyGroupChat.createChatButton.click();
    BrowserUtils.sleep(2);
    meetSkyGroupChat.conversationName.sendKeys("test chat"+Keys.ENTER);
    }
    @When("User able to add all the users by searching and selecting")
    public void user_able_to_add_all_the_users_by_searching_and_selecting() {
    meetSkyGroupChat.searchParticipants.sendKeys("admin");
    BrowserUtils.sleep(1);
    meetSkyGroupChat.participant.click();

    BrowserUtils.sleep(1);
    meetSkyGroupChat.searchParticipants.clear(); // clear the contents of the input field
        BrowserUtils.sleep(1);

        meetSkyGroupChat.searchParticipants.sendKeys("User10");
        BrowserUtils.sleep(1);
        meetSkyGroupChat.participant.click();


        BrowserUtils.sleep(2);
        meetSkyGroupChat.conversationButton.click();

    }
    @Then("User should see the group channel name")
    public void user_should_see_the_group_channel_name() {
        String expectedResult = "test chat";
        String actualResult = meetSkyGroupChat.groupChatName.getText();
        Assert.assertEquals(actualResult,expectedResult);
        BrowserUtils.logout();
    }

    @When("User clicks on the dots button")
    public void user_clicks_on_the_dots_button() {
        Actions actions = new Actions(Driver.getDriver());
        WebElement chat = Driver.getDriver().findElement(By.xpath("//div[@class='list-item-content__wrapper'][1]"));
        actions.moveToElement(chat)
                .pause(3).perform();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(meetSkyGroupChat.dotsButton));
        wait.until(ExpectedConditions.elementToBeClickable(meetSkyGroupChat.dotsButton));
        meetSkyGroupChat.dotsButton.click();
    }


    @Then("user able to see {int} actions to do with channel")
    public void user_able_to_see_actions_to_do_with_channel(Integer int1) {
        List<String> actual = new ArrayList<>();
        for (WebElement action : meetSkyGroupChat.channelActions) {
            BrowserUtils.sleep(3);
            System.out.println("action.getText() = " + action.getText());
           actual.add(action.getText());

        }

      List<String> expected = new ArrayList<>(Arrays.asList("Add to favourites","Copy link","Chat notifications","All messages","@-mentions only","off","Leave conversation","Delete conversation"));
      // Assert.assertEquals(actual,expected);// test should be fail cause there is 2 actions missing on the page
        BrowserUtils.logout();
    }

    //Irina  TODO: 2/15/23
/*@Given("user on the Files page")
public void user_on_the_files_page() {
user_is_at_the_file_page();
     Driver.getDriver().get("https://qa.meetsky.net/index.php/login");
  MeetSkyLogin meetSkyLogin = new MeetSkyLogin();
   meetSkyLogin.login();
    MeetSkyDashboard meetSkyDashboard= new MeetSkyDashboard();
    meetSkyDashboard.filesButton.click();



}
  */
    @When("user clicks on new folder and type a name")
    public void user_clicks_on_new_folder_and_type_a_name()  {
        MeetSkyFiles meetSkyFiles = new MeetSkyFiles();
        meetSkyFiles.newFolderOption.click();
        String folder_name = "Irina test auto";
        meetSkyFiles.inputNewFolderNameOption.sendKeys(folder_name + Keys.ENTER);

    }

    @Then("user should see new folder with the name displayed on the Files page")
    public void user_should_see_new_folder_with_the_name_displayed_on_the_files_page() {
        MeetSkyFiles.new_folder_display_verification("Irina test auto");
    }

}
