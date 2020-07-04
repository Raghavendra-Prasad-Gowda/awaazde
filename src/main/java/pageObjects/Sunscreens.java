package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Sunscreens {
	
	private WebDriver driver;

	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='text-center col-4']"))
	private List<WebElement> sunScreensNamesFromWebsite;
	
	@FindAll(@FindBy(how = How.XPATH, using = "(//div[@class='text-center col-4'])/p[2]"))
	private List<WebElement> priceListOfSunscreens;

	public Sunscreens(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public ArrayList<Integer> getleastExpensiveSPF50() {

		ArrayList<Integer> SPF50List = new ArrayList<Integer>();

		for (int i = 0; i < sunScreensNamesFromWebsite.size(); i++) {

			if (sunScreensNamesFromWebsite.get(i).getText().contains("SPF-50")) {
				
				String[] price = priceListOfSunscreens.get(i).getText().split(" ");

				SPF50List.add(Integer.parseInt(price[price.length - 1]));
			}
		}

		return SPF50List;
	}

	public ArrayList<Integer> getleastExpensiveSPF30() {

		ArrayList<Integer> SPF30List = new ArrayList<Integer>();

		for (int i = 0; i < sunScreensNamesFromWebsite.size(); i++) {

			if (sunScreensNamesFromWebsite.get(i).getText().contains("SPF-30")) {
				
				String[] price = priceListOfSunscreens.get(i).getText().split(" ");

				SPF30List.add(Integer.parseInt(price[price.length - 1]));
			}
		}

		return SPF30List;
	}


}
