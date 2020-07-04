package testCases;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

import org.testng.annotations.Test;

public class TC_001 extends BaseClass {

	@Test(priority = 0)
	public static void selectingProductBasedOnTemperature() {

		String currentTemperature = homePageObjects.getCurrentTemperature();
		String[] splittingCurrentTemperature = currentTemperature.split(" ");

		int currentTemperatureValueFromWebsite = Integer.parseInt(splittingCurrentTemperature[0].trim());

		if (currentTemperatureValueFromWebsite < 19) {
			homePageObjects.clickMoisturizers();
			System.out.println("Moisture");
			ArrayList<Integer> moisturizerNames1 = moisturizersObjects.getleastExpensiveAloe();
			ArrayList<Integer> moisturizerNames2 = moisturizersObjects.getleastExpensiveAlmond();
			System.out.println(Collections.min(moisturizerNames1));
			System.out.println(Collections.min(moisturizerNames2));
			

			
		} else if (currentTemperatureValueFromWebsite > 34) {
			homePageObjects.clickSunscreens();
			ArrayList<Integer> sunscreenNames1 = sunScreensObjects.getleastExpensiveSPF50();
			ArrayList<Integer> sunscreenNames2 = sunScreensObjects.getleastExpensiveSPF30();
			System.out.println("Sunscreen");
			System.out.println(Collections.min(sunscreenNames1));
			System.out.println(Collections.min(sunscreenNames2));
			

		} else {
			driver.close();
		}
	}

}
