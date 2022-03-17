package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationsPage {
	
	     //step1: Declaration
	
		@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement CreateOrgImg;
		
		//step2: initialisation
		
		 public OrganisationsPage(WebDriver driver)
		 {
			 PageFactory.initElements(driver, this);
		 }
		 
         //step3: utilization
		 
		public WebElement getCreateOrgImg()
		{
			return CreateOrgImg;
		}

		//Business library
		
		public void CreateOrganisation()
		{
			CreateOrgImg.click();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
