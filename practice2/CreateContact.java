package week2.day2.practice2;
//Goal : Code to create new Contact form

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Importing the driver files
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launching the webpage
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		//Providing Credentials
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Locate the CRM/SFA and  click it
		driver.findElement(By.xpath("//a[contains (text(),'/SFA') ]")).click();
		
		//Locate Contacts tab and click it
		driver.findElement(By.xpath("//a[text() = 'Contacts']")).click();
		
		//Click Create contact
		driver.findElement(By.xpath("//a[text() = 'Create Contact']")).click();
		
		//Input First name and last name
		driver.findElement(By.id("firstNameField")).sendKeys("Usha");
		driver.findElement(By.id("lastNameField")).sendKeys("Sathish");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Usha");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Sathish");
		
		//Input Department, Description and email boxes
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("IT Software");
		driver.findElement(By.id("createContactForm_description")).sendKeys("This is new Create contact form");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("test@gmail.com");
		
		//Select State/Province as NewYork
		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select stateOption = new Select(state);
		stateOption.selectByVisibleText("New York");
		
		//Click Create Contact
		driver.findElement(By.name("submitButton")).click();
		
		//Click Edit 
		driver.findElement(By.xpath("//a[text() = 'Edit']")).click();
		
		//Clear the Description box
		driver.findElement(By.id("updateContactForm_description")).clear();
		
		//Fill Important Note
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("This is the Note field");
		
		//Click Update
		driver.findElement(By.xpath("//input[@value = 'Update']")).click();
		
		//Verification 
		String title = driver.getTitle();
		System.out.println("The Title of the current URL is :" + title);
		
		
		
		
		
		
		
		
	}

}
