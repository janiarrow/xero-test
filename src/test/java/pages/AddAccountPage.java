package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAccountPage {

	@FindBy(id="accountname-1025-inputEl")
	WebElement accountName;
	
	@FindBy(id="accounttype-1027-inputEl")
	WebElement accountType;
	
	@FindBy(id="accountnumber-1056-inputEl")
	WebElement accountNumber;
	
	@FindBy(id="common-button-submit-1015-btnInnerEl")
	WebElement continueBtn;
	
	public AddAccountPage(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}
	
	public void enterAccountName(String accountName) {
		this.accountName.sendKeys(accountName);
	}
	
	public void selectAccountType(String accountType) {
		this.accountType.sendKeys(accountType);
	}
	
	public void enterAccountNumber(String accountNumber) {
		this.accountNumber.sendKeys(accountNumber);
	}
	
	public void selectContinue() {
		continueBtn.click();
	}
	
}
