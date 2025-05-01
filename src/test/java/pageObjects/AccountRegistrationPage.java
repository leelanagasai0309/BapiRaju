package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	//Constructor
	public AccountRegistrationPage(WebDriver driver){
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLname;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement telephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement confirmPassword;
	@FindBy(xpath="//input[@name='agree']") WebElement privacyChkBox;
	@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement cnfMessage;
	
	//AcionMethods
	public void setFname(String fName)
	{
		txtFname.sendKeys(fName);
	}
	public void setLname(String lName)
	{
		txtLname.sendKeys(lName);
	}
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setTelephone(String telephone1)
	{
		telephone.sendKeys(telephone1);
	}
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	public void cnfPassword(String cnfPassword)
	{
		confirmPassword.sendKeys(cnfPassword);
	}
	public void setChkBox()
	{
		privacyChkBox.click();
	}
	public void clickContinue()
	{
		btnContinue.click();
		
		//sol2 
		//btnContinue.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
					
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//Sol 5
		//btnContinue.sendKeys(Keys.RETURN);
		
		//Sol6  
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    //mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		
	}
	public String getCnfMessage()
	{
		try {
			
			return (cnfMessage.getText());
			
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
}
