package rahulshettyacademy.stepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponent.BaseTest;
import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.CheckoutPage;
import rahulshettyacademy.pageobject.ConfirmationPage;
import rahulshettyacademy.pageobject.LandingPage;
import rahulshettyacademy.pageobject.ProductCatalogue;

public class stepDefinationimpl extends BaseTest {
	
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	@Given("I landed on Ecommerce page")
	
	public void I_landed_on_Ecommerce_page() throws IOException
	{
		landingPage = launchApplication();
		
	}
	
	//Given logged in with username xoweke7325@dalebig.com and password Qwerty123
	@Given("^logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_and_password_(String username, String password) 
	{
		productCatalogue = landingPage.loginApplication(username,password);
	}
	
	@When("^I add product to  (.+)  cart$")
	public void I_add_produc_to_cart(String productName)
	{
	List<WebElement>products = productCatalogue.getProductList();
	productCatalogue.addProductToCart(productName);
	}
	
	@When("^checkout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String productName)
	{
        CartPage cartPage =productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
	}
	
	@Then("{string} mesage is displyed on ConfirmationPage")
	public void message_is_displayed_on_ConfirmationPage(String string)
    {
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		
	}
}
