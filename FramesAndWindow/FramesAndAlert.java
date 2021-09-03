package week4.day1.FramesAndWindow;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesAndAlert {

	public static void main(String[] args) {
		// Importing the setup files for browser
		WebDriverManager.chromedriver().setup();

		// Launching the web browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Load the URL
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");

		//Switch to frame using id
		driver.switchTo().frame("iframeResult");
		
		//click the try it button
		driver.findElement(By.xpath("//button[text()='Try it']")).click();

		//Switching to alert
		Alert alert = driver.switchTo().alert();
		
		//Pressing cancel in alert box
		alert.dismiss();

		//Verifying the button you Pressed
		WebElement result = driver.findElement(By.id("demo"));
		String text = result.getText();

		if (text.equals("You pressed OK!"))
			System.out.println("You Pressed OK");
		else
			System.out.println("You Pressed Cancel");

		//Out of frames and Returning to the main page 
		driver.switchTo().defaultContent();

		driver.close();
	}

}
