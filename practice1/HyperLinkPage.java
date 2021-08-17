package week2.day2.practice1;

//Goal : Code to Practice HyperLinks

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperLinkPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Importing the driver files
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launching the webpage
		driver.get("http://www.leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// 1.Go to Home Page
		WebElement homePage = driver.findElement(By.linkText("Go to Home Page"));
		String link1 = homePage.getAttribute("href");
		homePage.click();
		driver.navigate().back();

		// 2.Find where am supposed to go without clicking me?
		WebElement link = driver.findElement(By.xpath("//a[contains (text() , ' to go without clicking me?')]"));
		String hyperLink = link.getAttribute("href");
		System.out.println("The hidden link is :" + hyperLink);

		// 3.Verify am I broken?
		WebElement brokenLink = driver.findElement(By.xpath("//a[text() = 'Verify am I broken?']"));
		brokenLink.click();

		// verification and Printing the result
		String title = driver.getTitle();
		if (title.contains("404"))
			System.out.println("Yes, The link is Broken");
		else
			System.out.println("No, The link is not Broken");

		// Back to target page
		driver.navigate().back();

		// 4.Go to Home Page (Interact with same link name)
		// homePage.click(); ----> this throws exception
		// get href from both element and compare
		WebElement homePage1 = driver.findElement(By.partialLinkText("Go to Home Page"));
		String link2 = homePage1.getAttribute("href");
		
		//If results same, click the link1 of href page
		if (link1.equals(link2))
			System.out.println("Both the links are same");
		driver.get(link1);
		driver.navigate().back();

		// 5.How many links are available in this page?
		List<WebElement> numOfLinks = driver.findElements(By.tagName("a"));
		int sizeOfLink = numOfLinks.size();
		System.out.println("The Total number of links in the page is :" + sizeOfLink);

	}

}
