package rahulshettyacademy.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractCoomponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents {

	
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".hero-primary")
	WebElement confirmationMessage;
	
	public ConfirmationPage() 
	{
		return;
	}

	public String getConfirmationMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
