package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeHRMLogin extends BasePage
{
	// constructor
	public OrangeHRMLogin(WebDriver driver) 
	{
		super(driver);
	}

	// locators
	@FindBy(xpath="//input[@placeholder='Username']") WebElement linkUserName;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement linkPassword;
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement btnLogin;
	

	// Action Methods
	public void setUserName(String name)
	{
		linkUserName.sendKeys(name);
	}
	
	public void setPassword(String password)
	{
		linkPassword.sendKeys(password);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	
}
