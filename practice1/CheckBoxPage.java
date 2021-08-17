package week2.day2.practice1;
//Goal : Code to Practice the Check Box element

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxPage {

	public static void main(String[] args) {

		// Importing the driver files
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launching the webpage
		driver.get("http://www.leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();

		// 1.Select the languages that you know?
		// Selecting Java and VB
		driver.findElement(By.xpath("(//section[@class = 'innerblock']//input)[1]")).click();
		driver.findElement(By.xpath("(//section[@class = 'innerblock']//input)[2]")).click();

		// 2.Confirm Selenium is checked
		WebElement checked = driver.findElement(By.xpath("(//section[@class = 'innerblock']//input)[6]"));
		if (checked.isSelected())
			System.out.println("Selenium is checked");
		else
			System.out.println("Selenium is not checked");

		// 3.DeSelect only checked
		WebElement deselect = driver.findElement(By.xpath("(//section[@class = 'innerblock']//input)[8]"));
		deselect.click();

		// 4.Select all below checkboxes
		driver.findElement(By.xpath("(//section[@class = 'innerblock']//input)[9]")).click();
		driver.findElement(By.xpath("(//section[@class = 'innerblock']//input)[10]")).click();
		driver.findElement(By.xpath("(//section[@class = 'innerblock']//input)[11]")).click();
		driver.findElement(By.xpath("(//section[@class = 'innerblock']//input)[12]")).click();
		driver.findElement(By.xpath("(//section[@class = 'innerblock']//input)[13]")).click();

	}

}
