package TestCases;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjectModel.ComposeEmail;
import PageObjectModel.EmailIdPage;
import PageObjectModel.Logout;
import PageObjectModel.PasswordPage;
import Utilities.ActionMethods;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRunner 
{
	public static WebDriver driver;
	public String URL = "https://www.gmail.com";
	
	@BeforeTest
	public void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(URL);
	}
	
	@Test
	public void testCase1() throws InvalidFormatException, IOException 
	{
			
		Map<String, String> hash = ActionMethods.dataFetchFromExcel("Gmail", 1);
		
		EmailIdPage.enterEmailId(hash.get("LoginEmailId"));
		EmailIdPage.clickNextButtonEmailID();
		
		PasswordPage.enterPassword(hash.get("Password"));
		PasswordPage.clickNextButtonPassword();
		
		ComposeEmail.clickComposeEmail();
		ComposeEmail.enterToEmailID(hash.get("ToEmailId"));
		ComposeEmail.enterSubject(hash.get("Subject"));
		ComposeEmail.enterBody(hash.get("Body"));
		ComposeEmail.clickSendButton();
		
		Logout.clickOnIcon();
		Logout.clickLogout();
	}
	
//	@AfterTest
//	public void exitBrowser()
//	{
//		driver.quit();
//	}
}

//<scope>test</scope>