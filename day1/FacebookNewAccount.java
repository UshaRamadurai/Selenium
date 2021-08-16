package week2.day1;
//Goal : Code to create new Facebook account

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookNewAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Importing the driver files and launching the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// launching the url page
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Click Create New Account
		driver.findElement(By.xpath("//a[contains (text(), 'New Account')]")).click();

		// Providing input to First Name and Surname element
		driver.findElement(By.name("firstname")).sendKeys("Adhiya");
		driver.findElement(By.name("lastname")).sendKeys("Tatwamashi");

		// Providing input to email address and Password
		driver.findElement(By.name("reg_email__")).sendKeys("UshaSathish21@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("UshaSathish21@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("My1stFBAccount");

		// Selecting from Drop downs for Birth date
		WebElement webBirthDay = driver.findElement(By.name("birthday_day"));
		Select birthDayDropDwn = new Select(webBirthDay);
		birthDayDropDwn.selectByValue("15");

		WebElement webBirthMonth = driver.findElement(By.name("birthday_month"));
		Select birthMonthDropDwn = new Select(webBirthMonth);
		birthMonthDropDwn.selectByValue("10");

		WebElement webBirthYear = driver.findElement(By.name("birthday_year"));
		Select birthYearDropDwn = new Select(webBirthYear);
		birthYearDropDwn.selectByValue("2015");

		// Selecting the Gender
		driver.findElement(By.xpath("//label[ text()='Male']")).click();

		// Click Sign Up
		driver.findElement(By.name("websubmit")).click();

		//Validating the Url for verification
		String currentUrl = driver.getCurrentUrl();
		String targetUrl = "https://en-gb.facebook.com/";
		
		//Verification and Printing the result
		if (targetUrl.equals(currentUrl))
			System.out.println("Test Pass!! Account created");
		else
			System.out.println("Test Fail!! Account not created");

	}

}
