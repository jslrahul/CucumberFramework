package utils;

import java.awt.ItemSelectable;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.operator.OutputAEADEncryptor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import factory.BrowserFactory;

public class MyExtentReport {
	
	BrowserFactory factory;
	WebDriver driver;
	
	public void generateExtentReport() {
		
		
		
		ExtentReports extentReport = new ExtentReports();
		File file = new File(System.getProperty("user.dir")+"\\advanceReport\\ExtentReport.html");
		ExtentSparkReporter sparkReported = new ExtentSparkReporter(file);
		
		sparkReported.config().setTheme(Theme.STANDARD);
		sparkReported.config().setDocumentTitle("Sample Automation Report");
		sparkReported.config().setReportName("Automation Extent Report");
		sparkReported.config().setTimeStampFormat("DD/MM/YY hh:mm:ss");
		
		extentReport.attachReporter(sparkReported);
		
		extentReport.setSystemInfo("Browser", "Chrome");
		extentReport.setSystemInfo("Project", "Sample Automation");
		ExtentTest extentTest = extentReport.createTest(this.getClass().getSimpleName());
		extentTest.log(Status.INFO, (Markup) extentTest.addScreenCaptureFromPath(getScreenshot()));
	}
	
	public String getScreenshot() {
		driver = factory.getDriver();
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			
			FileUtils.copyDirectory(src, new File(System.getProperty("user.dir")+"\\screenshots\\failed.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return System.getProperty("user.dir")+"\\screenshots\\failed.png";
	}
	
	
}
