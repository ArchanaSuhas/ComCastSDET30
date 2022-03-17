package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CalendarForAllTheDate {
	@Test
	public void claendar()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		Actions actions=new Actions(driver);
		actions.moveByOffset(10, 10).click().perform();
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		
		String date="12";
		String monthandyear="March 2022";
		String DateXpath="//div[.='"+monthandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']";
		driver.findElement(By.xpath(DateXpath)).click();
		
		driver.findElement(By.xpath(""));
	}

}
