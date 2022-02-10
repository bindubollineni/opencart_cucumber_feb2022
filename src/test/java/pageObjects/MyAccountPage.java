package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage 
{
	WebDriver driver;

	public MyAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Locators
	@FindBy(xpath="//li[@class='dropdown']//a[text()='Logout']")
	WebElement lnkLogout;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a")
	List <WebElement> logout;



	/*public void clickLogout()
{
	lnkLogout.click();
}*/


	public void clickLogout()
	{
		for(WebElement d : logout)
		{
			if(	d.getText().equals("Logout"))
			{
				d.click();
				break;
			}
		}
	}
	
	public void validateLogoutText()
	{
		
	}


}
