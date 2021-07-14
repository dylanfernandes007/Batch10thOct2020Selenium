package testcases;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTabsandPopups {

	public static void main(String[] args) {


		//naukri.com - get title for each window and then close them

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("http://way2automation.com/");
	
		
		Set<String> winids = driver.getWindowHandles(); //1
		Iterator<String> iterator = winids.iterator();
		
		String firstWindow = iterator.next(); // first window id
		System.out.println(firstWindow);
		
		
		
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[2]/div/div[2]/div/a[1]")).click();
		
		winids = driver.getWindowHandles(); //2
		iterator = winids.iterator();
		System.out.println("Generating window ids from second window");
		
		System.out.println(iterator.next()); //
		String secondWindow = iterator.next(); //2nd
		System.out.println(secondWindow);
		
		driver.switchTo().window(secondWindow);
		driver.findElement(By.id("user_email")).sendKeys("trainer@way2automation.com");
		
		/*
		 * driver.close(); driver.switchTo().window(firstWindow); driver.close();
		 */
		
		driver.quit();
		/*
		 * while(iterator.hasNext()) {
		 * 
		 * iterator.next(); }
		 */
		
	
	}

}
