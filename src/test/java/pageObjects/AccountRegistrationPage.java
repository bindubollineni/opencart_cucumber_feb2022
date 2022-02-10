package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountRegistrationPage {

	WebDriver driver;
	
	//Constructors
	public AccountRegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_FirstName;
	

	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txt_LastName;

	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_Email;

	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txt_Telephone;

	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_Password;

	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txt_Password_Confirm;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement radioBtn_Subscribe;
	

	@FindBy(xpath="//input[@name='agree']")
	WebElement checkBtn_Agree;

	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_Continue;
	
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement msg_Confirmation;
	
	//Action Methods
	public void setFirstName(String fName)
	{
		txt_FirstName.sendKeys(fName);
	}
	
	public void setLastName(String lName)
	{
		txt_LastName.sendKeys(lName);

	}
	public void setEmail(String email)
	{
		txt_Email.sendKeys(email);
	}
	public void setTelephone(String tNum)
	{
		txt_Telephone.sendKeys(tNum);
	}
	public void setPassword(String pwd)
	{
		txt_Password.sendKeys(pwd);
	}
	public void setConfirmPassword(String pwd)
	{
		txt_Password_Confirm.sendKeys(pwd);
	}
	public void click_RadioBtn()
	{
		radioBtn_Subscribe.click();
	}
	public void check_PrivacyPolicy()
	{
		checkBtn_Agree.click();
	}
	public void click_Continue()
	{
		btn_Continue.click();

	}
	
	//In page Object Class we dont do any validations
	public String checkConfirmation()
	{
		try
		{
			return (msg_Confirmation.getText());
		}
		catch(Exception e)
		{
		return (e.getMessage())	;
		}
		}
	
}
