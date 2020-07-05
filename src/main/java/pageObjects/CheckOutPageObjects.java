package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPageObjects {
	
	private WebDriver driver;
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Pay with Card')]")
	private WebElement payWithCardButton;
	
	
	public CheckOutPageObjects(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void clickPayWithCardButton() {
		
		payWithCardButton.click();
		
	}
	
	
	
	
	

}
