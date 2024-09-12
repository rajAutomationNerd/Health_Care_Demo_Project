package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	public WebDriver driver;
	
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
	PageFactory.initElements(driver, this);	
	}
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="Registration Desk")
	WebElement rdesk;
	
	@FindBy(id="loginButton")
	WebElement lbutton;
	
	@FindBy(id="error-message")
	WebElement errorm;
	
	public void user(String txtUser)
	{
		username.sendKeys(txtUser);
	}
	
	public void pass(String txtPass)
	{
		password.sendKeys(txtPass);
	}
	
	public void desk()
	{
		rdesk.click();
	}
	
	public void loginButton()
	{
		lbutton.click();
	}
	
	public String geterror()
	{
	  return errorm.getText();
	}
	

}
