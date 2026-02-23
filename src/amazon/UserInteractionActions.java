/*Mouseover*/
package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class UserInteractionActions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// opens Chrome in maximized mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		//open browser
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.com/Smart-Home/b/?ie=UTF8&node=6563140011&ref_=nav_cs_smart_home");
		
		//create actions class with an object of action
		Actions action = new Actions(driver);
		
		/*
		 * move to SINGLE element: moveover mouse to 'Hello, sign in, Account and Lists' and the right click on it; 
		 * make sure to 'perform build' of the entire action at the end
		 */
		WebElement singInMouseOver = driver.findElement(By.cssSelector("div[id='nav-link-accountList'] a"));
		action.moveToElement(singInMouseOver).contextClick().build().perform();
		
		/*
		 * move to COMPOSITE elements: Write 'shoe' in capital letter in the search box and the select shoe word by double-clicking on it;
		 * By holding 'shift' key down and the typing in at the same time -> you will type capital letter words
		 */
		WebElement searcBoxTypeIn = driver.findElement(By.id("twotabsearchtextbox"));
		action.moveToElement(searcBoxTypeIn).click().keyDown(Keys.SHIFT).sendKeys("shoe").doubleClick().build().perform();
		
		
		

	}
}
