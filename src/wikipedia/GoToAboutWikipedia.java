package wikipedia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoToAboutWikipedia {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		
		
		// opens Chrome in maximized mode from start point, in this case you can see left side menu to click on 'About Wikipedia'
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");   
        
        
		// Open brower
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://en.wikipedia.org/wiki/Special:UserLogin");

		driver.findElement(By.name("wpName")).sendKeys("AnaSeleniumTest"); // locator: name
		driver.findElement(By.id("wpPassword1")).sendKeys("12345Sel$$$"); // locator: name

		driver.findElement(By.cssSelector("button[tabindex='5']")).click(); // locator: cssSelector -> TagName[attribute='value']
		
		
		Thread.sleep(1000);
		
		
		/*
		 Parent-to-child & Sibling-to-sibling traverses by xPath 
		 to click on 'About Wikipedia' from left side menu by finding 'Random article'
		 */
		//driver.findElement(By.xpath("//div[@id='vector-main-menu']/div[2]/div[2]/ul/li[4]/following-sibling::li[1]/a/span")).click();
		
		
		/*
		 ALTERNATIVE WAY:
		 Parent-to-child traverse & child-to-parent back traverse by xPath 
		 to click on 'About Wikipedia' from left side menu by finding 'Random article'
		 */
		driver.findElement(By.xpath("//div[@id='vector-main-menu']/div[2]/div[2]/ul/li[4]/parent::ul/li[@id='n-aboutsite']/a/span")).click();

	}

}
