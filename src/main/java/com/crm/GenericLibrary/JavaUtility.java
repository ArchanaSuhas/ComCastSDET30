
package com.crm.GenericLibrary;

import java.util.Date;
import java.util.Random;

/**
 * 
 */
/**
 * This class consists of generic methods wrt to java
 * @author Archana
 * @author HP
 *
 */
public class JavaUtility{
	
	/**
	 * This method will generate a random number and return it to user
	 * @return
	 */
	public int getRandomnumber()
	{
		Random ran= new Random();
		int random = ran.nextInt(500);
		return random;
	}
	/**
	 * This method will generate current system date and return it to user
	 * @return
	 */
	public String getSystemDate()
	{
		Date d=new Date();
		String date=d.toString();
		return date;
	}
	/**
	 * This method will generate system date and return date in format to user
	 * @return
	 */
	
	public String getSystemDateInFormat()
	{
		Date d=new Date();
		String d1=d.toString();
		String[] date = d1.split(" ");
		String mon=date[1];
		String day=date[2];
		String year=date[5];
		String time=date[3].replace(":", "-");
		
		String DateFormat=day+"-"+mon+"-"+year+"-"+time;
		
		
		return DateFormat;
	
		
	}
	
}