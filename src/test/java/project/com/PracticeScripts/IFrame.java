package project.com.PracticeScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrame {

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
	public void iframestart() throws InterruptedException {

		driver.navigate().to("https://nxtgenaiacademy.com/iframe/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		WebElement i_frame = driver.findElement(By.name("iframe_a"));
		driver.switchTo().frame(i_frame);
		driver.findElement(By.xpath("//*[@id=\"vfb-5\"]")).sendKeys("first");
		driver.findElement(By.xpath("//*[@id=\"vfb-7\"]")).sendKeys("last");

		WebElement radiobtn = driver.findElement(By.id("vfb-31-2"));
		radiobtn.click();

		driver.findElement(By.xpath("//*[@id=\"vfb-13-address\"]")).sendKeys("address");
		driver.findElement(By.xpath("//*[@id=\"vfb-13-address-2\"]")).sendKeys("street");
		driver.findElement(By.xpath("//*[@id=\"vfb-13-city\"]")).sendKeys("city");
		driver.findElement(By.xpath("//*[@id=\"vfb-13-state\"]")).sendKeys("state");
		driver.findElement(By.xpath("//*[@id=\"vfb-13-zip\"]")).sendKeys("zip");
		
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		jss.executeScript("window.scrollBy(0,2000)");
		
		Thread.sleep(3000);

		// dropdown
		Select menu = new Select(
				driver.findElement(By.xpath("//*[@id=\"vfb-13-country\"]")));
		menu.selectByValue("Andorra");

		driver.findElement(By.xpath("//*[@id=\"vfb-14\"]")).sendKeys("mail@gamil.com");

		// date
//		driver.findElement(By.xpath("//*[@id=\"vfb-18\"]")).click();
		Thread.sleep(1000);

		// choose month from dropdown
//		WebElement month = driver.findElement(By.xpath("//*[@id=\"vfb-18\"]"));
//		Select date = new Select(month);
//		date.selectByVisibleText("Jan");
//		Thread.sleep(1000);

		Select time1 = new Select(driver.findElement(By.xpath("//*[@id=\"vfb-16-hour\"]")));
		time1.selectByValue("02");

		Select time2 = new Select(driver.findElement(By.xpath("//*[@id=\"vfb-16-min\"]")));
		time2.selectByValue("25");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"vfb-19\"]")).sendKeys("123457658768");
		driver.findElement(By.xpath("//*[@id=\"vfb-20-0\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"vfb-23\"]")).sendKeys("this is demo");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id=\"vfb-3\"]")).sendKeys("11");
		driver.findElement(By.xpath("//*[@id=\"vfb-4\"]")).click();
		Thread.sleep(5000);
		
	}

	@AfterSuite
	public void closeBrowser() throws InterruptedException {

		Thread.sleep(3000);
		driver.quit();
	}
}