package com.crm.Contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateMailMergeWithContactTest {
	
	@Test
	public void CreateMailMergeWithContactTest() throws Throwable
	{
		//step1: read data from property file
				FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
				Properties pObj=new Properties();
				pObj.load(fis);
				String Browser = pObj.getProperty("browser");
				String URL = pObj.getProperty("url");
				String USERNAME = pObj.getProperty("username");
				String PASSWORD = pObj.getProperty("password");
				
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
			
			
				//step5: navigate to create mail merge template
				driver.findElement(By.xpath("//a[.='Create Mail Merge templates ']")).click();
				
				//step6: navigate to choose file
	
			  WebElement ele = driver.findElement(By.name("binFile"));
				ele.sendKeys("C:\\Users\\HP\\Documents\\ARC.docx");
				
				//step7:select module as contact
				WebElement ele1 = driver.findElement(By.xpath("//select[@name='target_module']"));
				Select s=new Select(ele1);
				s.selectByValue("Contacts");
				
				
				driver.findElement(By.name("button")).click();
				
				//step7: logout of application
				WebElement el=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act=new Actions(driver);
				act.moveToElement(el).perform();
				driver.findElement(By.xpath("//a[.='Sign Out']")).click();
				
				driver.quit();


				
				
				
				
		
		
	}

}
