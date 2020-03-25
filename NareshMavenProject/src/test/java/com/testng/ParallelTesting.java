package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTesting extends Reusable {
	
	@Parameters("browsername")
	@BeforeTest()
	public static void open(String browsername){	
		if(browsername.equalsIgnoreCase("firefox")){
	        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Lenovo\\Downloads\\geckodriver.exe");
            driver=new FirefoxDriver();
		}else if(browsername.equalsIgnoreCase("chrome")){
			   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver.exe");
			  driver=new ChromeDriver();//to launch thr browser
			  driver.manage().window().maximize();
	    }
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.mortgagecalculator.org/");
	
	}

	@AfterSuite
	public static void close(){
		driver.close();
	}
	
	@Test
	public void testmethod(){
		sendkeys(By.id("homeval"),"2344" );
		sendkeys(By.id("downpayment"),"5443" );		
		sendkeys(By.id("loanamt"),"5433" );
		sendkeys(By.id("intrstsrate"), "6");
		click(By.name("cal"));
		
	}

}
