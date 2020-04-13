package com.testng;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Reusable  {
	
	//String browsername="chrome";
	static WebDriver driver;
	static Actions action;
	static Select select;
	//@BeforeSuite
	@Parameters({"browsername"})
	@BeforeTest(groups={"smoke","regression","ssanity"})
	public void launchapp(String browsername){
		if(browsername.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		}else if(browsername.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Lenovo\\Downloads\\geckodriver.exe");
			driver=new FirefoxDriver();			
		}else{
		 driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://candidate.psiexams.com/index.jsp");
	}
	
	//@AfterSuite
	@AfterTest(groups={"smoke","regression","sanity"})
	public void close(){
		driver.quit();
	}
	
public static void sendText(By locatorname,String value){
	driver.findElement(locatorname).clear();
		driver.findElement(locatorname).sendKeys(value);
	}
	
	public static void click(By locatorname){
		driver.findElement(locatorname).click();
	}
	
	public static void mousehover(By locatorname){
		
		 action=new Actions(driver);
	   WebElement ele=	driver.findElement(locatorname);
		 action.moveToElement(ele).perform();
		
	}
	
	public static void switchToframeIndex(int index){
		
		driver.switchTo().frame(index);
	}
	
	public static void dropdown(By locatorname,String text){
		
		select=new Select(driver.findElement(locatorname));
		select.selectByVisibleText(text);
	}

	public static String readerrormessage(By locatorname){
		
		String text=driver.findElement(locatorname).getText();
		return text;
	}
	
	public void alert(){
		try{
		String text=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		//Assert.assertEquals("The password you entered does not meet the mandatory rules.", text);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	

}
