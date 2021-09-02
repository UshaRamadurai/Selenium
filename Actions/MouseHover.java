package week4.day2.Actions;
//Goal: Code to work with mouse actions - Mouse Hover

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) {

		// Importing the driver files
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Load the URL
		driver.get("http://www.leafground.com/pages/mouseOver.html");

		//Locating the Web element
		WebElement mouse = driver.findElement(By.className("btnMouse"));

		//Mouse hover on the web element
		Actions builder = new Actions(driver);
		builder.moveToElement(mouse).perform();

		//Printing the following links of the web element
		List<WebElement> links = driver.findElements(By.xpath("//a[@class='btnMouse']/following::a"));
		for (WebElement eachlink : links) {
			String text = eachlink.getText();
			System.out.println(text);
		}
		//Clicking on the first course
		links.get(0).click();

		//Handling the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

}
