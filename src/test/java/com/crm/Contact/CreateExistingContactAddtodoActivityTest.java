package com.crm.Contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;

public class CreateExistingContactAddtodoActivityTest extends BaseClass{

	@Test
	public void CreateExistingContactAddtodoActivityTest() throws Throwable
	{
		
		
		/*generate  random number*/
		Random ran= new Random();
		int random=ran.nextInt(500);
		//step1: read data from property file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String Browser = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		//read data from excel sheet
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Test data.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sheet = wb.getSheet("Contacts");
		Row ro=sheet.getRow(7);
		
		Cell c = ro.getCell(2);
		String firstname = c.getStringCellValue()+random;
		String firstnameRan = firstname+" "+random;
		Cell ce = ro.getCell(3);
		String lastname = ce.getStringCellValue()+random;
		String lastnameRan = lastname+" "+random;
		
	
		Cell cel = ro.getCell(2);
		String ToDoname = cel.getStringCellValue();
		String ToDonameRan = ToDoname+" "+random;
		
		
		//step2 : launch the browser
		WebDriver driver=null;
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else if (Browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		
		//step3:login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitbutton")).click();
		
		//step4: navigate to  contacts link
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		
		//step5: click on create contact
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		//driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastnameRan);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();		
		driver.findElement(By.xpath("//a[.='Contacts']")).click();

		
				
		//step6:click on existing contact
	    driver.findElement(By.xpath("//a[text()='"+lastnameRan+"']")).click();
	    
	    //step7: navigate to more info
	    driver.findElement(By.xpath("//a[.='More Information']")).click();
	    
	   // driver.findElement(By.xpath("//a[.='Activities']")).click();
	    driver.findElement(By.id("show_Contacts_Activities"
	    		+ "")).click();
	    
	    driver.findElement(By.xpath("//input[@value='Add To Do']")).click();
	    
	    driver.findElement(By.name("subject")).sendKeys(ToDonameRan);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	    //step8: logout of application
		WebElement el=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(el).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		driver.quit();


		

	    
		
	

	
	}
}
