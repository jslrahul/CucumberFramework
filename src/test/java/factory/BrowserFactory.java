package factory;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

public	WebDriver driver;
	

	public WebDriver initializeBrowser(String browserName) {
		// Properties prop = new
		// Properties(System.getProperty("user.dir")+"\\src\\test\\resources.ConfigReader.properties"));
		if (browserName.equals("chrome")) {
			/*ChromeOptions option = new ChromeOptions();
            option.addArguments("--remote-allow-origins=*");*/
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equals("safari")) {
			driver = new SafariDriver();
		}else if(browserName.equals("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}
