package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;


import Pages.DressProductPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.RegistrationPage;
import Pages.ShoppingCartSummaryPage;
import Reusables.Reusables;
import Utils.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateAccountAndAddItemToCartTestSteps extends TestBase {

	public LoginPage Lp = null;
	public MyAccountPage map = null;
	public DressProductPage dpp = null;
	public static String email;
	public ShoppingCartSummaryPage scsp=null;

	@Before
	public void setup() throws IOException {
		initialize();
	}

	@Given("^the user navigates to the homepage$")
	public void the_user_navigates_to_the_homepage() {
		driver.get(CONFIG.getProperty("testsiteName"));

	}

	@When("^the user clicks on the signin link from the homepage$")
	public void the_user_clicks_on_the_signin_link_from_the_homepage() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		Lp = home.ClickSignIn();

	}

	@When("^the user enters details to create a new account$")
	public void the_user_enters_details_to_create_a_new_account() throws IOException {
		email = Reusables.randomEmails();
		RegistrationPage Rp = Lp.createAnAccount(email);
		Rp.clickTitle();
		Rp.enterFirstName("ken", "Adewale", "kenneth");
		Rp.enterDateofBirth(21, 3, 31);
		Rp.enterUserDetails("James", "Melrose", "124 Great Portland Street", "Alaska", 2);
		map = Rp.enterMoreDetails("12435", "02345987600", "Olais", 1);

	}

	@Then("^a new account is created for the user and the user is logged into account$")
	public void a_new_account_is_created_for_the_user_and_the_user_is_logged_into_account(){
		map.checkVisible();
		
	}

	@When("^the user searches for the most expensive item$")
	public void the_user_searches_for_the_most_expensive_item(){

		dpp = map.searchDress("dress");
		dpp.sortDresses(2);
		
	}

	@When("^the user adds the item to the cart$")
	public void the_user_adds_the_item_to_the_cart() throws Exception {
		dpp.selectMostExpDress();
		Thread.sleep(3000);
		dpp.contShopping();
	}

	@When("^the user logs out of the account and logs back in$")
	public void the_user_logs_out_of_the_account_and_logs_back_in() {
		Lp= dpp.LogOut();
		Lp.logIntoApp(email, "kenneth");
	}

	@Then("^the item is still present in the cart$")
	public void the_item_is_still_present_in_the_cart() {
		
		scsp = map.searchCart();
		scsp.checkItemIsPresent();
	}
	
	@After
	public void cleardown(){
	
		driver.close();
		driver.quit();
	
	}

}
