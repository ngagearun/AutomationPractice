package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	
	public HomePage () throws IOException{
		super();
	}
	
	@FindBy(how=How.XPATH,using="//a[@class='login']")
	public static WebElement HomeSignin;
	
	
	public LoginPage ClickSignIn(){
		
		HomeSignin.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}

}
