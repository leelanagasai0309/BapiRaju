package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC_003_LoginDDT extends testBase {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verifiyLogin(String email,String password,String exp) {
			try {
			logger.info("**** Starting  TC_002_LoginTest  ****");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			LoginPage lp = new LoginPage(driver);

			lp.setLoginInput(email);
			lp.setPwdInput(password);
			lp.clickLogIn();

			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage=macc.isMyAccountPageExists();

			/*
			  valid - login successful - test pass 
			          login failed - test fail
			invalid - login successful - test fail 
			          login failed - test pass
			 */
           
			if(exp.equalsIgnoreCase("valid"))
			{
				if(targetPage==true)
				{
					macc.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
				
			}
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					macc.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
			}
			catch(Exception e)
			{
				Assert.fail("An exception occurred: " + e.getMessage());
			}
				
			logger.info("**** Finished TC_003_LoginDDT *****");

	}
	

}
