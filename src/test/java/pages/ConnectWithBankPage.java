package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConnectWithBankPage {

	private WebDriver driver;
	
	@FindBy(xpath="//a[@data-automationid='connectbank-buttonIHaveAForm']")
	WebElement iHaveAFormBtn;
	
	@FindBy(xpath="//a[@data-automationid='uploadForm-uploadLaterButton']")
	WebElement doItLater;
	
	@FindBy(xpath="//a[@href='https://go.xero.com/Dashboard']")
	WebElement goToDashboard;
	
	public ConnectWithBankPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectIGotAForm() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.iHaveAFormBtn));
		iHaveAFormBtn.click();
	}
	
	public void selectDoItLater() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.doItLater));
		doItLater.click();
	}

	public void goToDashboard() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.goToDashboard));
		goToDashboard.click();
	}
}
