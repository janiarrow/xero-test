package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankAccountsPage {

	@FindBy(xpath = "//span[@data-automationid='Add Bank Account-button']")
	WebElement addBankAccountBtn;
	
	public BankAccountsPage(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}
	
	public void selectAddBankAccount() {
		addBankAccountBtn.click();
	}
	
}
