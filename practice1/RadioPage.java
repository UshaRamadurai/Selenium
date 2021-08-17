package week2.day2.practice1;
//Goal : Code to Practice Radio buttons

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Importing the driver files
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launching the webpage
		driver.get("http://www.leafground.com/pages/radio.html");
		driver.manage().window().maximize();

		//1.Are you enjoying the classes?
		driver.findElement(By.id("yes")).click();
		
		//2.Find default selected radio button
		WebElement unchecked = driver.findElement(By.xpath("//label[@for = 'Unchecked']"));
		if (unchecked.isSelected())
			System.out.println("UnChecked is selected by default");
		else 
			System.out.println("Checked is selected by default");
				
		//3.Select your age group (Only if choice wasn't selected)
		int myage = 30;
		if (myage < 20) {
			driver.findElement(By.xpath("//label[contains (text(),'Select your age')]/following-sibling::input[@value = '0']")).click();
			System.out.println("My age group is 1-20 years");
		}
		else if (myage > 40) {
			driver.findElement(By.xpath("//label[contains (text(),'Select your age')]/following-sibling::input[@value = '2']")).click();
			System.out.println("My age group is above 40 years");
		}
		else
			System.out.println("My age group is 20-40 years");
	
}

}
