package project.com.PracticeScripts;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopupMessegeOne {
	
	WebDriver driver;
	
	@BeforeSuite
	public void startbrowser() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void popupmsg() {
		
		driver.get("https://backpackbang.com/");
		driver.findElement(By.xpath("/html/body/nav/ul/li[5]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Test@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123476765");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();
		
		WebElement passwordmsg =driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[2]/div/span"));
		System.out.println(passwordmsg.getText());
		//assertEquals(passwordmsg.getText(), "Password is less than 6 digits");
		
		//WebElement popupmsgis = driver.findElement(By.xpath("//*[@id=\"noty_1133200274274991700\"]/div[1]/h5"));
		//System.out.println(popupmsgis.getText());
		//assertEquals(popupmsgis.getText(), "Login Failed:");
	}
	
	@AfterSuite
	public void closebrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	
	

}
