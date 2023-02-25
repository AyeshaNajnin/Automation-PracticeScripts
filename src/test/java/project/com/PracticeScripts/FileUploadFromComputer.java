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

public class FileUploadFromComputer {

	WebDriver driver;

	@BeforeSuite
	public void startbeowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// waits
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void fileUpload() throws InterruptedException {

		driver.get("https://automationexercise.com/contact_us");
		driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input")).sendKeys("Ayesha");
		driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[2]/input")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[3]/input")).sendKeys("Test");
		driver.findElement(By.xpath("//*[@id=\"message\"]")).sendKeys("Test123456");
		driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[5]/input"))
				.sendKeys("C:\\Users\\Shammy Najnin\\Pictures\\photo of nature.jpg");
		driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input")).submit();
		Thread.sleep(3000);

		Alert alertmsg = driver.switchTo().alert();
		String msg = driver.switchTo().alert().getText();
		System.out.println(msg);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();

		WebElement OKmsg = driver.findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]"));
		System.out.println(OKmsg.getText());

	}

	@AfterSuite
	public void closeBrowser() throws InterruptedException {

		Thread.sleep(3000);
		driver.quit();

	}

}
