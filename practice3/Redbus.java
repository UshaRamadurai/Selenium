package week2.day2.practice3;
//Goal : Printing the search result in Redbus page

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Redbus {

	public static void main(String[] args) throws InterruptedException {

		// Importing the driver files
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// launching the webpage
		driver.get("http://www.redbus.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Enter from location
		WebElement src = driver.findElement(By.id("src"));
		src.sendKeys("CMBT, Chennai");
		Thread.sleep(1000);
		src.sendKeys(Keys.TAB);
				
		// Enter to location
		WebElement dest = driver.findElement(By.id("dest"));
		dest.sendKeys("Bengaluru");
		Thread.sleep(1000);
		dest.sendKeys(Keys.TAB);

		// Select Date
		driver.findElement(By.id("onward_cal")).click();
		
		//click next button in right corner of calendar
		driver.findElement(By.xpath("//td[@class='next']/button")).click();
		
		//click the date
		driver.findElement(By.xpath("//td[text()='9']")).click();

		// Click Search Buses
		driver.findElement(By.xpath("//button[@class='fl button']")).click();
		
		Thread.sleep(5000);
		
		// Close the popup using X button at the right corner
		driver.findElement(By.xpath("//div[@class='close']/i")).click();

		// Print the number of search result found
		String noOfBus = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("The number of  total search result is :" + noOfBus);
		
		// select 6am to 12pm only 
		driver.findElement(By.xpath("(//ul[@class='dept-time dt-time-filter']//label)[3]")).click();
		
		// Print the number of search result found
		String noOfMorgBus = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("The number of  6am-12pm buses are :" + noOfMorgBus);
		
		// Deselect 6am to 12pm only 
		driver.findElement(By.xpath("(//ul[@class='dept-time dt-time-filter']//label)[3]")).click();
		
		driver.close();

		
	}

}
