package groupProject.step_definitions;

import groupProject.Pages.MeetSkyPhotosPage;
import groupProject.Utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class MeetSky_AccessPhotoPage_stepDefinitions {

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

}


