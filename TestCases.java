package demoTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import demoLibrary.HealthCareDomainPages;


public class TestCases {
	
	WebDriver driver = null;
	static String path = "D:\\Suuresh\\Workspace\\DataDrivenProject\\src\\test\\java\\demoTestData\\HMS.xlsx";
	
	@BeforeTest
	public void startUp(){
		
		driver = demoLibrary.Browser_URL.openBrowser("chrome", "http://selenium4testing.com/hms/",
				"D:\\Suuresh\\chromedriver.exe");
	}
	
	
	@Test
	public void test() {
		try {
			
			
			HealthCareDomainPages.userLogin(driver);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			HealthCareDomainPages.perRegistrarion(driver);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			HealthCareDomainPages.emergencyRegistration(driver);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	//@AfterTest
	public void tearDown(){
		
		driver.close();
	}
	
	
	

}
