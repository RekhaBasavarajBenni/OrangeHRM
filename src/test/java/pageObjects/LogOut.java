package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOut extends BasePage
{

	public LogOut(WebDriver driver) 
	{
		super(driver);
		
	}
	
	// user locator
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']") WebElement linkUserDropdown;
	// logout locator
	@FindBy(xpath="//a[normalize-space()='Logout']") WebElement linkLogOut;
	
	public void clickUser()
	{
		linkUserDropdown.click();
	}
	
	public void clickLogOut()
	{
		linkLogOut.click();
	}
		

}
