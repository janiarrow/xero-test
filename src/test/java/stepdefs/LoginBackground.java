package stepdefs;

import org.openqa.selenium.WebDriver;

import hooks.GlobalHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class LoginBackground {

	private LoginPage login;
	private WebDriver driver;
	private GlobalHooks globalHooks;

	@Given("I have opened xero website")
	public void i_have_opened_xero_website() {
		this.globalHooks = new GlobalHooks();
		this.driver = globalHooks.getDriver();
		new HomePage(driver).selectLogin();
	}

	@When("I have entered login details")
	public void i_have_entered_login_details() {
		login = new LoginPage(driver);
		login.enterEmail(globalHooks.getProperty("xero.test.user"));
		login.enterPassword(globalHooks.getProperty("xero.test.pass"));
		login.selectLogin();
	}

	@When("I have passed the security authentication steps")
	public void i_have_passed_the_security_authentication_steps() {
		login.useAnotherAuth();
		login.useAuthWithSecurityQuestions();
		login.enterSecurityAnswer1(securityAnswer(login.getSecurityQuestion1()));
		login.enterSecurityAnswer2(securityAnswer(login.getSecurityQuestion2()));
	}

	@Then("I am logged into my xero account successfully")
	public void i_am_logged_into_my_xero_account_successfully() {
		login.selectSubmitAuthentication();
	}

	private String securityAnswer(String question) {
		switch (question) {
		case "What is the name of your favourite cartoon?":
			return globalHooks.getProperty("xero.test.securityAns1");
		case "What is your dream job?":
			return globalHooks.getProperty("xero.test.securityAns2");
		case "What was the name of your first pet?":
			return globalHooks.getProperty("xero.test.securityAns3");
		}
		return "answer not available";
	}

}
