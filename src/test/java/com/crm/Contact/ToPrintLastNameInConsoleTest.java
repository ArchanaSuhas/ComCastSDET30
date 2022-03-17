package com.crm.Contact;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class ToPrintLastNameInConsoleTest extends BaseClass {
	
	@Test
	public void toPrintLastNameInConsole()
	{
		//step1:navigate to home page
		HomePage hp=new HomePage(driver);
		hp.clickOnConLnk();
		
		//step2: To print last name in console
		
		List<WebElement> lastname = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[4]/a[@title='Contacts']"));
		int count = lastname.size();
		for(int i=0;i<count;i++)
		{
			WebElement we = lastname.get(i);
			String text = we.getText();
			System.out.println(text);
		}
	}
	

}
