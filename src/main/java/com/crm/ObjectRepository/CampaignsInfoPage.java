package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsInfoPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement CampaignName;
	
	public CampaignsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampaignName() {
		return CampaignName;
	}
	
	//business library
	public String CampaignHeaderTitle()
	{
		return CampaignName.getText();
	}


}
