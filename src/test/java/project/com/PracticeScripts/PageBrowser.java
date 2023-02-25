package project.com.PracticeScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageBrowser {
	
	WebDriver driver;
	
	
	@BeforeSuite
	public void pageLoad() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void maintest() {
		
	
		driver.get("https://www.daraz.com.bd/");
		driver.findElement(By.xpath("//*[@id=\"q\"]")).sendKeys("kamiz");
	}
	
	 @AfterSuite
	 public void closebrowser() throws InterruptedException {
		 
		 driver.quit();
		 Thread.sleep(4000);
		 
	 }
	 
}