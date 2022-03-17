package com.crm.ObjectRepository;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
	//step1:Declaration
	
	@FindBy(linkText="Calendar")
	private WebElement calendarLnk;
	
	 @FindBy(linkText="Organizations")
	 private WebElement Organizationslnk;
	 
	 @FindBy(linkText="Contacts")
	 private  WebElement ContactsLnk;
	 
	 @FindBy(linkText="Opportunities")
	 private WebElement Opportunitieslnk;
	 
	 @FindBy(linkText="More")
	 private WebElement MoreLnk;
	 
	 @FindBy(linkText="Campaigns")
	 private WebElement CampaignsLnk;
	 
	 @FindBy(linkText="Products")
	 private WebElement ProductsLnk;
	 
	 @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	 private WebElement adminstratorImg;
	 
	  @FindBy(linkText="Sign Out")
      private WebElement SignOutLnk;
	  
	  //step2:Initailization
	  
	  public HomePage(WebDriver driver)
	  {
		  PageFactory.initElements(driver, this);
	  }

	  //provide getters
	  
	public WebElement getCalendarLnk() {
		return calendarLnk;
	}

	public WebElement getOrganizationslnk() {
		return Organizationslnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitieslnk() {
		return Opportunitieslnk;
	}

	public WebElement getMoreLnk() {
		return MoreLnk;
	}

	public WebElement getCampaignsLnk() {
		return CampaignsLnk;
	}

	public WebElement getAdminstratorImg() {
		return adminstratorImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	  
	  //Business library
	public void clickOnOrgLnk()
	{
		Organizationslnk.click();
	}
	
	public void clickOnConLnk()
	{
		ContactsLnk.click();
	}
	
	public void clickOnCampaignsLnk()
	{
		MoreLnk.click();
		CampaignsLnk.click();	
	}
	
	public void clickOnProductLnk()
	{
		ProductsLnk.click();
	}
	
	public void clickOnMoreLnk()
	{
		MoreLnk.click();
	}
	
	 public void signoutofApp(WebDriver driver)
	 {
		 mouseHover(driver, adminstratorImg);
		 SignOutLnk.click();
		 
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
























