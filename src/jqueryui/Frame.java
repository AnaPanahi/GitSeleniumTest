/*Drag-Drop using 'Actions' class in a 'Frame'*/
package jqueryui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Frame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// opens Chrome in maximized mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		// Open brower
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://jqueryui.com/droppable/");

		// to know how many 'iframe' do we have
		// System.out.println(driver.findElement(By.tagName("iframe")).size());

		// switch from web object to frame 
		// since there is only 1 iframe, we can use index to switch to the iframe; like driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));

		// define action class, and then define 'DragAndDrop' which take 2 webElements as "source" and 'target'
		Actions action = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		action.dragAndDrop(source, target).build().perform();
		
		// coming back to the default content out of frame 
		driver.switchTo().defaultContent();
	}
}
