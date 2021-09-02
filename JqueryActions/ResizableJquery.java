package week4.day2.JqueryActions;
//Goal: Code to work with mouse actions - resize

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResizableJquery {

	public static void main(String[] args) {
		
		// Importing the driver files
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Load the URL
		driver.get("https://jqueryui.com/resizable/");

		//Switching to the frame
		driver.switchTo().frame(0);
		
		//Locating the Web element
		WebElement tip = driver.findElement(By.xpath("(//div[@id='resizable']/div)[3]"));
		
		//Dragging the right corner tip of the web element to some position
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(tip, 10, 80).perform();
		
		

	}

}
