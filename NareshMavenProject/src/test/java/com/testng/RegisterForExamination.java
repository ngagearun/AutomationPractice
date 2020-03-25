package com.testng;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterForExamination extends Reusable {

	
   @BeforeClass(groups={"regression","smoke"})	
	public void clickoncreateaccountlink() throws InterruptedException{
	   Thread.sleep(5000);
		click(By.linkText("Register"));
	}
   
   @Test(priority=7,groups="regression")
   public void fDNY_RegisterExam_coreectuerdetails(){
	   
	   dropdown(By.id("c0"), "FDNY");
	   dropdown(By.id("c1"), "FDNY");
	   click(By.linkText("FDNY Entrance Exam (7001-E1)"));
	   click(By.name("Submit3"));
	   sendkeys((By.name("emailid")), "samule@gmail.com");
	   sendkeys((By.name("password")), "123456789Aa@");
	   click(By.name("loginbtn"));
	   String reisteruername=readtextmesage(By.id("welcomeDiv"));
	   System.out.println(reisteruername);
	   Assert.assertTrue(reisteruername.contains("arun"));	   
	   click(By.linkText("Logout"));
	   click(By.linkText("Register"));
   }
   
   @Test(priority=8,groups="smoke")
   public void findtestdate_RegisterExam(){
	   
	   dropdown(By.id("c0"), "FDNY");
	   dropdown(By.id("c1"), "FDNY");
	   click(By.linkText("FDNY Entrance Exam (7001-E1)"));
	   click(By.name("Submit3"));
	   sendkeys((By.name("emailid")), "samule@gmail.com");
	   sendkeys((By.name("password")), "123456789Aa@");
	   click(By.name("loginbtn"));	   
	   click(By.linkText("Find test date"));
	   dropdown(By.id("c0"), "FDNY");
	   dropdown(By.id("c1"), "FDNY");
	   click(By.id("radio0"));
	   click(By.id("Continue"));
	   sendkeys(By.id("autoSuggestField"), "99501");
	   driver.findElement(By.id("autoSuggestField")).sendKeys(Keys.ENTER);
	   click(By.id("Searchbtn"));
	   String message=readtextmesage(By.className("tips"));
	   Assert.assertEquals("No test centers found.",message);
	  
	   
   }







}
