package week2.day1;
//Goal : Opening a Web browser and getting into a website

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Importing the setup files for browser
		WebDriverManager.chromedriver().setup();
		
		//Launching the web browser
		ChromeDriver driver = new ChromeDriver();
		
		//Load the URL
		driver.get("http://www.Google.com");
		
		//Maximizing the window
		driver.manage().window().maximize();
		

	}

}
