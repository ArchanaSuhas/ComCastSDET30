 
package com.crm.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class consists of all the methods respect to Database
 * @author HP
 *
 */
public class DataBaseUtility {
	Connection con=null;
	/**
	 * This method will register the driver and establish connection with database
	 * @throws Throwable
	 */
	public void connectToDb() throws Throwable
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IPathConstants.dbURL, IPathConstants.dbUsername, IPathConstants.dbPassword);
	}
    /**
     * This method will close database connection
     * @throws Throwable
     */
	public void closeDB() throws Throwable
	{
		con.close();
	}
	/**
	 * This method will execute the query and return the matching data to user
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String query,int columnIndex,String expData) throws Throwable
	{
		String data=null;
		boolean flag=false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			data=result.getString(columnIndex);
			{
				flag=true;//flag rising
				break;
			}
		}
		
			if(flag)
			{
				System.out.println(data+"----->data verified");
				return expData;
			}
			else
			{
				System.out.println("datanot verified");
				return"";
			}
		}
		
	
}
         




















