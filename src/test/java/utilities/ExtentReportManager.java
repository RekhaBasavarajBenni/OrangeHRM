package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener
{
	// variables created in class level with class and object 
	// sperk reporter is object of ExtentSparkReporter //
	public ExtentSparkReporter sparkReporter;   // popultate UI of the report  //
	public ExtentReports extent ;      // populate common info of the report //
	public ExtentTest test;   // creating test case entries in the report and update status of the test methods //
	
	String repName;
	
	public void onStart(ITestContext context)
	{
		// first creating timestamp  or getting current timestamp
		/*  Method 1
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");   // format
		Date dt = new Date();  
		String currentdatestimestamps = df.format(dt);  // generating date in particular format
		*/      // OR //
		
		// Method 2
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());  // time stamp
		
		// concatinating reportname with timestamp and extension .html
		repName = "Test-Report-" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);
		// location specifying above in sparkReporter object //
		
		// accessing more methods for the title, name and theme of the report //
		// using sparkReporter object //
		sparkReporter.config().setDocumentTitle("OrangeHRM Automation Report");   // Title of the report //
		sparkReporter.config().setReportName("OrangeHRM Functional Testing");    // Name of the report //
		sparkReporter.config().setTheme(Theme.DARK);                   // Theme of the report //
		
		
		// using extent object we can populate common info //
		extent = new ExtentReports();
		// attatching extent and sparkReporter 
		extent.attachReporter(sparkReporter);  // connecting each other classes //
		
		// using extent object we can update common info below using .setSystemInfo method 
		extent.setSystemInfo("Application", "OrangeHRM");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", System.getProperty("user.name")); // returns current user
		
		// getting dynamically the other things like OS,  browser etc
		// capturing os and browser and groups from xml file
		// .getCurrentXmlTest()  will retuen xml file
		String os = context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Opearting System", os);
		
		String browser = context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Browser", browser);
		
		List <String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
		if (!includedGroups.isEmpty())
		{
			extent.setSystemInfo("Groups", includedGroups.toString());
			// if groups are empty then .toString() method will add group names the report
		}
	} 
	
	
	public void onTestSuccess(ITestResult result)
	{
		// using test object we already created above //
		test = extent.createTest(result.getTestClass().getName());  // creating new entry in report //
		test.assignCategory(result.getMethod().getGroups());  // to display groups in report
		test.log(Status.PASS,result.getName() + "Test case PASSED"); // update status p/f/s
	}
	 
	public void onTestFailure(ITestResult result) 
	{
		test = extent.createTest(result.getTestClass().getName());   // creating new entry in report //
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL, result.getName() + "Test case FAILED");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try
		{
			String imgPath  =new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
	}
	
	
	public void onTestSkipped(ITestResult result)
	{
		// using test object we already created above //
		test = extent.createTest(result.getTestClass().getName());   // creating new entry in report //
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() + "Test case SKIPPED"); // update status p/f/s
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	
	public void onFinish(ITestContext result)
	{
		extent.flush();
		
		String pathOfextentReport  = System.getProperty("user.dir")+"\\reports\\" + repName;
		File extentReport = new File(pathOfextentReport);
		
		try
		{
			Desktop.getDesktop().browse(extentReport.toURI());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
