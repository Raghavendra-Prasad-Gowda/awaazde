package pageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Moisturizers {

	private WebDriver driver;

	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='text-center col-4']"))
	private List<WebElement> moisturizersNamesFromWebsite;
	
	@FindAll(@FindBy(how = How.XPATH, using = "(//div[@class='text-center col-4'])/p[2]"))
	private List<WebElement> priceListOfMoisturizers;
	

	public Moisturizers(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ArrayList<String> getleastExpensiveAloe() {

		ArrayList<String> aloeList = new ArrayList<String>();

		for (int i = 0; i < moisturizersNamesFromWebsite.size(); i++) {

			if (moisturizersNamesFromWebsite.get(i).getText().contains("Aloe")) {
				
				aloeList.add(priceListOfMoisturizers.get(i).getText());
			}
		}

		return aloeList;
	}

	public ArrayList<String> getleastExpensiveAlmond() {
		ArrayList<String> almondList = new ArrayList<String>();
		for (int i = 0; i < moisturizersNamesFromWebsite.size(); i++) {

			if (moisturizersNamesFromWebsite.get(i).getText().contains("almond")) {
				almondList.add(priceListOfMoisturizers.get(i).getText());
			}
		}

		return almondList;
	}

}
