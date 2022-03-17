package com.crm.Contact;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class CheckBoxParticularAndDeleteTest extends BaseClass {
	@Test
	public void checkBoxParticularTest()
	
		{
			//step1:navigate to home page
			HomePage hp=new HomePage(driver);
			hp.clickOnConLnk();
			
			
			//step2: check the check boxes 
			
			WebElement check = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@id='77']"));
                check.click();
                WebElement delete = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[7]/td[10]/a[.='del']"));
                delete.click();
                 wLib.acceptAlert(driver);
		
	
	}

}
