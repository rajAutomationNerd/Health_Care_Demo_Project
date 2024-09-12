package Base;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class B_class {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(B_class.class);

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("Driver initialized and navigated to login page.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Driver quit successfully.");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
