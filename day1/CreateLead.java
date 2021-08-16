package week2.day1;
//Goal : Code to locate web elements and drop downs 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Locating the user name web element and type "demosalesmanager"
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		// Locating the password and type "crmsfa"
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Locating the login button and click it
		driver.findElement(By.className("decorativeSubmit")).click();
		
		// CLick on the CRM/SFA link
				driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click Leads tab		
		driver.findElement(By.linkText("Leads")).click();
		
		//Click Create Lead Tab
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Enter Company name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Adhi Company Ltd");
		
		//Enter First name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Usha");
		
		//Enter Last name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Sathish");
		
		//Working on drop downs
		//Select Source
		WebElement drop1 = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dropdwn1 = new Select(drop1);
		dropdwn1.selectByIndex(3);
		
		//Select Industry
		WebElement drop2 = driver.findElement(By.name("industryEnumId"));
		Select dropdwn2 = new Select(drop2);
		dropdwn2.selectByValue("IND_DISTRIBUTION");
		
		//Select Ownership
		WebElement drop3 = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select dropdwn3 = new Select(drop3);
		dropdwn3.selectByVisibleText("Corporation");
		
		//Clear the Country code and input new value
		WebElement countrycode = driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode"));
		countrycode.clear();
		countrycode.sendKeys("6");		
		
		//Submit the form
		driver.findElement(By.name("submitButton")).click();
		

	}

}
