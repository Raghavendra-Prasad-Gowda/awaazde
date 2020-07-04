package pageObjects;

import java.util.ArrayList;
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

public class Moisturizers {

	private WebDriver driver;

	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='text-center col-4']"))
	private List<WebElement> moisturizersNamesFromWebsite;

	@FindAll(@FindBy(how = How.XPATH, using = "(//div[@class='text-center col-4'])/p[2]"))
	private List<WebElement> priceListOfMoisturizers;

	@FindBy(how = How.XPATH, using = "//button[@onclick='goToCart()']")
	private WebElement cartButton;

	public Moisturizers(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnleastExpensiveAloe() {

		HashMap<Integer, Integer> v1 = new HashMap<Integer, Integer>();

		for (int i = 0; i < moisturizersNamesFromWebsite.size(); i++) {

			if (moisturizersNamesFromWebsite.get(i).getText().contains("Aloe")) {

				String[] price = priceListOfMoisturizers.get(i).getText().split(" ");

				v1.put(Integer.parseInt(price[price.length - 1]), i);
			}
		}

		moisturizersNamesFromWebsite.get(v1.get(Collections.min(v1.keySet()))).click();

		Integer a = v1.get(Collections.min(v1.keySet())) + 1;
		String AddNumber = (a).toString();
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])" + "[" + AddNumber + "]")).click();
	}

	public void clickOnleastExpensiveAlmond() {

		HashMap<Integer, Integer> v2 = new HashMap<Integer, Integer>();

		for (int i = 0; i < moisturizersNamesFromWebsite.size(); i++) {

			if (moisturizersNamesFromWebsite.get(i).getText().contains("almond")) {
				String[] price = priceListOfMoisturizers.get(i).getText().split(" ");

				v2.put(Integer.parseInt(price[price.length - 1]), i);
			}
		}

		Integer a = v2.get(Collections.min(v2.keySet())) + 1;
		String AddNumber = (a).toString();

		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])" + "[" + AddNumber + "]")).click();
	}

	public void clickOnCartButton() {
		cartButton.click();
	}

}
