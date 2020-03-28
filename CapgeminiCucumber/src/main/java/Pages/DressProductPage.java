package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Reusables.Reusables;
import Utils.TestBase;

public class DressProductPage extends TestBase
{
	public DressProductPage() throws IOException{
		super();
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='layered_price_slider']//a[1]")
	public WebElement DressSliderBar;
	
	@FindBy(how=How.XPATH,using="//select[@id='selectProductSort']")
	public WebElement SortDresses;
	
	@FindBy(how=How.XPATH,using="//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line']//img[@title='Printed Dress']")
	public WebElement mostExpDress;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Add to cart')]")
	public WebElement addToCart;
	
	@FindBy(how=How.XPATH,using="//span[@title='Continue shopping']//span")
	public WebElement ContShopping;
	
	@FindBy(how=How.XPATH,using="//a[@title='Log me out']")
	public WebElement LogOutLink;
	
	@FindBy(how=How.XPATH,using="//a[@title='Log in to your customer account']")
	public WebElement LogBackIn;
	
	
	public void sortDresses(int num){
		
		Reusables.dropdown(SortDresses, num);
	}
	
	public void selectMostExpDress(){
		
		Actions actions = new Actions(driver);
		actions.moveToElement(mostExpDress);
		actions.moveToElement(addToCart);
		actions.click().build().perform();
		
	}
	
	
	public void contShopping(){
		
		ContShopping.click();
	}
	
	public LoginPage LogOut(){
		
		LogOutLink.click();
		LogBackIn.click();
		return PageFactory.initElements(driver,LoginPage.class);
		
	}	
	
}
