package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement ProductsLookUpImg;
	
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductsLookUpImg() {
		return ProductsLookUpImg;
	}
	
	//business library
	
	public void CreateNewProduct()
	{
		ProductsLookUpImg.click();
	}
	

}
