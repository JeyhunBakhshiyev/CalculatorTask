package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.CalculatorPage;
import Utilities.CalculatorUtils;
import Utilities.Driver;
import Utilities.TestBase;
import Utilities.TestConfigs;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class CalculatorSteps extends TestBase{

	private WebDriver driver = Driver.getInstance().getDriver();
	private CalculatorPage cPage = new CalculatorPage();
	private static int scenarioCount = 0;
	private Scenario scenario;
	
	public CalculatorSteps() {
		scenarioCount++;
	}
	
	
	@Before
	public void keepScenario(Scenario scenario) {
		this.scenario = scenario;
	}
	
	

	@Given("User navigates to {string} calculator page")
	public void user_nvigates_to_calculator_page(String env) {
		if(scenarioCount ==1) {
		if(env.equals(TestConfigs.STAGING_ENV_NAME)) {
	    driver.get(properties.getProperty("calculator_page_url"));
		}
	
		else if(env.equals(TestConfigs.PROD_ENV_NAME)) {
			    driver.get(properties.getProperty("calculator_page_url"));
				}
		
		}
        driver.manage().window().maximize();
		   assertEquals(CalculatorUtils.CALCULATOR_PAGE_TITLE, driver.getTitle());
	}


	@Then("User clears display clicking C button")
	public void user_clears_display_clicking_C_button() {
	  cPage.clearButton.click();
	  String actualValue = cPage.display.getText();
	   assertEquals(CalculatorUtils.DEFAULT_DISPLAY_VALUE, actualValue);
	}



	@When("User clicks {string} button")
	public void user_clicks_button(String button) {
	   cPage.clickOn(button);
	}
	
	

	
	
	
	
	@Then("User validates value {string} on display")
	public void user_validates_on_display(String expectedValue) {
		try {
		String actualValue = cPage.display.getText();
		   assertEquals(expectedValue, actualValue );
		}
		   catch(Exception e) {
			   e.printStackTrace();
			   cPage.clearDisplay();
		   }
	}
	
	


	@Then("User user sees {string}")
	public void user_user_sees(String expectedValue) {
			String actualValue = cPage.display.getText();
			   assertEquals(expectedValue, actualValue );
			   cPage.clearButton.click();
			    assertEquals(cPage.display.getText(), CalculatorUtils.DEFAULT_DISPLAY_VALUE);
			    if(scenarioCount == testCount) {
			    	driver.close();
			    }
		}




	@Then("User enters {string} on display")
	public void user_enters_on_display(String value) {
		cPage.enterValueOnDisplay(value);
		
	   
	}



	
	
	@After
	public void tearDown() {		
		if(scenarioCount != testCount ) {
			cPage.clearButton.click();
	    assertEquals(cPage.display.getText(), CalculatorUtils.DEFAULT_DISPLAY_VALUE);
		}
		else if(scenario.isFailed()) {
			driver.close();
		}

	}
	
}
