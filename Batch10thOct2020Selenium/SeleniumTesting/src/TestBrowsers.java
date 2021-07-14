import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBrowsers {

	public static void main(String[] args) {
		/*
		 * 3.141.59, 4.0, 4.1
		 * Chrome - 86,87,89
		 * Firefox - 70,71
		 * 
		 */
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\way2automation\\Downloads\\Compressed\\chromedriver_win32_5\\chromedriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://way2automation.com");
		
		
		
	}

}
