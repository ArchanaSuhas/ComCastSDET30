package com.crm.PRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganisationsInfoPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrgainsationInfoPage;
import com.crm.ObjectRepository.OrganisationsPage;

public class CreateOrgWithMultipleData extends BaseClass {
	
	
	@Test(dataProvider = "OrgtestData")
	public void createOrgWithMltipleData(String orgName, String indType) throws Throwable
	{
		
		String orgname = orgName+jLib.getRandomnumber();
	
		//navigate to organization
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLnk();
		Reporter.log("navigated to org link",true);
		
		//create Org
		OrganisationsPage op = new OrganisationsPage(driver);
		op.getCreateOrgImg();
		Reporter.log("click on create org link",true);
		
		//create new org
		CreateOrganisationsInfoPage cop = new CreateOrganisationsInfoPage(driver);
		cop.OrganisationInfo(orgname, indType);
		Reporter.log("create org with insustry type",true);
		
		//validate
		OrgainsationInfoPage oip = new OrgainsationInfoPage(driver);
		String actHeader = oip.organisationInfoPage();
		if (actHeader.contains(orgname)) {
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
		Reporter.log("verification successful",true);		
		
		}
	
	@DataProvider(name = "OrgtestData")
	public Object[][] getData() throws Throwable
	{
		Object[][] data = eLib.readmultipleDataFromExcel("OrgMultipleData");
		return data;
	}

}
