
package com.crm.GenericLibrary;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * This class consists of all generic methods related to webDriverActions
 * @author HP
 *
 */

public class WebDriverUtility {
	/**
	 * This method will maximize the window
	 * @param driver
	 */

	public void maximizewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method will wait for 20 seconds for the page to load
	 * @param driver
	 */

	
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	} 
	/**
	 * This method will wait for 10 seconds for an element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will select data from dropdown using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This method will select data from dropdown using value
	 * @param element
	 * @param value
	 */
	public void select(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method will select data from dropdown using vissibletext
	 * @param text
	 * @param element
	 */
	
	public void select(String text,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void mouseHover(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void dragAndDrop(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(element, element).perform();
		
	}
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element);
		
		
	}
	public void doubleClick(WebDriver driver)
	
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	public void rightClickonwebpage(WebDriver driver)

	
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	public void rightClickonwebpage(WebDriver driver,WebElement element)
	
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}

	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver,String name)
	{
		driver.switchTo().frame(name);
	}
	public void switchToFrame(WebDriver driver,WebElement address)
	{
		driver.switchTo().frame(address);
	}
	/**
	 * This method will accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will cancel the alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will switch to window depending on partial window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		//step1: use getwindowHandles to captire all window ids
		Set<String> windows = driver.getWindowHandles();
		
		//step2: iterate thru the windows
		Iterator<String> it = windows.iterator();
		
		//step3: check whether there is next window
		while(it.hasNext())
		{
			//step4: capture current window id
			String winId = it.next();
			
			//step5: switch to current window and capture title
			String currentWinTitle = driver.switchTo().window(winId).getTitle();
			
			//step6: check whether the current window is expected
			if(currentWinTitle.contains(partialWinTitle))
			{
				break;
			}
		}
			
	}
	/**
	 * This method will take screenshot and store in the file
	 * @param driver
	 * @param screenShotName
	 * @throws Throwable 
	 */
	
	public String getScreenShot(WebDriver driver,String ScreenShotsName) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path=".\\Screenshots\\"+ScreenShotsName+".png";
		File dst= new File(path);
		FileUtils.copyFile(src, dst);
		
		return dst.getAbsolutePath();
	}
	/**
	 * This method perform  random scroll
	 * @param driver
	 */
	
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", " ");
	}
	/**
	 * This method will scroll until the specified element is found
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
		//js.executeScript("argument[0].scrollIntoView()",element);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}































