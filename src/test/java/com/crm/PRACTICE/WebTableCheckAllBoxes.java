package com.crm.PRACTICE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganisationsPage;

public class WebTableCheckAllBoxes extends BaseClass{

	@Test
	public void webTableCheckAllBoxes() throws InterruptedException
	{
		//step1: navigate to create organisatvionlink
		
		HomePage hp=new HomePage(driver);
				hp.clickOnOrgLnk();
		
		//step2: click on create orgaisation link
		
		OrganisationsPage op=new OrganisationsPage(driver);
				
				
		//step3: check all the check boxes individualy
				
				List<WebElement> check = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
               int count = check.size();
               for(int i=0;i<count;i++)
               {
            	    WebElement we = check.get(i);
            	    we.click();
            	    Thread.sleep(2000);
               }
		
	}
}
