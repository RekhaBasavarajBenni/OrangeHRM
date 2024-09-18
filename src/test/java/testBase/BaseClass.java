package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	public static WebDriver driver;    // making common variable using static //
 	public Logger logger;
	public Properties p;

	// setup method
	@BeforeClass(groups={"Sanity", "Master", "Regression", "Datadriven"}) // bcs every test needs setup method
	@Parameters({"os", "browser"})
	public void setUp(String os, String br) throws IOException 
	{
		logger = LogManager.getLogger(this.getClass());
		
		// loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		// for mutiple browsers //
		switch(br.toLowerCase())
		{
		case "chrome" : driver = new ChromeDriver(); break;
		case "edge" : driver = new EdgeDriver(); break;
		case "firefox" : driver = new FirefoxDriver(); break;
		default: System.out.println("Invalid Browser"); return;
		// return will totally exit from the execution if browser is not matched 
		// here only exiting from entire execution part when browser not matched
		}
		
		driver.manage().deleteAllCookies(); // to delete all cookies //
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// now instead of above url we can get it from properties file
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}

	// closing application method
	@AfterClass(groups={"Sanity", "Master", "Regression", "Datadriven"})  // we can add Datadriven as well, removing bcs comsumes time //
	public void tearDown() 
	{
		driver.quit();
	}

	public String captureScreen(String tname) 
	{
		// screenshot also we have to save with timestamp
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    File  sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	    
	    // actual name will be generated with timestamp
	    String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+tname+"__"+ timeStamp+ ".png";
		File targetFile = new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;

	}

}
