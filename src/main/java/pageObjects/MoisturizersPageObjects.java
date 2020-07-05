package pageObjects;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MoisturizersPageObjects {

	private WebDriver driver;

	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='text-center col-4']"))
	private List<WebElement> moisturizersNamesFromWebsite;

	@FindAll(@FindBy(how = How.XPATH, using = "(//div[@class='text-center col-4'])/p[2]"))
	private List<WebElement> priceListOfMoisturizers;

	@FindBy(how = How.XPATH, using = "//button[@onclick='goToCart()']")
	private WebElement cartButton;

	public MoisturizersPageObjects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnleastExpensiveAloe() {

		HashMap<Integer, Integer> leastExpensiveAloe = new HashMap<Integer, Integer>();

		for (int i = 0; i < moisturizersNamesFromWebsite.size(); i++) {

			if (moisturizersNamesFromWebsite.get(i).getText().contains("Aloe")) {

				String[] price = priceListOfMoisturizers.get(i).getText().split(" ");

				leastExpensiveAloe.put(Integer.parseInt(price[price.length - 1]), i);
			}
		}

		if (!leastExpensiveAloe.isEmpty()) {
			Integer a = leastExpensiveAloe.get(Collections.min(leastExpensiveAloe.keySet())) + 1;
			String AddNumber = (a).toString();
			driver.findElement(By.xpath("(//button[@class='btn btn-primary'])" + "[" + AddNumber + "]")).click();
		}
	}

	public void clickOnleastExpensiveAlmond() {

		HashMap<Integer, Integer> leastExpensiveAlmond = new HashMap<Integer, Integer>();

		for (int i = 0; i < moisturizersNamesFromWebsite.size(); i++) {

			if (moisturizersNamesFromWebsite.get(i).getText().contains("almond")) {
				String[] price = priceListOfMoisturizers.get(i).getText().split(" ");

				leastExpensiveAlmond.put(Integer.parseInt(price[price.length - 1]), i);
			}
		}

		if (!leastExpensiveAlmond.isEmpty()) {
			Integer a = leastExpensiveAlmond.get(Collections.min(leastExpensiveAlmond.keySet())) + 1;
			String AddNumber = (a).toString();
			driver.findElement(By.xpath("(//button[@class='btn btn-primary'])" + "[" + AddNumber + "]")).click();
		}
	}

	public void clickOnCartButton() {
		cartButton.click();
	}

}
