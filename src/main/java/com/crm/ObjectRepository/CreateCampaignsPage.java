package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateCampaignsPage extends WebDriverUtility {
	
	@FindBy(name="campaignname")
	private WebElement campaignnameEdt;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement ProductLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement SearchTextEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	public CreateCampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampaignnameEdt() {
		return campaignnameEdt;
	}

	public WebElement getProductLookUpImg() {
		return ProductLookUpImg;
	}

	public WebElement getSearchTextEdt() {
		return SearchTextEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
	//Business library
	
	public void CreateNewCampaign(String CampaignName)
	{
		campaignnameEdt.sendKeys(CampaignName);
		saveBtn.click();
		
	}
	
	public void CreateNewCampaign(WebDriver driver,String CampaignName, String Pname)
	{
		campaignnameEdt.sendKeys(CampaignName);
		ProductLookUpImg.click();
		switchToWindow(driver, "Products");
		SearchTextEdt.sendKeys(Pname);
		searchBtn.click();
		driver.findElement(By.xpath("//a[.='"+Pname+"']")).click();
		switchToWindow(driver, "Campaigns");
		saveBtn.click();
		
	}
	
	

}























