package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JSWindowAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// open Chrome in maximized mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/javascript_alerts?utm_source=chatgpt.com");

		// click on 'Click for JS Alert' button
		driver.findElement(By.xpath("//div[@class='example']/ul/li[1]/button")).click();

		// print text on alert
		System.out.println(driver.switchTo().alert().getText());

		// click on 'OK' btn on alert
		driver.switchTo().alert().accept();

		// click on 'Click on JS Confirm' button
		driver.findElement(By.xpath("//div[@class='example']/ul/li[2]/button")).click();

		// print text on alert
		System.out.println(driver.switchTo().alert().getText());

		// click on 'Cancel' btn on alert
		driver.switchTo().alert().dismiss();
	}
}
