/*Checkbox*/
package booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CheckDriverAge {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// opens Chrome in maximized mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.booking.com/?chal_t=1770225535257&force_referer=https%3A%2F%2Fchatgpt.com%2F");

		Thread.sleep(1000); // wait for 1 seconds

		// close pop-up page
		driver.findElement(By.xpath("//button[contains(@class,'daf5d4cb1c')]")).click();

		// click on 'Car rental' on top menu
		driver.findElement(By.id("cars")).click();

		/*
		 * check if the checkbos was already selected in initial stage. Using assertions to validate is more professional.
		 */
		// System.out.println(driver.findElement(By.name("drivers-age")).isSelected());
		Assert.assertTrue(driver.findElement(By.name("drivers-age")).isSelected());
		

		
		// check the driver's age checkbox
		driver.findElement(By.xpath("//div[contains(@class, 'LPCM_6e9e6a44')]/div[2]/input")).click();

		
		
		/*
		 * check if the checkbox is selected now, after clicking on it. Using assertions to validate is more professional.
		 */
		//System.out.println(driver.findElement(By.name("drivers-age")).isSelected());
		Assert.assertFalse(driver.findElement(By.name("drivers-age")).isSelected());	
	}
}
