// print qunatity of columns, rows, and show the whole second row's data in all three columns
package shettyacademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CountRowsColumnsQty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// opens Chrome in maximized mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		// open browser
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// JS execution for 'scroll' in page and the table in it
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// scroll whole page
		js.executeScript("window.scrollBy(0, 400)");

		// print quantity of rows
		List<WebElement> rows = driver.findElements(By.cssSelector(".table-display tbody tr"));
		int rowsQty = rows.size();
		System.out.println(rowsQty);

		// print quantity of columns
		//List<WebElement> columns = driver.findElements(By.cssSelector(".table-display tbody tr:first-child th"));
		List<WebElement> columns = driver.findElements(By.cssSelector(".table-display tbody tr:nth-child(1) th"));
		int columnsQty = columns.size();
		System.out.println(columnsQty);

		// Display data on second row for whole 3 columns
		List<WebElement> secondRowVals = driver.findElements(By.cssSelector(".table-display tbody tr:nth-child(3)"));
		for (int i = 0; i < secondRowVals.size(); i++) {
			System.out.println(secondRowVals.get(i).getText());
		}
	}
}
