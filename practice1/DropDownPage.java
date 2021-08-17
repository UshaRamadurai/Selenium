package week2.day2.practice1;
//Goal : Code to Practice DropDowns and Listboxes

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Importing the driver files
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launching the webpage
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();

		// 1.Select training program using Index
		WebElement listBox1 = driver.findElement(By.id("dropdown1"));
		Select listBox1Select = new Select(listBox1);
		listBox1Select.selectByIndex(1);

		// 2.Select training program using Text
		WebElement listBox2 = driver.findElement(By.name("dropdown2"));
		Select listBox2Select = new Select(listBox2);
		listBox2Select.selectByVisibleText("Appium");

		// 3.Select training program using Value
		WebElement listBox3 = driver.findElement(By.id("dropdown3"));
		Select listBox3Select = new Select(listBox3);
		listBox3Select.selectByValue("3");

		// 4.Get the number of dropdown options
		WebElement listBox4 = driver.findElement(By.xpath("//select[ @class = 'dropdown']"));
		Select listBox4Select = new Select(listBox4);
		listBox4Select.selectByIndex(3);
		int size = listBox4Select.getOptions().size();
		System.out.println("The size of the listbox is :" + size);

		// 5.You can also use sendKeys to select
		driver.findElement(By.xpath("(//section[ @class = 'innerblock']//select)[5]")).sendKeys("Loadrunner");

		// 6.Select multiple programs
		WebElement listBox6 = driver.findElement(By.xpath("(//section[ @class = 'innerblock']//select)[6]"));
		Select listBox6Select = new Select(listBox6);
		listBox6Select.selectByValue("1");
		listBox6Select.selectByValue("2");
		listBox6Select.selectByValue("3");

	}

}
