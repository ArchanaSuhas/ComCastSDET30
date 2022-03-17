package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility
{

	@FindBy(name="lastname")
	private WebElement LastNameEdt;

	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement orgNameLookUpImg;
	
	@FindBy(name="leadsource")
	private WebElement LeadSrcDropDown;
	
	@FindBy(name="button")
	private WebElement SaveBtn;
	
	@FindBy(id="search_txt")
	private WebElement SearchEdt;
	
	@FindBy(name="search")
	private WebElement SearchBtn;
	
	public CreateNewContactPage(WebDriver driver)
	{
	
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getOrgNameLookUpImg() {
		return orgNameLookUpImg;
	}

	public WebElement getLeadSrcDropDown() {
		return LeadSrcDropDown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//business library
	
	public void CreateNewContactPage(String lastname)
	{
		LastNameEdt.sendKeys(lastname);
		SaveBtn.click();
		
	}
	
	public void CreateNewContactPage(WebDriver driver,String lastname,String OrgName)
	{
		LastNameEdt.sendKeys(lastname);
		orgNameLookUpImg.click();
		switchToWindow(driver, "Accounts");
		SearchEdt.sendKeys(OrgName);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+OrgName+"']")).click();
		switchToWindow(driver, "Contacts");
		SaveBtn.click();
		
	}
	
}


























