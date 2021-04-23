package org.FunctionModule;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pojoclass.org.FacebookLoginPojo;

public class FaceBookModuleFunction extends LibGlobal {

	//Login to Facebook
	public static void toLogin(String uName,String pasWd) throws IOException {
		
		toFileInputStream("user.dir","\\application.properties");			
		WebElement txtUserName=driver.findElement(By.name(obj.getProperty("facebookUserName")));
		toSendKeys(txtUserName, uName);
		WebElement txtPassword=driver.findElement(By.name(obj.getProperty("facebookPassword")));
		toSendKeys(txtPassword, pasWd);
		WebElement btnLogin=driver.findElement(By.name(obj.getProperty("facebookLogin")));
		btnLogin.click();		
		toTakeScreenShot("C:\\Users\\Anish\\eclipse-workspace\\MavenDemo01\\ScreenShots\\loginpage.png");
	}
	
	//Login from Pojo Class
	public static void toPojoLogin(String uName,String pasWd) throws IOException
	{
		FacebookLoginPojo fbPoJo=new FacebookLoginPojo();
		toSendKeys(fbPoJo.getTxtUser(),uName);
		toSendKeys(fbPoJo.getTxtPass(),pasWd );
		clickElement(fbPoJo.getBtnLogin());
		toTakeScreenShot("C:\\Users\\Anish\\eclipse-workspace\\MavenDemo01\\ScreenShots\\fbpojologin.png");
	}
	
	
	
	//LOgin from Excel
    public static void toLoginFromExcel(String fileName,String sheet,int rowNumber) throws IOException
    {
    	toFileInputStream("user.dir","\\application.properties");	
    	String userName=toReadFromExcel(fileName, sheet, rowNumber, 0);		
    	WebElement txtUserName=driver.findElement(By.name(obj.getProperty("facebookUserName")));
		//WebElement txtUserName=driver.findElement(By.id("email"));
		toSendKeys(txtUserName, userName);
		//Read Password
		String userPWD=toReadFromExcel(fileName, sheet, rowNumber, 1);		
		//WebElement txtPassword=driver.findElement(By.id("pass"));
		WebElement txtPassword=driver.findElement(By.name(obj.getProperty("facebookPassword")));
		toSendKeys(txtPassword, userPWD);
		WebElement btnLogin=driver.findElement(By.name(obj.getProperty("facebookLogin")));
		btnLogin.click();
		toTakeScreenShot("C:\\Users\\Anish\\eclipse-workspace\\MavenDemo01\\ScreenShots\\loginPageFromExcel.png");
    }
	
	//Register FAcebook account
	public static void toRegister(String fName,String lName,String email,String passWD,String bDay, String bMonth, String bYear, String gender) throws IOException {
		
		toFileInputStream("user.dir","\\application.properties");			
		WebElement btnCreateAnAccount=driver.findElement(By.xpath(obj.getProperty("facebookCreateNewAcc")));
		clickElement(btnCreateAnAccount);
		toWaitImplicit(30, TimeUnit.SECONDS);
		
		//Enter FirstName,LastName, Email,passwd,Date of Birth
		WebElement txtfName=driver.findElement(By.name(obj.getProperty("registerFName")));
		toSendKeys(txtfName, fName);
		WebElement txtLName=driver.findElement(By.name(obj.getProperty("registerLName")));
		toSendKeys(txtLName, lName);
		WebElement txtEmail=driver.findElement(By.name(obj.getProperty("registerEmailMob")));
		toSendKeys(txtEmail, email);
		WebElement txtPasswd=driver.findElement(By.name(obj.getProperty("registerPasswd")));
		toSendKeys(txtPasswd, passWD);
		WebElement drpDay=driver.findElement(By.name(obj.getProperty("dayOfBirth")));
		toSelectItemVisibleText(drpDay, bDay);
		WebElement drpMonth=driver.findElement(By.name(obj.getProperty("monthOfBirth")));
		toSelectItemVisibleText(drpMonth, bMonth);
		WebElement drpYear=driver.findElement(By.name(obj.getProperty("yearOfBirth")));
		toSelectItemVisibleText(drpYear, bYear);
		if((gender=="Male") ||(gender=="male"))
		{
			WebElement genMale=driver.findElement(By.xpath(obj.getProperty("genderMale")));
			clickElement(genMale);
		}
		else if(gender=="Female")
		{
			WebElement genfeMale=driver.findElement(By.xpath(obj.getProperty("genderFemale")));
			clickElement(genfeMale);
		}
		else
		{
			WebElement genOthers=driver.findElement(By.xpath(obj.getProperty("genderOther")));
			clickElement(genOthers);
		}
		
		toTakeScreenShot("C:\\Users\\Anish\\eclipse-workspace\\MavenDemo01\\ScreenShots\\registerPage.png");
		
	}
	
}
