package wikipedia;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAttempts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Open brower
		WebDriver driver = new ChromeDriver();

		/*
		 * I'm on Selenium 4.40.0, which supports Selenium Manager. It downloads a
		 * matching driver automatically.
		 */
		
		// driver.get("https://auth.wikimedia.org/enwiki/wiki/Special:PasswordReset");
		driver.get("https://en.wikipedia.org/wiki/Special:UserLogin");

		driver.findElement(By.name("wpName")).sendKeys("ana"); // locator: name
		driver.findElement(By.id("wpPassword1")).sendKeys("2652"); // locator: name

		driver.findElement(By.cssSelector("button[tabindex='5']")).click(); // locator: cssSelector -> TagName[attribute='value']
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Wait for couple of seconds for the error message to be shown
		
		System.out.println(driver.findElement(By.cssSelector(".cdx-message__content")).getText()); //locator -> cssSelector
		System.out.println(driver.findElement(By.className("cdx-message__content")).getText()); //locator -> class Name
		
		//Clear Username and Password
		driver.findElement(By.name("wpName")).clear();
		driver.findElement(By.id("wpPassword1")).clear();
		
		Thread.sleep(1000); // In Java, if you wanna wait for 1 sec for an obj to be in a stable state when you change view!
		
		
		driver.findElement(By.xpath("//div[contains(@class,'loginText')]/div[2]/div/input")).sendKeys("anaSeleniumTest"); // locator -> combination of parent-to-child traversing, indexing, and customized xPath locators 
		driver.findElement(By.cssSelector("input[name*='wpPass']")).sendKeys("12345Sel$$$"); //locator -> CSS for DYNAMIC attributes or customized combination
		driver.findElement(By.id("wpRemember")).click(); //locator -> id
		driver.findElement(By.cssSelector("input#mw-input-captchaWord")).sendKeys(" "); //locator: cssSelector -> tagName#id
		driver.findElement(By.xpath("//button[contains(@class, 'mw-htmlform-submit')]")).click(); //locator -> xPath using constant value
	}
}
