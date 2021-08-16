package week2.day1;
//Goal : Code to sign up for new SalesForce account

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SalesForceNewAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Importing the driver files and launching the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// launching the url page
		driver.get("https://login.salesforce.com/?locale=in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Click Try for Free
		driver.findElement(By.id("signup_link")).click();

		// Providing input to First Name, Last name and email element
		driver.findElement(By.name("UserFirstName")).sendKeys("Adhiya");
		driver.findElement(By.name("UserLastName")).sendKeys("Tatwamashi");
		driver.findElement(By.name("UserEmail")).sendKeys("ushasathish21@gmail.com");

		// Selecting from Drop downs for Job Title
		WebElement webJobTitle = driver.findElement(By.name("UserTitle"));
		Select jobTitleDropDwn = new Select(webJobTitle);
		jobTitleDropDwn.selectByValue("IT_Manager_AP");

		//Input for Company
		driver.findElement(By.name("CompanyName")).sendKeys("Google");

		// Selecting from Drop downs for Employees 
		WebElement webEmployees = driver.findElement(By.name("CompanyEmployees"));
		Select empDropDwn = new Select(webEmployees);
		empDropDwn.selectByValue("1600");

		//Input for Phone number
		driver.findElement(By.name("UserPhone")).sendKeys("9781736142");

		//Check box click
		driver.findElement(By.className("checkbox-ui")).click();

		//Click Submit button
		driver.findElement(By.name("start my free trial")).click();

		//Validating the Url for verification
		String currentUrl = driver.getCurrentUrl();
		String targetUrl = "https://ap24.lightning.force.com/one/one.app";

		// Verification and Printing the result
		if (targetUrl.equals(currentUrl))
			System.out.println("Test Pass!! Account created. In Home page");
		else
			System.out.println("Test Fail!! Account not created");

	}

}
