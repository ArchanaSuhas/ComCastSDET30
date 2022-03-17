package com.crm.PRACTICE;

import org.testng.annotations.Test;

public class DataProvider2 {
	public class DataProvider {
		@Test(dataProvider= "getData")
		public void sampleDataProvider(String name,String model)
		{
			System.out.println(name+"---"+model);
		}
		
	       @org.testng.annotations.DataProvider
	       public Object[][] getData()
		{
			Object[][] obj=new Object[6][2];
			
				obj[0][0]="mi";
				obj[0][1]="10pro";
				
				obj[1][0]="iphone";
				obj[1][1]="11max";
				
				obj[2][0]="vivo";
				obj[2][1]="17max";
				
				obj[3][0]="samsung";
				obj[3][1]="10plous";
				
				obj[4][0]="samsung";
				obj[4][1]="10plous";
				
				obj[5][0]="samsung";
				obj[5][1]="10plous";
				
				
				return obj;
				
				
				
				
			}

	}

}
