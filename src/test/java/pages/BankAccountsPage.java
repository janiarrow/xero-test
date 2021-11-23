package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankAccountsPage {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//span[@data-automationid='Add Bank Account-button']")
	WebElement addBankAccountBtn;
	
	public BankAccountsPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectAddBankAccount() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(addBankAccountBtn));
		addBankAccountBtn.click();
	}
	
	public boolean isBankAccountDisplayed(String accountName) {
		List<WebElement> webelements = driver.findElements(By.xpath("//div[contains(@class, 'bank-header')]"));
		for (Iterator iterator = webelements.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			if(webElement.getText().contains(accountName)) {
				return true;
			}
		}
		return false;
	}
	
}
