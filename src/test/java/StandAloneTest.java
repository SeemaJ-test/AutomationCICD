package rahulshettyacademy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage {
	
	WebDriver driver;
	
	public void LandingPage(WebDriver driver)
	
	{
		//intialization
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;

	@FindBy(id="login")
	WebElement submit;
	
	public void loginApplication(String email,String password)
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
	}
//	driver.findElement(By.id("userEmail")).sendKeys("xoweke7325@dalebig.com");
//	driver.findElement(By.id("userPassword")).sendKeys("Qwerty123");

}

