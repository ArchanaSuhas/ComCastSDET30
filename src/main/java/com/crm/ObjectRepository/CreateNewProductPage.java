package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {
	
	@FindBy(name="productname")
	private WebElement productnameEdt;
	
	@FindBy(name="button")
	private WebElement SaveBtn;
	
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductnameEdt() {
		return productnameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//business library
	 
	public void createNewProduct(String Pname)
	{
		productnameEdt.sendKeys(Pname);
		SaveBtn.click();
	}
	
	

}

















