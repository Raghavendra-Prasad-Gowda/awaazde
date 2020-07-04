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
			ArrayList<String> moisturizerNames1 = moisturizersObjects.getleastExpensiveAloe();
			ArrayList<String> moisturizerNames2 = moisturizersObjects.getleastExpensiveAlmond();
			
			System.out.println(moisturizerNames1);
			System.out.println(moisturizerNames2);

			
		} else if (currentTemperatureValueFromWebsite > 34) {
			homePageObjects.clickSunscreens();
			ArrayList<String> sunscreenNames1 = sunScreensObjects.getleastExpensiveSPF50();
			ArrayList<String> sunscreenNames2 = sunScreensObjects.getleastExpensiveSPF30();
			
			System.out.println(sunscreenNames1);
			System.out.println(sunscreenNames2);
			

		} else {
			driver.close();
		}
	}

}
