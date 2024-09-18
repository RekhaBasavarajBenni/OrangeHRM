package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePassword extends BasePage
{
	public ChangePassword(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath="//p[@class='oxd-userdropdown-name']") WebElement linkUserDropdown;
	@FindBy(xpath="//a[normalize-space()='Change Password']") WebElement linkChangePassword;
	@FindBy(xpath="//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']") WebElement linkCurrentPassword;
	@FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']") WebElement linkNewPassword;
	@FindBy(xpath="//div[@class='oxd-form-row user-password-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']") WebElement linkConfirnPassword;
	@FindBy(xpath="//button[normalize-space()='Save']") WebElement btnSave;
	
	public void clickUserDropdown()
	{
		linkUserDropdown.click();
	}
	
	public void changePassword()
	{
		linkChangePassword.click();
	}
	
	public void enterCurrentPassword(String current_Password)
	{
		linkCurrentPassword.sendKeys(current_Password);
	}
	
	public void setNewPassword(String new_password)
	{
		linkNewPassword.sendKeys(new_password);
	}
	
	public void confirmNewPassword(String confirm_new_password)
	{
		linkConfirnPassword.sendKeys(confirm_new_password);
	}
	
	public void clickSaveButton()
	{
		btnSave.click();
	}
			
}
