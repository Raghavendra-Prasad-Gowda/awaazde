package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.CheckOutPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.MoisturizersPageObjects;
import pageObjects.PayWithCardFrameObjects;
import pageObjects.PaymentSuccessPageObjects;
import pageObjects.SunscreensPageObjects;

public class PageObjectManager {

	private WebDriver driver;
	private HomePageObjects homePageObjects;
	private MoisturizersPageObjects moisturizersPageObjects;
	private SunscreensPageObjects sunscreensPageObjects;
	private CheckOutPageObjects checkoutPageObjects;
	private PayWithCardFrameObjects payWithCardFrameObjects;
	private PaymentSuccessPageObjects paymentSuccessPageObjects;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;

	}

	public HomePageObjects getHomePageObjects() {

		if (homePageObjects == null) {
			homePageObjects = new HomePageObjects(driver);
		}
		return homePageObjects;
	}

	public MoisturizersPageObjects getMoisturizersPageObjects() {

		if (moisturizersPageObjects == null) {
			moisturizersPageObjects = new MoisturizersPageObjects(driver);
		}
		return moisturizersPageObjects;
	}

	public SunscreensPageObjects getSunscreensPageObjects() {

		if (sunscreensPageObjects == null) {
			sunscreensPageObjects = new SunscreensPageObjects(driver);
		}
		return sunscreensPageObjects;
	}

	public CheckOutPageObjects getCheckoutPageObjects() {

		if (checkoutPageObjects == null) {
			checkoutPageObjects = new CheckOutPageObjects(driver);
		}
		return checkoutPageObjects;
	}
	
	
	public PayWithCardFrameObjects getPayWithCardFrameObjects() {

		if (payWithCardFrameObjects == null) {
			payWithCardFrameObjects = new PayWithCardFrameObjects(driver);
		}
		return payWithCardFrameObjects;
	}
	
	public PaymentSuccessPageObjects getPaymentSuccessPageObjects() {

		if (paymentSuccessPageObjects == null) {
			paymentSuccessPageObjects = new PaymentSuccessPageObjects(driver);
		}
		return paymentSuccessPageObjects;
	}

}
