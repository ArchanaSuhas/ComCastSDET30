package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CalendarWRTGoibiboTest {
	
	@Test
	public void calendar()
	{
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		String MonthAndYear="March 2022";
		String Date="12";
		driver.findElement(By.xpath("//div[.='"+MonthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+Date+"']")).click();
		driver.findElement(By.xpath("//span[.='Done']")).click();
		
		driver.findElement(By.xpath("//span[.='Travellers & Class']")).click();
		
	}

}
