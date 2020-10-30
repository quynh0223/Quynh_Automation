package Test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	
	String urlLoginErr = "https://www.skygate.co.jp/common/confirm_auth/sg_login/";

		
	public void login(String userNames,String passWords) throws InterruptedException {
		driver.findElement(By.xpath("//*[@class='login hideLoading']")).click();
		driver.findElement(By.id(userName)).sendKeys(userNames);
		driver.findElement(By.id(passWord)).sendKeys(passWords);
		driver.findElement(By.xpath("//*[contains(@href,'memberLoginForm')]")).click();
		Thread.sleep(1000);
	}

	@Test(priority = 1)
	public void loginSuccessful() throws InterruptedException{		
		login("anh01@evo.vn", "123456");
		Assert.assertEquals(driver.getCurrentUrl(), urlLandingPage);
	}	
	
	@Test(priority = 2)
	public void loginEmptyUsrPw() throws InterruptedException {
		login("", "");
		Assert.assertEquals(driver.getCurrentUrl(), urlLoginErr);
	}	
	
	@Test(priority = 3)
	public void loginEmptyUsrerName() throws InterruptedException {
		login("", "123456");
		Assert.assertEquals(driver.getCurrentUrl(), urlLoginErr);
	}
	
	@Test(priority = 4)
	public void loginEmptyPassword() throws InterruptedException {
		login("anh01@evo.vn", "");
		Assert.assertEquals(driver.getCurrentUrl(), urlLoginErr);
	}
	
	@Test(priority = 5)
	public void loginUsernameIncorrect() throws InterruptedException {
		login("anh011@evo.vn", "123456");
		Assert.assertEquals(driver.getCurrentUrl(), urlLoginErr);
	}
	
	@Test(priority = 6)
	public void loginPasswordIncorrect() throws InterruptedException {
		login("anh01@evo.vn", "123456@");
		Assert.assertEquals(driver.getCurrentUrl(), urlLoginErr);
	}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}
}
