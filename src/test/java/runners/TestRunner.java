package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;





@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"configs", "stepDefinitions"},
        plugin = {"pretty", "html:target/html-report-cucumber", "json:target/json-cucumber"}
)


public class TestRunner {




}
