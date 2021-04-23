package org.MainClassPackage;

import java.io.IOException;
import java.util.Date;

import org.FunctionModule.FaceBookModuleFunction;
import org.FunctionModule.LibGlobal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pojoclass.org.DemoQAPojo;

public class DemoQATest extends LibGlobal {
	
	@BeforeClass
	public static void loadBrowser1()
	{
		browserChromeLaunch();
		toload("https://demoqa.com/automation-practice-form");
		maximizeWindow();
		toGetCurrentURL();
		toGetTitle();
	}
	
	@AfterClass
	public static void endBrowser()
	{
		
		driver.quit();
		System.out.println("End Browser");
	}

	@Before
	public void startDate() 
	{
		
		Date d=new Date();
		System.out.println("StartDate= "+d);

	}
	
	@After
	public void endDate()
	{
		Date d=new Date();
		System.out.println("end date= " +d);
		
	}
		
	
	@Test
	public void demoSQARegister() throws IOException, InterruptedException
	{	
		DemoQAPojo dpojo=new DemoQAPojo();
		toSendKeys(dpojo.getTxtFName(), "Tittu");
		toSendKeys(dpojo.getTxtLName(), "Varghese");
		toMoveToElement(dpojo.getTxtEmail());
		toSendKeys(dpojo.getTxtEmail(), "tittuanish@gmail.com");		
		toSendKeys(dpojo.getTxtMobNumber(), "7678678");
		toJSClick("click()", dpojo.getRadioMale());
		toJSClick("click()", dpojo.getTxtDOB());
		toSelectItemVisibleText(dpojo.getDobMonth(),"April");
		toSelectItemVisibleText(dpojo.getDobYear(),"1985");
		toJSClick("click()", dpojo.getDobDay());
		toJSClick("click()", dpojo.getCheckSports());
		toJSClick("click()", dpojo.getCheckReading());
		toJSClick("click()", dpojo.getBtnSubmit());
		Thread.sleep(2000);
		System.out.println("Success");
	}
	
	@Test
	public void tc2() {
		
		System.out.println("test1");

	}
	
	@Test
	public void tc3()
	{
		System.out.println("test2");
	}

		

}
