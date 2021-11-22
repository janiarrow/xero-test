package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//button[contains(@data-name,'navigation-menu/accounting')]")
	WebElement accountingMenu;
	
	@FindBy(xpath = "//a[@href='https://go.xero.com/Bank/BankAccounts.aspx']")
	WebElement accountSubMenu;	

	public DashboardPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	public void selectAccount() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(accountingMenu));
		accountingMenu.click();
	}
	
	public void selectBankAccountsSubMenu() {
		accountSubMenu.click();
	}
}
