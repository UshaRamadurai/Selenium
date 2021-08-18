package week2.day2.practice2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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

		// Click on Phone
		driver.findElement(By.linkText("Phone")).click();

		//Input phone number
		driver.findElement(By.name("phoneNumber")).sendKeys("9966996699");

		// Click Find Leads
		WebElement findLeads = driver.findElement(By.xpath("//button[text() = 'Find Leads']"));
		findLeads.click();

		Thread.sleep(3000);

		// Capture Leadid of first result and click it
		WebElement searchLink = driver
				.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a"));
		String leadId = searchLink.getText();
		System.out.println("The leadId is :" + leadId);
		searchLink.click();

		// Delete the Leadid
		driver.findElement(By.className("subMenuButtonDangerous")).click();

		// Click Find Leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Search for captured id
		driver.findElement(By.name("id")).sendKeys(leadId);

		// Click Find Lead
		driver.findElement(By.xpath("//button[text() ='Find Leads']")).click();

		// Verification of delete
		boolean displayed = driver.findElement(By.xpath("//div[text() = 'No records to display']")).isDisplayed();
		if (displayed)
			System.out.println("TEst pass!! Delete lead successful");
		else
			System.out.println("TEst fail");

	}

}
