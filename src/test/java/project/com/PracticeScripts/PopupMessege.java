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

public class PopupMessege {

	WebDriver driver;

	@BeforeSuite
	public void startbeowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void PopupMsg() {

		driver.get("https://member.daraz.com.bd/user/login");
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/form/div/div[1]/div[1]/input"))
				.sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/form/div/div[1]/div[2]/input"))
				.sendKeys("34354");
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/form/div/div[2]/div[1]/button")).click();

		WebElement popup = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]"));
		System.out.println(popup.getText());
		assertEquals(popup.getText(), "Incorrect username or password.");
	}

	@Test
	public void IFrame() throws InterruptedException {

		driver.get("https://jqueryui.com/checkboxradio/");

		WebElement iframe = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("/html/body/div/fieldset[1]/label[1]")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/a")).click();
		Thread.sleep(3000);

	}

	@AfterSuite
	public void closeBrowser() throws InterruptedException {

		Thread.sleep(3000);
		driver.quit();

	}
}
