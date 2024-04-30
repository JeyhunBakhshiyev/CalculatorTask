package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * @smoke 42 scenarios 
 * includes @addition, @subtraction, @multiplication, @division, @boundary scenarios
 * 
 * @addition - 10 scenarios
 * @subtraction - 10 scenarios
 * @multiplication - 10 scenarios
 * @division - 10 scenarios
 * @boundary - 2 scenarios
 */


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"StepDefinitions"},
		dryRun = false,
		monochrome = true,
		tags = {"@smoke"},
		plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"}
		)

public class TestRunner {

}
