package test_Assign;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoqaForm {

	public static void main(String[] args) throws InterruptedException {
		
		 WebDriverManager.edgedriver().setup();
	        WebDriver driver = new EdgeDriver();
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        driver.get("https://demoqa.com/automation-practice-form");
	        driver.manage().window().maximize();
	        
	        
	        
	        driver.findElement(By.id("firstName")).sendKeys("Shubham");
	        
	        driver.findElement(By.id("lastName")).sendKeys("Verma");
	        
	        driver.findElement(By.id("userEmail")).sendKeys("Shubham@gmail.com");
	        
	        driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
	        
            try {
    	        driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();
    	        
    	        Thread.sleep(2000);
    	        driver.findElement(By.cssSelector(".react-datepicker__month-select")).click();
    	        driver.findElement(By.xpath("//option[@value='7']")).click();
    	        driver.findElement(By.id("dateOfBirthInput")).sendKeys("17 May 1995");
    	        driver.findElement(By.id("userEmail")).click();
            }catch(Exception e) {
            	System.out.println("Not getting Date Formate");
            }
	        
	        driver.findElement(By.id("userNumber")).sendKeys("9074967678");
	        
	        try {
	        	driver.findElement(By.cssSelector(".subjects-auto-complete__value-container--is-multi")).sendKeys("Maths");
	        }catch(Exception e) {
	        	System.out.println("Not able to Get Subject");
	        }
	        
//	        WebElement subjectInput = driver.findElement(By.cssSelector(".subjects-auto-complete__value-container--is-multi"));
//	        subjectInput.sendKeys("Maths");
//	        subjectInput.click();
	        
	        driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']")).click();
	        
	        driver.findElement(By.xpath("//textarea[@placeholder='Current Address']")).sendKeys("Happy Birthday Colony");
	        
	        
	        try {
	        	driver.findElement(By.cssSelector("#state")).sendKeys("NCR");
		        driver.findElement(By.cssSelector("#city")).sendKeys("Delhi");
	        }catch(Exception e) {
	        	System.out.println("Not able to Get State");
	        }
	        
	        try {
		        driver.findElement(By.cssSelector("#city")).sendKeys("Delhi");
	        }catch(Exception e) {
	        	System.out.println("Not able to Get City");
	        }
	        // Select state from the dropdown
//	        WebElement stateDropdown = driver.findElement(By.xpath("//div[@id='state']"));
//	        Select selectState = new Select(stateDropdown);
//	        selectState.selectByValue("NCR");
//	        
//	        // Select city from the dropdown
//	        WebElement cityDropdown = driver.findElement(By.id("city"));
//	        Select selectCity = new Select(cityDropdown);
//	        selectCity.selectByVisibleText("Delhi");
	        
	        driver.findElement(By.cssSelector("button[type='submit']")).click();
	        
	        
	       String congo= driver.findElement(By.cssSelector("#example-modal-sizes-title-lg")).getText();
	       System.out.println(congo);
	
	
	
	
	}
}
