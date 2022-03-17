package com.crm.Organisations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganisationsInfoPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganisationsPage;

public class CreateOrganisationTest extends BaseClass {
	@Test
	public void createOrganisationTest() throws Throwable
	{
		 String OrgName = eLib.ReadDataFromExcelSheet("Org", 1, 2)+"_"+jLib.getRandomnumber();
			
			//step4: navigate to create organisatvionlink
			
			HomePage hp=new HomePage(driver);
					hp.clickOnOrgLnk();
			
			//step5: click on create orgaisation link
			
			OrganisationsPage op=new OrganisationsPage(driver);
					op.CreateOrganisation();
			
			
			//step5: create org with mandatory fields
			
			CreateOrganisationsInfoPage cop=new CreateOrganisationsInfoPage(driver);
					 String actData = cop.OrganisationInfo(OrgName);
					 String expData = OrgName;
					 Assert.assertEquals(actData, expData);
					
					
		
	}
	

}
