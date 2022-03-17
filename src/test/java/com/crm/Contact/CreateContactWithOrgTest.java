/**
 * 
 */
/**
 * @author HP
 *
 */
package com.crm.Contact;

import java.io.FileInputStream;

import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateNewContactPage;
import com.crm.ObjectRepository.CreateOrganisationsInfoPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrgainsationInfoPage;
import com.crm.ObjectRepository.OrganisationsPage;
@Listeners(com.crm.GenericLibrary.ListnerImplementationClass.class)

public class CreateContactWithOrgTest extends BaseClass{
	


	@Test
	public void createConTest() throws Throwable
	{     
		
		  String OrgName = eLib.ReadDataFromExcelSheet("Org", 1, 2)+"_"+jLib.getRandomnumber();
		 String LastName = eLib.ReadDataFromExcelSheet("Contacts", 1, 3)+"_"+jLib.getRandomnumber();
		
		/*Step 4: Navigate to Organizations Link*/
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLnk();
		Assert.fail();
		/*Step 5: click on create organization btn*/
		OrganisationsPage op=new OrganisationsPage(driver);
		op.CreateOrganisation();
		
		/*Step 6: enter mandatory fields and save*/
		CreateOrganisationsInfoPage cop=new CreateOrganisationsInfoPage(driver);
		cop.OrganisationInfo(OrgName);
		
		/*Step 7:verify for orgaqnization*/
		OrgainsationInfoPage oip=new OrgainsationInfoPage(driver);
		String header = oip.organisationInfoPage();
		if(header.contains(OrgName))
		{
			System.out.println(header);
			System.out.println("org created");
		}
		else
		{
			System.out.println(header);
			System.out.println("Org not created");
		}
		
		//step8: navigate to  contacts link
		hp.clickOnConLnk();
		
		//step9: click on create contact
		ContactsPage cp=new ContactsPage(driver);
		cp.contactsPage();
		
		//step10: create contact with mandatory fields
		CreateNewContactPage ccp=new CreateNewContactPage(driver);
		ccp.CreateNewContactPage(driver, LastName, OrgName);
		
		/*Step 11: verfify for contact*/
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		String contactHeader = cip.ContactInfoPage();
		if(contactHeader.contains(LastName))
		{
			System.out.println(contactHeader +" contact created");
		}
		else
		{
			System.out.println("contact not created");
		}
	

}
}







