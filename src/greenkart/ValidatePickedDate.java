package greenkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ValidatePickedDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String year = "2028";
		String month = "6";
		String day = "20";

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
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();

		// select desired day as provided above day in String
		driver.findElement(By.xpath("//abbr[text()='" + day + "']")).click();
	}
}
