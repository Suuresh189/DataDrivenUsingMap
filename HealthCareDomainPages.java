package demoLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HealthCareDomainPages {

	public static File src;
	public static FileInputStream fin = null;
	public static Properties prop;
	public static String excelFile = "D:\\Suuresh\\Workspace\\DataDrivenProject\\src\\test\\java\\demoTestData\\HMS.xlsx";

	public static void getPropertiesData() {

		src = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Locators.properties");
		try {
			fin = new FileInputStream(src);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		prop = new Properties();
		try {
			prop.load(fin);
		} catch (Exception e) {

		}

	}

	public static void userLogin(WebDriver driver) {

		String username = null;
		String password = null;
		try {

			Map<String, Map<String, String>> HMS_Login = MapUser.readMultipleTestData(excelFile, "HMS", "HMS_Login");
			Iterator<Entry<String, Map<String, String>>> entries = HMS_Login.entrySet().iterator();

			while (entries.hasNext()) {

				Map.Entry<String, Map<String, String>> entry = (Entry<String, Map<String, String>>) entries.next();
				Map<String, String> values = (Map<String, String>) entry.getValue();
				username = values.get("Username");
				password = values.get("Password");

			}

			getPropertiesData();
			driver.findElement(By.xpath(prop.getProperty("userName"))).clear();
			driver.findElement(By.xpath(prop.getProperty("userName"))).sendKeys(username);
			driver.findElement(By.xpath(prop.getProperty("passWord"))).clear();
			driver.findElement(By.xpath(prop.getProperty("passWord"))).sendKeys(password);
			driver.findElement(By.xpath(prop.getProperty("signIn"))).click();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void perRegistrarion(WebDriver driver) {

		try {

			Map<String, Map<String, String>> Registration = MapUser.readMultipleTestData(excelFile, "HMS","Registration");
			Iterator<Entry<String, Map<String, String>>> entries = Registration.entrySet().iterator();

			while (entries.hasNext()) {

				Map.Entry<String, Map<String, String>> entry = (Entry<String, Map<String, String>>) entries.next();
				Map<String, String> values = (Map<String, String>) entry.getValue();

				getPropertiesData();
				driver.findElement(By.xpath(prop.getProperty("RegLink"))).click();
				new Select(driver.findElement(By.xpath(prop.getProperty("Patient_Cat"))))
						.selectByVisibleText(values.get("PatientCategory"));
				new Select(driver.findElement(By.xpath(prop.getProperty("Relation"))))
						.selectByVisibleText(values.get("Relation"));
				new Select(driver.findElement(By.xpath(prop.getProperty("Title"))))
						.selectByVisibleText(values.get("Title"));
				driver.findElement(By.xpath(prop.getProperty("FirstName"))).sendKeys(values.get("FirstName"));
				driver.findElement(By.xpath(prop.getProperty("LastName"))).sendKeys(values.get("LastName"));
				// new
				// Select(driver.findElement(By.xpath(prop.getProperty("PatientIden")))).selectByVisibleText(values.get("PatientIdentifier"));
				driver.findElement(By.xpath(prop.getProperty("PAN"))).sendKeys(values.get("PAN"));
				driver.findElement(By.xpath(prop.getProperty("DOB"))).sendKeys(values.get("DOB"));
				// new
				// Select(driver.findElement(By.xpath(prop.getProperty("Nationlity")))).selectByVisibleText(values.get("Nationality"));
				driver.findElement(By.xpath(prop.getProperty("Age"))).sendKeys(values.get("Age"));
				new Select(driver.findElement(By.xpath(prop.getProperty("VIP"))))
						.selectByVisibleText(values.get("VIP"));
				new Select(driver.findElement(By.xpath(prop.getProperty("Gender"))))
						.selectByVisibleText(values.get("Gender"));
				new Select(driver.findElement(By.xpath(prop.getProperty("Education"))))
						.selectByVisibleText(values.get("Education"));
				new Select(driver.findElement(By.xpath(prop.getProperty("Mstatus"))))
						.selectByVisibleText(values.get("Mstatus"));
				new Select(driver.findElement(By.xpath(prop.getProperty("Occupation"))))
						.selectByVisibleText(values.get("Occupation"));
				new Select(driver.findElement(By.xpath(prop.getProperty("Religion"))))
						.selectByVisibleText(values.get("Religion"));
				new Select(driver.findElement(By.xpath(prop.getProperty("BloodGP"))))
						.selectByVisibleText(values.get("BloodGroup"));
				new Select(driver.findElement(By.xpath(prop.getProperty("PrimaryLang"))))
						.selectByVisibleText(values.get("PrimaryLang"));
				new Select(driver.findElement(By.xpath(prop.getProperty("Citizenship"))))
						.selectByVisibleText(values.get("Citizenship"));
				new Select(driver.findElement(By.xpath(prop.getProperty("SrCitizen"))))
						.selectByVisibleText(values.get("SeniorCitizen"));
				driver.findElement(By.xpath(prop.getProperty("Address"))).sendKeys(values.get("Address"));
				driver.findElement(By.xpath(prop.getProperty("Phone"))).sendKeys(values.get("Phone"));
				new Select(driver.findElement(By.xpath(prop.getProperty("Country"))))
						.selectByVisibleText(values.get("Country"));
				driver.findElement(By.xpath(prop.getProperty("Zip"))).sendKeys(values.get("Zip"));
				driver.findElement(By.xpath(prop.getProperty("PermanentSave"))).submit();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void emergencyRegistration(WebDriver driver) {
		
		try {
			Map<String, Map<String, String>> EmergencyReg = MapUser.readMultipleTestData(excelFile, "HMS","EmergencyReg");
			Iterator<Entry<String, Map<String, String>>> entries = EmergencyReg.entrySet().iterator();

			while (entries.hasNext()) {

				Map.Entry<String, Map<String, String>> entry = (Entry<String, Map<String, String>>) entries.next();
				Map<String, String> values = (Map<String, String>) entry.getValue();

				getPropertiesData();
				driver.findElement(By.xpath(prop.getProperty("EmerLink"))).click();
				new Select(driver.findElement(By.xpath(prop.getProperty("Patient_Cat"))))
						.selectByVisibleText(values.get("PatientCategory"));
				new Select(driver.findElement(By.xpath(prop.getProperty("Relation"))))
				.selectByVisibleText(values.get("Relation"));
				new Select(driver.findElement(By.xpath(prop.getProperty("Title"))))
				.selectByVisibleText(values.get("Title"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
	

