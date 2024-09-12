package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.B_class;
import pageObjects.RegisterPatient;
import pageObjects.loginPage;

public class TC_04_Registering_Patient_DataProvider extends B_class {

    @DataProvider(name = "patientDataProvider")
    public Object[][] patientData() {
        return new Object[][] {
            {"Aarav", "Sharma", "Male", "10", "January", "1990", "123 Main St, Mumbai", "400001", "9876543210"},
            {"Isha", "Patel", "Female", "15", "February", "1992", "456 Park Ave, Delhi", "110001", "8765432109"},
            {"Vivaan", "Reddy", "Male", "20", "March", "1988", "789 Hill Rd, Bangalore", "560001", "7654321098"},
            {"Ananya", "Singh", "Female", "25", "April", "1995", "101 Lakeview, Chennai", "600001", "6543210987"},
            {"Arjun", "Gupta", "Male", "30", "May", "1980", "202 Sunset Blvd, Hyderabad", "500001", "5432109876"},
            {"Saanvi", "Kumar", "Female", "05", "June", "1993", "303 Greenfield, Pune", "411001", "4321098765"},
            {"Rohan", "Desai", "Male", "12", "July", "1990", "404 River Rd, Ahmedabad", "380001", "3210987654"},
            {"Mia", "Mehta", "Female", "18", "August", "1997", "505 Seaside, Kolkata", "700001", "2109876543"},
            {"Kabir", "Joshi", "Male", "22", "September", "1985", "606 Mountain St, Jaipur", "302001", "1098765432"},
            {"Aditi", "Nair", "Female", "28", "October", "1991", "707 City Center, Surat", "395001", "0987654321"}
        };
    }

    @Test(dataProvider = "patientDataProvider")
    public void registeringPatient(String firstName, String lastName, String gender, String day, String month, String year, String address, String postalCode, String phoneNumber) {
    	 WebDriver driver = B_class.getDriver();
        loginPage lp = new loginPage(driver);
        lp.user("Admin");
        lp.pass("Admin123");
        lp.desk();
        lp.loginButton();

        RegisterPatient reg = new RegisterPatient(driver);
        reg.clckReg();
        reg.enterFirstName(firstName);
        reg.LastName(lastName);
        reg.nxtBtn();
        reg.selectGender(gender);
        reg.nxtBtn();
        reg.selectDay(day);
        reg.selectMonth(month);
        reg.selectYear(year);
        reg.nxtBtn();
        reg.enterAddress(address);
        reg.enterPostal(postalCode);
        reg.nxtBtn();
        reg.enterPhone(phoneNumber);
        reg.nxtBtn();
        reg.nxtBtn();
        reg.confirm();
    }
}
