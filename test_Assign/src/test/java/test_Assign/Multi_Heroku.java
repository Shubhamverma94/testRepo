package test_Assign;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multi_Heroku {

	public static void main(String[] args) throws InterruptedException {
		  WebDriverManager.edgedriver().setup();
	        WebDriver driver = new EdgeDriver();
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        driver.get("https://the-internet.herokuapp.com/");
	        driver.manage().window().maximize();
	      
	        driver.findElement(By.linkText("Multiple Windows")).click();
	        System.out.println("Child window open that will be Parent tab now");
	        
	        driver.findElement(By.linkText("Click Here")).click();
	        System.out.println("GrandChild window open that will act as Child tab now");
	        
	        Set<String> id =  driver.getWindowHandles();
			System.out.println(id);
			
			//navigate back to parent window
			Iterator<String> it = id.iterator();   
			String parentId = it.next();
			System.out.println(parentId);
			String childId = it.next();
			System.out.println(childId);
			
			driver.switchTo().window(parentId); 
			Thread.sleep(2000);
			System.out.println(driver.findElement(By.tagName("body")).getText());
            driver.switchTo().window(childId);
            Thread.sleep(3000);
			System.out.println(driver.findElement(By.tagName("body")).getText());
            
			
			
				
			driver.switchTo().window(parentId);
            System.out.println("Returned to parent tab.");
	}
}
