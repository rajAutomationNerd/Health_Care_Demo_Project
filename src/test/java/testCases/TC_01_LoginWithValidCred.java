package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Base.B_class;
import pageObjects.loginPage;

public class TC_01_LoginWithValidCred extends B_class{
	
	
	@Test
	public void loginTest()
	{
		 WebDriver driver = B_class.getDriver();
		loginPage lp= new loginPage(driver);
		lp.user("Admin");
		lp.pass("Admin123");
		lp.desk();
		lp.loginButton();
	}

}
