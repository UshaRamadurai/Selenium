package week4.day1.FramesAndWindow;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertLearning {

	public static void main(String[] args) {
		// Importing the setup files for browser
		WebDriverManager.chromedriver().setup();

		// Launching the web browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Load the URL
		driver.get("http://www.leafground.com/pages/Alert.html");

		// 1.Alert
		driver.findElement(By.xpath("//button[text() = 'Alert Box']")).click();
		Alert alert = driver.switchTo().alert();
		String text1 = alert.getText();
		System.out.println(text1);
		alert.accept();

		// 2.Confirm box
		driver.findElement(By.xpath("//button[text() = 'Confirm Box']")).click();
		alert.dismiss();
		WebElement result = driver.findElement(By.id("result"));
		String text = result.getText();
		System.out.println(text);

		// 3.Prompt Box
		driver.findElement(By.xpath("//button[text() = 'Prompt Box']")).click();
		alert.sendKeys("TestLeaf");
		alert.accept();

	}

}
