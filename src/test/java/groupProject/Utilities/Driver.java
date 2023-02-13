package groupProject.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.DriverManager;
import java.time.Duration;

public class Driver {

    private Driver(){}

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigurationReader.getProperty("browser")) {
                case "chrome":
                    driver=new ChromeDriver();
                    break;
                case "edge":
                driver=new EdgeDriver();
                break;
                case "firefox":
                driver=new FirefoxDriver();
                break;
                default:
                    System.out.println("Invalid browser provided!");
                    return null;
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static void driverClose(){
        if (driver==null){
            driver.quit();
            driver=null;
        }
    }
}
