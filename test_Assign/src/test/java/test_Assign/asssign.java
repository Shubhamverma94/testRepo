package test_Assign;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class asssign {

	public static void main(String[] args) throws InterruptedException {
		
		 WebDriverManager.edgedriver().setup();
	        WebDriver driver = new EdgeDriver();
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        driver.get("https://www.makemytrip.com/");
	        driver.manage().window().maximize();
	        
	        driver.findElement(By.xpath("//*[@for=\"fromCity\"]")).click();
	        driver.findElement(By.xpath("//*[@for=\"fromCity\"]")).sendKeys("PUNE");
	        driver.findElement(By.xpath("//*[@for=\"toCity\"]")).click();
	        driver.findElement(By.xpath("//*[@for=\"toCity\"]")).sendKeys("New Delhi");
	        
	        
	        driver.get("https://the-internet.herokuapp.com/login");
	        driver.findElement(By.id("username")).sendKeys("tomsmith");
	        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
	        driver.findElement(By.xpath("//*[@type='submit']")).click();
	        
	        driver.get("https://demoqa.com/buttons");
	        driver.findElement(By.id("doubleClickBtn")).click();
	        
	}
}
