package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddAccountPage {
	
	private WebDriver driver;
	
	@FindBy(id="accountname-1025-inputEl")
	WebElement accountName;
	
	@FindBy(id="accounttype-1027-trigger-picker")
	WebElement accountTypes;
	
	@FindBy(id="accounttype-1027-inputEl")
	WebElement accountType;
	
	@FindBy(id="accountnumber-1056-inputEl")
	WebElement accountNumber;
	
	@FindBy(id="common-button-submit-1015-btnInnerEl")
	WebElement continueBtn;
	
	public AddAccountPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterAccountName(String accountName) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.accountName));
		this.accountName.sendKeys(accountName);
	}
	
	public void selectAccountType(int position) {
		this.accountType.click();
		for(int i = 0; i <= position; i++){
			Actions actions = new Actions(driver);
			if(i==position) {
				actions.sendKeys(Keys.ENTER).build().perform();
				return;
			}
			actions.sendKeys(Keys.DOWN).build().perform();
		}
	}
	
	public void enterAccountNumber(String accountNumber) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.accountNumber));
		this.accountNumber.sendKeys(accountNumber);
	}
	
	public void selectContinue() {
		continueBtn.click();
	}
	
}
