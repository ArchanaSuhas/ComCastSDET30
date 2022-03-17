package com.crm.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
	public static WebDriver sDriver;
	public  PropertyFileUtility pLib=new PropertyFileUtility();
	public ExcelFileUtility eLib=new ExcelFileUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public DataBaseUtility dbLib=new DataBaseUtility();
	public WebDriver driver=null;

	@BeforeSuite(groups="smokeSuite")
	public void connectToDB() throws Throwable
	{
		// dbLib.connectToDb();
		Reporter.log("db connection successfully");
	}

	@BeforeClass(groups="smokeSuite")
	//	   @Parameters("browser")
	//	   @BeforeTest
	public void launchtheBrowser() throws Throwable
	{
		//read data from propertyfilr

		String Browser = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");

		//create run time polymorphism

		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("FIREFOX"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		sDriver=driver;
		wLib.maximizewindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		Reporter.log("browser launch successfully",true);

	}

	@BeforeMethod(groups="smokeSuite")
	public void login() throws Throwable
	{
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.logintoApp(USERNAME, PASSWORD);
		Reporter.log("login successfully",true);
	}

	@AfterMethod(groups="smokeSuite")
	public void logout()
	{
		HomePage hp = new HomePage(driver);
		hp.signoutofApp(driver);
		Reporter.log("logout successfully",true);

	}

	@AfterClass(groups="smokeSuite")
	//@AfterTest
	public void closebrowser()
	{
		driver.quit();
		Reporter.log("browser close successfully",true);

	}

	@AfterSuite(groups="smokeSuite")
	public void closeDb()
	{
		// dbLib.closeDB();
		Reporter.log("Database close successfully",true);
	}


























}
