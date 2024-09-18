package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddEmployee extends BasePage {

	public AddEmployee(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Admin']")
	WebElement linkadmin;
	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement btnAdd;
	@FindBy(xpath = "//div[@class=\"oxd-grid-item oxd-grid-item--gutters\"][1]//div[2]//div//div//div[2]") 
	WebElement dropdownUserRole;  
	@FindBy(xpath="//span[contains(text(),'Admin')]") 
	WebElement linkAdminDropdown;
	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement txtName;
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]")
	WebElement dropdownStatus;
	@FindBy(xpath="//span[normalize-space()='Enabled']")
	WebElement linkEnabledDropdown;
	@FindBy(xpath = "//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
	WebElement linkUserName;
	@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
	WebElement linkPassword;
	@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
	WebElement linkConfirmPassword;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement btnSave;

	public void clickAdmin() 
	{
		linkadmin.click();
	}

	public void clickAddButton() 
	{
		btnAdd.click();
	}

	public void clickUserRole()
	{
		dropdownUserRole.click();
	}
	
	public void selectUserRole()  // selecting admin from the dropdown
	{
		linkAdminDropdown.click();
	}

	public void enterEmployeeName(String name) 
	{
		txtName.sendKeys(name);
	}

	public void clickStatus()
	{
		dropdownStatus.click();
	}
	
	public void selectStatus()
	{
		linkEnabledDropdown.click();
	}
	
	public void setUserName(String user_name)
	{
		linkUserName.sendKeys(user_name);
	}
	
	public void setPassword(String password)
	{
		linkPassword.sendKeys(password);
	}
	
	public void setConfirmPassword(String password)
	{
		linkConfirmPassword.sendKeys(password);
	}
	
	public void clickSave()
	{
		btnSave.click();
	}
}
