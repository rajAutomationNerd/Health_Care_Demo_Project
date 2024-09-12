package testCases;

import org.testng.annotations.Test;

import Base.B_class;
import pageObjects.loginPage;

public class TC_01_LoginWithValidCred extends B_class{
	
	
	@Test
	public void loginTest()
	{
		loginPage lp= new loginPage(driver);
		lp.user("Admin");
		lp.pass("Admin123");
		lp.desk();
		lp.loginButton();
	}

}
