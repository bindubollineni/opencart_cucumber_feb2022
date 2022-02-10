package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	//Constructors
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Locators
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_emailId;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_pwd;
	@FindBy(xpath="//input[@value='Login']")
	WebElement btn_Login;

	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;

	@FindBy(xpath="//*[@id=\"logo\"]/h1/a")
	WebElement title_Login;
	
	@FindBy(xpath="//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
	WebElement btn_ForgotPwd;
	
	

	//Action Methods

	public void setEmailId(String em)
	{
		txt_emailId.sendKeys(em);
	}

	public void setPwd(String pwd)
	{
		txt_pwd.sendKeys(pwd);
	}

	public void click_LoginBtn()
	{
		btn_Login.click();
	}
	public  boolean validateLogin()
	{ 
		try
		{
			return (msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean validateTitle()
	{
		try
		{
			return (title_Login.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void click_ForgotPwd()
	{
		btn_ForgotPwd.click();
	}

}
