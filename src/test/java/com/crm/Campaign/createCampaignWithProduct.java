package com.crm.Campaign;

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
import com.crm.ObjectRepository.CampaignsInfoPage;
import com.crm.ObjectRepository.CampaignsPage;
import com.crm.ObjectRepository.CreateCampaignsPage;
import com.crm.ObjectRepository.CreateNewProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createCampaignWithProduct {

	@Test
	public void createCampaignWithProduct() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
		/*read data*/
		PropertyFileUtility pLib = new PropertyFileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		/*Step 1: read all neccessary data*/
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		String campaignName = eLib.ReadDataFromExcelSheet("Campaign", 1, 2)+"_"+jLib.getRandomnumber();
		String prodName = eLib.ReadDataFromExcelSheet("Product", 1, 2)+"_"+jLib.getRandomnumber();
		
	
		/*Step 2: launch the browser*/
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser name");
		}
		
		wLib.maximizewindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		//step3:login to application
		LoginPage lp=new LoginPage(driver);
		lp.logintoApp(USERNAME, PASSWORD);
		
	    //step 4: create a Product
		HomePage hp=new HomePage(driver);
		hp.clickOnProductLnk();
		
		ProductsPage pg=new ProductsPage(driver);
		pg.CreateNewProduct();
		 
		CreateNewProductPage cpp=new CreateNewProductPage(driver);
		cpp.createNewProduct(prodName);
		
	    //step5: craete a campaign
		
		hp.clickOnCampaignsLnk();
		CampaignsPage cp=new CampaignsPage(driver);
		cp.CreateCampaignspage();
		
		CreateCampaignsPage ccp=new CreateCampaignsPage(driver);
		ccp.CreateNewCampaign(driver, campaignName, prodName);
		
		//step6: verification
		
		CampaignsInfoPage cip= new CampaignsInfoPage(driver);
		String ActData = cip.CampaignHeaderTitle();
		if(ActData.contains(campaignName))
		{
			System.out.println("verified");
		}
		else
		{
			System.out.println("data is not valid");
		}
		
		
		//step7: logout of application
		hp.signoutofApp(driver);

		
		
		
		driver.quit();
		
	}

}
