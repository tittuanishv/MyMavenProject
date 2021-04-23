package pojoclass.org;

import org.FunctionModule.LibGlobal;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class DemoQAPojo extends LibGlobal {
	
	public DemoQAPojo()
	{
		PageFactory.initElements(driver, this);
	}
		@CacheLookup
		@FindBy(id="firstName")
		private WebElement txtFName;
		
		@FindBy(id="lastName")
		private WebElement txtLName;		
		
		@FindBy(id="userEmail")
		private WebElement txtEmail;		
		
		@FindBy(xpath="(//input[@name='gender'])[1]")
		private WebElement radioMale;		
		
		@FindBy(id="userNumber")
		private WebElement txtMobNumber;
		
		@FindBy(xpath="//input[@id='dateOfBirthInput']")
		private WebElement txtDOB;
		
		@FindBy(xpath="//select[@class='react-datepicker__month-select']")
		private WebElement dobMonth;
		
		@FindBy(xpath="//select[@class='react-datepicker__year-select']")
		private WebElement dobYear;
		
		@FindBy(xpath="//div[text()='22']")
		private WebElement dobDay;
		
		@FindBy(xpath="//input[@id='hobbies-checkbox-1']")
		private WebElement checkSports;
		
		@FindBy(xpath="//input[@id='hobbies-checkbox-2']")
		private WebElement checkReading;
		
		@FindBy(id="submit")
		private WebElement btnSubmit;
		
		public WebElement getBtnSubmit() {
			return btnSubmit;
		}


		public WebElement getTxtDOB() {
			return txtDOB;
		}


		public WebElement getCheckReading() {
			return checkReading;
		}


		public WebElement getCheckSports() {
			return checkSports;
		}


		public WebElement getDobMonth() {
			return dobMonth;
		}


		public WebElement getDobYear() {
			return dobYear;
		}


		public WebElement getDobDay() {
			return dobDay;
		}


		public WebElement getTxtFName() {
			return txtFName;
		}


		public WebElement getTxtLName() {
			return txtLName;
		}


		public WebElement getTxtEmail() {
			return txtEmail;
		}


		public WebElement getRadioMale() {
			return radioMale;
		}


		public WebElement getTxtMobNumber() {
			return txtMobNumber;
		}
		
		
		
		
		
		
		
			
		
		
		

}
