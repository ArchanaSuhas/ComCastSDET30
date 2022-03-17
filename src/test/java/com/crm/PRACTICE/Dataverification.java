package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class Dataverification {
	@Test
	public void dataverification() throws Throwable
	{
		String expdata = "Archana";
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
	Statement state = con.createStatement();	
	            ResultSet result = state.executeQuery("select * from student;");
	            while(result.next())
	            {
	            	String actData = result.getString(1);
	            	if(expdata.equalsIgnoreCase(actData))
	            	{
	            		System.out.println("data is verefied");
	            	}
	            	
	            }
	            con.close();
	
	}

}
