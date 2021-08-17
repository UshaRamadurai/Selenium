package week2.day2.practice1;

import java.util.concurrent.TimeUnit;

//Goal : Code to Practice buttons in Selenium

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Importing the driver files
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launching the webpage
		driver.get("http://www.leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// 1.click the button
		driver.findElement(By.id("home")).click();
		
		//back to the target page
		driver.navigate().back();

		// 2.get position
		WebElement position = driver.findElement(By.id("position"));
		Point xypoint = position.getLocation();
		int xvalue = xypoint.getX();
		int yvalue = xypoint.getY();
		System.out.println(" x point is :" + xvalue + "\n y point is :" + yvalue);

		// 3.button colour
		WebElement color = driver.findElement(By.id("color"));
		String colorname = color.getAttribute("style");
		System.out.println("Background color is :" + colorname);

		// 4.height and width
		WebElement size = driver.findElement(By.id("size"));
		int height = size.getSize().getHeight();
		int width = size.getSize().getWidth();
		System.out.println("height and width is: " + height + "," + width);

	}

}
