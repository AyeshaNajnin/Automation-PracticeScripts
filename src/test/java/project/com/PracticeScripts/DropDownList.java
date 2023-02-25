package project.com.PracticeScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownList {
	
	WebDriver driver; 
	
	@BeforeSuite
	public void startbrowser() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void mainTest() {
		
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		//taking a variable (header) under WebElement, after print that variable using getText() 
		WebElement header = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[1]/div[1]/div/div/div/div[2]/h1"));
		System.out.println(header.getText());
		
		//taking dropdown list
		Select menu = new Select(driver.findElement(By.xpath("//*[@id=\"post-2646\"]/div[2]/div/div/div/p/select")));
		menu.selectByValue("ALB");
		
	}
	 @AfterSuite
	 public void closebrowser() throws InterruptedException {
		 
		 driver.quit();
		 Thread.sleep(4000);
	 }
	

}
