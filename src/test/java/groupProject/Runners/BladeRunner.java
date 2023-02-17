package groupProject.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/cucumber-reports.html",
        publish = true,
        features = "src/test/resources/features",
        glue = "groupProject/step_definitions",
        dryRun = false,
        tags = "@LogoutFunctionality"
        )
public class BladeRunner {
}
