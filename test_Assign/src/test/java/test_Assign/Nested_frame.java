package test_Assign;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nested_frame {
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
	public void TestFrames() {
		try {
			driver.findElement(By.linkText("Frames")).click();
			System.out.println("Frames Link Open");
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}
	
	@Test(priority=2)
	public void TestNestedFrames() {
		try {
			driver.findElement(By.linkText("Nested Frames")).click();
			System.out.println("Nested Frames Link Open");
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}
	
	@Test(priority=3)
	public void GetMiddleText() {
		//go inside frame 
		// Switch to the frame containing the text "MIDDLE".
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
		try {
			String text = driver.findElement(By.id("content")).getText();
			System.out.println("Middle Frame Text-->" + text);
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
