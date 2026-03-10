package kayak;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LimitScope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// opens Chrome in maximized mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.kayak.com/");
		
		//print quantity or count of links (a tage)
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		/*
		 * print quantity or count of links (a tage) in 'footer' only 
		 * First select entire footer section
		 */
		WebElement footerDriver = driver.findElement(By.tagName("footer"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
	}
}
