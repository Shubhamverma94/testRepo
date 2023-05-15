package test_Assign;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Herokuapp {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        //Get list of web-elements with tagName  - a
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println(allLinks.size());

        String parentTab = driver.getWindowHandle();

        Actions actions = new Actions(driver);
        for (WebElement link : allLinks) {
            actions.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();
        

        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(parentTab)) {
            	try {
            		System.out.println("Opening a New Window :-"+tab);
            		System.out.println(link.getText() + " - " + link.getAttribute("href"));
                    driver.switchTo().window(tab);

                    // Get text on the child tab and print to console
                    String childTabText = driver.findElement(By.tagName("body")).getText();
                    System.out.println(childTabText);
                    Thread.sleep(2000);
                    driver.close();
                    // Switch back to the original tab and print a message
                    driver.switchTo().window(parentTab);
                    System.out.println("Returned to parent tab.");
                    Thread.sleep(2000);
                    
            	}
            	catch(Exception err){
            		
            		System.out.println("Error occured While loading!!!!--->" + err);
            	}
            }
            }
            
        }
        driver.switchTo().window(parentTab);
        System.out.println("Fetching Finished!");

//        driver.quit();
    }
}
