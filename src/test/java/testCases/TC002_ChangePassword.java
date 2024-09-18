package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ChangePassword;

public class TC002_ChangePassword extends TC001_Login
{
	@Test(groups= "Sanity")
	public void changePassword() throws InterruptedException
	{
		logger.info("*****TC002_ChangePassword started*****");
		
		try
		{
		ChangePassword cp = new ChangePassword(driver);
		
		cp.clickUserDropdown();
		
		cp.changePassword();
		
		cp.enterCurrentPassword("admin123");
		
		String new_password = "admin12345";
		
		cp.setNewPassword(new_password);
		
		cp.confirmNewPassword(new_password);
		
		cp.clickSaveButton();
		}
		catch(Exception e)
		{
			logger.error("Test case failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
		logger.info("*****TC002_ChangePassword Finished*****");
	}
}

