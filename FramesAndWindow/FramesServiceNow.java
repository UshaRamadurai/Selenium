package week4.day1.FramesAndWindow;
//Goal : Code to automate new incident creation in ServiceNow web site

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesServiceNow {

	public static void main(String[] args) throws InterruptedException, IOException  {
		
		// Importing the setup files for browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//launch URL:https://dev113545.service-now.com/
		driver.get("https://dev113545.service-now.com/");
		
		//Enter username and password
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("w6hnF2FRhwLC");
		
		//Click Login
		driver.findElement(By.id("sysverb_login")).click();
		
		//Search for “incident“ in Filter Navigator
		driver.findElement(By.id("filter")).sendKeys("incident");
		
		//driver.findElement(By.xpath("//div[text()='Incidents']")).click();	
		driver.findElement(By.xpath("//div[@data-id='b55b4ab0c0a80009007a9c0f03fb4da9']")).click();
						
		//Moving into the frame
		driver.switchTo().frame("gsft_main");
						
		//Click New button
		driver.findElement(By.id("sysverb_new")).click();
		
		//Read the incident number and save it a variable
		String incidentNumber = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println("The incident number is :"+ incidentNumber);
		
		//Lookup for Caller options
		driver.findElement(By.xpath("//button[@id ='lookup.incident.caller_id']/span")).click();
		
		//Move the handle to newly opened window
		Set<String> winHandleSet = driver.getWindowHandles();
		List<String> winHandleList = new ArrayList<String>(winHandleSet);
		driver.switchTo().window(winHandleList.get(1));
		
		//Select a value for Caller
		driver.findElement(By.xpath("//td[@class='list_decoration_cell col-small col-center ']/following-sibling::td/a")).click();
		
		Thread.sleep(5000);
		driver.switchTo().window(winHandleList.get(0));
		
		driver.switchTo().frame(0);
				
		//Enter value for short_description
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("New incident for client");
								
		//Click on Submit button
		driver.findElement(By.id("sysverb_insert")).click();
		
		//Search the same incident number in the next search screen 
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentNumber+ "\n");
		
		//Verify is the incident created successful 
		String text1 = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		if (text1.contains(incidentNumber)) {
			System.out.println("Incident Created Successful!!");
		}
		else
			System.out.println("No match of incident number");
		
		//Take snapshot of the created incident
		File Scr = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/incident.png");
		FileUtils.copyFile(Scr, dst);
		
	}

}
