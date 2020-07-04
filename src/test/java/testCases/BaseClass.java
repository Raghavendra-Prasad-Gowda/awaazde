package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import configurations.ConfigurationProperties;
import managers.WebDriverManager;
import pageObjects.HomePageObjects;
import pageObjects.Moisturizers;
import pageObjects.Sunscreens;

public class BaseClass {

	public static WebDriver driver;
	public static ConfigurationProperties configProperties;
	public static HomePageObjects homePageObjects;
	public static Moisturizers moisturizersObjects;
	public static Sunscreens sunScreensObjects;

	static {
		try {
			configProperties = new ConfigurationProperties();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeClass
	public static void launchBrowser() {
		driver = WebDriverManager.getDriver();
		homePageObjects = new HomePageObjects(driver);
		moisturizersObjects = new Moisturizers(driver);
		sunScreensObjects = new Sunscreens(driver);
		driver.get(configProperties.getAppURL());
	}

	@AfterClass
	public static void closeBrowser() {

		driver.close();

	}

}
