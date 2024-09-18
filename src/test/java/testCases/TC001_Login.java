package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.OrangeHRMLogin;
import testBase.BaseClass;
import testBase.BaseClassForRemoteExcutionGrid;

public class TC001_Login extends BaseClass
{
	@Test(groups="Master")  // including all groups in login bcs this class is extended by all other classes //
	public void loginTest() throws InterruptedException
	{
		logger.info("*****TC001_Login started*****");
		
		try
		{
		OrangeHRMLogin lg = new OrangeHRMLogin(driver);
		
		lg.setUserName(p.getProperty("username"));
		
		lg.setPassword(p.getProperty("password"));
		
		Thread.sleep(2000);
		lg.clickLogin();
		
		logger.info("*clicked on login***");
		
		Thread.sleep(2000);
		if (driver.getTitle().equals("OrangeHRM"))
		{
			Assert.assertTrue(true);  // assertion in another way //
		}
		else
		{
			logger.error("Test failed");
			logger.debug("Debug Logs");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(driver.getTitle(), "OrangeOrangeHRM");   // hard assertion //
		}
		catch (Exception e)
		{
			//logger.error("Test failed");
			//logger.debug("Debug Logs");
			Assert.fail();  // failing the test bcs it came to catch block //
		}
		logger.info("*****TC001_Login finished*****");
		
		
	}
}

/* logs result after failing intentionally
2024-08-29 03:45:38.934 [main] INFO  testCases.TC001_Login - *****TC001_Login started*****
2024-08-29 03:45:44.668 [main] INFO  testCases.TC001_Login - *clicked on login***
2024-08-29 03:45:44.686 [main] ERROR testCases.TC001_Login - Test failed
2024-08-29 03:45:44.687 [main] DEBUG testCases.TC001_Login - Debug Logs
*/
