//BasePage class is only for constructor //
//This class will be extended in every page object classes //
//This is the parent of all the page object classes //
//instead of creating constructor for all page object class everytime, we are creating it for one time in basepage class


package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage 
{
	WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
