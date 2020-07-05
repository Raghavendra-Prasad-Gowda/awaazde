package testCases;



import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;



public class TC_001 extends BaseClass {
	
	
	@Test(priority = 1)
	public static void selectingProductBasedOnTemperature() throws InterruptedException {

		String currentTemperatureWebpage = pageObjectManager.getHomePageObjects().getCurrentTemperature();
		String[] splittingCurrentTemperature = currentTemperatureWebpage.split(" ");

		int currentTemperatureValueFromWebsite = Integer.parseInt(splittingCurrentTemperature[0].trim());

		if (currentTemperatureValueFromWebsite < 19) {
			pageObjectManager.getHomePageObjects().clickMoisturizers();
			pageObjectManager.getMoisturizersPageObjects().clickOnleastExpensiveAloe();
			pageObjectManager.getMoisturizersPageObjects().clickOnleastExpensiveAlmond();
			pageObjectManager.getMoisturizersPageObjects().clickOnCartButton();
			pageObjectManager.getCheckoutPageObjects().clickPayWithCardButton();
			Thread.sleep(3000);
			pageObjectManager.getPayWithCardFrameObjects().switchToPaymentFrame();
			pageObjectManager.getPayWithCardFrameObjects().setEmailAddress(RandomString.make(10)+"@gmail.com");
			pageObjectManager.getPayWithCardFrameObjects().setCardNumber("378282246310005");
			pageObjectManager.getPayWithCardFrameObjects().set_3_Number_CVC("343");
			pageObjectManager.getPayWithCardFrameObjects().setMonthYearIn_MM_YY_Format("08");
			pageObjectManager.getPayWithCardFrameObjects().setMonthYearIn_MM_YY_Format("22");
			pageObjectManager.getPayWithCardFrameObjects().setZipCode("571301");
			
			pageObjectManager.getPayWithCardFrameObjects().clickPayButton();
			Thread.sleep(5000);
			pageObjectManager.getPayWithCardFrameObjects().switchToDefaultPage();
			
			System.out.println("Payment "+pageObjectManager.getPaymentSuccessPageObjects().getPaymentStatusMessage());

		} else if (currentTemperatureValueFromWebsite > 34) {
			pageObjectManager.getHomePageObjects().clickSunscreens();
			pageObjectManager.getSunscreensPageObjects().clickOnleastExpensiveSPF50();
			pageObjectManager.getSunscreensPageObjects().clickOnleastExpensiveSPF30();
			pageObjectManager.getSunscreensPageObjects().clickOnCartButton();
			pageObjectManager.getCheckoutPageObjects().clickPayWithCardButton();
			
			Thread.sleep(3000);
			pageObjectManager.getPayWithCardFrameObjects().switchToPaymentFrame();
			pageObjectManager.getPayWithCardFrameObjects().setEmailAddress(RandomString.make(10)+"@gmail.com");
			pageObjectManager.getPayWithCardFrameObjects().setCardNumber("5105105105105100");
			pageObjectManager.getPayWithCardFrameObjects().set_3_Number_CVC("343");
			pageObjectManager.getPayWithCardFrameObjects().setMonthYearIn_MM_YY_Format("09");
			pageObjectManager.getPayWithCardFrameObjects().setMonthYearIn_MM_YY_Format("23");
			pageObjectManager.getPayWithCardFrameObjects().setZipCode("571301");
			
			pageObjectManager.getPayWithCardFrameObjects().clickPayButton();
			Thread.sleep(5000);
			pageObjectManager.getPayWithCardFrameObjects().switchToDefaultPage();
			
			System.out.println("Payment "+pageObjectManager.getPaymentSuccessPageObjects().getPaymentStatusMessage());

		} else {

			driver.close();

		}
	}

}
