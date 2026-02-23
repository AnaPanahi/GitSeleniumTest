package booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChangeAdultQtyAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// open Chrome in maximized mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.booking.com/?chal_t=1770225535257&force_referer=https%3A%2F%2Fchatgpt.com%2F");

		Thread.sleep(1000); // wait for 1 seconds

		// close pop-up page
		driver.findElement(By.xpath("//button[contains(@class,'daf5d4cb1c')]")).click();

		// check for initial quantity of adults
		System.out.println(driver.findElement(By.xpath("//button[contains(@class, 'b3d1de1c28')]/span[1]")).getText());

		// click on 'adults-children-room' dropdown
		driver.findElement(By.xpath("//button[contains(@class, 'b3d1de1c28')]")).click();

		// add 4 adults (click on + btn)
		int i = 1;
		while (i < 5) {
			driver.findElement(By.xpath("//div[@class='a9669463b9']/div[1]/div[2]/button[2]")).click();
			i++;
		}

		// click on 'Done' btn
		driver.findElement(By.xpath("//div[contains(@class, 'aad29c76fe')]/button")).click();

		// check for updated quantity of adults
		System.out.println(driver.findElement(By.xpath("//button[contains(@class, 'b3d1de1c28')]/span[1]")).getText());

	}
}
