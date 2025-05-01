package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_002_LoginTest extends testBase {

	@Test(groups={"Sanity","Master"})
	public void verifiyLogin() {
		try {
			
			logger.info("**** Starting  TC_002_LoginTest  ****");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);

			lp.setLoginInput(p.getProperty("email"));
			lp.setPwdInput(p.getProperty("password"));
			lp.clickLogIn();

			MyAccountPage macc = new MyAccountPage(driver);

			boolean targetPage = macc.isMyAccountPageExists();

			Assert.assertEquals(targetPage, true, "Login failed");
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("**** Finished TC_002_LoginTest  ****");

	}

}
