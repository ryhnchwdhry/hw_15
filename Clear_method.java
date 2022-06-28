package hw_15;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Clear_method {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www3.mtb.com/log-in");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@Test
	public void test() throws InterruptedException {

		driver.findElement(By.xpath("//input[@name='txtUserID']")).sendKeys("IdontHaveUserId");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='txtUserID']")).clear();
		Thread.sleep(3000);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
