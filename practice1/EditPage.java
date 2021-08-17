package week2.day2.practice1;

//Goal : Code to practice with edit fields

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Importing driver files
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launching the webpage
		driver.get("http://www.leafground.com/pages/Edit.html");
		driver.manage().window().maximize();

		// 1.Enter your email address
		driver.findElement(By.id("email")).sendKeys("test@gmail.com");

		// 2.Append a text and press keyboard tab
		driver.findElement(By.xpath("//input[@value = 'Append ']")).sendKeys("Text \t");

		// 3.Get default text entered
		WebElement getText = driver.findElement(By.xpath("//input[@value = 'TestLeaf']"));
		String getTextValue = getText.getAttribute("value");
		System.out.println("The Default Text entered is : " + getTextValue);

		// 4.Clear the text
		WebElement clearText = driver.findElement(By.xpath("//input[@value = 'Clear me!!']"));
		clearText.clear();

		// 5.Confirm that edit field is disabled
		WebElement isEnable = driver.findElement(By.xpath("//input[@disabled = 'true']"));
		boolean isEnabledvalue = isEnable.isEnabled();

		// Verifying and Printing the result
		if (isEnabledvalue)
			System.out.println("The button is Enabled");
		else
			System.out.println("The button is Disabled");

	}

}
