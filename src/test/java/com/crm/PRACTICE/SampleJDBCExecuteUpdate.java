package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import org.testng.annotations.Test;

public class SampleJDBCExecuteUpdate {
	@Test
	public void sampleJDBCExecuteUpdate() throws Throwable{
		Connection conn=null;
		try
		{
		//step1: register the database
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		//step2: get connection from database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		System.out.println("connection established");
		//step3:issue create statement
		Statement state = con.createStatement();
		//step4:execute a query
		 int result = state.executeUpdate("insert into student values(3,'Arpitha','Feamle')");
		 if(result==1)
		 {
			 System.out.println("data aded sucessfully");
		 }
		 else
		 {
			 System.out.println("data not added");
		 }
		}
		 catch(Exception e){
			 
		 }
		 finally
		 {
		//step5:close the database
		 conn.close();
		 }
	}
}
	


