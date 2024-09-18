package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckLogo extends BasePage
{

	public CheckLogo(WebDriver driver) 
	{
		super(driver);
		
	}

	// logo locator //
	@FindBy(xpath="//img[@alt='client brand banner']") WebElement linkLogo;
	
	public boolean verifyLogo()
	{
		return linkLogo.isDisplayed();
	}
	
}
