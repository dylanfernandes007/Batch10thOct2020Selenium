package testnglearning;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestCase3 {
	
	
	
	@Test(priority = 1)
	public void registerUser() {
	
		System.out.println("Executing user reg test");
		Assert.fail("Submit button missing");
	
		
		
		
	}
	
	@Ignore
	@Test(priority = 2,dependsOnMethods = "registerUser")
	public void doLogin() {
		
		System.out.println("Executing login test");
		
	}
	
	
	@Test(priority = 3)
	public void isSkip() {
		
		throw new SkipException("Skipping the test as the condition is not met");
	}

}
