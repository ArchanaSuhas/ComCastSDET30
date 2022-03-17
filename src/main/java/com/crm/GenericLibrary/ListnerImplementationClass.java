package com.crm.GenericLibrary;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ListnerImplementationClass implements ITestListener 
{
    ExtentReports report;
    ExtentTest test;
    
	public void onTestStart(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
		test=report.createTest(MethodName);
	}

	public void onTestSuccess(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS,MethodName + "--- testscript success");
	}

	public void onTestFailure(ITestResult result) 
	{
		String path = null;
		
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName + "--- TestScript Failed",true);
		
		//Step 1: Configure screenshot name
		String screenshotName = MethodName+new JavaUtility().getSystemDateInFormat();
		System.out.println(screenshotName);
		//Step 2: using screenshot method from webDriver Utility
		try {
			
			path =new WebDriverUtility().getScreenShot(BaseClass.sDriver, screenshotName);
			
	
//			EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
//			File src = eDriver.getScreenshotAs(OutputType.FILE);
//			//String pa = System.getProperty("user.dir")+"/ScreenShots/"+screenshotName+".PNG";
//			 path = "./Screenshots/"+screenshotName+".png";
//			File dst = new File(path);
//			Files.copy(src, dst);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, MethodName+"---->failed");
		//it will capture the execution and log it in the report
		test.log(Status.FAIL,result.getThrowable());
		test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.FAIL,MethodName + "--- testscript skipped");
		test.log(Status.FAIL,result.getThrowable());

		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result)
	{
		
	}

	public void onStart(ITestContext context) 
	{
		//EXECUTION WILL START HERE
		/*CONFIGURE THE REPORT*/
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./ExtentReports/Report"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("SDET-30 Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("selenium execution report");
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("OS", "windows");
		report.setSystemInfo("Reporter name", "Archana");
	}

	public void onFinish(ITestContext context) 
	{
		report.flush();
	}
	

}
