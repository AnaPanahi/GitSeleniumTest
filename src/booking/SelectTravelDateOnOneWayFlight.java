/*Calendar -> for selecting today only*/
package booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SelectTravelDateOnOneWayFlight {

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

		// Choose one-way trip
		driver.findElement(By.cssSelector("div[data-ui-name='search_type_oneway'] input")).click();

		// open calendar (Travel dates)
		driver.findElement(By.cssSelector("button[data-ui-name='button_date_segment_0']")).click();

		// choose 'Travel date' as current date on calendar
		driver.findElement(By.cssSelector("span[aria-current='date']")).click();

	}

}
