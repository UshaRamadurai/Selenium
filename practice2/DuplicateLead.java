package week2.day2.practice2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Input Username and password
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click login
		driver.findElement(By.className("decorativeSubmit")).click();

		// CLick CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click Leads tab
		driver.findElement(By.linkText("Leads")).click();

		// Click Find Leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Click Email tab
		driver.findElement(By.xpath("//span[text() = 'Email']")).click();

		// Input email id
		driver.findElement(By.name("emailAddress")).sendKeys("test@gmail.com");

		// Click Find Leads
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();

		Thread.sleep(3000);
		// Capture and Click first resulting lead name
		WebElement firstLead = driver
				.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a"));
		String firstText = firstLead.getText();
		firstLead.click();

		// Click Duplicate Lead tab
		driver.findElement(By.xpath("(//div[@class='frameSectionExtra'])[2]/a[text() = 'Duplicate Lead']")).click();

		// verification of Duplicate Lead page
		if (driver.getTitle().equals("Duplicate Lead | opentaps CRM"))
			System.out.println("In Duplicate Lead page");

		// Click Create Lead
		driver.findElement(By.name("submitButton")).click();

		//Capture the duplicated name
		String dupText = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		
		//Verification of duplicated one
		if (firstText.equals(dupText))
			System.out.println("Test Pass !! Duplicate created");
		else
			System.out.println("Test Fail !! Duplicate not created");

		driver.close();
	}

}
