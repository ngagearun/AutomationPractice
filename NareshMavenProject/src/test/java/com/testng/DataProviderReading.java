package com.testng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderReading extends Reusable {
	

	
	@BeforeTest
	public static void open(){			
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Lenovo\\Downloads\\geckodriver.exe");
    driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.mortgagecalculator.org/");
	
	}

	@AfterTest
	public static void close(){
		driver.close();
	}
	
	@Test(dataProvider="loancalculator")
	public void calculate(String homrvlue,String downpayment,String loanamount,String interestrate){
		
		sendkeys(By.id("homeval"),homrvlue );
		sendkeys(By.id("downpayment"),downpayment );		
		sendkeys(By.id("loanamt"),loanamount );
		sendkeys(By.id("intrstsrate"), interestrate);
		click(By.name("cal"));
		
	}
	
	@DataProvider(name="loancalculator")
	public String[][] readingdata() throws EncryptedDocumentException, InvalidFormatException, IOException{
		/*String arr[][]={   {"23456","34344","43244","5"},
				           {"43224","543345","6543","6"},
				           {"23456","78900","3245","7"}

                      };		
		return arr;*/
		String arr[][]=	readingdatafromexcel("C:\\Users\\Lenovo\\Desktop\\ExcelOperations.xlsx","Sheet1");
		return arr;
		
		
		
	}

	private String[][] readingdatafromexcel(String path, String sheetname) throws EncryptedDocumentException, InvalidFormatException, IOException {
		String value[][];//declration
		FileInputStream fi=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(sheetname);	
		int total_rows=sh.getLastRowNum();
		int total_cols=sh.getRow(2).getLastCellNum();		
		value=new String[total_rows][total_cols];//initailiation
		for(int i=1;i<total_rows;i++){			
			Row row=sh.getRow(i);
			for(int j=0;j<total_cols;j++){				
				Cell cell=row.getCell(j);
				value[i-1][j]=cell.getStringCellValue();
			}			
		}		
		return value;
		
		
	}
	
	
}
