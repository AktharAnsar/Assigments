package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://en-gb.facebook.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Create New Account")).click();
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Firstname1");
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Lastname1");
		
		driver.findElement(By.xpath("//div[text()='Mobile number or email address']/following::input[1]")).sendKeys("12345678901");
		
		driver.findElement(By.xpath("//div[text()='New password']/following::input[1]")).sendKeys("1234567890");
		
		driver.findElement(By.xpath("//label[text()='Female']/following::input[1]")).click();
		
		Select dayDropdown = new Select(driver.findElement(By.id("day")));
	
		dayDropdown.selectByVisibleText("7");
		
		Select monthDropdown = new Select(driver.findElement(By.id("month")));
		
		monthDropdown.selectByVisibleText("Nov");		
		
		Select yearDropdown = new Select(driver.findElement(By.id("year")));
		
		yearDropdown.selectByVisibleText("1992");
		
		
		
		

	}

}
