package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchAccountPage {

	@FindBy(xpath = "//input[@data-automationid='bankSearch--input']")
	WebElement searchYourBank;

	public SearchAccountPage(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}

	public void searchForBank(String bank) {		
		searchYourBank.sendKeys(bank);
//		(new WebElement(By.xpath("//span[@class='xui-contentblockitem--primaryheading'][contains(.,'"+ bank +"')]"))).click();
	}

}
