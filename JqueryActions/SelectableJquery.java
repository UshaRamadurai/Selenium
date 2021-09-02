package week4.day2.JqueryActions;
//Goal: Code to work with mouse actions - Select

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectableJquery {

	public static void main(String[] args) {
		
		// Importing the driver files
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Maximize the window
		driver.manage().window().maximize();
		
		// Load the URL
		driver.get("https://jqueryui.com/selectable/");
		
		//Switching to the frame
		driver.switchTo().frame(0);
		
		//Locating the from and to selectable Web elements 
		WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		
		//Selecting the web elements from item2 to item5
		Actions builder = new Actions(driver);
		builder.clickAndHold(item2).moveToElement(item5).release().perform();
		

	}

}
