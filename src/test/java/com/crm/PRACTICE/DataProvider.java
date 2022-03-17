package com.crm.PRACTICE;

import org.testng.annotations.Test;

public class DataProvider {
	@Test(dataProvider= "getData")
	public void sampleDataProvider(String name,String model,int qty)
	{
		System.out.println(name+"---"+model+"---"+qty);
	}
	
       @org.testng.annotations.DataProvider
       public Object[][] getData()
	{
		Object[][] obj=new Object[4][3];
		
			obj[0][0]="mi";
			obj[0][1]="10pro";
			obj[0][2]=10;
			
			obj[1][0]="iphone";
			obj[1][1]="11max";
			obj[1][2]=12;
			
			obj[2][0]="vivo";
			obj[2][1]="17max";
			obj[2][2]=25;
			
			obj[3][0]="samsung";
			obj[3][1]="10plous";
			obj[3][2]=12;
			
			return obj;
			
			
			
			
		}

}
