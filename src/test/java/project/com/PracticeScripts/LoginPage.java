package project.com.PracticeScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	
	WebDriver driver;
	
	@BeforeSuite
	public void loginOpen() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
			
	}
	
	@Test
	public void mainTest() {
		
		
		driver.get("https://backpackbang.com/");
		driver.findElement(By.xpath("/html/body/nav/ul/li[5]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123");
		
	}
	
	
	@AfterSuite
	public void closebrowser() throws InterruptedException {

		Thread.sleep(5000);
		driver.quit();

	}

}
	

	

