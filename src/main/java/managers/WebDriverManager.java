package managers;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import configurations.ConfigurationProperties;

public class WebDriverManager {
	
	private static WebDriver driver;
	private static String userDirectory=System.getProperty("user.dir");
	private static ConfigurationProperties configManager;
	
	private static String CHROME_DRIVER_PROPERTY="webdriver.chrome.driver";
	private static String FIREFOX_DRIVER_PROPERTY="webdriver.gecko.driver";
	private static String INTERNETEXPLORER_DRIVER_PROPERTY="webdriver.ie.driver";
	
	static {
		try {
			configManager = new ConfigurationProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
		
	public  static WebDriver getDriver() {
		
		if(driver==null) {
			driver=createDriver();
			return driver;
		}else {
			return driver;
		}
	}
	
	private static WebDriver createDriver() {
		
		if(configManager.getDriverEnvironment().equals("local")) {
			driver = createLocalDriver();
		}else if (configManager.getDriverEnvironment().equals("remote")) {
			driver = createRemoteDriver();
		}		
		return driver;
	}
	
	
	private static WebDriver createRemoteDriver() {
		driver=null;	
		return driver;
	}
	
	
	private static WebDriver createLocalDriver() {
		
		
		if(configManager.getBrowserName().equals("chrome")) {
			System.setProperty(CHROME_DRIVER_PROPERTY, WebDriverManager.userDirectory+configManager.getDriverPath());
			driver = new ChromeDriver();
			
		}else if(configManager.getBrowserName().equals("firefox")) {
			
			System.setProperty(FIREFOX_DRIVER_PROPERTY, WebDriverManager.userDirectory+configManager.getDriverPath());
			driver = new FirefoxDriver();
			
		}else if(configManager.getBrowserName().equals("internetexplorer")) {
			
			System.setProperty(INTERNETEXPLORER_DRIVER_PROPERTY, WebDriverManager.userDirectory+configManager.getDriverPath());
			driver = new InternetExplorerDriver();
		}
		return driver;
	}

}
