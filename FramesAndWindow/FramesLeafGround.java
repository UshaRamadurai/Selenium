package week4.day1.FramesAndWindow;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesLeafGround {

	public static void main(String[] args) throws IOException {

		// Importing the driver files
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launching the webpage
		driver.get("http://www.leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		
		//1.click me-I am inside a frame
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@src='default.html']"));
		driver.switchTo().frame(frame1);
		
		//Taking screenshot of the webelement Clickme
		WebElement clickMe1 = driver.findElement(By.xpath("//button[@id='Click']"));
		File srcFile = clickMe1.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./snaps/clickme.png");
		FileUtils.copyFile(srcFile, destFile);
		System.out.println("Snapshot taken successfully");
		
		//Click on CLickme
		clickMe1.click();
		
		driver.switchTo().defaultContent();
		
		//2.Click me-I am inside a nested frame
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@src='page.html']"));
		driver.switchTo().frame(frame2);
		driver.switchTo().frame("frame2");
		driver.findElement(By.xpath("//button[@id='Click1']")).click();
		
		driver.switchTo().defaultContent();
		
		//3.Find total number of frames.
		List<WebElement> noOfFrames = driver.findElements(By.tagName("iframe"));
		int size = noOfFrames.size();
		System.out.println("Total Frames are :"+ size);
	
		driver.close();
	}

}
