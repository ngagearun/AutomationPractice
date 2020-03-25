package com.testng;

import java.util.Random;
import java.util.concurrent.TimeUnit;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateAnAccount extends Reusable{	
	
	
	@BeforeClass(groups={"regression","smoke","sanity"})
	
	public void clickoncreateaccountlink(){
		click(By.linkText("Create"));
		
	}
	
	@Test(priority=6,groups="regression")
	public void createaccount(){
		
		Random num=new Random();
		 int g_num=num.nextInt(1000);
		 
		 
		 
		
		sendkeys((By.name("emailid")), "candiate"+g_num+"@gmail.com");
		sendkeys((By.name("firstname")), "arun");
		sendkeys((By.name("lastname")), "kumar");
		sendkeys((By.name("password")), "123456789Aa@");
		sendkeys((By.name("confirmpassword")), "123456789Aa@");
		dropdown(By.name("hintquestion"), "Place of birth");
		sendkeys((By.name("hintanswer")), "hyderabad");
		click(By.name("Submit"));
		click(By.linkText("Logout"));
	}
	
	@Test(priority=2,groups="sanity")
	public void checkpasswordrulevalidation(){
		
		
		sendkeys((By.name("emailid")), "test@gmail.com");
		sendkeys((By.name("firstname")), "arun");
		sendkeys((By.name("lastname")), "kumar");
		sendkeys((By.name("password")), "123456789Aa@");
		sendkeys((By.name("confirmpassword")), "123456789Aa@");
		click(By.name("Submit"));
		alert();
	}
	
	@Test(priority=3,groups="smoke")
	public void checkinvalidpasswordvalidation(){
		
	
		sendkeys((By.name("emailid")), "test@gmail.com");
		sendkeys((By.name("firstname")), "arun");
		sendkeys((By.name("lastname")), "kumar");
		sendkeys((By.name("password")), "123456789Aa@");
		sendkeys((By.name("confirmpassword")), "1233443456789Aa@");
		dropdown(By.name("hintquestion"), "Place of birth");
		sendkeys((By.name("hintanswer")), "hyderabad");
		click(By.name("Submit"));
		alert();
	}
	
	@Test(priority=4,groups="regression")
	public void emailvalidrulemessage(){
		
		//click(By.linkText("Create"));
		sendkeys((By.name("emailid")), "test");
		sendkeys((By.name("firstname")), "arun");
		String value=readtextmesage(By.className("errorInline"));
		Assert.assertEquals("Please provide valid email address.", value);
			
	}
	
	@Test(priority=5,groups="regression")
	public void createaccountwithemailalreadyexist(){
		
		//click(By.linkText("Create"));
		sendkeys((By.name("emailid")), "test@gmail.com");
		sendkeys((By.name("firstname")), "arun");
		sendkeys((By.name("lastname")), "kumar");
		sendkeys((By.name("password")), "123456789Aa@");
		sendkeys((By.name("confirmpassword")), "123456789Aa@");
		dropdown(By.name("hintquestion"), "Place of birth");
		sendkeys((By.name("hintanswer")), "hyderabad");
		click(By.name("Submit"));
		String value=readtextmesage(By.xpath("//*[@id='instruction']/table/tbody/tr/td/ul/li"));
		Assert.assertEquals("Email already exists. Please enter another Email ID", value);
		
	}
	
	

}
