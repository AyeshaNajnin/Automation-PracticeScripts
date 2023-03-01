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

		driver.get("https://nxtgenaiacademy.com/iframe/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		// enter into iframe
		WebElement i_frame = driver.findElement(By.name("iframe_a"));
		driver.switchTo().frame(i_frame);

		driver.findElement(By.xpath("//*[@id=\"vfb-5\"]")).sendKeys("first");
		driver.findElement(By.xpath("//*[@id=\"vfb-7\"]")).sendKeys("last");
		
		//radio btn
		WebElement radiobtn = driver.findElement(By.id("vfb-31-2"));
		radiobtn.click();

		driver.findElement(By.xpath("//*[@id=\"vfb-13-address\"]")).sendKeys("address");
		driver.findElement(By.xpath("//*[@id=\"vfb-13-address-2\"]")).sendKeys("street");
		driver.findElement(By.xpath("//*[@id=\"vfb-13-city\"]")).sendKeys("city");
		driver.findElement(By.xpath("//*[@id=\"vfb-13-state\"]")).sendKeys("state");
		driver.findElement(By.xpath("//*[@id=\"vfb-13-zip\"]")).sendKeys("zip");

		// scrolling page
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		jss.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(3000);

		// dropdown menu
		Select menu = new Select(driver.findElement(By.xpath("//*[@id=\"vfb-13-country\"]")));
		menu.selectByValue("Andorra");

		driver.findElement(By.xpath("//*[@id=\"vfb-14\"]")).sendKeys("mail@gamil.com");

		//calendar pick
		driver.findElement(By.xpath("//*[@id=\"vfb-18\"]")).click();
		Thread.sleep(1000);

		while (true) {

			String month = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]")).getText();
			String year = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[2]")).getText();

			if (month.equals("December") && year.equals("2020")) {
				WebElement date = driver
						.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[1]/a"));
				date.click();
				break;
			} else {
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
			}
		}
		
		//timepick from dropdown
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