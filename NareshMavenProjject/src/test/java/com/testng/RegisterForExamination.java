package com.testng;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterForExamination extends Reusable{
	
	@BeforeClass(groups={"smoke","regression","ssanity"})
	public void clickonregisterlink(){
		click(By.linkText("Register"));
	}
	
	 @Test(priority=7,groups="smoke")
	   public void fDNY_RegisterExam_coreectuerdetails(){
		   
		   dropdown(By.id("c0"), "FDNY");
		   dropdown(By.id("c1"), "FDNY");
		   click(By.linkText("FDNY Entrance Exam (7001-E1)"));
		   click(By.name("Submit3"));
		   sendText((By.name("emailid")), "samule@gmail.com");
		   sendText((By.name("password")), "123456789Aa@");
		   click(By.name("loginbtn"));
		   String reisteruername=readerrormessage(By.id("welcomeDiv"));
		   System.out.println(reisteruername);
		   Assert.assertTrue(reisteruername.contains("arun"));	   
		   click(By.linkText("Logout"));
		   click(By.linkText("Register"));
	   }
	   
	   @Test(priority=8,groups="sanity")
	   public void findtestdate_RegisterExam() throws InterruptedException{
		   
		   dropdown(By.id("c0"), "FDNY");
		   dropdown(By.id("c1"), "FDNY");
		   click(By.linkText("FDNY Entrance Exam (7001-E1)"));
		   click(By.name("Submit3"));
		   sendText((By.name("emailid")), "samule@gmail.com");
		   sendText((By.name("password")), "123456789Aa@");
		   click(By.name("loginbtn"));	   
		   click(By.linkText("Find test date"));
		   dropdown(By.id("c0"), "FDNY");
		   dropdown(By.id("c1"), "FDNY");
		   click(By.id("radio0"));
		   Thread.sleep(4000);
		   JavascriptExecutor jse = ((JavascriptExecutor)driver);
		   jse.executeScript("window. scrollBy(0,800)", "");
		   Thread.sleep(4000);
		//   jse.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.id("Continue")));
		   click(By.id("Continue"));
		   sendText(By.id("autoSuggestField"), "99501");
		   driver.findElement(By.id("autoSuggestField")).sendKeys(Keys.ENTER);
		   click(By.id("Searchbtn"));
		   String message=readerrormessage(By.className("tips"));
		   Assert.assertEquals("No test centers found.",message);
		  
		   
	   }

}
