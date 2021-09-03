package week4.day1.FramesAndWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WinHandling {

	public static void main(String[] args) throws InterruptedException {

		// Importing the setup files for browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");

		// Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click on contacts Button
		driver.findElement(By.xpath("//a[text() = 'Contacts']")).click();

		// Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		// Click on Widget of From Contact
		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();

		// Move the handle to newly opened window
		Set<String> winHandleSet = driver.getWindowHandles();
		List<String> winHandleList = new ArrayList<String>(winHandleSet);
		driver.switchTo().window(winHandleList.get(1));

		// Click on First Resulting Contact
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

		driver.switchTo().window(winHandleList.get(0));
		Thread.sleep(5000);
		
		// Click on Widget of To Contact
		 driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdTo']/following-sibling::a")).click();
		 
		Set<String> winHandleSet1 = driver.getWindowHandles();
		List<String> winHandleList1 = new ArrayList<String>(winHandleSet1);
		driver.switchTo().window(winHandleList1.get(1));

		Thread.sleep(3000);
		
		// Click on Second Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		
		driver.switchTo().window(winHandleList1.get(0));

		// Click on Merge button
		driver.findElement(By.className("buttonDangerous")).click();

		// Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

		// Verify the title of the page
		String title = driver.getTitle();
		if (title.equals("View Contact | opentaps CRM"))
			System.out.println("Test pass!!Merge contact successful");
		else
			System.out.println("Test fail!! ");
		
		//Close the window
		driver.close();
	}

}
