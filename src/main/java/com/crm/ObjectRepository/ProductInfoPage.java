package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ProductNameTitle;
	
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductNameTitle() {
		return ProductNameTitle;
	}
	
	//Business library
	
	public String ProductHeaderTitle()
	{
		
		String ActData = ProductNameTitle.getText();
		return ActData;
	}


}
