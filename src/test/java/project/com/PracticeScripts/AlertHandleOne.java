package project.com.PracticeScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandleOne {
	
	WebDriver driver;
	
	@BeforeSuite
	public void BrowserSetup() {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	
	@Test
	public void AlertHandle() throws InterruptedException {
		driver.get("https://nxtgenaiacademy.com/alertandpopup/");
		driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[1]/div/section[3]/div/div[1]/div/div/div/center/button")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
	}
	@Test
	public void ConfirmAlertBox() throws InterruptedException {
		driver.get("https://nxtgenaiacademy.com/alertandpopup/");
		driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[1]/div/section[3]/div/div[2]/div/div/div/center/button")).click();
		
		driver.switchTo().alert();
		Thread.sleep(3000);
		
		Alert alertmsg = driver.switchTo().alert();
		String msg = driver.switchTo().alert().getText();
		System.out.println(msg);
		Thread.sleep(3000);
		
		driver.switchTo().alert().dismiss();
		WebElement Okmsg = driver.findElement(By.xpath("//*[@id=\"demo\"]"));
		System.out.println(Okmsg.getText());
	}
	
	@Test
	public void PromptAlertBox() throws InterruptedException {
		
		driver.get("https://nxtgenaiacademy.com/alertandpopup/");
		driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[1]/div/section[3]/div/div[3]/div/div/div/center/button")).click();
		
		Alert msg = driver.switchTo().alert();
		Thread.sleep(2000);
		msg.sendKeys("Yes");
		Thread.sleep(3000);
		msg.accept();
		
		WebElement Okmsg = driver.findElement(By.xpath("//*[@id=\"demoone\"]"));
		System.out.println(Okmsg.getText());
	}
	
	@AfterSuite
	public void BrowserClose() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
