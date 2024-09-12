package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Base.B_class;
import pageObjects.loginPage;

public class TC_03_LoginWithoutCred extends B_class{
	
	
	@Test
	public void loginTestWithoutCred()
	{
		 WebDriver driver = B_class.getDriver();
		loginPage lp= new loginPage(driver);
		lp.desk();
		lp.loginButton();
	}

}
