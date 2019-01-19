package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShoppingCartSummaryPage {
	
	public ShoppingCartSummaryPage() throws IOException{
		super();
	}
	
	@FindBy(how=How.XPATH,using="//a[@href='http://automationpractice.com/index.php?id_product=4&controller=product#/size-s/color-beige']//img")
	public WebElement SelectMostExpItem;
	
	
	public void checkItemIsPresent(){
		
		SelectMostExpItem.isDisplayed();
		
		}
					
	}

