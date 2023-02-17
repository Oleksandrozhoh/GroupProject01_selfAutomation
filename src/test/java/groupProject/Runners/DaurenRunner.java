package groupProject.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "groupProject/step_definitions",
        dryRun = false,
        tags = "@piw"
)

public class DaurenRunner {
}
