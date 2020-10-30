package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	String urlLandingPage = "https://www.skygate.co.jp/";
	String userName = "member_mail";
	String passWord = "password";
	
	WebDriver driver;	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium_Training\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(urlLandingPage);
		driver.manage().window().maximize();			
	}
}
