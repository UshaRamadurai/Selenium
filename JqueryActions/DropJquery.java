package week4.day2.JqueryActions;
//Goal: Code to work with mouse actions - drop

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropJquery {

	public static void main(String[] args) {
	
		// Importing the driver files
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Load the URL
		driver.get("https://jqueryui.com/droppable/");
		
		//Switching to the frame
		driver.switchTo().frame(0);
		
		//Locating the Web elements
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));

		//Drag and drop of web elements using Actions class
		Actions builder = new Actions(driver);
		builder.dragAndDrop(drag, drop).perform();
		

	}

}
