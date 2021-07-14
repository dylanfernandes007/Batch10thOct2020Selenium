package testnglearning;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2 {
	
	
	@Test
	public void validateTitle() {
		
	
		System.out.println("Beginning");
		String expected_title = "Gmail.com";
		String actual_title = "Google.com";
		/*
		 * if(expected_title.equals(actual_title)) {
		 * 
		 * System.out.println("Test case pass"); }else {
		 * 
		 * System.out.println("Test case fail"); }
		 */
		
		SoftAssert assrt = new SoftAssert();
	
		assrt.assertEquals(actual_title, expected_title);
		assrt.fail("Forcefully failing the test");
		assrt.assertTrue(false,"Failing the test as the button is missing");
		
		System.out.println("Ending");
		
		assrt.assertAll();
		
	
	}

}
