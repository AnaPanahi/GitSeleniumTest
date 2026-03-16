// validate expected and actual dates on calendar
package greenkart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class ValidatePickedDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String year = "2028";
		String month = "6";
		String day = "20";
		String[] expectedDateList = { month, day, year };

		// opens Chrome in maximized mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// click on datepicker to open it
		driver.findElement(By.cssSelector(".react-date-picker__calendar-button")).click();

		// click on top button on datePicker to see months
		driver.findElement(By.className("react-calendar__navigation__label")).click();

		// click again on top button on datePicker to see years
		driver.findElement(By.className("react-calendar__navigation__label")).click();

		// select desired year as provided above year in String
		driver.findElement(By.xpath("//button[text()='" + year + "']")).click();

		// select desired month as provided above month in String
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"))
				.get(Integer.parseInt(month) - 1).click();

		// select desired day as provided above day in String
		driver.findElement(By.xpath("//abbr[text()='" + day + "']")).click();

		// validate the selected date
		List<WebElement> actualDateList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

		// now, iterate through the actual list above
		for (int i = 0; i < actualDateList.size(); i++) {
			// compae two strings of actual and expected dates
			Assert.assertEquals(actualDateList.get(i).getAttribute("value"), expectedDateList[i]);
		}
	}
}
