package week2.day2.practice1;
//Goal : Code to Practice on Image files

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImagePage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Importing the driver files
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launching the webpage
		driver.get("http://www.leafground.com/pages/Image.html");
		driver.manage().window().maximize();

		// 1.Click on this image to go home page
		driver.findElement(By.xpath("//img[contains (@src, '/home.png')]")).click();
		driver.navigate().back();

		// 2.Am I Broken Image?
		WebElement brokenImg = driver.findElement(By.xpath("//img[contains(@src , 'abcd.jpg')]"));
		String size = brokenImg.getAttribute("naturalWidth");

		if (size.equals("0"))
			System.out.println(" The image is broken");
		else
			System.out.println(" The image is not broken");

	}

}
