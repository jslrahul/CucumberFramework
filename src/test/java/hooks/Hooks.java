package hooks;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.PropertyReader;

public class Hooks {
	WebDriver driver;
	BrowserFactory browserFact;
	Properties prop;

	@Before
	public void openBrowser(Scenario scenario) {
		System.out.println("Scanario name before execution starts: "+scenario.getName());
		PropertyReader propReader = new PropertyReader();
		prop = propReader.readProperty();

		String browser = prop.getProperty("browser");
		System.out.println(browser);
		browserFact = new BrowserFactory();
		driver = browserFact.initializeBrowser(browser);	

		System.out.println("opening the browser before the scenario gets executed");
		driver.get(prop.getProperty("url"));


	}

	@After
	public void closeBrowser(Scenario scenario) {
		/*String scenarioName = scenario.getName().replace(" ", "_");

		if(scenario.isFailed()) {
		byte[]srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(srcFile, "png/jpeg", scenarioName);
		}
		 */
		driver.quit();
		System.out.println("closing the browser after the scenarios is executed");

	}
}
