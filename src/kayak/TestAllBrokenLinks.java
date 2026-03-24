// testing all URLs in footer to see if they are broken with the status code of 400 or more than 400
package kayak;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class TestAllBrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		// TODO Auto-generated method stub
		
		// opens Chrome in maximized mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.kayak.com/");
		
		
		List <WebElement> links = driver.findElements(By.cssSelector("ul[class='qQ-X'] li a"));
		
		for (WebElement link: links) {
			// get all URLs (anchor tags) which are tied up to the links using Selenium
			String hrefString = link.getAttribute("href");
			System.out.println(hrefString);
			
			
			
			 // get the status code of each URL in the Network tab in inspect
			/*
			 * URI: Uniform Resource Identifier 
			 * URI: is a class that has URL class in it that we need it. 
			 * Why we need to access URL class -> to use the method of openConnection()		 
			 */		
			HttpURLConnection conn = (HttpURLConnection) new URI(hrefString).toURL().openConnection();
			conn.setRequestMethod("HEAD"); // set which type of http request method 
			
		
			/*
			 * check if the status code is 400 or more than 400; then the URL related to
			 * that link is broken; if it is 200, then url is working well.
			 */
			conn.connect();
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			
			if (responseCode > 400) {
				System.out.println("The link with text" + link.getText() + "is broken with status code of" + responseCode);
				Assert.assertTrue(false);
			}
		}
	}
}
