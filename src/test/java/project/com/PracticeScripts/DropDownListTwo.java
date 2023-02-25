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

public class DropDownListTwo {
	
	WebDriver driver;
	
	@BeforeSuite
	public void startbrowser() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void mainTest() {
		
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		
		WebElement headerText = driver.findElement(By.xpath("//*[@id=\"page-top\"]/div/div/div/div/div[1]/div[1]"));
		System.out.println(headerText.getText());
		
		Select dropdownlist = new Select(driver.findElement(By.xpath("//*[@id=\"first\"]")));
		dropdownlist.selectByValue("Yahoo");
		Select dropdownlisttwo = new Select(driver.findElement(By.xpath("//*[@id=\"animals\"]")));
		dropdownlisttwo.selectByValue("avatar");
		System.out.println(driver.getCurrentUrl());
	}
	
	@AfterSuite
	public void closebrowser() throws InterruptedException {
		
		driver.quit();
		Thread.sleep(4000);
			
		}
		
	}


