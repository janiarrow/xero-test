package hooks;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GlobalHooks {

	public static WebDriver driver;
	private static Properties config;
	private static FileInputStream fileInputStream;

	public static void loadUrl() {

		loadConfig();
		
		String browser = config.getProperty("browser");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", config.getProperty("chrome.webdriver"));
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			driver = new ChromeDriver(options);
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", config.getProperty("firefox.webdriver"));
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		
		driver.get(config.getProperty("xero.test.suturl"));
	}
	
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
	
	public Properties getProperty() {
		return config;
	}
	
	private static void loadConfig() {
		config = new Properties();
		try {
			fileInputStream = new FileInputStream("config.properties");
			config.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
