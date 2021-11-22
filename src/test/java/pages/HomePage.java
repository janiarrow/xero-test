package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath = "(//a[contains(.,'Log in')])[2]")
	WebElement loginBtn;

	public HomePage(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}
	
	public void selectLogin() {
		loginBtn.click();
	}
}
