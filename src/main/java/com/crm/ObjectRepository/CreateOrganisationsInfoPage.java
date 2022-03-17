package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOrganisationsInfoPage extends WebDriverUtility {

	
	
	@FindBy(name="accountname")
	private WebElement OrgnameEdt;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement IndTypeDropDown;
	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement TypeDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//step2:Initialisation
	
	public  CreateOrganisationsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//step3: provide getters
	
	

	public WebElement getOrgnameEdt() {
		return OrgnameEdt;
	}

	public WebElement getIndTypeDropDown() {
		return IndTypeDropDown;
	}

	public WebElement getTypeDropDown() {
		return TypeDropDown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	
	//business library
	
	public String OrganisationInfo(String Orgname)
	{
		OrgnameEdt.sendKeys(Orgname);
		SaveBtn.click();
		return Orgname;
		
	}
	public void OrganisationInfo(String Orgname, String indType)
	{
		OrgnameEdt.sendKeys(Orgname);
		select(IndTypeDropDown, indType);
		SaveBtn.click();
		
	}
	
	public void OrganisationInfo(String Orgname, String indType, String type)
	{
		OrgnameEdt.sendKeys(Orgname);
		select(IndTypeDropDown, indType);
		select(TypeDropDown, type);
		SaveBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}   

