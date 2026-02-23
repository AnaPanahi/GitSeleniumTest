package spicejet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class ValidateReturnDateEnabledStatus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		// opens Chrome in maximized mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.spicejet.com/");
		
		//choose round trip
		driver.findElement(By.xpath("//div[@data-testid='round-trip-radio-button']/div[1]")).click();
		
		
		/*
		 * check if 'Return date' is enabled or not; most of the times below code using
		 * isEnables() method does not work. Best way is to use getDomAttribute() method.
		 * If you switch between on-way and round-way, you can see that in style attribute, 
		 * the only value that will be appeared and disappread is opacity.
		 * Then use 'style' attribute in getDomAttribute() method.
		 */
		//System.out.println(driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-19h5ruw r-136ojw6']/div[1]/div[1]/div[2]")).isEnabled());
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-19h5ruw r-136ojw6']/div[1]/div[1]/div[2]/div[1]")).getDomAttribute("style");
		if(driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-19h5ruw r-136ojw6']/div[1]/div[1]/div[2]/div[1]")).getDomAttribute("style").contains("1")) {
			
			System.out.println("This field is enabled!");
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}

	}

}
