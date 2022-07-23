package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.linkText("Phone")).click();
		
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("123");
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(5000);
		
		String firstResultID = driver.findElement(By.xpath("(//div[@class='x-grid3-body']//table//tr[1]/td[1]/div)[1]/a")).getText();
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-body']//table//tr[1]/td[1]/div)[1]/a")).click();
		
		driver.findElement(By.linkText("Delete")).click();
		
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(firstResultID);
		
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		boolean noRecordMessage = driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();
		
		if(noRecordMessage) {
			
			System.out.println(firstResultID +" record has been deleted");
		}
	}

}
