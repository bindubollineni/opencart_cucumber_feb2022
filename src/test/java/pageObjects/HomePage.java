package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@title='My Account']")
	WebElement link_MyAccount;

	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement link_Register;

	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement link_Login;

	@FindBy(xpath="//input[@name='search']")
	WebElement txt_Search;

	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement btn_Search;
	
	@FindBy(xpath="//a[text()='Desktops']")
	WebElement lnk_Desktops;
	
	@FindBy(xpath="//a[normalize-space()='Show All Desktops']")
	WebElement show_All_Desktop;

	public void clickMyAccount()

	{
		link_MyAccount.click();
	}

	public void clickRegister()
	{
		link_Register.click();
	}

	public void clickLogin()
	{
		link_Login.click();
	}

	public void setSearchtxt(String str)
	{
		txt_Search.sendKeys(str);
	}

	public void clickSearchBtn()
	{
		btn_Search.click();
	}

	
	public void click_Desktops()
	{
		Actions action = new Actions(driver);
		action.moveToElement(lnk_Desktops).click().perform();
	}
	
	public void click_ShowAllDesktop()
	{
		Actions action = new Actions(driver);
		action.moveToElement(show_All_Desktop).click().perform();
	}
	
	
	
	
}
