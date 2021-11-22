package stepdefs;

import org.openqa.selenium.WebDriver;

import hooks.GlobalHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddAccountPage;
import pages.BankAccountsPage;
import pages.DashboardPage;
import pages.SearchAccountPage;

public class AddBankAccount {
	
	private WebDriver driver;
	
	@Given("I am on xero dashboard")
	public void i_am_on_xero_dashboard() {
		this.driver = new GlobalHooks().getDriver();
	}

	@When("I navigate to add a bank account")
	public void account() {
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.selectAccount();

		dashboard.selectBankAccountsSubMenu();
	}

	@Then("I can add an ANZ account")
	public void add() {
		BankAccountsPage bankAccounts = new BankAccountsPage(driver);
		bankAccounts.selectAddBankAccount();
		new SearchAccountPage(driver).searchForBank("ANZ");
		AddAccountPage addAccountPage = new AddAccountPage(driver);
		addAccountPage.enterAccountName("Test account");
		addAccountPage.selectAccountType("Everyday (day-to-day)");
		addAccountPage.enterAccountNumber("12345678912");
		addAccountPage.selectContinue();
	}	
}
