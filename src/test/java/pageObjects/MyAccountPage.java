package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	// Constructor
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement myAcnt;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btn_Logout;

	// Action Methods
	public boolean isMyAccountPageExists() {
		try {
			boolean status = myAcnt.isDisplayed();
			return status;
		} catch (Exception e) {
			return (false);
		}

	}
	
	public void clickLogout() {
		btn_Logout.click();
	}

}
