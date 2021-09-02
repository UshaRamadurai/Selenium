package week4.day2.Actions;
//Goal: Code to work with mouse actions - drag

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable {

	public static void main(String[] args) {
		// Importing the driver files
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Load the URL
		driver.get("http://www.leafground.com/pages/drag.html");
		
		//Locating the Web element
		WebElement drag = driver.findElement(By.id("draggable"));
		
		//Using Actions class
		Actions builder = new Actions(driver);
		
		//Dragging the element to certain position
		builder.dragAndDropBy(drag, 100,220).perform();
		
		

	}

}
