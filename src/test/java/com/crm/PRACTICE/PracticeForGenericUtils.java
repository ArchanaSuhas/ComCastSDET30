package com.crm.PRACTICE;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;

public class PracticeForGenericUtils {
	
	@Test
	public void Practice() throws Throwable 
	{
		JavaUtility JLib=new JavaUtility();
		int ran = JLib.getRandomnumber();
		String dat = JLib.getSystemDate();
		String date = JLib.getSystemDateInFormat();
		System.out.println(ran+dat);
		System.out.println(date);
		
		PropertyFileUtility PLib=new PropertyFileUtility();
		String brows = PLib.readDataFromPropertyFile("browser");
		System.out.println(brows);
		
	}

}
