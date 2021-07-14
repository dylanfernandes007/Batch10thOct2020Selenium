package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.DbManager;
import utilities.ExcelReader;
import utilities.MonitoringMail;

public class BaseTest {
	
	
	
	public WebDriver driver;
	public Properties Config = new Properties();
	public FileInputStream fis;
	public ExcelReader excel = new ExcelReader(".//src//test//resources//excel//testdata.xlsx");
	public Logger log = Logger.getLogger(BaseTest.class);
	public MonitoringMail mail = new MonitoringMail();
	public WebDriverWait wait;
	
	
	public void setUp(String browserName) {
		
		PropertyConfigurator.configure(".//src//test//resources//properties//log4j.properties");

		log.info("Test Execution started !!!");
	
		
		try {
			fis = new FileInputStream(".//src//test//resources//properties//Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Config.load(fis);
			log.info("Config Properties loaded !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		if (browserName.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome Browser launched !!!");
		} else if (browserName.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Firefox Browser launched !!!");
		}
		
		
		
		driver.get(Config.getProperty("testsiteurl"));
		log.info("Navigated to : " + Config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);

		try {
			DbManager.setMysqlDbConnection();
			log.info("Database connection established !!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait = new WebDriverWait(driver, Integer.parseInt(Config.getProperty("explicit.wait")));

		
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		log.info("Test execution completed !!!");
	}
	
	

}
