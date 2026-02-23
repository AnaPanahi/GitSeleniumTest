
/*'Auto gggestive Dropdown' example*/

package booking;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChooseCruiseDestination {

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

		// click on 'Cruises' on top menu
		driver.findElement(By.id("cruises")).click();

		// type in 'aus' to search for cruise destination
		driver.findElement(By.id("autoComplete")).sendKeys("aus");

		// retrieve the list of suggested options based on typed letters
		List<WebElement> suggestedOptions = driver.findElements(By.cssSelector("li.autoComplete_result span"));

		
		for (WebElement suggestedOption : suggestedOptions) {
			
			//returns the first option that has "Australia" in it
			if (suggestedOption.getText().contains("Australia")) {
				suggestedOption.click();
				break;
			}
		}
	}
}
