package hooks;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class GlobalHooks {

	public static WebDriver driver;
	private static Properties config;
	private static FileInputStream fileInputStream;

	@Before
	public void loadUrl() {

		loadConfig();
		
		String browser = config.getProperty("browser");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", config.getProperty("chrome.webdriver"));
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", config.getProperty("firefox.webdriver"));
			driver = new FirefoxDriver();
		}
		
		driver.get(config.getProperty("xero.test.suturl"));
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	public Properties getProperty() {
		return config;
	}
	
	private void loadConfig() {
		config = new Properties();
		try {
			fileInputStream = new FileInputStream("config.properties");
			config.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
