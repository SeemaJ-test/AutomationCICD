package rahulshettyacademy.Tests;

import java.time.Duration;
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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponent.BaseTest;
import rahulshettyacademy.pageobject.LandingPage;
import rahulshettyacademy.pageobject.ProductCatalogue;

public class ErrorValidation extends BaseTest {
	
	@Test
	public void submitOrder() 
	{
		String productName = "ZARA COAT 3";
	    landingPage.loginApplication("xoweke7325@dalebig.com\",\"Qwerty123");
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
	}

	
}
