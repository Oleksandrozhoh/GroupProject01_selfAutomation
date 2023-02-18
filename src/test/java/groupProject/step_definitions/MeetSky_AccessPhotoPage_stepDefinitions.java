package groupProject.step_definitions;

import groupProject.Pages.MeetSkyPhotosPage;
import groupProject.Utilities.BrowserUtils;
import groupProject.Utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MeetSky_AccessPhotoPage_stepDefinitions {
 // Driver.getDriver().get("https://qa.meetsky.net/index.php/login");
    MeetSkyPhotosPage meetSkyPhotosPage = new MeetSkyPhotosPage();
    @When("user clicks on the  photo .")
    public void user_clicks_on_the_photo() {
        System.out.println("user clicks on photo ");

        Driver.getDriver().get("https://qa.meetsky.net/index.php/login");
       MeetSkyPhotosPage meetSkyPhotosPage=new MeetSkyPhotosPage();
       meetSkyPhotosPage.photo.click();




    }
    @Then("user should be able to access to the photo page.")
    public void user_should_be_able_to_access_to_the_photo_page() {

        System.out.println("user access photo page!");
        String expectedTitle="Photos - QA - Meetsky";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals("Title verification!",expectedTitle,actualTitle);



    }
    @When("user at photo page.")
    public void user_at_photo_page() {

        System.out.println("User already on photo page !");

        Driver.getDriver().get("https://qa.meetsky.net/index.php/login");
        MeetSkyPhotosPage meetSkyPhotosPage=new MeetSkyPhotosPage();
        meetSkyPhotosPage.photo.click();

    }

    @Then("user clicks on the navigation button.")
    public void user_clicks_on_the_navigation_button() {
        System.out.println("user clicks on the navigation button.");

        Driver.getDriver().get("https://qa.meetsky.net/index.php/login");
        MeetSkyPhotosPage meetSkyPhotosPage=new MeetSkyPhotosPage();
        meetSkyPhotosPage.photo.click();
        meetSkyPhotosPage.navigationButton.click();

    }

    @Then("user can see photo view")
    public void userCanSeePhotoView() {

        System.out.println("photo view verification");
        meetSkyPhotosPage.photo.click();
        meetSkyPhotosPage.navigationButton.click();
       meetSkyPhotosPage.view.getText();


    }

    @Then("user can see checkbox under settings")
    public void userCanSeeCheckboxUnderSettings() {
        System.out.println("checkBox exist verification!");

        meetSkyPhotosPage.settingButton.click();





       BrowserUtils.logout();
    }
}




