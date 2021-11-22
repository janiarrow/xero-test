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
	
	@FindBy(xpath = "//button[@data-automationid='auth-continuebutton']")
	WebElement useAnotherAuthMeth;
	
	@FindBy(xpath = "//button[@data-automationid='auth-authwithsecurityquestionsbutton']")
	WebElement authWithSecurityQs;
	
	@FindBy(xpath = "//label[@data-automationid='auth-firstanswer--label']")
	WebElement authFirstQ;

	@FindBy(xpath = "//input[@data-automationid='auth-firstanswer--input']")
	WebElement authFirstAns;
	
	@FindBy(xpath = "//label[@data-automationid='auth-secondanswer--label']")
	WebElement authSecondQ;

	@FindBy(xpath = "//input[@data-automationid='auth-secondanswer--input']")
	WebElement authSecondAns;
	
	@FindBy(xpath = "//button[@data-automationid='auth-submitanswersbutton']")
	WebElement authSubmit;
	
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
	
	public void useAnotherAuth() {
		useAnotherAuthMeth.click();
	}
	
	public void useAuthWithSecurityQuestions() {
		authWithSecurityQs.click();
	}
	
	public String getSecurityQuestion1() {
		return authFirstQ.getText();
	}
	
	public void enterSecurityAnswer1(String answer) {
		authFirstAns.sendKeys(answer);
	}
	
	public String getSecurityQuestion2() {
		return authSecondQ.getText();
	}

	public void enterSecurityAnswer2(String answer) {
		authSecondAns.sendKeys(answer);
	}

	public void selectSubmitAuthentication() {
		authSubmit.click();
	}
	
}
