package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropdown {

	public static void main(String[] args) {


		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.wikipedia.org/");
		
		//driver.findElement(By.id("searchLanguage")).sendKeys("Eesti");
		WebElement dropdown = driver.findElement(By.id("searchLanguage"));
		
		Select select = new Select(dropdown);
		//select.selectByVisibleText("Eesti");
		select.selectByValue("hi");
		
		
		List<WebElement> values = dropdown.findElements(By.tagName("option"));

		System.out.println(values.size());
		
		
		for(int i=0; i<values.size(); i++) {
			
			
			System.out.println(values.get(i).getAttribute("lang"));
			
		}
		
		
		//driver.findElements(By.xpath("//*[@id=\"load_form\"]/div/div[2]/input")).get(0).click();
		
		
		WebElement block = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[9]/div[3]"));
		
		
		List<WebElement> links = block.findElements(By.tagName("a"));
		
		
		System.out.println("Total links are : "+links.size());
		
		
		for(WebElement link:links) {
			
			System.out.println(link.getText()+"---URL IS --"+link.getAttribute("href"));
			
			
		}
		
		
		
		

	}

}
