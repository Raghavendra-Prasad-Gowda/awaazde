package testCases;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.testng.annotations.Test;

public class TC_001 extends BaseClass {

	@Test(priority = 0)
	public static void selectingProductBasedOnTemperature() {

		String currentTemperature = homePageObjects.getCurrentTemperature();
		String[] splittingCurrentTemperature = currentTemperature.split(" ");

		int currentTemperatureValueFromWebsite = Integer.parseInt(splittingCurrentTemperature[0].trim());

		if (currentTemperatureValueFromWebsite < 19) {
			homePageObjects.clickMoisturizers();
			moisturizersObjects.clickOnleastExpensiveAloe();
			moisturizersObjects.clickOnleastExpensiveAlmond();
			moisturizersObjects.clickOnCartButton();

		} else if (currentTemperatureValueFromWebsite > 34) {
			homePageObjects.clickSunscreens();
			sunScreensObjects.clickOnleastExpensiveSPF50();
			sunScreensObjects.clickOnleastExpensiveSPF30();
			sunScreensObjects.clickOnCartButton();

		} else {
			driver.close();
		}
	}

}
