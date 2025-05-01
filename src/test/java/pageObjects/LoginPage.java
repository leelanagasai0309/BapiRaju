package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	//Constructor
	public LoginPage(WebDriver driver){
		
		super(driver);
	}
	
	//Locators
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_loginInput;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_PwdInput;
	@FindBy(xpath="//input[@value='Login']") WebElement btn_Login;
	
	
	//Action Methods
	
	public void setLoginInput(String lEmail)
	{
		txt_loginInput.sendKeys(lEmail);
	}
	
	public void setPwdInput(String lPwd)
	{
		txt_PwdInput.sendKeys(lPwd);
	}
	
	public void clickLogIn()
	{
		btn_Login.click();
	}
	

	
	
	
}
