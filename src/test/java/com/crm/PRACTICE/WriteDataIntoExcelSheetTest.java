package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteDataIntoExcelSheetTest {
	@Test
	public void WriteDataintoExcelSheetTest() throws Throwable
	{
		//step1: load excel file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Data.xlsx.xlsx");
		//step2: create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		//step3: get the sheet
		Sheet sh = wb.getSheet("Sheet1");
		//step4: get the row
		Row ro = sh.getRow(0);
		//step6:create a cell to write new data
         Cell ce = ro.createCell(5);
         //set cell value
          ce.setCellValue("archana");
        //open file in write mode
         FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\Data.xlsx.xlsx");
       wb.write(fos);
 
 //System.out.println(value);
		
		
		
		
		
		
		
		
		

	}
}
