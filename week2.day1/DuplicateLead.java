package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Tech");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Akthar");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("ansar");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("syed");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Test department");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("test description");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("asyedakthar117@gmail.com");
		WebElement dropdown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		
		Select dropdownSelect = new Select(dropdown);
		
		dropdownSelect.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		String pageTitle = driver.getTitle();
		
		System.out.println("the page title is "+pageTitle);
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Duplicate Tech");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Duplicate akthar");
		driver.findElement(By.className("smallSubmit")).click();
		pageTitle = driver.getTitle();
		
		System.out.println("the page title is "+pageTitle);
		
	}

	}

