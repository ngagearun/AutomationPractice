package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Reusables.Reusables;

public class RegistrationPage extends  BasePage{

	public RegistrationPage() throws IOException{
		super();
	
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='id_gender1']")
	public static WebElement Regtitle;
	
	@FindBy(how=How.XPATH,using="//input[@id='customer_firstname']")
	public static WebElement RegFirstname;
	
	@FindBy(how=How.XPATH,using="//input[@id='customer_lastname']")
	public static WebElement RegLastname;
	
	@FindBy(how=How.XPATH,using="//input[@type='password']")
	public static WebElement RegPassword;
	
	@FindBy(how=How.XPATH,using="//select[@id='days']")
	public static WebElement RegDays;
	
	@FindBy(how=How.XPATH,using="//select[@id='months']")
	public static WebElement RegMonths;
	
	@FindBy(how=How.XPATH,using="//select[@id='years']")
	public static WebElement RegYears;
	
	@FindBy(how=How.XPATH,using="//input[@id='firstname']")
	public static WebElement firstname;
	
	@FindBy(how=How.XPATH,using="//input[@id='lastname']")
	public static WebElement lastname;
	
	@FindBy(how=How.XPATH,using="//input[@id='address1']")
	public static WebElement RegAddress1;
	
	@FindBy(how=How.XPATH,using="//input[@id='city']")
	public static WebElement RegCity;
	
	@FindBy(how=How.XPATH,using="//select[@id='id_state']")
	public static WebElement RegState;
	
	@FindBy(how=How.XPATH,using="//input[@id='postcode']")
	public static WebElement RegPostcode;
	
	@FindBy(how=How.XPATH,using="//select[@id='id_country']")
	public static WebElement RegCountry;
	
	@FindBy(how=How.XPATH,using="//input[@id='phone_mobile']")
	public static WebElement RegPhoneMobile;
	
	@FindBy(how=How.XPATH,using="//input[@id='alias']")
	public static WebElement RegAlias;
	
	@FindBy(how=How.XPATH,using="//button[@id='submitAccount']")
	public static WebElement RegSubmitAccout;
	
	
	public void clickTitle(){
		
		Regtitle.click();	
	}
	
	public void enterFirstName(String firstname,String lastname,String password){
		
		 RegFirstname.sendKeys(firstname);
		 RegLastname.sendKeys(lastname);
		 RegPassword.sendKeys(password);
	}
	
	/*public void enterLastName(String lastname){
		
		RegLastname.sendKeys(lastname);
	}
	
	public void enterPassword(String password){
		
	*/	//RegPassword.sendKeys(password);
	//}
	
	public void enterDateofBirth(int day,int Month,int Year){
		
		Reusables.dropdown(RegDays, day);
		Reusables.dropdown(RegMonths, Month);
		Reusables.dropdown(RegYears, Year);
	}
	
	public void enterUserDetails(String firstnames,String lastnames,String address,String city,int state){
		
		firstname.clear();
	    lastname.clear();
	    RegAddress1.clear();
	    RegAlias.clear();
		firstname.sendKeys(firstnames);
		lastname.sendKeys(lastnames);
		RegAddress1.sendKeys(address);
		RegCity.sendKeys(city);
		Reusables.dropdown(RegState,state);
		
	}
	
	public MyAccountPage enterMoreDetails(String postcode,String Mobile,String alias,int us){
		
		RegPostcode.sendKeys(postcode);
		RegPhoneMobile.sendKeys(Mobile);
		RegAlias.sendKeys(alias);
		Reusables.dropdown(RegCountry, us);
		RegSubmitAccout.click();
		
		return PageFactory.initElements(driver, MyAccountPage.class);
		
		
	}
	
}
