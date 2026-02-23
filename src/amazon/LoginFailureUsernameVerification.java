package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginFailureUsernameVerification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Open brower
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com/gp/sign-in.html");


		driver.findElement(By.id("ap_email_login")).sendKeys("invalidgmailaddress@gmail.com"); // locator -> cssSelector
		driver.findElement(By.xpath("//input[@class='a-button-input']")).click(); // locator: xPath -> //TagName[@attribute='value']
		
		String email = verifyEmailAddress(driver);
		Assert.assertEquals(driver.findElement(By.className("claim-value")).getText() , email); // locator -> cssSelector
		
	}
	
	public static String verifyEmailAddress(WebDriver driver) {
		String emailAddress = driver.findElement(By.cssSelector("p.a-spacing-top-medium span")).getText();
		return emailAddress;
	}
}
