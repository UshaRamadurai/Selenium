package week4.day2.Actions;
//Goal: Code to work with mouse actions - Select
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		
		// Importing the driver files
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Load the URL
		driver.get("http://www.leafground.com/pages/selectable.html");
		
		//Locating the from and to selectable Web elements 
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item6 = driver.findElement(By.xpath("//li[text()='Item 6']"));
		
		//Selecting the web elements from item1 to item6
		Actions builder = new Actions(driver);
		builder.clickAndHold(item1).moveToElement(item6).release().perform();

	}

}
