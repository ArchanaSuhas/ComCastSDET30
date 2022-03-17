package com.crm.Opportunity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOpportunityWithConAndCampainTest {
	@Test
	public void createOpportunity() throws Throwable
	{
		//step1: read data from property file
		 PropertyFileUtility pLib=new PropertyFileUtility();
		    ExcelFileUtility eLib=new ExcelFileUtility();
		    JavaUtility jLib=new JavaUtility();
		    WebDriverUtility wLib=new WebDriverUtility();
		    
		    
			//step1: read all necessary data
		    String Browser = pLib.readDataFromPropertyFile("browser");
		    String Url = pLib.readDataFromPropertyFile("url");
		    String Username = pLib.readDataFromPropertyFile("username");
			String Password = pLib.readDataFromPropertyFile("password");
			
			 String OppName = eLib.ReadDataFromExcelSheet("Opportunity", 1, 2)+" "+jLib.getRandomnumber();
			  String ConName = eLib.ReadDataFromExcelSheet("Contacts", 1, 3)+" "+jLib.getRandomnumber();
			  String CamName = eLib.ReadDataFromExcelSheet("Campaign", 1, 2)+" "+jLib.getRandomnumber();
			  String OrgName = eLib.ReadDataFromExcelSheet("Org", 1, 2)+"_"+jLib.getRandomnumber();
			 
			 
			
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
		wLib.maximizewindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(Url);
		//step3:login to application
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitbutton")).click();
	
		
		//step3:create contact
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(ConName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 4: verfify for contact
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactHeader.contains(ConName))
		{
			System.out.println(contactHeader +" contact created");
		}
		else
		{
			System.out.println("contact not created");
		}
	
		
		//step5: create campaign
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		driver.findElement(By.name("campaignname")).sendKeys(CamName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step6: verify campaign
		
		String campaignHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactHeader.contains(ConName))
		{
			System.out.println(campaignHeader +" campaign created");
		}
		else
		{
			System.out.println("campaign not created");
		}
	//step7:create opportunity
		driver.findElement(By.xpath("//a[.='Opportunities']")).click();
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		driver.findElement(By.xpath("//input[@name='potentialname']")).sendKeys(OppName);
		WebElement ele = driver.findElement(By.id("related_to_type"));
		ele.click();
		wLib.select(ele, "Contacts");
		driver.findElement(By.xpath("//input[@name='related_to_display']/following-sibling::img[@alt='Select']")).click();
		

		//step8:choose contact
	
		wLib.switchToWindow(driver, "Accounts");
		driver.findElement(By.name("search_text")).sendKeys(ConName);
		driver.findElement(By.name("search")).click();
		
	
	    driver.findElement(By.linkText(ConName)).click();
		
		wLib.switchToWindow(driver, "Potentials");
		
		//step9:chose campaign src
		driver.findElement(By.xpath("//input[@name='campaignid']/following-sibling::img[@alt='Select']")).click();
		wLib.switchToWindow(driver, "Campaigns");
		driver.findElement(By.name("search_text")).sendKeys(CamName);
		driver.findElement(By.name("search")).click();
		
	
		driver.findElement(By.linkText(CamName)).click();
		
		wLib.switchToWindow(driver, "Potentials");
		
		//step10: save
	     
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step11: logout of application
		WebElement el=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHover(driver, el);
		
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		driver.quit();
		
	
	
		
		

		
	}

}



















