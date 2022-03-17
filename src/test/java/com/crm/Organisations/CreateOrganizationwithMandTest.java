package com.crm.Organisations;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganisationsInfoPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrgainsationInfoPage;
import com.crm.ObjectRepository.OrganisationsPage;

@Listeners(com.crm.GenericLibrary.ListnerImplementationClass.class)

public class CreateOrganizationwithMandTest extends BaseClass {
	@Test
	public void createOrgTest() throws Throwable
	{
			
			 String OrgName = eLib.ReadDataFromExcelSheet("Org", 4, 2)+"_"+jLib.getRandomnumber();
			 String IndTyp = eLib.ReadDataFromExcelSheet("Org", 4, 3);
			 
		//step4: navigate to create organisatvionlink
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLnk();
		Assert.fail();
		
		
		//step5: click on create orgaisation link
         OrganisationsPage op=new OrganisationsPage(driver);
         op.CreateOrganisation();
		
		//step6: create org with mandatory fields
		CreateOrganisationsInfoPage cop=new CreateOrganisationsInfoPage(driver);
		cop.OrganisationInfo(OrgName, IndTyp);
		
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












