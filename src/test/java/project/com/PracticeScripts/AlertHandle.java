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

public class AlertHandle {

	WebDriver driver;

	@BeforeSuite
	public void startbeowser() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(description = "verifying alert messege", invocationCount = 1)
	public void startbrowser() throws InterruptedException {

		driver.get("https://demo.guru99.com/test/delete_customer.php");

		WebElement headertext = driver.findElement(By.xpath("/html/body/h2"));
		System.out.println(headertext.getText());

		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("007");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).submit();
		
		//verifying the alert box msg 
		Alert alertmsg = driver.switchTo().alert();
		String msg = driver.switchTo().alert().getText();
		System.out.println(msg);
		Thread.sleep(3000);
		
		//this mean: alert msg (Ok) directly accepted or rejected
		driver.switchTo().alert().accept();

	}

	@Test
	public void popupmsg() throws InterruptedException {

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();

		Alert msg = driver.switchTo().alert();
		Thread.sleep(2000);
		msg.sendKeys("yes!");
		Thread.sleep(2000);
		msg.accept();
		Thread.sleep(3000);

		if (driver.getPageSource().contains("You entered: yes!")) {
			System.out.println("You entered: yes!");
		}

	}

	@AfterSuite
	public void closeBrowser() throws InterruptedException {

		Thread.sleep(3000);
		driver.quit();

	}
}
