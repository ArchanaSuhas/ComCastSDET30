package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class LoginPage extends WebDriverUtility
{

	//step1: Declaration
	
	@FindBy(name="user_name")
	private WebElement UsernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement Submitbtn;
	
	//step2: Initialization
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//step3: provide getters
	
	public WebElement getUsernameEdt() {
		return UsernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitbtn() {
		return Submitbtn;
	}
	 
	   //business library

     public void logintoApp(String username, String password)
{
	
    	 passwordEdt.sendKeys(password);
    	 UsernameEdt.sendKeys(username);
    	 Submitbtn.click();
}
}










