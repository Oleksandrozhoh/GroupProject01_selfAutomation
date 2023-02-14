package groupProject.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BrowserUtils {

    public static void logout(){
        WebElement profileIcon = Driver.getDriver().findElement(By.xpath("//div[@id='expand']"));
        profileIcon.click();
        WebElement logoutOption = Driver.getDriver().findElement(By.xpath("//li[@data-id='logout']"));
        logoutOption.click();
    }
}
