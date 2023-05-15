package test_Assign;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Heroku_testNg {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String url = "https://the-internet.herokuapp.com/";
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public void testMultipleWindows() {
		try {
			driver.findElement(By.linkText("Multiple Windows")).click();
			System.out.println("Window open that will be Parent tab now");
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}

	@Test(priority=2)
	public void testClickHereText() {
		try {
			driver.findElement(By.linkText("Click Here")).click();
			System.out.println("Window open that will act as Child tab now");
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}

	@Test(priority=3)
	public void testSwitchWindowAndGetText() {
		try {
			Set<String> id = driver.getWindowHandles();
			System.out.println(id);

			// navigate back to parent window
			Iterator<String> it = id.iterator();
			String parentId = it.next();
			System.out.println(parentId);
			String childId = it.next();
			System.out.println(childId);

			driver.switchTo().window(parentId);
			
			driver.switchTo().window(childId);

			System.out.println("Text on Child Tab--->" + driver.findElement(By.tagName("body")).getText());
			
			driver.switchTo().window(parentId);

			System.out.println("Text on Parent Tab--->" + driver.findElement(By.tagName("h3")).getText());
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}

	// Close the browser after all tests have executed
	@AfterTest()
	public void tearDown() {
		
			driver.quit();
		
	}
}
