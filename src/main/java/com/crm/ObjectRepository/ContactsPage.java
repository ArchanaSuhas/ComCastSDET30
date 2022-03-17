package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement CreateContactLooUpImg;
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContactLooUpImg() 
	{
		return CreateContactLooUpImg;
	}
	
	//Business library
	
	public void contactsPage()
	{
		CreateContactLooUpImg.click();
	}

}