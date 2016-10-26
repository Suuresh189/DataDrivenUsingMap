package demoLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser_URL {

	static WebDriver driver = null;

	public static WebDriver openBrowser(String sBrowserName, String sURL, String sPathOfDriver) {
		
		if (sBrowserName.equalsIgnoreCase("ie")) {
			return driver = openIEBrowser(driver, sURL, sPathOfDriver);
		}
		if (sBrowserName.equalsIgnoreCase("chrome")) {
			return driver = openChromeBrowser(driver, sURL, sPathOfDriver);
		}
		if (sBrowserName.equalsIgnoreCase("firefox")) {
			return driver = openFirefoxBrowser(driver, sURL, sPathOfDriver);
		}

		System.out.println("No browser drivers found");
		return driver;
	}

	private static WebDriver openFirefoxBrowser(WebDriver driver, String surl, String sPathOfDriver) {
		try {
			System.setProperty("webdriver.firefox.marionette", sPathOfDriver);
			driver = new FirefoxDriver();
			driver.get(surl);
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;
	}

	private static WebDriver openChromeBrowser(WebDriver driver, String sUrl, String sPathOfDriver) {
		try {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("chrome.switches","--disable-extensions");
			System.setProperty("webdriver.chrome.driver", sPathOfDriver);
			driver = new ChromeDriver(option);
			driver.get(sUrl);
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;
	}

	private static WebDriver openIEBrowser(WebDriver driver, String sUrl, String sPathOfdriver) {
		try {
			System.setProperty("webdriver.ie.driver", sPathOfdriver);
			driver = new InternetExplorerDriver();
			driver.get(sUrl);
			driver.manage().window().maximize();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;
	}

	public static void navigateBack(WebDriver driver) {
		driver.navigate().back();
	}

	public static void navigateForward(WebDriver driver) {
		driver.navigate().forward();
	}

	public static void reloadPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public static void deleteAllCookies(WebDriver driver) {
		driver.manage().deleteAllCookies();
	}

}
