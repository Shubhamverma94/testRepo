package test_Assign;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LiksPresent {


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
	public void GettingLinks() {
		try {
			List<WebElement> allLinks = driver.findElements(By.tagName("a"));
			for (WebElement link : allLinks) {
			      System.out.println(link.getAttribute("href"));
			    }
			System.out.println(allLinks.size());
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}

	@Test(priority=2)
	public void HoverClick() {
		try {
			driver.findElement(By.linkText("Hovers")).click();
			System.out.println("Hovers Link Open");
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}
	
	@Test(priority=3)
	public void ValidateUrl() {
		try {
			//Validate the current url using soft assertion.
		    Assert.assertTrue(driver.getCurrentUrl().contains("/hovers"));
		    System.out.println("Soft Assertion Success");
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}
	
	@Test(priority=4)
	public void MouseHover() {
		try {
			WebElement user1Profile = driver.findElement(By.xpath("//h5[text()='name: user1']/../.."));
		    Actions action = new Actions(driver);
		    action.moveToElement(user1Profile).perform();
		    System.out.println("Hover on User1");
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}
	
	@Test(priority=5)
	public void ViewProfileClick() {
		try {
		  driver.findElement(By.linkText("View profile")).click();
		  Assert.assertTrue(driver.getCurrentUrl().contains("/users/1"));
		  System.out.println("SoftAssert-->Navigate to view Profile Page");
		  String pageText = driver.findElement(By.tagName("body")).getText();
		  System.out.println("Text On View Profile Page-->"+pageText);
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
