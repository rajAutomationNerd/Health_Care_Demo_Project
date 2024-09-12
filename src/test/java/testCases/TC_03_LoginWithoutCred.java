package testCases;

import org.testng.annotations.Test;

import Base.B_class;
import pageObjects.loginPage;

public class TC_03_LoginWithoutCred extends B_class{
	
	
	@Test
	public void loginTestWithoutCred()
	{
		loginPage lp= new loginPage(driver);
		lp.desk();
		lp.loginButton();
	}

}
