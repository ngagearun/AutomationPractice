package com.testng;

import java.util.Random;
import java.util.concurrent.TimeUnit;




import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CreateAnAccount extends Reusable{
	
	@BeforeClass(groups={"smoke","regression","ssanity"})
	public void clickoncreateaccountlink(){
		click(By.linkText("Create"));
	}
	
	@AfterClass(groups={"smoke","regression","ssanity"})
	public void clickonlogout(){
		click(By.linkText("Logout"));
	}
	
	@Test(priority=7,groups={"smoke","regression"})
	public void createaccount(){
		Random r=new Random();
		int num=r.nextInt();
			
		sendText((By.name("emailid")), "candiate"+num+"@gmail.com");
		sendText((By.name("firstname")), "arun");
		sendText((By.name("lastname")), "kumar");
		sendText((By.name("password")), "123456789Aa@");
		sendText((By.name("confirmpassword")), "123456789Aa@");
		dropdown(By.name("hintquestion"), "Place of birth");
		sendText((By.name("hintanswer")), "hyderabad");
		click(By.name("Submit"));
		String value=readerrormessage(By.id("welcomeDiv"));
		Assert.assertEquals("Welcome arun  kumar   ", value);
		
		
		
	}
	
	@Test(priority=2,groups="smoke")
	public void checkerrormessageformadatoryfields(){
		
		sendText((By.name("emailid")), "candiate@gmail.com");
		click(By.name("Submit"));
		String text=readerrormessage(By.className("errorInline"));
		Assert.assertEquals("This field is required", text);
		
	}
@Test(priority=3,groups="sanity")	
public void checkpasswordrulevalidation(){
		
	
	sendText((By.name("emailid")), "test@gmail.com");
	sendText((By.name("firstname")), "arun");
	sendText((By.name("lastname")), "kumar");
	sendText((By.name("password")), "123456789");
	sendText((By.name("confirmpassword")), "123456789A");
	click(By.name("Submit"));
	alert();
	}
	
	@Test(priority=4,groups="regression")
	public void checkinvalidpasswordvalidation(){
		
	
		sendText((By.name("emailid")), "test@gmail.com");
		sendText((By.name("firstname")), "arun");
		sendText((By.name("lastname")), "kumar");
		sendText((By.name("password")), "123456789Aa@");
		sendText((By.name("confirmpassword")), "1233443456789Aa@");
		dropdown(By.name("hintquestion"), "Place of birth");
		sendText((By.name("hintanswer")), "hyderabad");
		click(By.name("Submit"));
		alert();
	}
	
	@Test(priority=5,groups="sanity")
	public void emailvalidrulemessage(){
		
		//click(By.linkText("Create"));
		sendText((By.name("emailid")), "test");
		sendText((By.name("firstname")), "arun");
		String value=readerrormessage(By.className("errorInline"));
		Assert.assertEquals("Please provide valid email address.", value);
			
	}
	
	@Test(priority=6,groups="smoke")
	public void createaccountwithemailalreadyexist(){
		
		//click(By.linkText("Create"));
		sendText((By.name("emailid")), "test@gmail.com");
		sendText((By.name("firstname")), "arun");
		sendText((By.name("lastname")), "kumar");
		sendText((By.name("password")), "123456789Aa@");
		sendText((By.name("confirmpassword")), "123456789Aa@");
		dropdown(By.name("hintquestion"), "Place of birth");
		sendText((By.name("hintanswer")), "hyderabad");
		click(By.name("Submit"));
		String value=readerrormessage(By.xpath("//*[@id='instruction']/table/tbody/tr/td/ul/li"));
		Assert.assertEquals("Email already exists. Please enter another Email ID", value);
		
	}
	

}
