package week2.day2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.MouseAction;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundAssignment {

	public static void main(String[] args) throws IOException {
	
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Edit.html");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("email")).sendKeys("asyedakthar117@gmail.com");
		
		driver.findElement(By.xpath("//label[text()='Append a text and press keyboard tab']/following::input[1]")).sendKeys(" text");
		
		driver.findElement(By.xpath("//label[text()='Append a text and press keyboard tab']/following::input[1]")).sendKeys(Keys.TAB);
		
		String defaultText = driver.findElement(By.xpath("//label[text()='Get default text entered']/following::input[1]")).getAttribute("value");	
		
		System.out.println("Default text entered in the field is " + defaultText);
		
		driver.findElement(By.xpath("//label[text()='Clear the text']/following::input[1]")).clear();
		
		boolean fieldEnabled = driver.findElement(By.xpath("//label[text()='Confirm that edit field is disabled']/following::input[1]")).isEnabled();

		if(!fieldEnabled) {
			
			System.out.println("the field is disabled");
		}
		
		
		driver.get("http://leafground.com/pages/Button.html");
		
		driver.findElement(By.id("home")).click();
		
		driver.navigate().back();
		
		int xPosition = driver.findElement(By.id("position")).getLocation().getX();
		
		int yPosition = driver.findElement(By.id("position")).getLocation().getY();
		
		System.out.println("x value is: "+ xPosition);
		
		System.out.println("y value is: "+ yPosition);
		
		String bgColor = driver.findElement(By.id("color")).getCssValue("background-color");
		
		System.out.println("BG color is "+ bgColor);
		
		int fieldHeight = driver.findElement(By.id("size")).getSize().getHeight();
		
		int fieldWidth = driver.findElement(By.id("size")).getSize().getWidth();
		
		System.out.println("height value is: "+ fieldHeight);
		
		System.out.println("weight value is: "+ fieldWidth);
		
		driver.get("http://leafground.com/pages/Link.html");
		
		driver.findElement(By.linkText("Go to Home Page")).click();
		
		driver.navigate().back();
		
		String findlink = driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href");
		
		System.out.println("the link is navigating to "+ findlink);
		
		 driver.findElement(By.linkText("Verify am I broken?")).click();
		 
			if(driver.getTitle().equals("404 Not Found")) {
				
			System.out.println("page is broken");
			
			driver.navigate().back();
			
			}
			
			
			driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]")).click();
			
			driver.navigate().back();
			
			List<WebElement> linksCount = driver.findElements(By.tagName("a"));
		
			System.out.println("the links count is " + linksCount.size());
			
			driver.get("http://leafground.com/pages/Image.html");
			
			driver.findElement(By.xpath("//label[text()='Click on this image to go home page']//following::img[1]")).click();
			
			driver.navigate().back();
			
			String brokenimage = driver.findElement(By.xpath("//label[text()='Am I Broken Image?']//following::img[1]")).getAttribute("onclick");
			
			if(brokenimage.equals(null)) {
				
				
				System.out.println("the image is broken");
			}
			
		
	}
	
	

}
