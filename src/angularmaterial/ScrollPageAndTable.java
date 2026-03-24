// Scroll the whole page and then the table inside the page
package angularmaterial;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ScrollPageAndTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// opens Chrome in maximized mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		// open browser
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://material.angular.dev/components/datepicker/overview");

		// click on accept cookies
		driver.findElement(By.xpath("//button[span[text()='Okay, got it']]")).click();

		// JS execution for 'scroll' in page and the table in it
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// scroll whole page
		js.executeScript("window.scrollBy(0, 2500)");

		// scroll right hand side table as a container
		js.executeScript("document.querySelector('.docs-component-view-text-content').scrollTop=5000");
	}
}