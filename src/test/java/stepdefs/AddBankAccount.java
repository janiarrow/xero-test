package stepdefs;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import hooks.GlobalHooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddAccountPage;
import pages.AuthenticationPage;
import pages.BankAccountsPage;
import pages.ConnectWithBankPage;
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchAccountPage;

public class AddBankAccount {

	private LoginPage login;
	private WebDriver driver;
	private Properties properties;
	
	@Before
	public void beforeScenario() {
		GlobalHooks.loadUrl();
	}

	@Given("I have logged in to my xero account")
	public void i_have_logged_in_to_my_xero_account() {
		this.driver = GlobalHooks.driver;
		new HomePage(driver).selectLogin();
		login = new LoginPage(driver);

		properties = new GlobalHooks().getProperty();
		login.enterEmail(properties.getProperty("xero.test.user"));
		login.enterPassword(properties.getProperty("xero.test.pass"));
		login.selectLogin();

		AuthenticationPage authenticationPage = new AuthenticationPage(driver);
		authenticationPage.useAnotherAuth();
		authenticationPage.useAuthWithSecurityQuestions();
		authenticationPage.enterSecurityAnswer1(securityAnswer(authenticationPage.getSecurityQuestion1()));
		authenticationPage.enterSecurityAnswer2(securityAnswer(authenticationPage.getSecurityQuestion2()));

		authenticationPage.selectSubmitAuthentication();
	}

	@Given("I have selected Bank Account from the menu")
	public void i_have_selected_Bank_Account_from_the_menu() {
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.selectAccount();
		dashboard.selectBankAccountsSubMenu();
	}

	@When("I select to add a bank account")
	public void i_select_to_add_a_bank_account() {
		BankAccountsPage bankAccounts = new BankAccountsPage(driver);
		bankAccounts.selectAddBankAccount();
	}

	@When("^add my ANZ (.*) bank details with (.*) and (.*)$")
	public void add_my_ANZ_bank_details(String accountType, String accountName, String accountNumber) {
		new SearchAccountPage(driver).selectANZBank();
		AddAccountPage addAccountPage = new AddAccountPage(driver);
		addAccountPage.enterAccountName(accountName);
		addAccountPage.selectAccountType(getAccountTypeIndex(accountType));
		addAccountPage.enterAccountNumber(accountNumber);
		addAccountPage.selectContinue();
	}
	
	@When("select the bank to send transactions to Xero later")
	public void select_the_bank_to_send_transactions_to_Xero_later() {
		ConnectWithBankPage connectWithBankPage = new ConnectWithBankPage(driver);
		connectWithBankPage.selectIGotAForm();
		connectWithBankPage.selectDoItLater();
		connectWithBankPage.goToDashboard();
	}

	@Then("^I can see my ANZ account (.*) has been added successfully$")
	public void i_can_see_my_ANZ_account_added_successfully(String accountName) {
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.selectAccount();
		dashboardPage.selectBankAccountsSubMenu();
		BankAccountsPage bankAccountsPage = new BankAccountsPage(driver);
		assertTrue(bankAccountsPage.isBankAccountDisplayed(accountName));
	}
	
	@After
	public void tear() {
		GlobalHooks.tearDown();
	}
	
	private String securityAnswer(String question) {
		switch (question) {
		case "What is the name of your favourite cartoon?":
			return properties.getProperty("xero.test.securityAns1");
		case "What is your dream job?":
			return properties.getProperty("xero.test.securityAns2");
		case "What was the name of your first pet?":
			return properties.getProperty("xero.test.securityAns3");
		}
		return "answer not available";
	}

	private int getAccountTypeIndex(String accountType) {
		switch (accountType) {
		case "Everyday":
			return 1;
		case "Loan":
			return 2;
		case "Term Deposit":
			return 3;
		case "Creditcard":
			return 4;
		default:
			return 5;//Other
		}
	}
}
