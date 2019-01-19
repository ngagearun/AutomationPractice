package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	
	public LoginPage() throws IOException{
		
		super();
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='email_create']")
	public WebElement createAccountEmail;
	
	@FindBy(how=How.XPATH,using="//button[@id='SubmitCreate']")
	public WebElement createAccountSubmit;
	
	@FindBy(how=How.XPATH,using="//input[@id='email']")
	public WebElement LogInwithEmail;
	
	@FindBy(how=How.XPATH,using="//input[@id='passwd']")
	public WebElement LogInwithPasswd;
	
	@FindBy(how=How.XPATH,using="//button[@id='SubmitLogin']//span")
	public WebElement LoginSubmitBut;
	
	
	public MyAccountPage logIntoApp(String email,String password)
	{
		LogInwithEmail.sendKeys(email);
		LogInwithPasswd.sendKeys(password);
		LoginSubmitBut.click();
		
		return PageFactory.initElements(driver, MyAccountPage.class);
	}
	
	public RegistrationPage createAnAccount(String email){
		
		createAccountEmail.sendKeys(email);
		createAccountSubmit.click();
		
		return PageFactory.initElements(driver, RegistrationPage.class);
	}

}
