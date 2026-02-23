package amazon;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MultipleWindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// opens Chrome in maximized mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		// Open brower
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.com/Smart-Home/b/?ie=UTF8&node=6563140011&ref_=nav_cs_smart_home");
		
		//open 'cart' page as a new window by holding 'Ctrl' key down and click on the cart
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-cart"))).keyDown(Keys.CONTROL).click().build().perform();
		
		/*
		 * return a set of string of opened windows to see how many windows are open:
		 * new tab or new window are considered as new window in Selenium
		 */
		Set<String> windows = driver.getWindowHandles(); //[parentId, childId]
		
		//access the elments in set of collection of strings -> using iterator
		Iterator<String> iterator = windows.iterator(); 
		
		//move one to grab the parentId
		String parentId = iterator.next();
		
		//move two to grab childId
		String childId = iterator.next();
		
		//switch to child window
		driver.switchTo().window(childId);
		
		//extract '$50 off'
		driver.findElement(By.id("maple-banner-text")).getText();
		
		//show only the number of discount ($50) in console
		String discount = driver.findElement(By.id("maple-banner-text")).getText().split("off")[0].split(" ")[1].trim();
		System.out.println(discount);
		
		//go back to the parent window
		driver.switchTo().window(parentId);
	}
}
