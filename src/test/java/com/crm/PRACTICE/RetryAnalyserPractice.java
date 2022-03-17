package com.crm.PRACTICE;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice
{
	@Test(retryAnalyzer=com.crm.GenericLibrary.RetryAnalyserImplementationClass.class)
	public void retryAnalyserPractice()
	{
		System.out.println("test is passed");
		Assert.fail();
		System.out.println("skipped");
		
		
	}

}
