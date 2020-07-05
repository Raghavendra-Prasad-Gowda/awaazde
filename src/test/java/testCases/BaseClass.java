package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import configurations.ConfigurationProperties;
import managers.WebDriverManager;
import pageObjects.HomePageObjects;
import pageObjects.MoisturizersPageObjects;
import pageObjects.SunscreensPageObjects;

public class BaseClass {

	public static WebDriver driver;
	public static ConfigurationProperties configProperties;
	public static HomePageObjects homePageObjects;
	public static MoisturizersPageObjects moisturizersObjects;
	public static SunscreensPageObjects sunScreensObjects;

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
		moisturizersObjects = new MoisturizersPageObjects(driver);
		sunScreensObjects = new SunscreensPageObjects(driver);
		driver.get(configProperties.getAppURL());
	}

	@AfterClass
	public static void closeBrowser() {

		driver.close();

	}

}
