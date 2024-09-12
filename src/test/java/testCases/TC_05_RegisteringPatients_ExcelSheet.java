package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Base.B_class;
import pageObjects.RegisterPatient;
import pageObjects.loginPage;
import utils.ExcelUtils;
import utils.ScreenshotUtil;

public class TC_05_RegisteringPatients_ExcelSheet extends B_class {

    private static final Logger logger = LogManager.getLogger(TC_05_RegisteringPatients_ExcelSheet.class);

    @BeforeClass
    public void setup() {
        try {
            // Path to your Excel file and sheet name
            String excelPath = "testData/Patient_Names.xlsx";
            String sheetName = "PatientsDetails";
            ExcelUtils.setExcelFile(excelPath, sheetName);
        } catch (Exception e) {
            logger.error("Error initializing ExcelUtils: ", e);
            throw new RuntimeException("Failed to initialize ExcelUtils", e);
        }
    }

    @DataProvider(name = "patientDataProvider")
    public Object[][] patientData() {
        try {
            return ExcelUtils.getData();
        } catch (Exception e) {
            logger.error("Error reading data from Excel: ", e);
            throw new RuntimeException("Failed to read data from Excel", e);
        }
    }

    @Test(dataProvider = "patientDataProvider")
    public void registeringPatient(String firstName, String lastName, String gender, String day, String month, String year, String address, String postalCode, String phoneNumber) {
        day = day.replace(".", "").trim();
        month = month.replace(".", "").trim();
        year = year.replace(".", "").trim();

        logger.info("Starting registration for patient: " + firstName + " " + lastName);

        WebDriver driver = B_class.getDriver();
        loginPage lp = new loginPage(driver);

        try {
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

            logger.info("Successfully registered patient: " + firstName + " " + lastName);
        } catch (Exception e) {
            logger.error("Error during patient registration: ", e);
            // Take a screenshot using the ScreenshotUtil class
            ScreenshotUtil.takeScreenshot(driver, "screenshots/registrationFailure_" + firstName + "_" + lastName + ".png");
            throw e; // Re-throw exception after taking screenshot
        }
    }
}
