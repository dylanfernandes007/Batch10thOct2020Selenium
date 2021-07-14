package testcases;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestChrome {

	public static void main(String[] args) {


		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("");
		driver.getTitle();
		driver.close();
		driver.quit();

	}

}
