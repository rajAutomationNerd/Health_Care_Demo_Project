package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.B_class;
import pageObjects.loginPage;

public class TC_02_LoginWithInvalid extends B_class{
	
	
	@Test
	public void loginTestInvalid()
	{
		loginPage lp= new loginPage(driver);
		lp.user("Admin");
		lp.pass("Rajkumar");
		lp.desk();
		lp.loginButton();
		
		 String expectedError = "Invalid username/password. Please try again.";
	        String actualError = lp.geterror();

	        // Validate the actual error message matches the expected one
	        Assert.assertEquals(actualError, expectedError, "Error message validation failed!");
	}

}
