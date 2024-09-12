package testCases;

import java.time.Duration;

import org.testng.annotations.Test;

import Base.B_class;
import pageObjects.RegisterPatient;
import pageObjects.loginPage;

public class TC_04_Registering_Single_patient extends B_class {

	
	
	@Test
	public void registertingPatient()
	{
		loginPage lp= new loginPage(driver);
		lp.user("Admin");
		lp.pass("Admin123");
		lp.desk();
		lp.loginButton();
		RegisterPatient reg= new RegisterPatient(driver);
		reg.clckReg();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		reg.enterFirstName("Sudama");
		reg.LastName("kumar");
		reg.nxtBtn();
		reg.selectGender("Male");
		reg.nxtBtn();
		reg.selectDay("10");
		reg.selectMonth("February");
		reg.selectYear("2003");
		reg.nxtBtn();
		reg.enterAddress("JM/573");
		reg.enterPostal("116629");
		reg.nxtBtn();
		reg.enterPhone("1234455666");
		reg.nxtBtn();
		reg.nxtBtn();
		reg.confirm();
		
		
		
	}
}
