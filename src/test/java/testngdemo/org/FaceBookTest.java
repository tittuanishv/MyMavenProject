package testngdemo.org;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.Date;
import org.FunctionModule.LibGlobal;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import org.testng.asserts.SoftAssert;

import pojoclass.org.FacebookLoginPojo;

public class FaceBookTest extends LibGlobal {
	@BeforeClass
	private void loadBrowser()
	{
		browserChromeLaunch();
		toload("https://www.facebook.com/");
		maximizeWindow();
		
	}
	@AfterClass
	private void endBrowser()
	{
		toQuit();
	}
	
	@BeforeMethod
	private void startDate() {
		Date d=new Date();
		System.out.println("Start Date: "+d);		
		
	}
	
	@AfterMethod
	private void endDate() {
		Date d=new Date();
		System.out.println("End Date: "+d);
		
	}
	
	@Test(priority=7)
	private void tc1() {
		System.out.println("Testcase 1");
		String actualTitle=toGetTitle();
		String expectedTitle="Facebook – log in or sign up";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	//hard assert
	@Parameters({"username","password"})
	@Test(priority=22)
	private void tc2(String user, String pass) {
		FacebookLoginPojo fpojo=new FacebookLoginPojo();
		//SoftAssert sa=new SoftAssert();
		String expectedUName="tittuani@gmail.com";
		String expectedPassWd="titt";
		toSendKeys(fpojo.getTxtUser(), user);
		String actualUname=fpojo.getTxtUser().getAttribute("value");
		Assert.assertEquals(actualUname, expectedUName);
		toSendKeys(fpojo.getTxtPass(), pass);
		String actualPassWd=fpojo.getTxtPass().getAttribute("value");
		Assert.assertEquals(actualPassWd, expectedPassWd);
		//sa.assertAll();
		clickElement(fpojo.getBtnLogin());
		
	}
	
	//soft assert
	@Parameters({"username","password"})
	@Test(priority=20)
	private void tc4(String user, String pass) {
		FacebookLoginPojo fpojo=new FacebookLoginPojo();
		SoftAssert sa=new SoftAssert();
		String expectedUName="tittuish@gmail.com";
		String expectedPassWd="titt";
		toSendKeys(fpojo.getTxtUser(), user);
		String actualUname=fpojo.getTxtUser().getAttribute("value");
		sa.assertEquals(actualUname, expectedUName);
		toSendKeys(fpojo.getTxtPass(), pass);
		String actualPassWd=fpojo.getTxtPass().getAttribute("value");
		sa.assertEquals(actualPassWd, expectedPassWd);
		sa.assertAll();
		clickElement(fpojo.getBtnLogin());
		
	}
	@Test(priority=-3)
	private void tc3() {
		System.out.println("Testcase 3");
		String actualUrl=toGetCurrentURL();
		String expectedUrl="https://www.facebook.com/";
		Assert.assertEquals(actualUrl, expectedUrl);
		

	}

  
}
