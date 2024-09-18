package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddEmployee;

public class TC003_AddEmployee extends TC001_Login
{
	@Test(groups= "Regression")
	public void addEmployee() throws InterruptedException
	{ 
		logger.info("*****TC003_AddEmployee started*****");
		try
		{
		AddEmployee emp = new AddEmployee(driver);
		
		Thread.sleep(5000);
		
		emp.clickAdmin();
		logger.info("*****Clicked on admin*****");
		
		emp.clickAddButton();
		logger.info("*****Clicked on  add admin*****");
		
		emp.clickUserRole();
		logger.info("*****Clicked on user role*****");
		
		Thread.sleep(5000);
		emp.selectUserRole();
		
		emp.enterEmployeeName("Praneet");
		logger.info("*****entered name*****");
		
		emp.clickStatus();
		
		Thread.sleep(5000);
		emp.selectStatus();          // by index
		logger.info("*****selected status*****");
		
		emp.setUserName("PraneetBenni");
		
		String password = "Praneet123";
		
		emp.setPassword(password);
		
		emp.setConfirmPassword(password);
		logger.info("*****confirmed password*****");
		
		Thread.sleep(5000);
		emp.clickSave();
		logger.info("*****Clicked save*****");
		
		// if test failed got failed bcs of title matching else block will take care //
		if (driver.getTitle().equals("OrangeHRM"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
		// if any other exception then catch block will fail the test //
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
	}
}
/* logs: after passing
2024-08-29 03:53:49.113 [main] INFO  testCases.TC003_AddEmployee - *****TC001_Login started*****
2024-08-29 03:53:56.050 [main] INFO  testCases.TC003_AddEmployee - *clicked on login***
2024-08-29 03:53:56.074 [main] INFO  testCases.TC003_AddEmployee - *****TC001_Login finished*****
2024-08-29 03:53:56.085 [main] INFO  testCases.TC003_AddEmployee - *****TC003_AddEmployee started*****
2024-08-29 03:54:03.397 [main] INFO  testCases.TC003_AddEmployee - *****Clicked on admin*****
2024-08-29 03:54:06.614 [main] INFO  testCases.TC003_AddEmployee - *****Clicked on  add admin*****
2024-08-29 03:54:07.462 [main] INFO  testCases.TC003_AddEmployee - *****Clicked on user role*****
2024-08-29 03:54:12.663 [main] INFO  testCases.TC003_AddEmployee - *****entered name*****
2024-08-29 03:54:17.899 [main] INFO  testCases.TC003_AddEmployee - *****selected status*****
2024-08-29 03:54:18.245 [main] INFO  testCases.TC003_AddEmployee - *****confirmed password*****
2024-08-29 03:54:23.322 [main] INFO  testCases.TC003_AddEmployee - *****Clicked save*****

logs: after failing
2024-08-29 03:55:55.570 [main] INFO  testCases.TC003_AddEmployee - *****TC001_Login started*****
2024-08-29 03:56:02.618 [main] INFO  testCases.TC003_AddEmployee - *clicked on login***
2024-08-29 03:56:02.642 [main] INFO  testCases.TC003_AddEmployee - *****TC001_Login finished*****
2024-08-29 03:56:02.655 [main] INFO  testCases.TC003_AddEmployee - *****TC003_AddEmployee started*****
2024-08-29 03:56:08.643 [main] INFO  testCases.TC003_AddEmployee - *****Clicked on admin*****
2024-08-29 03:56:10.636 [main] INFO  testCases.TC003_AddEmployee - *****Clicked on  add admin*****
2024-08-29 03:56:11.221 [main] INFO  testCases.TC003_AddEmployee - *****Clicked on user role*****
2024-08-29 03:56:16.462 [main] INFO  testCases.TC003_AddEmployee - *****entered name*****
2024-08-29 03:56:21.640 [main] INFO  testCases.TC003_AddEmployee - *****selected status*****
2024-08-29 03:56:22.000 [main] INFO  testCases.TC003_AddEmployee - *****confirmed password*****
2024-08-29 03:56:27.091 [main] INFO  testCases.TC003_AddEmployee - *****Clicked save*****
2024-08-29 03:56:27.100 [main] ERROR testCases.TC003_AddEmployee - Test failed
2024-08-29 03:56:27.100 [main] DEBUG testCases.TC003_AddEmployee - Debug logs

console logs:
04:04:40.359 [main] INFO  testCases.TC003_AddEmployee - *****TC001_Login started*****
04:04:47.703 [main] INFO  testCases.TC003_AddEmployee - *clicked on login***
04:04:47.717 [main] INFO  testCases.TC003_AddEmployee - *****TC001_Login finished*****
04:04:47.727 [main] INFO  testCases.TC003_AddEmployee - *****TC003_AddEmployee started*****
04:04:54.586 [main] INFO  testCases.TC003_AddEmployee - *****Clicked on admin*****
04:04:56.301 [main] INFO  testCases.TC003_AddEmployee - *****Clicked on  add admin*****
04:04:57.245 [main] INFO  testCases.TC003_AddEmployee - *****Clicked on user role*****
04:05:02.524 [main] INFO  testCases.TC003_AddEmployee - *****entered name*****
04:05:07.754 [main] INFO  testCases.TC003_AddEmployee - *****selected status*****
04:05:08.118 [main] INFO  testCases.TC003_AddEmployee - *****confirmed password*****
04:05:13.228 [main] INFO  testCases.TC003_AddEmployee - *****Clicked save*****
PASSED: testCases.TC001_Login.loginTest
PASSED: testCases.TC003_AddEmployee.addEmployee

===============================================
    Default test
    Tests run: 2, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 2, Passes: 2, Failures: 0, Skips: 0
===============================================



*/

