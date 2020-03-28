package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utils.TestBase;

public class MyAccountPage extends TestBase {
	
	public MyAccountPage() throws IOException{
		super();
	}
	
	@FindBy(how=How.XPATH,using="//h1[@class='page-heading']")
	public WebElement MyAccountTheme;
	
	@FindBy(how=How.XPATH,using="//input[@id='search_query_top']")
	public WebElement SearchQuery;
	
	@FindBy(how=How.XPATH,using="//button[@name='submit_search']")
	public WebElement SubmitSearch;
	
	
	@FindBy(how=How.XPATH,using="//b[contains(text(),'Cart')]")
	public WebElement CartContent;
	
	public ShoppingCartSummaryPage searchCart(){
		
		CartContent.click();
		return PageFactory.initElements(driver, ShoppingCartSummaryPage.class);
	}
	
	
	public void checkVisible(){
		
		MyAccountTheme.isDisplayed();
	}
	
	public DressProductPage searchDress(String dress){
		
		SearchQuery.sendKeys(dress);
		SubmitSearch.click();
		
		
		return PageFactory.initElements(driver, DressProductPage.class);
	}
}
