package testnglearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;

public class TestParameterization {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
	}
	
	
	@Test(dataProvider = "dp")
	public void doLogin(String username, String password) {
		
		
		driver.get("http://facebook.com");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
	}
	
	
	@DataProvider(name = "dp")
	public Object[][] getData() {
		
		ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\excel\\testdata.xlsx");
		
		String sheetName = "LoginTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		System.out.println(excel.getCellData(sheetName, 0, 2));
		
		//rows - 1, cols =0
		System.out.println("Total rows are : "+rows+"---total cols are : "+cols);
		
		Object[][] data = new Object[rows-1][cols];
		
		
		for(int rowNum=2; rowNum<=rows; rowNum++) {
			
			
			for(int colNum=0; colNum<cols; colNum++) {
				
				//data[1][0] = excel.getCellData(sheetName, 0, 3);
				data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
				
			}
			
			
		}
		
		
		
		
		/*
		data[0][0] = excel.getCellData(sheetName, 0, 2);
		data[0][1] = excel.getCellData(sheetName, 1, 2);
		
		
		data[1][0] = excel.getCellData(sheetName, 0, 3);
		data[1][1] = excel.getCellData(sheetName, 1, 3);
		
		
		
		data[2][0] = excel.getCellData(sheetName, 0, 4);
		data[2][1] = excel.getCellData(sheetName, 1, 4);
		*/
		
		
		
		return data;
		
		
	}
	
	
	
	
	

}
