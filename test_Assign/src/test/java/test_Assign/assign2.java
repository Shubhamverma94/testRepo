package test_Assign;

import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assign2 {
	public static void main(String[] args) throws InterruptedException {
		
		 WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        driver.get("https://www.google.com/");
	        driver.manage().window().maximize();
	        
	       driver.findElement(By.linkText("Gmail")).click();
	       
	       driver.get("https://the-internet.herokuapp.com/upload");
//	       driver.findElement(By.id("file-upload")).sendKeys("C:/Users/Shubham/Pictures/Screenshots/z.png/");
	       
	        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	        driver.findElement(By.id("Click for JS Confirm")).click();
	        Alert alert = driver.switchTo().alert();
	        alert.accept();
	}
}
