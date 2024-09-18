// performing login using excel sheet data using Data Providers class //

/* Conditions below:
Data is valid  - login success - test pass - logout
Data is valid - login failed - test fail 

Data is invalid - login success - test fail - logout
Data is invalid - login failed - test pass
*/

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckLogo;
import pageObjects.LogOut;
import pageObjects.OrangeHRMLogin;
import testBase.BaseClass;
import testBase.BaseClassForRemoteExcutionGrid;
import utilities.DataProviders;

public class TC004_LoginDataDrivenTest extends BaseClassForRemoteExcutionGrid
{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven")
	// data provider and and from which class it is taken are 2 parameters above //
	// if DP are created in another package then we ahve to use extra parameter like above //
	// parameters coming from xl data (String email, String psw, String expResult)
	public void verify_loginDDT(String username, String psw, String expResult) throws InterruptedException
	{
		logger.info("*****TC004_LoginDataDrivenTest started*****");
		
		try
		{
		OrangeHRMLogin lg = new OrangeHRMLogin(driver);
		
		lg.setUserName(username);
		lg.setPassword(psw);
		lg.clickLogin();
		Thread.sleep(5000);
		
		CheckLogo chlg = new CheckLogo(driver);
		boolean logopresent = chlg.verifyLogo();
		System.out.println("Logo present : " + logopresent);
		// based on this above condition whwether it is true or false we have to do the validation //

		/*
		 * Conditions below: 
		 * Data is valid - login success - test pass - logout 
		 				   login failed - test fail
		 
		 * Data is invalid - login success - test fail - logout 
		  					 login failed - test pass
		*/
		LogOut log = new LogOut(driver);
		
		Thread.sleep(5000);
		if (expResult.equalsIgnoreCase("Valid"))
		{
			if (logopresent==true)
			{
				Assert.assertTrue(true);   // if expres is Valid and logo is present then making test passed
				log.clickUser();
				log.clickLogOut();
			}
			else
			{
				Assert.assertTrue(false);  // if if cond is wrong then failing the test in else block 
			}
		}
		if (expResult.equalsIgnoreCase("InValid"))
		{
			if (logopresent==true)
			{
				log.clickUser();
				log.clickLogOut();
				Assert.assertTrue(false); // failing test bcs invalid data and login successfull should fail the test //
			}
			else
			{
				Assert.assertTrue(true);  // data is invalid, login is failed so test is passed // 
			}
		}
	
		}
		catch (Exception e)
		{
			Assert.fail();
		}
		logger.info("*****TC004_LoginDataDrivenTest finished*****");
		
	}
}
/*
Result after running this single class in master.xml
[RemoteTestNG] detected TestNG version 7.10.2
Logo present : true
Logo present : true

===============================================
Master Suite
Total tests run: 6, Passes: 2, Failures: 4, Skips: 0
===============================================

2 valid data are passed remaining are failed
*/
