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

public class FacebookMainTest extends LibGlobal
{
		@BeforeClass
		public static void loadBrowser1()
		{
			browserChromeLaunch();
			toload("https://www.facebook.com/");
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
		public void faceBookLogin() throws IOException
		{	
			FaceBookModuleFunction fc=new FaceBookModuleFunction();
			fc.toPojoLogin("tittu","tittu");
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//to Read the data from excel
	//1.Path of a file
		/* File  f=new File("C:\\Users\\Anish\\eclipse-workspace\\MavenDemo01\\ExcelFiles\\facebook.xlsx") ;
		//2.to read a file
		 FileInputStream input=new FileInputStream(f);
		 //3.Workbook Instatition
		 Workbook w=new XSSFWorkbook(input);
		 //4.to read the sheet
		 Sheet s=w.getSheet("Login");
		 //5.to get row
		 Row r=s.getRow(2);
		 //6.to get the cell
		Cell userName=r.getCell(0);
		Cell passWD=r.getCell(1);
		//7.to Fetch a value in a particular cell
		String uName=userName.getStringCellValue();
		System.out.println(uName);*/
		//Pass the Value to the UserName Field
		//WebElement txtUserName=driver.findElement(By.name(obj.getProperty("facebookUserName")));
	  // toSendKeys(txtUserName, uName);
		
		
		//String pWD=passWD.getStringCellValue();
		//System.out.println(pWD);
		//Pass the value to the password
		//WebElement txtPassword=driver.findElement(By.name(obj.getProperty("facebookPassword")));
		//toSendKeys(txtPassword, pWD);
		

