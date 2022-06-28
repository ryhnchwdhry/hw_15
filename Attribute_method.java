package hw_15;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Attribute_method {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www3.mtb.com/personal");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@Test
	public void test() throws InterruptedException {
		String att = driver.findElement(By.xpath("//a[@aria-label='Log In, use escape key to exit modal window.']"))
				.getAttribute("class");
		System.out.println("Attribut value: " + att);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
