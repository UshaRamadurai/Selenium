package week2.day1;
//Goal: Code to Login a website with username and password 

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Importing the setup files for browser
		WebDriverManager.chromedriver().setup();

		// Launching the web browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("http://leaftaps.com/opentaps");

		// Maximizing the window
		driver.manage().window().maximize();

		// wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Locating the user name web element and type "demosalesmanager"
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		// Locating the password and type "crmsfa"
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Locating the login button and click it
		driver.findElement(By.className("decorativeSubmit")).click();

		// CLick on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// verifying the landing page is correct or not
		String orgTitle = "My Home | opentaps CRM";
		String webTitle = driver.getTitle();

		if (orgTitle.equals(webTitle))
			System.out.println("Test pass !! In Home page");
		else
			System.out.println("Tetst Fail !! Login unsuccessful");

	}

}
