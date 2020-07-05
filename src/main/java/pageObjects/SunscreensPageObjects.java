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

public class SunscreensPageObjects {

	private WebDriver driver;

	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='text-center col-4']"))
	private List<WebElement> sunScreensNamesFromWebsite;

	@FindAll(@FindBy(how = How.XPATH, using = "(//div[@class='text-center col-4'])/p[2]"))
	private List<WebElement> priceListOfSunscreens;

	@FindBy(how = How.XPATH, using = "//button[@onclick='goToCart()']")
	private WebElement cartButton;

	public SunscreensPageObjects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnleastExpensiveSPF50() {

		HashMap<Integer, Integer> v3 = new HashMap<Integer, Integer>();

		for (int i = 0; i < sunScreensNamesFromWebsite.size(); i++) {

			if (sunScreensNamesFromWebsite.get(i).getText().contains("SPF-50")) {

				String[] price = priceListOfSunscreens.get(i).getText().split(" ");

				v3.put(Integer.parseInt(price[price.length - 1]), i);
			}
		}
		Integer a = v3.get(Collections.min(v3.keySet())) + 1;
		String AddNumber = (a).toString();

		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])" + "[" + AddNumber + "]")).click();
	}

	public void clickOnleastExpensiveSPF30() {

		HashMap<Integer, Integer> v4 = new HashMap<Integer, Integer>();

		for (int i = 0; i < sunScreensNamesFromWebsite.size(); i++) {

			if (sunScreensNamesFromWebsite.get(i).getText().contains("SPF-30")) {

				String[] price = priceListOfSunscreens.get(i).getText().split(" ");

				v4.put(Integer.parseInt(price[price.length - 1]), i);
			}
		}
		Integer a = v4.get(Collections.min(v4.keySet())) + 1;
		String AddNumber = (a).toString();

		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])" + "[" + AddNumber + "]")).click();
	}

	public void clickOnCartButton() {
		cartButton.click();
	}

}
