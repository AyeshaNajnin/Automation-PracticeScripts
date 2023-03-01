package project.com.PracticeScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActions {

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
	public void MouseHandle() throws InterruptedException {

		driver.get("https://nxtgenaiacademy.com");

		WebElement mainMenu = driver
				.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div[3]/div[2]/div[2]/ul/li[3]/a"));

		Actions act = new Actions(driver);
		act.moveToElement(mainMenu).perform();
		Thread.sleep(3000);

		WebElement subMenu = driver
				.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div[3]/div[2]/div[2]/ul/li[3]/ul/li/a"));
		Actions act2 = new Actions(driver);
		act2.moveToElement(subMenu).perform();

		WebElement lastMenu = driver.findElement(
				By.xpath("//*[@id=\"header\"]/div[2]/div/div/div[3]/div[2]/div[2]/ul/li[3]/ul/li/ul/li[1]/a"));
		Actions act3 = new Actions(driver);
		act3.moveToElement(lastMenu).perform();
		lastMenu.click();
		Thread.sleep(3000);

	}

	@Test
	public void MouseHover() throws InterruptedException {

		driver.get("https://nxtgenaiacademy.com");

		WebElement mainMenu = driver
				.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div[3]/div[2]/div[2]/ul/li[6]/a"));
		Actions act = new Actions(driver);
		act.moveToElement(mainMenu).perform();

		WebElement subMenu = driver
				.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div[3]/div[2]/div[2]/ul/li[6]/ul/li[2]/a"));
		Actions act2 = new Actions(driver);
		act2.moveToElement(subMenu).perform();

		WebElement lastMenu = driver.findElement(
				By.xpath("//*[@id=\"header\"]/div[2]/div/div/div[3]/div[2]/div[2]/ul/li[6]/ul/li[2]/ul/li[4]/a"));
		Actions act3 = new Actions(driver);
		act3.moveToElement(subMenu).perform();
		lastMenu.click();
		Thread.sleep(3000);

	}

	@AfterSuite
	public void closeBrowser() throws InterruptedException {

		Thread.sleep(5000);
		driver.quit();
	}

}
