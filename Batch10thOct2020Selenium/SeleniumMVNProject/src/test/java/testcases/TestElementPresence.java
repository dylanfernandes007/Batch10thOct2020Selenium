package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestElementPresence {

	public static WebDriver driver;

	public static boolean isElementPresent(String xpath) {

		try {
			driver.findElement(By.xpath(xpath));
			return true;
		} catch (Throwable t) {

			return false;
		}
	}

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");

		System.out.println(isElementPresent("//div[4]/input[4]"));

	}

}
