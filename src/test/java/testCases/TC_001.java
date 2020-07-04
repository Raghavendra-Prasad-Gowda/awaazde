package testCases;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.testng.annotations.Test;

public class TC_001 extends BaseClass {

	@Test(priority = 0)
	public static void selectingProductBasedOnTemperature() {

		String currentTemperature = homePageObjects.getCurrentTemperature();
		String[] splittingCurrentTemperature = currentTemperature.split(" ");

		int currentTemperatureValueFromWebsite = Integer.parseInt(splittingCurrentTemperature[0].trim());

		if (currentTemperatureValueFromWebsite < 19) {
			homePageObjects.clickMoisturizers();
			ArrayList<String> moisturizerNames = moisturizersObjects.getleastExpensiveAloe();

			
		} else if (currentTemperatureValueFromWebsite > 34) {
			homePageObjects.clickSunscreens();

			

		} else {
			driver.close();
		}
	}

}
