package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver){
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//span[normalize-space()='My Account']") 
	WebElement myAccountBtn;
	@FindBy(xpath="(//ul[@class='dropdown-menu dropdown-menu-right']//a)[1]") 
	WebElement registerBtn;
	@FindBy(xpath="//a[normalize-space()='Login']") 
	WebElement linkLogin;
	
	//ActionMethods
	public void clickMyAccount() {
		myAccountBtn.click();
	}
	public void clickRegisterBtn() {
		registerBtn.click();
	}
	public void clickLogin() {
		linkLogin.click();
	}
	

}
