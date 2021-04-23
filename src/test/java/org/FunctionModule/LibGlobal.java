package org.FunctionModule;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobal 
{
	public static WebDriver driver;
	public static Actions ac;
	public static JavascriptExecutor js;
	public static Select s;
	public static TakesScreenshot tk;
	public static WebDriverWait w;
	public static Properties obj;
	
	//Function for browser Launch
	public static void browserChromeLaunch() 
	{
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();		
	}
	
	//to load the url
	public static void toload(String url) 
	{
		driver.get(url);
	}
	
	//to maximize the screen
	public static void maximizeWindow()
	{
		driver.manage().window().maximize();
	}
	
	//to get current url
	public static String toGetCurrentURL() {
		String currentURL=driver.getCurrentUrl();
		System.out.println("Current Url is :" +currentURL);		
		return currentURL;
	}
	
	//to get title
	public static String toGetTitle() {
		String pageTitle=driver.getTitle();
		System.out.println("Page title is:"+pageTitle);
		return pageTitle;
	}
	//toFileInputStream
	public static void toFileInputStream(String dirName,String fileName) throws IOException {		
		 obj=new Properties();
		 FileInputStream objFile = new FileInputStream(System.getProperty(dirName)+fileName);
		 obj.load(objFile);
	}
		
	// click a Webelement
	public static void clickElement(WebElement element) 
	{
		element.click();
	}
	
	//Typing text to the control
	public static void toSendKeys(WebElement element,String value) 
	{		
		element.sendKeys(value);
	}
	
	//Mouse Over MoveToElement
	public static void toMoveToElement(WebElement element) 
	{
		ac=new Actions(driver);
		ac.moveToElement(element).perform();
	}
	
	public static void toActionsClick(WebElement element)
	{
		ac=new Actions(driver);
		ac.click(element).perform();
	
	}
	//Drag AndDrop
	public static void toDragAndDrop(WebElement source, WebElement destination) 
	{
		ac=new Actions(driver);
		ac.dragAndDrop(source, destination).perform();
		
	}
	
	//Context Click
	public static void toRightClick(WebElement element) {		
	ac=new Actions(driver);
	ac.contextClick(element).perform();
	}
	
	//double click a Webelement
	public static void toDoubleClick(WebElement element) {
		ac=new Actions(driver);
		ac.doubleClick(element);

	}
	
	//to scroll
	public static void toScroll(String script,WebElement element) {
		
		js=(JavascriptExecutor)driver;
		js.executeScript(script, element);
		
	}
	
  public static void  toJSClick(String script, WebElement element)
  {
	  js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0]."+script+";", element);
		  
  }
	
	//to get the text from a Webelement
	public static String toGetText(WebElement element) {	
	
		String innerText=element.getText();
		System.out.println(innerText);
		return innerText;
	}
	
	//to get the attribute value
	public static void toGetAttribute(WebElement element,String attributeName)
	{
		element.getAttribute(attributeName);
	}
	
	//select from dropdown by visible text
	public static void toSelectItemVisibleText(WebElement element,String value) 
	{
		s=new Select(element);
		s.selectByVisibleText(value);	
	}
	//select from dropdown by index
	public static void toSelectItemIndex(WebElement element,int value) {
		
		s=new Select(element);
		s.selectByIndex(value);
	}
	
	//select from dropDown by Value
	public static void toSelectItemValue(WebElement element,String value) {
		
		s=new Select(element);
		s.selectByValue(value);
	}
	
	//to Deselect by index
	public static void toDeSelectIndex(WebElement element,int index) {
		s=new Select(element);
		s.deselectByIndex(index);		
	}
	//Deselect by value
	public static void toDeSelectValue(WebElement element, String value) {
		s=new Select(element);
		s.deselectByValue(value);
	}

	//Deselect by visible text
	public static void toDeSelectText(WebElement element, String value) {
		s=new Select(element);
		s.deselectByValue(value);
	}
	
	//take screenshot
	public static void toTakeScreenShot(String path) throws IOException {		
		tk=(TakesScreenshot)driver;
		File tempFile=tk.getScreenshotAs(OutputType.FILE);
		File newFile=new File(path);
		//Copy pic to desired folder
		FileUtils.copyFile(tempFile, newFile);	
	}
	
	//implicit wait
	public static void toWaitImplicit(long time,TimeUnit unit) {
		
		driver.manage().timeouts().implicitlyWait(time,unit);

	}
	
	//explicit wait until element is clickable
	public static void toExplicitWaitClickable(long timeOutInSeconds,WebElement locator) 
	{		
		w=new WebDriverWait(driver, timeOutInSeconds);
		w.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
	
	//to fetch value from excel file 
	public static String toReadFromExcel(String fileName,String sheet,int rowNo,int cellNo) throws IOException 
	{		
		//1.Path of a file
		 File  f=new File("C:\\Users\\Anish\\eclipse-workspace\\MavenDemo01\\ExcelFiles\\"+fileName+".xlsx") ;
		//2.to read a file
		 FileInputStream input=new FileInputStream(f);
		 //3.Workbook Instatition
		 Workbook w=new XSSFWorkbook(input);
		 //4.to read the sheet
		 Sheet s=w.getSheet(sheet);
		 //5.to get row
		 Row r=s.getRow(rowNo);
		 //6.to get the cell
		Cell c=r.getCell(cellNo);
		//7.to Fetch a value in a particular cell
		String value=c.getStringCellValue();
		return value;
	}
	
	//to fetch all the values from excel file
	public static void toReadAllValuesFromExcel(String fileName,String sheet) throws IOException {
		//1.Path of a file
		 File  f=new File("C:\\Users\\Anish\\eclipse-workspace\\MavenDemo01\\ExcelFiles\\"+fileName+".xlsx") ;
		//2.to read a file
		 FileInputStream input=new FileInputStream(f);
		 //3.Workbook Instatition
		 Workbook w=new XSSFWorkbook(input);
		 //4.to read the sheet
		 Sheet s=w.getSheet(sheet);
		 //5.to get row
		 Row r=s.getRow(0);
		 //6.to get the cell
		Cell c=r.getCell(0);
		
		//to get the number of Rows
		int numberOfRows=s.getPhysicalNumberOfRows();
		System.out.println(numberOfRows);
		//to get the number Columns
		int numberOfColumns=r.getPhysicalNumberOfCells();
		System.out.println(numberOfColumns);	
		
		//to print the all excel cell values
		for(int rws=0;rws<numberOfRows;rws++)
		{	//to get row
			Row rw=s.getRow(rws);
			for(int col=0;col<numberOfColumns;col++)
			{
				//to get the cell value
				Cell cells=rw.getCell(col);				
			    int cellType=cells.getCellType();
				String values;
				
			    //System.out.println(cellType);
			    if(cellType==1)
			    {
			    	 values=cells.getStringCellValue();
			    		    	
			    }
			    else if(DateUtil.isCellDateFormatted(cells))
			    {
			    	Date d=cells.getDateCellValue();		    	 
			    	SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
			    	values=sim.format(d);
			    	
			    }
			    else
			    {
			     double num=cells.getNumericCellValue();
			     //type cast
			     long l=(long)num;
			     values=String.valueOf(l);
			    		 
			    // System.out.print(values+" ");
			    }
			    System.out.print(values+" ");	
			 }		
			System.out.println();
			//System.out.println("Cell Type"+cellType);
			}
		
		
		

	}
	
	
	public static void toQuit() {	
		driver.quit();
	}	

}
