package wikipedia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		//maximize browser
		driver.manage().window().maximize();
		
		driver.get("https://en.wikipedia.org/wiki/Special:UserLogin");
		
		//go to another webpage from your current window
		driver.navigate().to("https://www.google.com/");
		
		//navigate back to the Wikipedia page
		driver.navigate().back();
		
		//navigate forward again to Google page
		driver.navigate().forward();

	}

}
