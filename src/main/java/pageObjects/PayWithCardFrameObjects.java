package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PayWithCardFrameObjects {

	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//iframe[@name='stripe_checkout_app']")
	private WebElement paymentFrameName;

	@FindBy(how = How.XPATH, using = "//input[@type='email']")
	private WebElement emailTextBox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Card number']")
	private WebElement cardNumberTextBox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='MM / YY']")
	private WebElement monthYearTextBox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='CVC']")
	private WebElement cvcTextBox;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	private WebElement payButton;
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='ZIP Code']")
	private WebElement zipCode;
	
	

	public PayWithCardFrameObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void switchToPaymentFrame() {
		driver.switchTo().frame(paymentFrameName);
	}

	public void setEmailAddress(String emailAddress) {
		emailTextBox.sendKeys(emailAddress);
	}

	public void setCardNumber(String cardNumber) {
		cardNumberTextBox.sendKeys(cardNumber);
	}

	public void setMonthYearIn_MM_YY_Format(String monthYearIn_MM_YY_Format) {
		monthYearTextBox.sendKeys(monthYearIn_MM_YY_Format);
	}

	public void set_3_Number_CVC(String cvcNumber) {
		cvcTextBox.sendKeys(cvcNumber);
	}
	
	public void setZipCode(String enterZipCode) {
		zipCode.sendKeys(enterZipCode);
	}
	
	public void clickPayButton() {
		payButton.click();
	}
	
	public void switchToDefaultPage() {
		driver.switchTo().defaultContent();
	}

}
