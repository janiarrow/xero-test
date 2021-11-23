package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id = "xl-form-email")
	WebElement email;
	
	@FindBy(id = "xl-form-password")
	WebElement password;
	
	@FindBy(id = "xl-form-submit")
	WebElement loginBtn;
	
	
	public LoginPage(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}
	
	public void enterEmail(String email) {
		this.email.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}
	
	public void selectLogin() {
		loginBtn.click();
	}
	
	
	
}
