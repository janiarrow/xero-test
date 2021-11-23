package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchAccountPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//div[@class='xui-contentblockitem--headings'][contains(.,'ANZ')]")
	WebElement optionANZBank;

	public SearchAccountPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}

	public void selectANZBank() {		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(optionANZBank));
		optionANZBank.click();
	}

}
