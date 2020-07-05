package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {

	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//span[@id='temperature']")
	private WebElement getTemperature;

	@FindBy(how = How.LINK_TEXT, using = "Buy moisturizers")
	private WebElement moisturizers;

	@FindBy(how = How.LINK_TEXT, using = "Buy sunscreens")
	private WebElement sunscreens;

	public HomePageObjects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String getCurrentTemperature() {
		return getTemperature.getText();
	}

	public void clickMoisturizers() {
		moisturizers.click();
	}

	public void clickSunscreens() {
		sunscreens.click();
	}

}
