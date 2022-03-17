package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ContactName;
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactName() {
		return ContactName;
	}
	
	//business library
	
	public String ContactInfoPage()
	{
		String ActName = ContactName.getText();
		return ActName;
	}

}



















