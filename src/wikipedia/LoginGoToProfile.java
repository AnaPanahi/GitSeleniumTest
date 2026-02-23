package wikipedia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginGoToProfile {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String name = "AnaSeleniumTest";
		// Open brower
		WebDriver driver = new ChromeDriver();

		driver.get("https://en.wikipedia.org/wiki/Special:UserLogin");

		driver.findElement(By.name("wpName")).sendKeys(name); // locator: name
		driver.findElement(By.id("wpPassword1")).sendKeys("12345Sel$$$"); // locator: name

		driver.findElement(By.cssSelector("button[tabindex='5']")).click(); // locator: cssSelector -> TagName[attribute='value']
		
		
		Thread.sleep(1000);
		
		
		//Println & Assertions -> using only assertion is professional and enough
		System.out.println(driver.findElement(By.cssSelector("div#mp-welcomecount div:nth-child(1) div[class*='mw-heading1'] h1")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("div#mp-welcomecount div:nth-child(1) div[class*='mw-heading1'] h1")).getText(), "Welcome to Wikipedia");
		
		
		//Println & Assertions
		System.out.println(driver.findElement(By.xpath("//a[@class='new']/span[text()='AnaSeleniumTest']")).getText()); //Since we have more than 1 span tag, we cannot use driver.findElement(By.tagName("span")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//a[@class='new']/span[text()='AnaSeleniumTest']")).getText(), name);
		
		
		driver.findElement(By.xpath("//span[text()='AnaSeleniumTest']")).click();
		//driver.findElement(By.xpath("//*[text()='AnaSeleniumTest']")).click(); // find any element with this text
		
		//close the browser
//		driver.close();
	}
}
