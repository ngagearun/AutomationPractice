package Reusables;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Reusables {
	
public static void dropdown(WebElement locator,int locatorValue){
		
		Select s = new Select(locator);
		s.selectByIndex(locatorValue);
	}

public static String randomEmails(){
	
	String userName = ""+(int)(Math.random()*Integer.MAX_VALUE);
	String emailID = "User"+userName+"@example.com";
	
	return emailID;
	
	}

}
