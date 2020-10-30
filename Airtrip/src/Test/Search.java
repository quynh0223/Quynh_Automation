package Test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Search extends BaseTest {
	
	@Test
	public void search() throws InterruptedException {
		//Navigate DomDP site
		driver.findElement(By.xpath("//*[@class='dp-dom']")).click();
		
		//Select Destination
		driver.findElement(By.xpath("//*[@data-name='outwardDeparturePort']//*[@value='TYO']")).click();
		driver.findElement(By.xpath("//*[@data-name='outwardArrivalPort']//*[@value='FUK']")).click();
		
		driver.findElement(By.id("outwardDate")).click();		
		
		Thread.sleep(2000);	
		
		List<WebElement> dates = driver.findElements(By.xpath("//*[@data-handler='selectDay']//*[@class='ui-state-default']"));
		int count = dates.size();
		
		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.xpath("//*[@data-handler='selectDay']//*[@class='ui-state-default']")).get(i).getText();
			if (text.equalsIgnoreCase("05")) {
				driver.findElements(By.xpath("//*[@data-handler='selectDay']//*[@class='ui-state-default']")).get(i).click();
				break;
			}
		}
		
		Thread.sleep(2000);	
		
		//Passenger
		driver.findElement(By.xpath("//*[@class='dom-dropdown-toggle']")).click();
			Thread.sleep(1000);		
			//Adult
		driver.findElement(By.xpath("//*[@data-name='adult']//*[@value='3']")).click();
			Thread.sleep(1000);	
			//Child-infant
		driver.findElement(By.xpath("//*[@data-name='child']//*[@value='1']")).click();
			Thread.sleep(1000);	
			//Child-infant
		driver.findElement(By.xpath("//*[@id='search-kids-select-0']//*[@value='5']")).click();
		
		driver.findElement(By.id("Path_675")).click();
		driver.findElement(By.id("dp-search")).click();
		
	}

}

