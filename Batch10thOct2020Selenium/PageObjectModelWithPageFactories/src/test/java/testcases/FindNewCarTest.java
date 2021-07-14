package testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import pages.HomePage;
import utilities.TestUtil;

public class FindNewCarTest extends BaseTest {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void findCarTest(String browserName, String runMode, String brandName,String carTitle) {

		if (runMode.equals("N")) {

			throw new SkipException("Skipping the test as the Run Mode is NO");
		}

		setUp(browserName);

		if (brandName.equals("maruti")) {
			HomePage home = new HomePage(driver);
			home.findNewCar().selectMarutiCar();
			Assert.assertEquals(BasePage.car.getCarTitle(),carTitle);
			System.out.println(BasePage.car.getCarTitle());
		} else if (brandName.equals("toyota")) {
			HomePage home = new HomePage(driver);
			home.findNewCar().selectToyotaCar();
			Assert.assertEquals(BasePage.car.getCarTitle(),carTitle);
			System.out.println(BasePage.car.getCarTitle());
		} else if (brandName.equals("kia")) {
			HomePage home = new HomePage(driver);
			home.findNewCar().selectKiaCar();
			Assert.assertEquals(BasePage.car.getCarTitle(),carTitle);
			System.out.println(BasePage.car.getCarTitle());
		} else if (brandName.equals("hyundai")) {
			HomePage home = new HomePage(driver);
			home.findNewCar().selectHyundaiCar();
			Assert.assertEquals(BasePage.car.getCarTitle(),carTitle);
			System.out.println(BasePage.car.getCarTitle());
		}

	}

}
