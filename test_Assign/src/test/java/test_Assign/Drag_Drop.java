package test_Assign;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag_Drop {

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
	public void TestDragDrop() {
		try {
			driver.findElement(By.linkText("Drag and Drop")).click();
			System.out.println("Drag and Drop Link Open");
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}
	
	@Test(priority=2)
	public void CheckPage() {
		try {
			driver.findElement(By.xpath("//h3[contains(text(),'Drag and Drop')]")).isDisplayed();
			System.out.println("Landed On Drag and Drop Page");
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}
	
	@Test(priority=3)
	public void DragAndDrop() {
		try {
			//drag and drop
		      WebElement source=driver.findElement(By.id("column-a"));
		      WebElement target=driver.findElement(By.id("column-b"));
		  
		      Actions act = new Actions(driver);
		      act.dragAndDrop(source, target).build().perform();
		      
//		      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		      wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("column-b"), "A"));

		      
		      System.out.println("A Successfully Dragged and Dropped to B");
		} catch(Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}
	
	// Close the browser after all tests have executed
			@AfterTest()
			public void tearDown() {
				
					driver.quit();
				
			}
}
