package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPatient {
	WebDriver driver;

	public WebDriverWait wait;
	
	public RegisterPatient(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@id='apps']/a[4]")
	WebElement rp;
	
	@FindBy(xpath="//input[@name='givenName']")
	WebElement fname;
	
	@FindBy(xpath="//input[@name='familyName']")
	WebElement lname;
	
	@FindBy(id="next-button")
	WebElement nnxtbtn;
	
	@FindBy(id="gender-field")
	WebElement genderOption;
	
	@FindBy(id="birthdateDay-field")
	WebElement bdayField;
	
	@FindBy(id="birthdateMonth-field")
	WebElement bmonthFeild;
	
	@FindBy(id="birthdateYear-field")
	WebElement yearField;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="postalCode")
	WebElement pc;
	
	@FindBy(xpath="//input[@name='phoneNumber']")
	WebElement phone;
	
	@FindBy(id="submit")
	WebElement submit;
	
	
	
	public void clckReg()
	{
		rp.click();
	}
	
	public void enterFirstName(String name) {
        wait.until(ExpectedConditions.visibilityOf(fname));
        fname.sendKeys(name);
    }
	public void LastName(String ln)
	{
		wait.until(ExpectedConditions.visibilityOf(lname));
		lname.sendKeys(ln);
	}
	public void nxtBtn()
	{
		nnxtbtn.click();
	}
	
	
	public void selectGender(String gender) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(genderOption));
	    Select select = new Select(genderOption);
	    select.selectByVisibleText(gender);
	}
	
	public void selectDay(String date)
	{
		bdayField.sendKeys(date);
	}
        
     public void selectMonth(String month) {
      Select dropdown = new Select(bmonthFeild);
     dropdown.selectByVisibleText(month);
     }
     
     public void selectYear(String year)
     {
    	 yearField.sendKeys(year); 
     }
     
     public void enterAddress(String address)
     {
    	 address1.sendKeys(address);
     }
     
     public void enterPostal(String code)
     {
    	 pc.sendKeys(code);
     }
     
     public void enterPhone(String ph)
     {
    	 phone.sendKeys(ph);
     }
     
     public void confirm()
     {
    	 submit.click();
     }
        
        

}
