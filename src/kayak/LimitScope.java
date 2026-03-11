package kayak;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LimitScope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// opens Chrome in maximized mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.kayak.com/");

		// 1.print quantity or count of links (a tage)
		System.out.println(driver.findElements(By.tagName("a")).size());

		/*
		 * 2.print quantity or count of links (a tage) in 'footer' only First select
		 * footer section by limiting webDriver scope from entire webpage to footer
		 */
		WebElement footerDriver = driver.findElement(By.tagName("footer"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());

		// 3.print count of links or anchor tags in the first column of footer section
		WebElement columnDriver = footerDriver.findElement(By.xpath("//div[@class='w6G7-links']/nav[1]/ul"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());

		// 4.click on each link on the firts column of footer and check if pages are
		// opened by opening the links in separate tabs
		for (int i = 0; i < columnDriver.findElements(By.tagName("a")).size(); i++) {

			// create the keyboard shortcut "Ctrl + Enter" to open a link in a new tab
			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
		}

		// 5.switch to each tab and print the title
		Set<String> openTabQty = driver.getWindowHandles();
		Iterator<String> it = openTabQty.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}
}
