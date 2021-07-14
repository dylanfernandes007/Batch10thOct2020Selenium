package testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import pages.HomePage;
import utilities.TestUtil;

public class CarNameAndPriceTest extends BaseTest{

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void carNameandPriceTest(String browserName, String runMode, String brandName) {
		

		if (runMode.equals("N")) {

			throw new SkipException("Skipping the test as the Run Mode is NO");
		}

		setUp(browserName);
		
		
		if (brandName.equals("maruti")) {
			HomePage home = new HomePage(driver);
			home.findNewCar().selectMarutiCar();
			BasePage.car.getCarNameAndPrice();
		} else if (brandName.equals("toyota")) {
			HomePage home = new HomePage(driver);
			home.findNewCar().selectToyotaCar();
			BasePage.car.getCarNameAndPrice();
		} else if (brandName.equals("kia")) {
			HomePage home = new HomePage(driver);
			home.findNewCar().selectKiaCar();
			BasePage.car.getCarNameAndPrice();
		} else if (brandName.equals("hyundai")) {
			HomePage home = new HomePage(driver);
			home.findNewCar().selectHyundaiCar();
			BasePage.car.getCarNameAndPrice();
		}

		
		
		
		
		
		
	}
	
	
	
	
	
	
}
