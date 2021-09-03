package week4.day1.FramesAndWindow;
//Goal : Code to work with Frames in chercher.Tech website

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesCherCherTech {

	public static void main(String[] args) {
		
		// Importing the setup files for browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();
		
		//Launching the Url of cherCherTech
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		//Input the Topic
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Working With Frames");
		
		//Mark the checkbox
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@id='a']")).click();
		
		//Returning to main content
		driver.switchTo().defaultContent();
		
		//Select from Dropdown
		driver.switchTo().frame("frame2");
		WebElement dropDown = driver.findElement(By.id("animals"));
		Select animals = new Select(dropDown);
		animals.selectByIndex(2);
		

	}

}
