package week2.day2.practice2;
//Goal : Code to edit a record

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {

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

		// Enter First name
		driver.findElement(By.xpath("(//input[@name ='firstName'])[3]")).sendKeys("test");

		// Click Find Leads
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		Thread.sleep(3000);

		// Click on the First resulting lead
		driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')])[1]/a")).click();

		// verification of Duplicate Lead page
		if (driver.getTitle().equals("Find Leads | opentaps CRM"))
			System.out.println("In Find Leads page");

		// Click Edit
		driver.findElement(By.xpath("//a[contains (@href, 'updateLeadForm?partyId')]")).click();

		// Edit Company name
		WebElement coName = driver.findElement(By.id("updateLeadForm_companyName"));
		coName.clear();
		coName.sendKeys("New Company");

		// Click Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();

		// Verification of update
		boolean displayed = driver.findElement(By.xpath("//span[contains(text(),'New Company')]")).isDisplayed();
		if (displayed)
			System.out.println("TEst pass!! Updation successful");
		else
			System.out.println("TEst fail");

	}

}
