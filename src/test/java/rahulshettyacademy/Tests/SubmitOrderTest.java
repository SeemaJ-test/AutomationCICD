package rahulshettyacademy.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Assert.ThrowingRunnable;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponent.BaseTest;
import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.CheckoutPage;
import rahulshettyacademy.pageobject.ConfirmationPage;
import rahulshettyacademy.pageobject.LandingPage;
import rahulshettyacademy.pageobject.ProductCatalogue;


public class SubmitOrderTest extends BaseTest {
String productName = "ZARA COAT 3";
	
	    @Test(dataProvider="getData",groups= {"Purchase"})
		
		public void SubmitOrder(HashMap<String,String>input) throws IOException
		{
		
		
	    LandingPage landingPage = launchApplication();
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
	    List<WebElement>products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage =productCatalogue.goToCartPage();
		
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
	    String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		

		
	}

	    @Test(dependsOnMethods= {"submitOrder"})
	    public void OrderHistoryTest()
	    {
	    	ProductCatalogue productCatalogue  = landingPage.loginApplication("xoweke7325@dalebig.com\",\"Qwerty123");
	    	OrderPage ordersPage = productCatalogue.goToOrdersPage();
	    	Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	    }	    //To verify ZARA COAT 3 is displaying in order page
		
	    @DataProvider
	    public Object[][] getData()
	    {
	    	HashMap<String,String> map = new HashMap<String,String>();
	    	map.put("email","xoweke7325@dalebig.com");
	    	map.put("password","Qwerty123");
	    	map.put("product", "ZARA COAT 3");
	    	
	    	HashMap<String,String> map1 = new HashMap<String,String>();
	    	map1.put("email", "rahulshetty@gmail.com");
	    	map1.put("password", "Qwerty1234567");
	    	map1.put("product", "ZARA COAT 3");
	    			
	    	return new Object[][] {{map}, {map1}};
	    	
	    }
//	    @DataProvider
//	    public Object[][] getData()
//	    {
//	    	return new Object[][] {{"xoweke7325@dalebig.com","Qwerty123","ZARA COAT 3"},{"rahulshetty@gmail.com","Qwerty1234567"}};
//	    }
}

