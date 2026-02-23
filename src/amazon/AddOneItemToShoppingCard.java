/*Implicit Wait, Explicit Wait (using WebDriverWait), Thread.Sleep()*/
package amazon;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddOneItemToShoppingCard {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// opens Chrome in maximized mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		// Open brower
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.com/");

		// add Implicit wait
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// add Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// call Explicit Wait for the search box to be visible
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='nav-search-field ']")));

		// Thread.sleep(1000);

		// type in 'shoe' on search box
		driver.findElement(By.xpath("//div[@class='nav-search-field ']")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("shoe");

		// click on search button
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		// Thread.sleep(1000);

		addItems(driver, wait);
	}

	public static void addItems(WebDriver driver, WebDriverWait wait) {

		By itemLocator = By.cssSelector("h2[class='a-size-base-plus a-spacing-none a-color-base a-text-normal'] span");

		int count = 0;

		for (int i = 0; count < 3; i++) {

			// re-load elements freshly for every loop
			// call Explicit Wait for all the searched items to be fully loaded
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(itemLocator));
			List<WebElement> items = driver.findElements(
					By.cssSelector("h2[class='a-size-base-plus a-spacing-none a-color-base a-text-normal'] span"));

			String itemTitle = items.get(i).getText();

			if (itemTitle.contains("Sneaker")) {
				items.get(i).click();

				wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button"))).click();
				count++;

				if (count == 3) {
					System.out.println("3 items are already added!");
					break;
				}

				driver.navigate().back();
				driver.navigate().back();
			}
		}
	}
}
