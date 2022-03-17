package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgainsationInfoPage 
{
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrganisationName;
	
	public OrgainsationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganisationName() {
		return OrganisationName;
	}
	
	//business library
	 public String organisationInfoPage()
	
	 {
		 String Orgname = OrganisationName.getText();
		 return Orgname;
	 }

}



















