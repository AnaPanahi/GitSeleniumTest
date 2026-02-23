//Test selection of time for 2:00 AM on 'Car rental'
package booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CarRentalTimeAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// opens Chrome in maximized mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");   
        
        
		// Open brower
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.booking.com/?chal_t=1770225535257&force_referer=https%3A%2F%2Fchatgpt.com%2F");
		
		Thread.sleep(1000); //wait for 1 seconds
		
		//close pop-up page
		driver.findElement(By.xpath("//button[contains(@class,'daf5d4cb1c')]")).click();
		
		//open 'car rental' page
		driver.findElement(By.xpath("//div[contains(@class,'ca9d921c46')]/span[text()='Car rental']")).click();
		
		
		WebElement staticDropdown = driver.findElement(By.cssSelector("select[name='drop-off-time']"));
		
		//define dropdown obj from select class
		Select dropdown = new Select(staticDropdown);
		
		//select an option based on index
		dropdown.selectByIndex(4); //02:00 AM
		System.out.println(dropdown.getFirstSelectedOption().getText()); //Show the text of selected option which you can see in UI
		
		//select an option based on value attribute
		dropdown.selectByValue("02:00");
		System.out.println(dropdown.getFirstSelectedOption().getText());
	}
}
