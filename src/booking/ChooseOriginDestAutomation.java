
/*This class is kinda an example of 'Auto Suggestive Dropdown', that we always type in exactly 3 letters. So the suggestions that we receive in options are fixed.
But we know that by typing 2 letters instead of 3, we will have a different list of options suggested for desired letters*/

package booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChooseOriginDestAutomation {

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

		// click on 'Flights' on top menu
		driver.findElement(By.id("flights")).click();

		
		
		
		// click on 'leaving from'
		driver.findElement(By.xpath("//div[@class='OriginDestinationHorizontal-module__wrapper___WgqqT ']/button[1]")).click();
		// type in 'JFK' as origin in input
		driver.findElement(By.xpath("//input[@class='AutoComplete-module__textInput___Qh3I- ']")).sendKeys("JFK");
		Thread.sleep(1000);
		// select 'JFK' for origin
		driver.findElement(By.xpath("//ul[@id='flights-searchbox_suggestions']/li[2]")).click();
		
		
		
		
		//click on 'going to'
		driver.findElement(By.xpath("//div[@class='OriginDestinationHorizontal-module__wrapper___WgqqT ']/button[3]")).click();
		// type in 'PER' as destination in input
	    driver.findElement(By.xpath("//input[@class='AutoComplete-module__textInput___Qh3I- ']")).sendKeys("PER");
	    Thread.sleep(1000);
		// select 'PER' as destination
	    //driver.findElement(By.xpath("//ul[@id='flights-searchbox_suggestions']/li[1]")).click();
	    
	    //Alternative way to select 'PER' as destination: using parent-child relationship xPath
	    driver.findElement(By.xpath("//div[@class='AutoComplete-module__wrapper___d3PlU'] //span[@class='List-module__content___48Y6B']")).click();

	}

}
