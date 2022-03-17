package com.crm.Organisations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class CraeteOrgainsationWithTypeDropDownTest extends BaseClass {
	@Test
	public void createOrgTest() throws Throwable
	{
			
			 String OrgName = eLib.ReadDataFromExcelSheet("Org", 7, 2)+"_"+jLib.getRandomnumber();
			 String IndTyp = eLib.ReadDataFromExcelSheet("Org", 7, 3);
			 String Type = eLib.ReadDataFromExcelSheet("Org", 7, 4);
			
		
		//step4: navigate to create organisatvionlink
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLnk();
		
		
		//step5: click on create orgaisation link
         OrganisationsPage op=new OrganisationsPage(driver);
         op.CreateOrganisation();
		
		//step6: create org with mandatory fields
		CreateOrganisationsInfoPage cop=new CreateOrganisationsInfoPage(driver);
		cop.OrganisationInfo(OrgName, IndTyp, Type);
		
		//step7:Verification
		OrgainsationInfoPage oip=new OrgainsationInfoPage(driver);
		String Actdata = oip.organisationInfoPage();
		if(Actdata.contains(OrgName))
		{
			System.out.println("Organisation Created");
		}
		else{
			System.out.println("Organisation not created");
		}
			
	}

}













