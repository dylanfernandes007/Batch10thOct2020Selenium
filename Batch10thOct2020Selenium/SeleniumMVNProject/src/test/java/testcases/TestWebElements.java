package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebElements {
	
	
	public static String browser = "chrome";
	public static WebDriver driver;


	public static void main(String[] args) throws InterruptedException {


		if(browser.equals("chrome")) {
			
			
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			
			
		}else if(browser.equals("firefox")) {
			
			
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
			
			
		}else if(browser.equals("edge")) {
			
			
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
			
			
		}
		
		
		driver.get("http://gmail.com");
		String title = driver.getTitle();
		title.length();
		
		driver.getTitle().length();
		
		Options opt = driver.manage();
		Window win = opt.window();
		win.maximize();
		
		driver.manage().window().maximize();
		
		System.out.println(title);
		System.out.println(title.length());
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		
		
		/*
		 * WebElement username = driver.findElement(By.id("identifierId"));
		 * username.sendKeys("trainer@way2automation.com");
		 */	//driver.close();//close the current window
		//driver.quit(); //close the current window
		
		
		  driver.findElement(By.cssSelector("#identifierId")).sendKeys(
		  "trainer@way2automation.com");
		  driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]"))
		  .click(); //Thread.sleep(3000);
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		  "//*[@id=\"password\"]/div[1]/div/div[1]/input"))).sendKeys("dfsfdsfsd");
		 	//driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("sdfsfsds");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/div[2]")).click();
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]")).getText());
		
		
	}

}
