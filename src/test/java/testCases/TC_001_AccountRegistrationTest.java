package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC_001_AccountRegistrationTest extends testBase {

	@Test(groups={"Regression","Master"})
	void regTest() {
		try {
			logger.info("**********Starting the Test***********");
			HomePage hp = new HomePage(driver);
			logger.info("**********Clicking My Account Link***********");
			hp.clickMyAccount();
			logger.info("**********Clicking the Register Button***********");
			hp.clickRegisterBtn();

			AccountRegistrationPage regPage = new AccountRegistrationPage(driver);

			logger.info("**********Filling the details***********");
			regPage.setFname(randomeString().toUpperCase());
			regPage.setLname(randomeString().toUpperCase());
			regPage.setEmail(randomeString() + "@gmail.com");
			regPage.setTelephone(randomNumber());
			String password1 = randomAlphaNumeric();
			regPage.setPassword(password1);
			regPage.cnfPassword(password1);
			regPage.setChkBox();
			regPage.clickContinue();

			logger.info("Validating expected message..");
			String confmsg = regPage.getCnfMessage();

			// Using Assert with custom message that will be caught in catch block
			Assert.assertEquals(confmsg, "Your Account Has Been Created!",
					"Account creation confirmation message not matching");

			logger.info("Test passed");

		} 
		
		catch (AssertionError e) 
		{
			// This will catch TestNG assertion failures
			logger.error("Test failed due to assertion error: " + e.getMessage());
			Assert.fail("Test failed due to assertion error: " + e.getMessage());
		} 
		catch (Exception e) 
		{
			// This will catch any other exceptions
			logger.error("Test failed due to exception: " + e.getMessage());
			Assert.fail("Test failed due to exception: " + e.getMessage());
		} 
		finally 
		{
			logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}
	}

}
