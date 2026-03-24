// setup browser with maximize window and delete all cookies when  opening the browser.
package angularmaterial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserSetup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// open browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://material.angular.dev/components/datepicker/overview");
	}
}
