package com.testng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataaProviderTestNG extends Reusable{
	
	@Test(dataProvider="cal")
	public void calculate_loan(String homevalue,String downpayment,String loanamount,String interetrate){
		sendText(By.id("homeval"),homevalue );
		sendText(By.id("downpayment"), downpayment);
		sendText(By.id("loanamt"), loanamount);
		sendText(By.id("intrstsrate"),interetrate);
		click(By.name("cal"));
	}
	
	
	
	
	
	
	@DataProvider(name="cal")
	public String[][] inputdata() throws IOException{ 
		
		/*String arr[][]={ {"10000","32333","32223","3"},
				         {"23456","23454","1234","5"},
				         {"12123","45677","43212","6"}
				         
		                };*/
		
		String arr[][]=readdatafromexcel("C:\\Users\\Lenovo\\Desktop\\ExcelOperations.xlsx","Sheet1");
		
		return arr;
		
	}

	private String[][] readdatafromexcel(String pathname, String sheetname) throws IOException {
		
		String arr[][]=null;
		FileInputStream fi=new FileInputStream(pathname);
		//Workbook wb=WorkbookFactory.create(fi);		
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sh=wb.getSheet(sheetname);
		int tot_rows=sh.getLastRowNum();
		int tot_cols=sh.getRow(2).getLastCellNum();
		XSSFRow row;XSSFCell cell;
		arr=new String[tot_rows][tot_cols];
		for(int i=1;i<=tot_rows;i++){
			
			row=sh.getRow(i);
			
			for(int j=0;j<tot_cols;j++){
				
				cell=row.getCell(j);
				arr[i-1][j]=cell.getStringCellValue();
			}
			
		}	
		
		return arr;
	}

}
