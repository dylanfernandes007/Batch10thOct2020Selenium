package rough;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LandingPage;

public class LoginTest {
	
	
	public static void main(String[] args) {
		
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		  prefs.put("profile.default_content_setting_values.notifications", 2);
		  prefs.put("credentials_enable_service", false);
		  prefs.put("profile.password_manager_enabled", false);
		 
		 
		 
		  ChromeOptions options = new ChromeOptions();
		  options.setExperimentalOption("prefs", prefs);
	
		
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
		
		
		
		
		
		
		
		
		HomePage home = new HomePage(driver);
		LandingPage lp = home.doLogin("prafulgupta84@yahoo.in", "Selenium@1234");
		lp.gotoProfile();
		
		
		//new HomePage(driver).doLogin("prafulgupta84@yahoo.in", "Selenium@1234").gotoProfile();
		
		
		
		
		
	}

}
