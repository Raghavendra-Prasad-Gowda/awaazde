package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import managers.PageObjectManager;
import managers.PropertiesManager;
import managers.WebDriverManager;

public class BaseClass {

	protected static WebDriver driver;
	protected static PageObjectManager pageObjectManager;
	protected static PropertiesManager propertiesManager;

	static {
		propertiesManager = new PropertiesManager();
	}

	@BeforeClass
	public static void launchBrowser() {
		driver = WebDriverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pageObjectManager = new PageObjectManager(driver);

	}

	@Test(priority = 0)
	public void navigateToHomePage() throws IOException {
		driver.get(propertiesManager.getConfigurationProperties().getAppURL());
	}

	@AfterClass
	public static void closeBrowser() {
		//driver.close();
	}

}
