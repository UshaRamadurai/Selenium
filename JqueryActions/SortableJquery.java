package week4.day2.JqueryActions;
//Goal: Code to work with mouse actions - sort

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortableJquery {

	public static void main(String[] args) {
		
		// Importing the driver files
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Maximize the window
		driver.manage().window().maximize();
		
		// Load the URL
		driver.get("https://jqueryui.com/sortable/");
		
		//Switching to the frame
		driver.switchTo().frame(0);
		
		//Locating the Web elements
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement item6 = driver.findElement(By.xpath("//li[text()='Item 6']"));
		
		//Getting X and Y position value of item3
		Point loc3 = item3.getLocation();
		int x3 = loc3.getX();
		int y3 = loc3.getY();
		
		//Getting X and Y position value of item6
		Point loc6 = item6.getLocation();
		int x6 = loc6.getX();
		int y6 = loc6.getY();
		
		//Moving item1 to Item3 position and item2 to Item6 position
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(item1, x3, y3).perform();
		builder.dragAndDropBy(item2, x6, y6).perform();
	}

}
