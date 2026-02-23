package booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class E2EFlightExploreTest {

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

		// choose one-way trip
		driver.findElement(By.cssSelector("div[data-ui-name='search_type_oneway'] input")).click();

		// click on 'leaving from'
		driver.findElement(By.xpath("//div[@class='OriginDestinationHorizontal-module__wrapper___WgqqT ']/button[1]")).click();
		// type in 'JFK' as origin in input
		driver.findElement(By.xpath("//input[@class='AutoComplete-module__textInput___Qh3I- ']")).sendKeys("JFK");
		Thread.sleep(1000);
		// select 'JFK' for origin
		driver.findElement(By.xpath("//ul[@id='flights-searchbox_suggestions']/li[2]")).click();

		
		// click on 'going to'
		driver.findElement(By.xpath("//div[@class='OriginDestinationHorizontal-module__wrapper___WgqqT ']/button[3]")).click();
		// type in 'PER' as destination in input
		driver.findElement(By.xpath("//input[@class='AutoComplete-module__textInput___Qh3I- ']")).sendKeys("PER");
		Thread.sleep(1000);
		// select 'PER' as destination
		driver.findElement(By.xpath("//ul[@id='flights-searchbox_suggestions']/li[1]")).click();

		// check to make sure 'Direct flights only' is not selected
		boolean selected = driver.findElement(By.cssSelector("span[class='InputCheckbox-module__field___V+2ZW']"))
				.isSelected();
		if (!selected) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}

		// open calendar (Travel dates)
		driver.findElement(By.cssSelector("button[data-ui-name='button_date_segment_0']")).click();

		Thread.sleep(1000);

		// choose 'travel date' as current date on calendar
		driver.findElement(By.cssSelector("span[aria-current='date']")).click();

		// click on 'Travelers' dropdown
		driver.findElement(By.cssSelector("button[data-ui-name='button_occupancy']")).click();
		
		Thread.sleep(1000);

		// add 4 adults (click on + btn)
		int i = 1;
		while (i < 5) {
			driver.findElement(By.cssSelector("button[data-ui-name='button_occupancy_adults_plus']")).click();
			i++;
		}

		// click on 'Done' btn
		driver.findElement(By.cssSelector("button[data-ui-name='button_occupancy_action_bar_done']")).click();

		// click on 'Explore' button
		driver.findElement(By.xpath("//button[@data-ui-name='button_search_submit']")).click();
	}
}
