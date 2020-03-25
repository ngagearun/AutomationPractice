package com.testng;

import java.util.concurrent.TimeUnit;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Reusable{
	static WebDriver driver;
	
	
	@Parameters({"browsername","appurl"})
	@BeforeTest(groups={"regression","smoke","sanity"})
	public void openapp(String browsername,String appurl){
		
		if(browsername.equalsIgnoreCase("chrome")){
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver.exe");
			  driver=new ChromeDriver();//to launch thr browser
			  driver.manage().window().maximize();
			}else if(browsername.equalsIgnoreCase("firefox")){			
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\Lenovo\\Downloads\\geckodriver.exe");
				  driver=new FirefoxDriver();			
			}else if(browsername.equalsIgnoreCase("ie")){
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				System.setProperty("webdriver.ie.driver", "C:\\Users\\Lenovo\\Downloads\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
				driver=new InternetExplorerDriver(capabilities);
			}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(appurl);
	}
	
	@AfterTest(groups={"regression","smoke","sanity"})	
	public void closeapp(){
		driver.close();
	}
	public void sendkeys(By by,String value){		
		try{
			driver.findElement(by).clear();
		driver.findElement(by).sendKeys(value);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	public void click(By by){
		try{
			driver.findElement(by).click();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	
	public void dropdown(By by,String value){
		Select objname=new Select(driver.findElement(by));
		objname.selectByVisibleText(value);
	}
	
	public void alert(){
		try{
		String text=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals("The password you entered does not meet the mandatory rules.", text);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public String readtextmesage(By by){
		
		String text=driver.findElement(by).getText();
		return text;
		
	}
	
}
